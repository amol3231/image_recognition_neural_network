
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import javax.media.*;
import javax.media.format.*;
import javax.media.util.*;
import javax.media.control.*;
import javax.media.protocol.*;
import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import com.sun.image.codec.jpeg.*;
 
public class SwingCapture extends JPanel implements ActionListener
{
  public static Player player = null;
  public CaptureDeviceInfo di = null;
  public MediaLocator ml = null;
  public JButton capture = null;
  public Buffer buf = null;
  public Image img = null;
  public VideoFormat vf = null;
  public BufferToImage btoi = null;
  public ImagePanel imgpanel = null;
  public  JComboBox ids;
 
  public SwingCapture(int x)
  {
  }
  public SwingCapture()
  {
    setLayout(null);
    //setSize(320,550);
    setBounds(55, 55,320, 590);

    imgpanel = new ImagePanel();
    imgpanel.setBounds(0,280, 320, 240);

    ids = new JComboBox(new RecordDB().getAllIDs());
    ids.setBounds(160, 240,155,40);
    capture = new JButton("Capture");
    capture.setBounds(0, 240,160,40);
    capture.addActionListener(this);

//    String str1 = "vfw:Logitech USB Video Camera:0";
//    String str2 = "vfw:Microsoft WDM Image Capture (Win32):0";
//    di = CaptureDeviceManager.getDevice(str2);
//    ml = di.getLocator();

     String str2 = "vfw:Microsoft WDM Image Capture (Win32):0";

     di = CaptureDeviceManager.getDevice(str2);
     ml = di.getLocator();

    try
    {
        Manager.setHint(Manager.LIGHTWEIGHT_RENDERER, true);
      player = Manager.createRealizedPlayer(ml);
      player.start();
      Component comp;

      if ((comp = player.getVisualComponent()) != null)
      {
        add(comp);
        comp.setBounds(0, 0, 320, 240);
      }
      add(capture);
      add(ids);
      add(imgpanel);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
 
 public void capture()
 {   JFrame f = new JFrame("Live Identification");
    SwingCapture cf = new SwingCapture();

    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
      playerclose();
     // System.exit(0);
      }});

      JPanel p = new JPanel()
         {
             public void paintComponent(Graphics g)
             {

                g.setColor(Color.RED);
                g.drawRect(75,30,155,175);
                super.paintComponent(g);
             }
             public boolean isOpaque() {
               return false;
             }
         };
         f.setGlassPane(p);
         p.setVisible(true);

    f.add("Center",cf);
    f.pack();
    f.setBounds(400, 100, 320, 550);
    f.setVisible(true);
 }
 
 public static void playerclose()
  {
    player.close();
    player.deallocate();
  }
 
  public void actionPerformed(ActionEvent e)
  {
    JComponent c = (JComponent) e.getSource();
    
    if (c == capture)
    {
      // Grab a frame
   if(ids.getSelectedIndex()!=0)
     {
      FrameGrabbingControl fgc = (FrameGrabbingControl)
      player.getControl("javax.media.control.FrameGrabbingControl");
      buf = fgc.grabFrame();
      
      // Convert it to an image
      btoi = new BufferToImage((VideoFormat)buf.getFormat());
      img = btoi.createImage(buf);
      
      // show the image
      imgpanel.setImage(img);
       String path=ids.getSelectedItem().toString();
        
      // save image
      saveJPG(img,"1.jpg");
      identify.id2retrieve=Train.format(Integer.parseInt(path));
      identify.idn_path=path+"\\";
	  new identify(1).identifyMe();
        }
        else
        {
          JOptionPane.showMessageDialog(null,"Select an ID from the drop down list");
        }
    }
  }
 
  class ImagePanel extends Panel
  {
    public Image myimg = null;
    
    public ImagePanel()
    {
      setLayout(null);
      setSize(320,240);
    }
    
    public void setImage(Image img)
    {
      this.myimg = img;
      repaint();
    }
    
    public void paint(Graphics g)
    {
      if (myimg != null)
      {
        g.drawImage(myimg, 0, 0, this);
      }
    }
  }
 
 
  public static void saveJPG(Image img, String s)
  {
    BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
    Graphics2D g2 = bi.createGraphics();
    g2.drawImage(img, null, null);
 
    FileOutputStream out = null;
    try
    {
      out = new FileOutputStream(s);
    }
    catch (java.io.FileNotFoundException io)
    {
      System.out.println("File Not Found");
    }
    
    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
    JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bi);
    param.setQuality(0.5f,false);
    encoder.setJPEGEncodeParam(param);
    
    try
    {
      encoder.encode(bi);
      out.close();
    }
    catch (Exception io)
    {
      System.out.println("IOException");
    }
  }
 
}