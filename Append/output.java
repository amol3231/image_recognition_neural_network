import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class output  extends JFrame implements ActionListener
{
	JLabel lname,lage,lphone,lemail,lsex,lab1,lab2;
	JButton ok;
	Font ft,ft1;
	public output()
	{
		//JLabel jb1;
		//jb1=new JLabel(new ImageIcon("image/re.PNG"));
	ft=new Font("Monotype Corsiva",10,26);	
	 ft1=new Font("Impact",10,15);
	Color clr=null;
	setBackground(clr.green);
	JTextField tname=new JTextField(15);
	JTextField tage=new JTextField(15);
	JTextField tphone=new JTextField(15);
	JTextField temail=new JTextField(15);
	JRadioButton male=new JRadioButton("Male");	
	JRadioButton female=new JRadioButton("Female");	
	lab1=new JLabel(new ImageIcon("image/cosmic_eye.PNG"));
	lname=new JLabel("Name :");
	lage=new JLabel("Age :");
	lphone=new JLabel("Phone :");
	lemail=new JLabel("Email :");
	lsex=new JLabel("Sex :");
	lname.setFont(ft1);
	lage.setFont(ft1);
	lphone.setFont(ft1);
	lemail.setFont(ft1);
	lsex.setFont(ft1);
	male.setFont(ft1);
	female.setFont(ft1);
	//bsave.setFont(ft1);
	//bback.setFont(ft1);
	//bsave=new JButton("Save");
	ok=new JButton("OK");
	lab2=new JLabel("Person Identified.");
	lab2.setFont(ft);
	lab2.setBounds(120,10,200,30);
	lname.setBounds(50,50,80,30);
	lage.setBounds(50,100,80,30);
	lphone.setBounds(50,150,80,30);
	lemail.setBounds(50,200,80,30);
	lsex.setBounds(50,250,80,30);
	male.setBounds(150,250,80,30);
	female.setBounds(270,250,80,30);
	tname.setBounds(150,50,200,30);
	tage.setBounds(150,100,200,30);
	tphone.setBounds(150,150,200,30);
	temail.setBounds(150,200,200,30);
	
	//bsave.setBounds(150,320,80,40);
	ok.setBounds(270,320,80,40);
	ok.setForeground(Color.red);

	lname.setForeground(Color.red);
	lphone.setForeground(Color.red);
	lemail.setForeground(Color.red);
	lsex.setForeground(Color.red);
	lage.setForeground(Color.red);
	male.setForeground(Color.red);
	female.setForeground(Color.red);
	lab2.setForeground(Color.red);
	//cancel.setForeground(Color.red);
    //setLayout(null);
	
	//bsave.addActionListener(this);
	//bback.addActionListener(this);

	
		//iris.setFont(ft);
		//og.setBounds(200,225,80,30);
		//cancel.setBounds(290,225,80,30);
	//	JPanel x=new JPanel();
		
		//x.setLayout(null);
		lab1.add(lab2);
		lab1.add(lname);
    	lab1.add(tname);
		lab1.add(lage);
		lab1.add(tage);
		lab1.add(lsex);
		lab1.add(lphone);
		lab1.add(tphone);
		lab1.add(lemail);
		lab1.add(temail);
		lab1.add(ok);
		//x.add(bsave);
		lab1.add(male);
		lab1.add(female);
		//x.add(ch);
      //  ch.setSize(300,300);	
	
		//x.setBackground(clr.green);
		JFrame f=new JFrame("OUTPUT");
		f.add(lab1);
		f.setBounds(250,100,400,425);
		f.setVisible(true);
		//train.addActionListener(this);
		ok.addActionListener(this);
		//browse.addActionListener(this);
	}
	public static void main(String args[])
	{
		new output();
	}
		
	public void actionPerformed(ActionEvent e)
	{
		
		try{
              if (e.getSource()==ok)
			  {
			  	System.exit(0);
			  }
		
								   
			
			
		    }catch(Exception ex)
		   {
			System.out.println("error  "+ex)	;
		   }
	}
}
 
