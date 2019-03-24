//import com.sun.corba.se.impl.orbutil .LogKeywords;
//import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;
import java.io.*;
//import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class training  extends JFrame implements ActionListener
{
    

       static String train_path;
	JLabel selectimg,imgid,ll,mess;
	JTextField selecttxt;
	JComboBox id;	
	JButton train,back,browse;
	Font ft,ft1;
	Color clr ;
    JFrame f;
	public training()
	{
		super("Training");
		ft=new Font("Monotype Corsiva",10,26);
		ft1=new Font("Impact",10,15);
		selectimg=new JLabel("Select image :");
		selectimg.setForeground(Color.magenta);

                        mess=new JLabel("Training in progress...");
                        mess.setBounds(100,10,300,30);
                        mess.setFont(ft1);                        
                      

		imgid=new JLabel(" ID :");

		id=new JComboBox();
			imgid.setForeground(Color.magenta);
		
		
		selecttxt=new JTextField(15);
		browse=new JButton("Browse");
		train=new JButton("Train");
		back=new JButton("Back");
		back.setForeground(Color.magenta);

		selectimg.setBounds(20,50,100,30);
		selecttxt.setBounds(125,50,200,30);
		imgid.setBounds(20,125,100,30);
		id.setBounds(125,125,200,30);
		browse.setBounds(350,50,100,30);
		back.setBounds(350,200,100,40);
		train.setBounds(225,200,100,40);
		selectimg.setFont(ft1);
		imgid.setFont(ft1);

		selecttxt.setFont(ft1);

        
		JPanel x=new JPanel();
		ll=new JLabel(new ImageIcon("image/iris_image_capture.PNG"));
		x.setLayout(null);
	
        train.setForeground(Color.magenta);
		browse.setForeground(Color.magenta);
		ll.add(selectimg);
        ll.add(mess);
		ll.add(selecttxt);
		ll.add(browse);
		ll.add(imgid);
		ll.add(id);
		ll.add(train);
		ll.add(back);
		
		x.setBackground(clr.green);
		 f=new JFrame("TRAINING");
		f.add(ll);
		
		f.setBounds(250,200,500,300);
		f.setVisible(true);
		train.addActionListener(this);
		back.addActionListener(this);
		browse.addActionListener(this);
		
		Vector v=new RecordDB().getAllIDs();
		try
		{
		for(int i=0;i<v.size();i++)
		{
		id.addItem(v.get(i));
		}
		}catch(Exception e)
			{
			System.out.println("error  "+e)	;
			}
			id.addActionListener(this);
	}
	public static void main(String args[])
	{
		new training();
	}
		
	public void actionPerformed(ActionEvent e)
	{
		
		try{
              if (e.getSource()==back)
			  {
			  	f.dispose();
			  }
		      if (e.getSource()==browse)
			  {

				
				JFileChooser jf=new JFileChooser("./");
        		jf.showOpenDialog(null);
        		selecttxt.setText(jf.getSelectedFile().getAbsolutePath());
				System.out.println(selecttxt);
	

			  }					   					   
			  if (e.getSource()==train)
			  {
			  	if (selecttxt.getText().length()>0)
				{
					
                    FileInputStream fis=new FileInputStream(selecttxt.getText());
					byte b[]=new byte[fis.available()];
					fis.read(b);
					FileOutputStream fos=new FileOutputStream(new File("1.jpg"));
					fos.write(b);
					fos.close();

                                        train_path=id.getSelectedItem().toString()+"\\";

                   for(int i =1;i<=10;i++)
                       {
                           File f=new File(train_path+"TrainningResult"+i+".txt");
                           if(f.exists())
                           f.delete();
                       }
                                        
                     File countfile=new File(train_path+"count.txt");
                     if(countfile.exists())
                     {
                        countfile.delete();
                     }

                        



                        
		       new Train(train_path+"TrainningResult1.txt",230,190,Integer.parseInt(id.getSelectedItem().toString()));
                       mess.setText("1st cycle completed...");
                                       
		       new Train(train_path+"TrainningResult2.txt",300,350,Integer.parseInt(id.getSelectedItem().toString()));
                       mess.setText("2nd cycle completed...");
                       
		       new Train(train_path+"TrainningResult3.txt",230,275,Integer.parseInt(id.getSelectedItem().toString()));
                       mess.setText("3rd cycle completed...");
                       
		       new Train(train_path+"TrainningResult4.txt",229,314,Integer.parseInt(id.getSelectedItem().toString()));
		       mess.setText("4th cycle completed...");
                       
                       new Train(train_path+"TrainningResult5.txt",295,190,Integer.parseInt(id.getSelectedItem().toString()));
                       mess.setText("5th cycle completed...");
                       
                       new Train(train_path+"TrainningResult6.txt",227,107,Integer.parseInt(id.getSelectedItem().toString()));
                       mess.setText("6th cycle completed...");
                       
                       new Train(train_path+"TrainningResult7.txt",362,274,Integer.parseInt(id.getSelectedItem().toString()));
                       mess.setText("7th cycle completed...");
                       
                       new Train(train_path+"TrainningResult8.txt",362,325,Integer.parseInt(id.getSelectedItem().toString()));
                       mess.setText("8th cycle completed...");
                       
                       new Train(train_path+"TrainningResult9.txt",387,303,Integer.parseInt(id.getSelectedItem().toString()));
                       mess.setText("9th cycle completed...");
                       
                       new Train(train_path+"TrainningResult10.txt",216,303,Integer.parseInt(id.getSelectedItem().toString()));
                       mess.setText("10th cycle completed...");


                                 Retrieval.count=0;
                                 identify temp=new identify(1);

                                 identify.id2retrieve=Train.format(Integer.parseInt(id.getSelectedItem().toString()));
                                 identify.idn_path=train_path;
                                 temp.identifyMe();
                                 System.out.print( "Total count===>"+Retrieval.count);
                                 File countf = new File(train_path+"count.txt");
                                 FileOutputStream count= new FileOutputStream(countf);
                                 String countstr=Integer.toString(Retrieval.count);
                                 count.write(countstr.getBytes());
                                 count.close();

                                 System.out.print("\n***************************************\n\n)");
			  		System.out.println("Trainning completed");
                    mess.setVisible(false);
					JOptionPane.showMessageDialog(this,"Training successfully completed");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please choose the image. ");
				}
                                
			  }
			
		    }catch(Exception ex)
		   {
			System.out.println("error  "+ex)	;
                        ex.printStackTrace();
		   }
	}
}
 
