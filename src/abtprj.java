import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class abtprj extends JFrame implements ActionListener
{
	Color clr;
	JButton ok;
	Font ft,ft1;
	FileInputStream fis=null;
	JScrollPane spane;
    JLabel l6;
public abtprj()
{
super("About project");
ft=new Font("Monotype Corsiva",10,26);
ft1=new Font("Impact",10,15);
JLabel txt=new JLabel("FACE RECOGNITION");
txt.setForeground(Color.magenta);
JLabel txt1=new JLabel("******************************************************");
txt1.setForeground(Color.blue);
JTextArea  text=new JTextArea();
spane=new JScrollPane(text); 
try
{

fis=new FileInputStream("abtp.txt");
byte b[]=new byte[fis.available()];
int ch=0;
while ((ch=fis.read())!=-1)
{

	String s=""+(char)ch;
	text.append(s);
}
}catch(Exception e)
{
	System.out.println(e);
}

txt.setBounds(140,10,250,40);
txt1.setBounds(140,40,250,20);
txt.setFont(ft);
txt1.setFont(ft1);

ok=new JButton("ok");
ok.setBounds(425,420,50,40);
spane.setBounds(10,60,480,350);

JPanel p=new JPanel();
add(p);
p.setLayout(null);
l6=new JLabel(new ImageIcon("image/200430948-001.PNG"));

l6.setBackground(clr.green);
l6.add(ok);

l6.add(txt);
l6.add(txt1);
l6.add(spane);
ok.setForeground(Color.magenta);


l6.setBounds(10,10,500,500);
add(l6);
setBounds(250,100,500,500);
setVisible(true);
ok.addActionListener(this);
}
public static void main(String args[])
{
		new abtprj();
		
}
public void actionPerformed(ActionEvent ae)
	{
		try{
			if (ae.getSource()==ok)
			{
				new menu();
			}
	        }catch(Exception ex)
		   		{
				System.out.println("error  "+ex)	;
		   		}
	  
	}	


}