import java.awt.*;
import javax.swing.*;


/*<applet code="test" width=400 height=100>
</applet>*/

//public class test extends JApplet
public class test extends JFrame
{


public test()
{
	JTabbedPane jp=new JTabbedPane();
	jp.addTab("cities",new CityPanel());
	jp.addTab("colors",new ColPanel());
	jp.addTab("flavors",new FlPanel());
 	getContentPane().add(jp);
	setBounds(100,100,400,400);
	setVisible(true);

}
public static void main(String args[])
{
	new test();
}

}
class CityPanel extends JPanel
{
	public CityPanel()
    {
		JButton b1=new JButton("New York");
		JButton b2=new JButton("London");
		JButton b3=new JButton("Hong kong");
		JButton b4=new JButton("Tokiyo");
		add(b1);
		add(b2);
		add(b3);
		add(b4);
    }
}
class ColPanel extends JPanel
{
	public ColPanel()
    {
		JCheckBox c1=new JCheckBox ("red");
		JCheckBox c2=new JCheckBox ("green");
		JCheckBox c3=new JCheckBox ("blue");
		add(c1);
		add(c2);
		add(c3);
    }
}
class FlPanel extends JPanel
{
	public FlPanel()
    {
		JComboBox cb1=new JComboBox();
		cb1.addItem("ss");
		cb1.addItem("ns");
		cb1.addItem("ms");
		add(cb1);
    }
}



