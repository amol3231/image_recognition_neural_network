import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Chgpaswd extends JFrame  implements ActionListener
{
	JLabel old,newp,confirm,l1;

	JPasswordField newtxt,oldtxt,confirmtxt;
	JButton submit,cancel;
	Font ft,ft1;
	Color clr ;
    JFrame f;
	public Chgpaswd()
	{
		ft=new Font("Monotype Corsiva",10,26);
		ft1=new Font("Impact",10,15);
		old=new JLabel("OldPassword :");
		old.setForeground(Color.magenta);
		
		newp=new JLabel("NewPassword :");
		newp.setForeground(Color.magenta);
		
		confirm=new JLabel("ConfirmPassword :");
		confirm.setForeground(Color.magenta);
		
		//iris=new JLabel("IRIS RECOGNITION");
		oldtxt=new JPasswordField(15);
		newtxt=new JPasswordField(15);
		confirmtxt=new JPasswordField();
		submit=new JButton("submit");
		cancel=new JButton("Cancel");
		old.setBounds(40,80,100,25);
		newp.setBounds(40,150,100,25);
		confirm.setBounds(40,220,120,25);
		
		oldtxt.setBounds(200,80,150,30);
		newtxt.setBounds(200,150,150,30);
		confirmtxt.setBounds(200,220,150,30);
		submit.setBounds(175,300,80,30);
		cancel.setBounds(270,300,80,30);
		old.setFont(ft1);
		newp.setFont(ft1);
		confirm.setFont(ft1);
		oldtxt.setFont(ft1);
		newtxt.setFont(ft1);
		confirmtxt.setFont(ft1);
		
		JPanel x=new JPanel();
		
		x.setLayout(null);
		l1=new JLabel(new ImageIcon("image/Nvidia_Eye.PNG"));
		l1.add(old);
		l1.add(oldtxt);
		l1.add(newp);
		l1.add(confirm);
		
		l1.add(newtxt);
		l1.add(confirmtxt);
		l1.add(submit);
		l1.add(cancel);
	     submit.setForeground(Color.red);
		 cancel.setForeground(Color.red);
		f=new JFrame("CHANGE PASSWORD");
		f.add(l1);
		
		f.setBounds(250,100,400,400);
		f.setVisible(true);
		submit.addActionListener(this);
		cancel.addActionListener(this);
	}
	public static void main(String args[])
	{
		new Chgpaswd();
	}
		
	public void actionPerformed(ActionEvent ac)
	{
	try
	{
		String strpas=log1.str2;
		String str=log1.str;
		String str1=oldtxt.getText();
		String str2=newtxt.getText();
		String str3=confirmtxt.getText();
		
	if (ac.getSource()==submit)
	{
		if (strpas.equals(str1))
		{
			if (str2.equals(str3))
			{
			 XMLDataBase xm = new XMLDataBase();
			if(xm.passChange(str, str2))
			JOptionPane.showMessageDialog(null,"Password changed successfully.");		
			setVisible(false);	
			}
			
			else
			{
	              oldtxt.setText("");
	              newtxt.setText("");
	              confirmtxt.setText("");
			}
		}
	}
	if (ac.getSource()==cancel)
	{
	     f.dispose();
	}
	
	
	}catch(Exception e)
	
	{
	System.out.println(e);
	
	}
		 	 
    }
} 

