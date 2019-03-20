import java.awt.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
class privillage extends JFrame implements ActionListener
{
	JComboBox uname;
	JLabel luname,l;
	JButton bsave6,bback6;
	JCheckBox ctrain,cidentify,cimage,crecord,cchange,cuser;
	Font ft1;
	Color clr;
        XMLDataBase xm=new XMLDataBase();
public  privillage()
{

	super("PRIVILLAGES");
	ft1=new Font("Impact",10,15);
	ctrain=new JCheckBox("	Training. ");
	cidentify=new JCheckBox("	Identification. ");

	crecord=new JCheckBox("	Record Management. ");
	cchange=new JCheckBox("	Change Password. ");
	cuser=new JCheckBox("	User Management. ");
	bsave6=new  JButton("save");
	bback6=new JButton("back");

         Vector v =xm.dispDB();
         v.add(0, "SELECT");
	uname=new JComboBox(v);
	luname=new JLabel("User Name :");
	luname.setBounds(50,50,80,30);
	uname.setBounds(150,50,225,30);
	bsave6.setBounds(225,395,70,40);
	bback6.setBounds(305,395,70,40);
    ctrain.setBounds(50,100,100,40);
	cidentify.setBounds(50,160,125,40);

	crecord.setBounds(50,220,150,40);
	cchange.setBounds(50,280,150,40);
	cuser.setBounds(50,340,150,40);
	JPanel jpp=new JPanel();
	jpp.setLayout(null);
	luname.setFont(ft1);
	l=new JLabel(new ImageIcon("image/Eye_movements_lateral_rot.PNG"));
    l.add(luname);
	l.add(uname);
	l.add(ctrain);
	l.add(cidentify);

	l.add(crecord);
	l.add(cchange);
	l.add(cuser);
	l.add(bsave6);
	l.add(bback6);
    add(l);

	setBounds(250,100,425,500);
	ctrain.setForeground(Color.red);
	cidentify.setForeground(Color.red);
	crecord.setForeground(Color.red);
	cchange.setForeground(Color.red);
	cuser.setForeground(Color.red);
	luname.setForeground(Color.red);
 	bsave6.setForeground(Color.red);
		 bback6.setForeground(Color.red);
	setVisible(true);
	bback6.addActionListener(this);
	bsave6.addActionListener(this);
	
		
	uname.addActionListener(this);

}

public static void main(String args[])
{
	new privillage();
}
public void actionPerformed(ActionEvent ae)

{
	
		if (ae.getSource()==uname)	
		{	  
		  
			String st=(String)uname.getSelectedItem();
		
		    
			if (uname.getSelectedIndex()!=0)
			{
                            try
				{
				       String str1=xm.getdata(st).get(1).toString();
					String s1=str1.substring(0,1);	
					String s2=str1.substring(1,2);
					String s3=str1.substring(2,3);
					String s4=str1.substring(3,4);
					String s5=str1.substring(4,5);
		        	
				
					if(s1.equals("t"))
					   ctrain.setSelected(true);
					else
					    ctrain.setSelected(false);  
					if(s2.equals("t"))
					   cidentify.setSelected(true);
					else
					    cidentify.setSelected(false);  
						if(s3.equals("t"))
					   crecord.setSelected(true);
					else
					    crecord.setSelected(false);  
						if(s4.equals("t"))
					   cchange.setSelected(true);
					else
					    cchange.setSelected(false);  
					if(s5.equals("t"))
					   cuser.setSelected(true);
					else
					    cuser.setSelected(false); 		
		                 }
                            catch(Exception ex)
				   {
					System.out.println("error  "+ex)	;
				   }
			 }
                        else
                        {
                            cchange.setSelected(false);
			crecord.setSelected(false);
			ctrain.setSelected(false);
			cidentify.setSelected(false);
			cuser.setSelected(false);
                        }
	        }
	
		
	
			if (ae.getSource()==bback6)
					{
					
					    dispose();
					
					}

			if (ae.getSource()==bsave6)
			{
					String str1,str2,str3,str4,str5;
						String st=(String)uname.getSelectedItem();			
				if (ctrain.isSelected())
				
					 str1="t";
					else
						str1="f";
				
				 if (cidentify.isSelected())
				
					 str2="t";
					else
						str2="f";
				
				if (crecord.isSelected())
				
					 str3="t";
					else
						str3="f";
				
				 if (cchange.isSelected())
				
					 str4="t";
					else
						str4="f";
				
					 if (cuser.isSelected())
				
					 str5="t";
					else
						str5="f";
				
				String str=str1+str2+str3+str4+str5;

			if (xm.privChange(st, str))
			{

			JOptionPane.showMessageDialog(null," successfull operation.");
                        uname.setSelectedIndex(0);
			

			}
			else
			{
				JOptionPane.showMessageDialog(null," Invalid operation.");	
			}
				
				
			}
		
		
}
}


