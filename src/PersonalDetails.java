
import java.awt.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
public class PersonalDetails extends JFrame
{
   JPanel jp;
	public PersonalDetails(int no)
	{

	    super("Personal Details Of ID No :"+no);
		Color clr=null;
		setLayout(null);
		jp=new adPanel1(no);
	 	add(jp);
        jp.setBounds(0, 0, 450, 450);
		jp.setBackground(clr.cyan);
		setBounds(250,100,450,450);
		setVisible(true);


	}

}




//Add panel

class adPanel1 extends JPanel
{

 JTextField tname,tage,tphone,temail;
 JRadioButton female,male;
 ButtonGroup b;
 RecordDB rd=new RecordDB();

	public adPanel1(int no)
    {
	JLabel jb=new JLabel();
	jb=new JLabel(new ImageIcon("image/200430948-001.PNG"));
	Font ft1=new Font("Impact",10,15);
	Color clr=null;
	setBackground(clr.green);

	 tname=new JTextField(15);
	 tage=new JTextField(15);
     tphone=new JTextField(15);
	 temail=new JTextField(15);
	male=new JRadioButton("Male");
	 female=new JRadioButton("Female");
	JLabel lname,lage,lphone,lemail,lsex;


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



    setLayout(null);
	b=new ButtonGroup();
	b.add(male);
	b.add(female);


	jb.add(lname);
    jb.add(tname);
	jb.add(lage);
	jb.add(tage);
	jb.add(lsex);
	jb.add(lphone);
	jb.add(tphone);
	jb.add(lemail);
	jb.add(temail);


	jb.add(male);
	jb.add(female);
	add(jb);

    Vector v=rd.getdata(Integer.toString(no));
    tname.setText(v.get(0).toString());
    tage.setText(v.get(1).toString());
    String str3=v.get(2).toString();

					if (str3.equals("m"))
					{

						male.setSelected(true);
					}
					 if (str3.equals("f"))
					{
					    female.setSelected(true);
				    }
    tphone.setText(v.get(3).toString());
    temail.setText(v.get(4).toString());;



	jb.setBounds(0,-10,450,500);
	jb.setVisible(true);


    }

}


