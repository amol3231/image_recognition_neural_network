//Client Log


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JTable;
  public class Clientlog extends JFrame implements ActionListener
  {
	JTable table;
    Color clr;
	JButton b1;
    JPanel p1;
	conn dbcon;
	DefaultTableModel model;
    public Clientlog()
	 {
		setTitle("Client Log");
		String header[]={"Name","UserName","LoginDate"};
		String data[][]={{"","",""},
	    };
		b1=new JButton("Cancel");
		p1=new JPanel();
        clr= Color.getHSBColor(0.55f,0.25f,0.67f);
		model=new DefaultTableModel(data,header);
	    table=new JTable(model);
		JScrollPane tablepane=new JScrollPane(table);
		tablepane.setBounds(0,0,500,600);
		b1.setBounds(200,440,100,27);
		add(tablepane);
		add(p1);
		p1.add(b1);
		p1.add(tablepane);
	    tablepane.setBackground(clr);
		p1.setBackground(clr);	
		setSize(500,500);
		p1.setLayout(null);
		p1.setBounds(600,100,800,600);
		b1.addActionListener(this);
		setVisible(true);
	 	setLayout(null);
		setBounds(250,100,500,500);
		dbcon=new conn();
		fillTable();
	}
	
	  public void fillTable()
	   {
	     String qry="select * from clientlogin";
         ResultSet rs=null;
         int r=0,c=0;
        try
		 {   
           model.setRowCount(0);
	       rs=dbcon.selectQuery(qry);
           while(rs.next())
             { 
			   model.addRow(new Object[4]);
               model.setValueAt(rs.getString(2),r,0);
		       model.setValueAt(rs.getString(3),r,1);
			   model.setValueAt(rs.getDate(4),r,2);                 
               r++;
             } 
           
        }
		   catch(Exception e){
           e.printStackTrace();
            
        }
    }	
	
	  public static void main(String args[])
	    {
	      Clientlog tb=new Clientlog();
	    }  
	  public void actionPerformed(ActionEvent ae)
	    {
		  try
		    {
			  if (ae.getSource()==b1)
			   {
				  new ServerMenu();
				  setVisible(false);
			   }
	        }
		  catch(Exception ex)
		   	{
				System.out.println("error  "+ex)	;
		   	}
	    }  
    }
		
	

		
