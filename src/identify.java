import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import org.omg.SendingContext.RunTime;
public class identify  extends JFrame implements ActionListener
{

         public static String id2retrieve;
         static String idn_path;
	JLabel selectimg,l5,enterid;
	JTextField selecttxt;
        JPasswordField pf;
	
	JButton identify,browse;
	Font ft,ft1;
	Color clr ;
    String idtoret;
	public identify(int x)
	{
	}
	public identify()
	{
		System.out.println("Identification");
		ft=new Font("Monotype Corsiva",10,26);
		ft1=new Font("Impact",10,15);
		selectimg=new JLabel("Select image :");
                enterid =new JLabel("Enter ID");
                enterid.setForeground(Color.magenta);
		selectimg.setForeground(Color.magenta);

		selecttxt=new JTextField(15);
                pf=new JPasswordField();
		browse=new JButton("Browse");
		identify=new JButton("Identify");

		selectimg.setBounds(20,60,100,30);
                enterid.setBounds(20,110,100,30);
                
		selecttxt.setBounds(125,60,200,30);
                pf.setBounds(125,110,200,30);
		browse.setBounds(350,60,100,30);
		identify.setBounds(330,150,120,40);		
		selectimg.setFont(ft1);		
		selecttxt.setFont(ft1);
                enterid.setFont(ft1);
                pf.setFont(ft1);
		

	  	l5=new JLabel(new ImageIcon("image/eeis_03_img0891.PNG"));	

		l5.add(selectimg);
                l5.add(enterid);
		l5.add(selecttxt);
		l5.add(browse);
                l5.add(pf);
	
		l5.add(identify);
		identify.setForeground(Color.magenta);
		browse.setForeground(Color.magenta);

		JFrame f=new JFrame("IDENTIFY");
		f.add(l5);
		
		f.setBounds(250,200,500,250);
		f.setVisible(true);
		
		identify.addActionListener(this);
		browse.addActionListener(this);
	}
	public static void main(String args[])
	{
		new identify();
	}
		
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			
			if (e.getSource()==browse)
			{
				
				JFileChooser jf=new JFileChooser("./");
        		jf.showOpenDialog(null);
        		selecttxt.setText(jf.getSelectedFile().getAbsolutePath());
				System.out.println(selecttxt);
	
				
			}
			if (e.getSource()==identify)
			{
                                idtoret=pf.getText();
			     	id2retrieve=Train.format(Integer.parseInt(idtoret));
                                idn_path=idtoret+"\\";
               if(new File(idtoret).exists())
               {
                 FileInputStream fis=new FileInputStream(selecttxt.getText());
				 byte b[]=new byte[fis.available()];
				fis.read(b);
				FileOutputStream fos=new FileOutputStream("1.jpg");
				fos.write(b);
				fos.close();
				this.dispose();                           
				identifyMe();
               }
               else
                JOptionPane.showMessageDialog(this,"User doesnot Exist");
			}
		}catch(Exception ex)
		   {
			System.out.println("error  "+ex)	;
		   }
	}
	public void identifyMe()
	{
		try
	  {
	  	int id[]=new int[15];
		 id[0]=new Identifcation().myIdentifcation(idn_path+"TrainningResult1.txt.1nn",idn_path+"TrainningResult1.txt.2nn",idn_path+"retieveID1.txt",230,190);
		  id[1]=new Identifcation().myIdentifcation(idn_path+"TrainningResult2.txt.1nn",idn_path+"TrainningResult2.txt.2nn",idn_path+"retieveID2.txt",300,350);
		  id[2]=new Identifcation().myIdentifcation(idn_path+"TrainningResult3.txt.1nn",idn_path+"TrainningResult3.txt.2nn",idn_path+"retieveID3.txt",230,275);
		  id[3]=new Identifcation().myIdentifcation(idn_path+"TrainningResult4.txt.1nn",idn_path+"TrainningResult4.txt.2nn",idn_path+"retieveID4.txt",229,314);
		  id[4]=new Identifcation().myIdentifcation(idn_path+"TrainningResult5.txt.1nn",idn_path+"TrainningResult5.txt.2nn",idn_path+"retieveID5.txt",295,190);
		  id[5]=new Identifcation().myIdentifcation(idn_path+"TrainningResult6.txt.1nn",idn_path+"TrainningResult6.txt.2nn",idn_path+"retieveID6.txt",227,107);
		  id[6]=new Identifcation().myIdentifcation(idn_path+"TrainningResult7.txt.1nn",idn_path+"TrainningResult7.txt.2nn",idn_path+"retieveID7.txt",362,274);
		  id[7]=new Identifcation().myIdentifcation(idn_path+"TrainningResult8.txt.1nn",idn_path+"TrainningResult8.txt.2nn",idn_path+"retieveID8.txt",362,325);
		  id[8]=new Identifcation().myIdentifcation(idn_path+"TrainningResult9.txt.1nn",idn_path+"TrainningResult9.txt.2nn",idn_path+"retieveID9.txt",387,303);
		  id[9]=new Identifcation().myIdentifcation(idn_path+"TrainningResult10.txt.1nn",idn_path+"TrainningResult10.txt.2nn",idn_path+"retieveID10.txt",216,303);
          
               

                  System.out.print( "Total count===>"+Retrieval.count);
                                 System.out.print("\n***************************************\n\n)");
          
		  if((new File(idn_path+"count.txt")).exists())
                  {
		  FileInputStream fin = new FileInputStream(idn_path+"count.txt");
                  byte b[]=new byte[fin.available()];
                  fin.read(b);
                  String s =new String(b);
                  int t=Integer.parseInt(s.trim());
		  if (Retrieval.count>t-25&&Retrieval.count<t+25)
		  {
		  	JOptionPane.showMessageDialog(this,"You are authorised.");
            int d=Integer.parseInt(idtoret);
            new PersonalDetails(d);
		  }
		  else
		  {
		  	JOptionPane.showMessageDialog(this,"You are unauthorised.");
		  }
		  System.out.println("Identification completed");
                  Retrieval.count=0;
                  }
	   }
                catch(Exception ex)
	  {
	  	ex.printStackTrace();
	  }
	}
}
 
		