
import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class locator extends JFrame
{
    Image img ;
    int x,y;

    public locator()
    {
        try
        {
        Toolkit tool = Toolkit.getDefaultToolkit();
        img =tool.getImage("1.jpg");
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(img, 1);
        mt.waitForID(1);
        }
        catch(Exception e)
        {
            System.out.println("error i locator constructor");
            e.printStackTrace();
        }
        setBounds(200, 100,img.getWidth(null),img.getHeight(null));
        setDefaultCloseOperation(3);
        setVisible(true);
    }

    void load(int x,int y)
    {
        this.x=x;
        this.y=y;
      //  repaint();
    }
    public void paint(Graphics g)
    {
        g.drawImage(img, 0, 0, null);
        Graphics2D g2 =(Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.red);
        g2.drawString("("+x+"),("+y+")", x, y);
        g2.fill(new Ellipse2D.Double(x,y, 5, 5));
    }

}
