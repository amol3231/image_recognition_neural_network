import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
class abtme extends JFrame implements ActionListener
{
	Color clr;
	JButton ok;
	Font ft,ft1;
	FileInputStream fip=null;
	JScrollPane ppane;
public abtme()
{
super("About Us");

ft=new Font("Monotype Corsiva",10,26);
ft1=new Font("Impact",10,15);

JLabel txt=new JLabel("FACE RECOGNITION");
JLabel txt1=new JLabel("******************************************************");
JTextArea  text=new JTextArea();
try
{
fip=new FileInputStream("abtpp.txt");
byte b[]=new byte[fip.available()];
int ch=0;
while ((ch=fip.read())!=-1)
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
ppane=new JScrollPane(text);
ppane.setBounds(10,60,480,350);
text.setBounds(10,60,480,350);
ok=new JButton("ok");
ok.setBounds(425,420,50,40);
JPanel p=new JPanel();
add(p);
p.setLayout(null);
text.setBackground(clr.cyan);
p.setBackground(clr.green);
p.add(ok);

p.add(txt);
p.add(txt1);
p.add(ppane);

p.setBounds(10,10,500,500);
setBounds(250,100,500,500);
setVisible(true);
ok.addActionListener(this);
}
public static void main(String args[])
{
		new abtme();
		
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