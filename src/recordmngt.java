import java.awt.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
public class recordmngt extends JFrame 
{

	public recordmngt()
	{
            
	        super("RECORD MANAGEMENT");
		Color clr=null;
		JTabbedPane jp=new JTabbedPane();
		jp.addTab("Add",new adPanel());	
		jp.addTab("Edit",new edtPanel());
		jp.addTab("Delete",new dlPanel());
	 	getContentPane().add(jp);
		jp.setBackground(clr.cyan);
		setBounds(250,100,450,450);	
		setVisible(true);
		

	}
	public static void main(String agrs[])
	{
		new recordmngt();
	}
}


//Add panel

class adPanel extends JPanel implements ActionListener
{
 JButton bsave,bback;
 JTextField tname,tage,tphone,temail;
 JRadioButton female,male;
 ButtonGroup b;
 
	public adPanel()
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

	bsave=new JButton("Save");
	bback=new JButton("Back");


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
	
	bsave.setBounds(150,320,80,40);
	bback.setBounds(270,320,80,40);
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
	jb.add(bback);
	jb.add(bsave);
	jb.add(male);
	jb.add(female);
	add(jb);
	
	
	jb.setBounds(0,-10,450,500);	
	jb.setVisible(true);
	bsave.addActionListener(this);
	bback.addActionListener(this);

    }
	public void actionPerformed(ActionEvent e)
	{
		boolean b1=male.isSelected();
		boolean b2=female.isSelected();
		String str6="";

	String str1=tname.getText();
	String str2=tage.getText();
	
	String str3=tphone.getText();
	String str4=temail.getText();
	
	

		try
		{
			if (b1==true)
			{
				 str6="m";
			}
				 else if (b2==true)
				{		
				 str6="f";
		    	}
		
					
			if (e.getSource()==bback)
			{
			tname.setText("");
			tage.setText("");
			tphone.setText("");
			temail.setText("");	
			setVisible(false);
			new menu();
			}
			if (e.getSource()==bsave)
			{					
				
			  RecordDB rdb=new RecordDB();
                          rdb.editDB(str1, str2, str6, str3, str4);
			 
			}
			
		
		  }
                catch(Exception ex)
		   {
			System.out.println("error  "+ex)	;
		   }
	}
}



//Edit Panel

class edtPanel extends JPanel implements ActionListener
{
	ButtonGroup b1=new ButtonGroup();
	JTextField tage2,tname2,temail2,tphone2;
	JComboBox cid1;
	JLabel lcid;
	JRadioButton male2,female2; 
	JButton bedit,bsave2,bback2;
        RecordDB rdb = new RecordDB();
	public edtPanel()
    {
	JLabel jb1=new JLabel();
	jb1=new JLabel(new ImageIcon("image/200430948-001.PNG"));
	Font ft1=new Font("Impact",10,15);
	Color clr=null;
	setBackground(clr.green);
	 lcid=new JLabel("SELECT ID");
	lcid.setFont(ft1);
        Vector v=rdb.getAllIDs();
	 cid1=new JComboBox(v);
          cid1.addActionListener(this);
	 tname2=new JTextField();
	 tage2=new JTextField(15);
	 tphone2=new JTextField(15);
	 temail2=new JTextField(15);
	 male2=new JRadioButton("Male");	
	 female2=new JRadioButton("Female");	
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
	male2.setFont(ft1);
	female2.setFont(ft1);

	bsave2=new JButton("Save");
	bback2=new JButton("Back");

	lcid.setBounds(50,50,80,30);
	cid1.setBounds(150,50,200,30);
	lname.setBounds(50,100,80,30);
	lage.setBounds(50,150,80,30);
	lphone.setBounds(50,200,80,30);
	lemail.setBounds(50,250,80,30);
	lsex.setBounds(50,300,80,30);
	male2.setBounds(150,300,80,30);
	female2.setBounds(270,300,80,30);
	tname2.setBounds(150,100,200,30);
	tage2.setBounds(150,150,200,30);
	tphone2.setBounds(150,200,200,30);
	temail2.setBounds(150,250,200,30);

	bsave2.setBounds(150,340,70,40);
	bback2.setBounds(280,340,70,40);
    setLayout(null);
	b1.add(male2);
	b1.add(female2);
	
	jb1.add(lcid);
	jb1.add(cid1);
	jb1.add(lname);
    jb1.add(tname2);
	jb1.add(lage);
	jb1.add(tage2);
	jb1.add(lsex);
	jb1.add(lphone);
	jb1.add(tphone2);
	jb1.add(lemail);
	jb1.add(temail2);
	jb1.add(bback2);
	jb1.add(bsave2);
	jb1.add(male2);
	jb1.add(female2);
	
	add(jb1);
	
	
	jb1.setBounds(0,-10,450,500);	
	jb1.setVisible(true);
	bsave2.addActionListener(this);
	bback2.addActionListener(this);
	
    }
	

	
	public void actionPerformed(ActionEvent ae)

     {
	
		if (ae.getSource()==cid1)	
		{
		  
			
			if (cid1.getSelectedIndex()!=0)
			{
		           try
			     {
				Vector v=rdb.getdata(cid1.getSelectedItem().toString());
				
					
					String str1=v.get(0).toString();
					String str2=v.get(1).toString();
				       String str3=v.get(2).toString();
					String str4=v.get(3).toString();
					String str5=v.get(4).toString();
						
					tname2.setText(str1);
					tage2.setText(str2);
					tphone2.setText(str4);
					temail2.setText(str5);
				
		
					
					if (str3.equals("m"))
					{
						
						male2.setSelected(true);
					}
					 if (str3.equals("f"))
					{
					    female2.setSelected(true);	
				    }
				
				
			
	         	}
                           catch(Exception ex)
				   {
					System.out.println("error  "+ex)	;
				   }
			 }

                        else
                        {
                                      tname2.setText("");
					tage2.setText("");
					tphone2.setText("");
					temail2.setText("");
                                        b1.clearSelection();
                        }
	        }
	
		
	
			if (ae.getSource()==bback2)
					{
					
					setVisible(false);
					new menu();
					}

			if (ae.getSource()==bsave2)
			{			
				boolean b21=male2.isSelected();
				boolean b22=female2.isSelected();
				String str6="";
				
				String str1=tname2.getText();
				String str2=tage2.getText();
				
				String str3=tphone2.getText();
				String str4=temail2.getText();
			

				try
				{
           				if (b21==true)
						{
							 str6="m";
						}
						 else if (b22==true)
						{		
						 str6="f";
				    	}
						

                                         rdb.editDATA(cid1.getSelectedItem().toString(), str1, str2, str6, str3, str4);
					tname2.setText("");
					tage2.setText("");
					tphone2.setText("");
					temail2.setText("");
                                        b1.clearSelection();
					
				}
                                catch(Exception e)
					{
						System.out.println("error  "+e)	;
					}
					
		
				}
        }		

}

//Delete Panel
class dlPanel extends JPanel implements ActionListener 
{
	ButtonGroup b2=new ButtonGroup();
	JButton bdelete,delback;
	JComboBox cid;
	JTextField tname3,tage3,tphone3,temail3;
    public JRadioButton mmale,ffemale;
    RecordDB rdb =new RecordDB();
	public dlPanel()
    {
	JLabel jb2=new JLabel();
	jb2=new JLabel(new ImageIcon("image/200430948-001.PNG"));
	Font ft1=new Font("Impact",10,15);
	Color clr=null;
	setBackground(clr.green);
	 Vector v=rdb.getAllIDs();
	 cid=new JComboBox(v);
	JLabel lid=new JLabel("ID");
	 tname3=new JTextField();

	 tage3=new JTextField(15);
    tphone3=new JTextField(15);
	temail3=new JTextField(15);
	 mmale=new JRadioButton("Male");	
	 ffemale=new JRadioButton("Female");	
	
	JLabel lname,lage,lphone,lemail,lsex;
	
	lname=new JLabel("Name :");
	lage=new JLabel("Age :");
	lphone=new JLabel("Phone :");
	lemail=new JLabel("Email :");
	lsex=new JLabel("Sex :");
	lid.setFont(ft1);
	lname.setFont(ft1);
	lage.setFont(ft1);
	lphone.setFont(ft1);
	lemail.setFont(ft1);
	lsex.setFont(ft1);
	mmale.setFont(ft1);
	ffemale.setFont(ft1);

	bdelete=new JButton("Delete");
	delback=new JButton("Back");
	lid.setBounds(50,50,80,30);
	lname.setBounds(50,100,80,30);
	lage.setBounds(50,150,80,30);
	lphone.setBounds(50,200,80,30);
	lemail.setBounds(50,250,80,30);
	lsex.setBounds(50,300,80,30);
	mmale.setBounds(150,300,80,30);
	ffemale.setBounds(270,300,80,30);
	cid.setBounds(150,50,200,30);
	tname3.setBounds(150,100,200,30);
	tage3.setBounds(150,150,200,30);
	tphone3.setBounds(150,200,200,30);
	temail3.setBounds(150,250,200,30);
	bdelete.setBounds(150,340,80,40);
	delback.setBounds(270,340,80,40);
    setLayout(null);
	b2.add(mmale);
	b2.add(ffemale);	
	jb2.add(lid);
	jb2.add(cid);
	jb2.add(lname);
    jb2.add(tname3);
	jb2.add(lage);
	jb2.add(tage3);
	jb2.add(lsex);
	jb2.add(lphone);
	jb2.add(tphone3);
	jb2.add(lemail);
	jb2.add(temail3);
	jb2.add(delback);
	jb2.add(bdelete);
	jb2.add(mmale);
	jb2.add(ffemale);
	add(jb2);
	
	
	jb2.setBounds(0,-10,450,500);	
	jb2.setVisible(true);
	delback.addActionListener(this);
	bdelete.addActionListener(this);
	

	

	cid.addActionListener(this);
    }


    public void actionPerformed(ActionEvent e)
	{
	try
	{	
				
	if (e.getSource()==cid)
		{
			if (cid.getSelectedIndex()!=0)
			{
		           try
			     {
				Vector v=rdb.getdata(cid.getSelectedItem().toString());


					String str1=v.get(0).toString();
					String str2=v.get(1).toString();
				       String str3=v.get(2).toString();
					String str4=v.get(3).toString();
					String str5=v.get(4).toString();

					tname3.setText(str1);
					tage3.setText(str2);
					tphone3.setText(str4);
					temail3.setText(str5);



					if (str3.equals("m"))
					{

						mmale.setSelected(true);
					}
					 if (str3.equals("f"))
					{
					    ffemale.setSelected(true);
				    }



	         	}
                           catch(Exception ex)
				   {
					System.out.println("error  "+ex)	;
				   }
			 }

                        else
                        {
                                       tname3.setText("");
					tage3.setText("");
					tphone3.setText("");
					temail3.setText("");
                                        b2.clearSelection();
                        }
	}
	if (e.getSource()==bdelete)
	{
            rdb.delete(cid.getSelectedItem().toString());
	}
	
	if (e.getSource()==delback)
			{
			
			setVisible(false);
			new menu();
			}

		}catch(Exception ex)
		   {
			System.out.println("error  "+ex)	;
		   }
	}

}