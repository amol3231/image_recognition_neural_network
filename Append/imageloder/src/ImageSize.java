import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

public class ImageSize extends JFrame
{
	Image image;
	public static void main(String[] args)
        {
		try{
			new ImageSize();
		}
		catch(InterruptedException e){}
	}
	public ImageSize() throws InterruptedException{
		Toolkit tool = Toolkit.getDefaultToolkit();
		//image = tool.getImage("1.jpg");
                image = tool.getImage("F:\\Amar\\ANN_FACE\\FaceRecBPN\\FaceRecBPNUW\\1.jpg");
		MediaTracker mTracker = new MediaTracker(this);
		mTracker.addImage(image,1);
		mTracker.waitForID(1);
		int width = image.getWidth(null);
		int height = image.getHeight(null);
		System.out.println("The width of image: " + width);
		System.out.println("The height of image: " + height);
		setSize(width, height+30);
		setTitle("Image Size Example!");
		setDefaultCloseOperation(3);
		setVisible(true);
	}
	public void paint(Graphics g){
		g.drawImage(image,0,30,null);
                g.setColor(Color.RED);
                g.drawRect(75,60,155,175);
                Graphics2D g2 = (Graphics2D)g;

              g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
             g2.setPaint(Color.red);
            g2.fill(new Ellipse2D.Double(100,100, 5, 5));
            g2.fill(new Ellipse2D.Double(190,77, 5, 5));
            g2.fill(new Ellipse2D.Double(193,157, 5, 5));
            g2.fill(new Ellipse2D.Double(179,168, 5, 5));
            g2.fill(new Ellipse2D.Double(109,144, 5, 5));
            g2.fill(new Ellipse2D.Double(227,107, 5, 5));
            g2.fill(new Ellipse2D.Double(162,84, 5, 5));
            g2.fill(new Ellipse2D.Double(122,155, 5, 5));
            g2.fill(new Ellipse2D.Double(207,153, 5, 5));
            g2.fill(new Ellipse2D.Double(146,184, 5, 5));






                
	}
}
