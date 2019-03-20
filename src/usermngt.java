

import java.awt.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class usermngt extends JFrame 


{

public usermngt()
{
    super("USER MANAGEMENT");

	
	Color clr=null;
	JTabbedPane jtp=new JTabbedPane();
	jtp.addTab("Add",new addPanel(this));
	

 
	jtp.setBackground(clr.magenta);

			getContentPane().add(jtp);
	setBounds(250,100,450,500);	
	setVisible(true);
	

}


public static void main(String args[])
	{
		new usermngt();
	}
}
	
 
class addPanel extends JPanel implements ActionListener
{

	JTextField ttname;
	JPasswordField pass1,repass;
	JButton bbsave,bbback;
        JCheckBox ctrain,cidentify,cimage,crecord,cchange,cuser;
        usermngt fram;
	public addPanel(usermngt fram)
    {	
	this.fram=fram;
        JLabel jb=new JLabel();
	jb=new JLabel(new ImageIcon("image/200430948-001.PNG"));
	
	Font ft1=new Font("Impact",10,15);
	Color clr=null;
	setBackground(clr.green);
	 ttname=new JTextField(15);	 
	 pass1=new JPasswordField();
	 repass=new JPasswordField();
	JLabel llname,lpas,lrepas;
	
	llname=new JLabel("UserName :");	
	lpas=new JLabel("Password :");
        lrepas=new JLabel("Re-Enter :");
	
	llname.setFont(ft1);	
	lpas.setFont(ft1);
        lrepas.setFont(ft1);
	bbsave=new JButton("Save");
	bbback=new JButton("Back");	
	llname.setBounds(50,50,80,30);
	lpas.setBounds(50,100,80,30);
        lrepas.setBounds(50,150,80,30);
	ttname.setBounds(150,50,200,30);
	pass1.setBounds(150,100,200,30);
        repass.setBounds(150,150,200,30);
	bbsave.setBounds(150,400,80,40);
	bbback.setBounds(270,400,80,40);
         setLayout(null);
	jb.add(llname);
	jb.add(lpas);
        jb.add(lrepas);
	jb.add(pass1);
        jb.add(repass);
        jb.add(ttname);

	jb.add(bbback);
	jb.add(bbsave);
	

        ctrain=new JCheckBox("Training");
	cidentify=new JCheckBox("Identification");
	crecord=new JCheckBox("Record Management");
	cchange=new JCheckBox("Change Password");
	cuser=new JCheckBox("User Management");

       ctrain.setBounds(50, 200, 100, 30);
       jb.add(ctrain);
       cidentify.setBounds(160, 200, 100, 30);
       jb.add(cidentify);
       crecord.setBounds(270, 200, 150, 30);
       jb.add(crecord);
       cchange.setBounds(80, 250, 150, 30);
       jb.add(cchange);
       cuser.setBounds(250, 250, 150, 30);
       jb.add(cuser);

	
	add(jb);
	jb.setBounds(0,-10,450,500);	
	jb.setVisible(true);
	bbback.addActionListener(this);
	bbsave.addActionListener(this);
	
    }
		public void actionPerformed(ActionEvent e)		
	{
              String name=ttname.getText().trim();
              String pass=pass1.getText();
              String rp=repass.getText();
               if(e.getSource()==bbsave)
               {
                   if(pass.equals(rp))
                   {
                      String str1,str2,str3,str4,str5;

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
                                XMLDataBase xm=new XMLDataBase();
                                xm.editDB(pass, str, name);
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null,"Password Mismatch");
                   }

               }
               else if(e.getSource()==bbback)
               {
                   fram.dispose();                 
               }

	}
	
}
