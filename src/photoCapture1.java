

import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
//import javax.media.*;
//import javax.media.format.*;
//import javax.media.util.*;
//import javax.media.control.*;
//import javax.media.protocol.*;
import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import com.sun.image.codec.jpeg.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class photoCapture1 extends JPanel implements ActionListener
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

  public photoCapture1(int x)
  {
  }
  public photoCapture1()
  {
    setLayout(null);

    setBounds(55, 55,640, 480);

    imgpanel = new ImagePanel();
    imgpanel.setBounds(0,280, 640, 480);

    ids = new JComboBox(new RecordDB().getAllIDs());
    ids.setBounds(320, 480,320,40);
    capture = new JButton("Capture");
    capture.setBounds(0, 480,320,40);
    capture.addActionListener(this);
  
     String str2 = "vfw:Microsoft WDM Image Capture (Win32):0";

     di = CaptureDeviceManager.getDevice(str2);
     ml = di.getLocator();



    try
    {

         Format[] cfmts = di.getFormats();
        VideoFormat fmt = (VideoFormat)cfmts[0];
        DataSource src = Manager.createDataSource(di.getLocator());
        FormatControl fmtc = ((CaptureDevice)src).getFormatControls()[0];
        fmtc.setFormat(fmt);
        Manager.setHint(Manager.LIGHTWEIGHT_RENDERER, true);

      player = Manager.createRealizedPlayer(src);

      player.start();
      Component comp;

      if ((comp = player.getVisualComponent()) != null)
      {
        add(comp);
        comp.setBounds(0, 0, 640, 480);
      }
      add(capture);
      add(ids);
      add(imgpanel);
      imgpanel.setVisible(false);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }




  public static void main(String[] args)
  {
        new photoCapture1(1).capture();
  }

 public void capture()
 {
       JFrame f = new JFrame("Photo Capture");
    photoCapture1 cf = new photoCapture1();

    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
      playerclose();

      }});

      JPanel p = new JPanel()
         {
             public void paintComponent(Graphics g)
             {

                g.setColor(Color.RED);
                g.drawRect(180,60,250,350);
                  g.drawRect(210,215,45,25);
                  g.drawRect(330,215,45,25);
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
    f.setBounds(400, 100, 645, 750);
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
      String path=ids.getSelectedItem().toString();
      File f = new File(path);
      f.mkdir();
      // show the image
      imgpanel.setImage(img);

      // save image
      saveJPG(img,path+"\\1.jpg");
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

      BufferedImage bi = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
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
    catch (java.io.IOException io)
    {
      System.out.println("IOException");
    }
  }

}