import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Color;

public class log1 extends JFrame implements ActionListener
{

    public static String str,str2;
	JLabel user,pass,face;
        JPanel jb;
        ImageIcon img;
	JTextField usrtxt;
	JPasswordField pastxt;
	JButton log,cancel;
	Font ft,ft1;
	JFrame f=new JFrame("Login Form");


	public log1()
	{
		
		ft=new Font("Monotype Corsiva",10,26);
		ft1=new Font("Impact",10,15);
		
		user=new JLabel("UserName :");
		user.setForeground(Color.black);
		
		pass=new JLabel("Password :");
		pass.setForeground(Color.black);
		face=new JLabel("FACE RECOGNITION");
		face.setForeground(Color.black);
		usrtxt=new JTextField(15);
		pastxt=new JPasswordField(15);
		log=new JButton("Login");
		cancel=new JButton("Cancel");
		user.setBounds(50,100,100,30);
		pass.setBounds(50,150,100,30);
		face.setBounds(100,10,300,100);
		usrtxt.setBounds(150,100,220,30);
		pastxt.setBounds(150,150,220,30);
		
		user.setFont(ft1);
		pass.setFont(ft1);
		usrtxt.setFont(ft1);
		pastxt.setFont(ft1);
		face.setFont(ft);
		log.setBounds(200,225,80,30);
		cancel.setBounds(290,225,80,30);

                img = new ImageIcon("images\\log.png");
		jb=new JPanel()
                {
                    public void paintComponent(Graphics g)
                    {
                       g.drawImage(img.getImage(),0,0,400,300,null);
                       setOpaque(false);
                       super.paintComponent(g);
                    }
                };
		jb.setLayout(null);
                jb.setBounds(0, 0, 400, 300);
	        jb.add(user);
		jb.add(pass);
	        jb.add(face);
		jb.add(usrtxt);
		jb.add(pastxt);
		jb.add(log);
		jb.add(cancel);

                f.getContentPane().add(jb);
		
		log.setForeground(Color.black);
		cancel.setForeground(Color.black);

		
		f.setBounds(250,200,400,300);
		f.setVisible(true);
	
		log.addActionListener(this);
		cancel.addActionListener(this);
		
	
	}		
	public static void main(String args[])
	{
		new log1();
	}
		
	public void actionPerformed(ActionEvent e)
	{
		try{
			
		
			 str2=pastxt.getText();
			 str=usrtxt.getText();
			
			if(e.getSource()==log)
			{
				if (str2.equals("") && str.equals(""))
				{
					JOptionPane.showMessageDialog(null,"ENTER UR PASSWORD & USERNAME");
				}else if(str2.equals(""))
				{
					JOptionPane.showMessageDialog(null,"ENTER UR PASSWORD ");
				}else if(str.equals(""))
				{
					JOptionPane.showMessageDialog(null,"ENTER UR USERNAME");
				}
				else
				{
						
					XMLDataBase mx=new XMLDataBase();
				       if (mx.logincheck(str, str2))
				      {
					 JOptionPane.showMessageDialog(null,"SUCCESSFUL LOGIN ");
					 f.dispose();
				         new menu();
                             	       }
				else
				{
					JOptionPane.showMessageDialog(null,"INVALID USER");
					usrtxt.setText("");
					pastxt.setText("");
							
				}	
				}			
				 	
				
			   
			}  						   
				
			 if (e.getSource()==cancel)
			{
				System.exit(0);
					usrtxt.setText("");
					pastxt.setText("");
			}
		   }catch(Exception ex)
		   {
			System.out.println("error  "+ex)	;
		   }
	}
}
 