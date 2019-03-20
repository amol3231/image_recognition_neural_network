import java.sql.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Vector;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
class menu extends JFrame implements ActionListener
{

	JMenuBar mbar;
	JMenu file,settings,help;
	JMenuItem tra,id,rm,e,live,photo;
	JMenuItem um,pr,cp,ab,abp;
	JLabel lab;
	JToolBar tb;
	Color clr=null;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8 = null;
	Object obj;
        ImageIcon img;

	public menu()
	{

	super("MAINFORM");
        setLayout(null);
	obj=this;
	 mbar=new JMenuBar();
	 tb=new JToolBar();

	 addButtons(tb);

	 setJMenuBar(mbar);
	file=new JMenu("File");
	file.add(tra=new JMenuItem("Training"));
	file.add(id=new JMenuItem("Identification"));
	file.add(photo=new JMenuItem("Photo"));	
	file.add(rm=new JMenuItem("Record Management"));
	file.add(e=new JMenuItem("Exit"));
	settings=new JMenu("Settings");
	settings.add(um=new JMenuItem("User Management"));
	settings.add(pr=new JMenuItem("Privillages"));
	settings.add(cp=new JMenuItem("ChangePassword"));

	help=new JMenu("Help");

	help.add(ab=new JMenuItem("About Us"));
	help.add(abp=new JMenuItem("About Project"));

	mbar.add(file);
	mbar.add(settings);
	mbar.add(help);

	add(tb, BorderLayout.NORTH);
	tb.setPreferredSize(new Dimension(50, 40));
	tb.setVisible(true);

	mbar.setBackground(clr.cyan);


        img = new ImageIcon("images\\menu.png");
        JPanel jp= new JPanel()
        {
            public void paintComponent(Graphics g)
            {
                g.drawImage(img.getImage(), 0, 0,500,500,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jp.setBounds(0, 0, 500, 500);
        jp.setLayout(null);
        add(jp);

	setBounds(250,100,500,500);
	setVisible(true);

	tra.addActionListener(this);
	id.addActionListener(this);
	
	photo.addActionListener(this);
	rm.addActionListener(this);
	e.addActionListener(this);
	um.addActionListener(this);
	pr.addActionListener(this);
	cp.addActionListener(this);
	ab.addActionListener(this);
	abp.addActionListener(this);

        setDefaultCloseOperation(3);

	}

		public void addButtons(JToolBar jb)

			{



		jb2 = new JButton(new ImageIcon("image/imag11.png"));
		jb2.setToolTipText("Training");
		jb2.addActionListener(this);


			tb.add(jb2);


		jb3 = new JButton(new ImageIcon("image/imag5.png"));
		jb3.setToolTipText("Identification");
		jb3.addActionListener(this);
			tb.add(jb3);


		jb4 = new JButton(new ImageIcon("image/imag10.png"));
		jb4.setToolTipText("RecordManagement");
		jb4.addActionListener(this);


			tb.add(jb4);
		tb.addSeparator();
		jb5 = new JButton(new ImageIcon("image/imag6.png"));
		jb5.setToolTipText("UserManagement");
		jb5.addActionListener(this);

		tb.add(jb5);
		jb6 = new JButton(new ImageIcon("image/imag8.png"));
		jb6.setToolTipText("Privillage Settings");
		jb6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				new privillage();
							}
		});;

		tb.add(jb6);
		jb7 = new JButton(new ImageIcon("image/imag12.png"));
		jb7.setToolTipText("Changepassword");
		jb7.addActionListener(this);
			tb.add(jb7);
			tb.addSeparator();
			jb8 = new JButton(new ImageIcon("image/imag9.png"));
		jb8.setToolTipText("About Project");
		jb8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new abtprj();
							}
		});
			tb.add(jb8);

	jb1= new JButton(new ImageIcon("image/imags.PNG"));


		jb1.setToolTipText("Exit");

		jb1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
							}
		});
		tb.add(jb1);
			}

	public static void main(String args[])
	{
		new menu();

	}

	public void actionPerformed(ActionEvent ae)
	{
		String s1=null,s2=null,s3=null,s4=null,s5=null,check=null,str1=null;
		String st=log1.str;
                Vector v=null;
		try
		{
		    XMLDataBase xm =new XMLDataBase();
	            v =xm.getdata(st);
                    str1=v.get(1).toString();
                    s1=str1.substring(0,1);
                    s2=str1.substring(1,2);
                    s3=str1.substring(2,3);
                    s4=str1.substring(3,4);
                    s5=str1.substring(4,5);
                    check="f";
				
		}catch(Exception ex)
   		{
		System.out.println("error  "+ex)	;
   		}



		try{
				if (ae.getSource()==photo)
				{
					new photoCapture1(1).capture();
				}
				
				if(ae.getSource()==e)
				{


				int  y=JOptionPane.showConfirmDialog (null,"Are u sure to exit from the system? Press YES to exit.","NOTIFICATION",JOptionPane.YES_NO_CANCEL_OPTION);
				if (y==JOptionPane.YES_OPTION)
				{
					System.exit(0);

				}

				}


				 else if(ae.getSource()==rm )
				{

						if (s3.equals(check))
						{

								JOptionPane.showMessageDialog(null," Access is denied.");
						}
						else
						{
						this.setVisible(false);
				     	new recordmngt();

						}
				}
				else if(ae.getSource()==um )
				{


					if (s5.equals(check))
					{
							JOptionPane.showMessageDialog(null,"  Access is denied..");
					}
					else
					{

					new usermngt();

					}
				}
				else if (ae.getSource()==cp )
				{
						if (s4.equals(check))
						{
								JOptionPane.showMessageDialog(null,"  Access is denied..");
						}
						else
						{
						new Chgpaswd();
						}
				}
				else if (ae.getSource()==tra )
				{
					if (s1.equals(check))
					{
							JOptionPane.showMessageDialog(null,"  Access is denied.");
					}
					else
					{
					new training();
					}
				}
				else if (ae.getSource()==id )
				{

						if (s2.equals(check))
						{
							JOptionPane.showMessageDialog(null,"  Access is denied..");
						}
					    else
						{
							new identify();
						}
				}
				else if (ae.getSource()==ab)
				{
					new abtme();
				}
				else if (ae.getSource()==abp)
				{
					new abtprj();
				}
				if (ae.getSource()==pr)
				{
					new privillage();
				}

			}
                catch(Exception ex)
               {
		  System.out.println("error  "+ex)	;
	       }

	 	 String s11=null,s22=null,s33=null,s44=null,s55=null,check1=null,str11=null;
		String stt=log1.str;
		try
		{
		str11=v.get(1).toString();
		s11=str1.substring(0,1);
		s22=str1.substring(1,2);
		s33=str1.substring(2,3);
		s44=str1.substring(3,4);
		s55=str1.substring(4,5);
	        check1="f";
				
		}catch(Exception ex)
   		{
		System.out.println("error  "+ex)	;
   		}



		try{



				 if( ae.getSource()==jb4)
				{

						if (s33.equals(check1))
						{

								JOptionPane.showMessageDialog(null," Access is denied.");
						}
						else
						{

				     	new recordmngt();

						}
				}
				else if( ae.getSource()==jb5)
				{


					if (s55.equals(check1))
					{
							JOptionPane.showMessageDialog(null,"  Access is denied..");
					}
					else
					{

					new usermngt();

					}
				}
				else if ( ae.getSource()==jb7)
				{
						if (s44.equals(check1))
						{
								JOptionPane.showMessageDialog(null,"  Access is denied..");
						}
						else
						{
						new Chgpaswd();
						}
				}
				else if ( ae.getSource()==jb2)
				{
					if (s11.equals(check))
					{
							JOptionPane.showMessageDialog(null,"  Access is denied.");
					}
					else
					{
					new training();
					}
				}
				else if ( ae.getSource()==jb3)
				{
						if (s22.equals(check1))
						{
							JOptionPane.showMessageDialog(null,"  Access is denied..");
						}
					    else
						{
						new identify();
						}
				}


			}catch(Exception ex)
		   		{
				System.out.println("error  "+ex)	;
		   		}
	}


}



