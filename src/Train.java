import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
import java.awt.Toolkit;
import java.io.*;


public class Train extends JFrame
{


int rsum,gsum,bsum;
int i=0;
int j=0;
static String binaryID="";
public Train(String fname,int x,int y,int id) throws Exception
{
//Pixel Grabbing   
        Image img;
		File f=new File("1.jpg");
        System.out.println(f.getAbsolutePath());
		img=Toolkit.getDefaultToolkit().getImage(f.getAbsolutePath());
        int oneDim[]=new int[49*49];
        int oneDim2[] = new int[10000];

        PixelGrabber pg=new PixelGrabber(img,x,y,49,49,oneDim,0,49);
        pg.grabPixels();
       
//Convert to 3D array

        int rgb[][][]=new int[49][49][4];
        for(int i=0;i<49;i++)
        {
            for (int j=0;j<49;j++)
            {
                      rgb[i][j][0]=(oneDim[i*49+j] >> 24) & 0xFF;//Hex to Integer conversion
                      rgb[i][j][1]=(oneDim[i*49+j] >> 16) & 0xFF;
                      rgb[i][j][2]=(oneDim[i*49+j] >> 8) & 0xFF;
                      rgb[i][j][3]=(oneDim[i*49+j]) & 0xFF;
                      
            }
        }
       


    char bin[][]=new char [49][49];
    for(i=0;i<49;i++)
    {
        for (j=0;j<49;j++)
        { 
            rgb[i][j][1]=rgb[i][j][1]-80;
            
              if(((rgb[i][j][1]>47)&&(rgb[i][j][1]<58)) ||((rgb[i][j][1]>64)&&(rgb[i][j][1]<91))&&(rgb[i][j][1]>31&&bin[i][j]!=127))
              {
                  bin[i][j]=(char)rgb[i][j][1];
              }
              else
              {
                bin[i][j]=48;
              }
            
              System.out.print("  "+bin[i][j]);
        }
        System.out.println();
    }
     
         
     binaryID=format(id);
    String str="49\n49\n7\n";

    for(i=0;i<49;i++)
    {
        for(j=0;j<49;j++)
        {
           str=str+bin[i][j];          
        }      
        str=str+" "+binaryID+"\n";
    }
    
    System.out.println(str);

    FileOutputStream fout=null;
	File fxx=new File(fname);
	System.out.println(fxx.getAbsolutePath());
	if (!fxx.exists())
	{
		fout=new FileOutputStream(fname);
		fout.write(str.getBytes());
	}

    fout.close();
    
    new BPN(fname);

    
	
}
       

	public static String format(int num)
	{
		String binary_num=Integer.toBinaryString(num);
		
		String formated_data="";
		for(int i=0;i<7;i++)
		{
			if(i<binary_num.length())
				formated_data+=binary_num.charAt(i);
			else
				formated_data="0"+formated_data;	
		}
		
		System.out.println(formated_data);
		return formated_data;
		
	}
        private static String formatnumber(int num)
        {
            String s =Integer.toString(num);
            
		String formated_data="";
		for(int i=0;i<2;i++)
		{
			if(i<s.length())
				formated_data+=s.charAt(i);
			else
				formated_data="0"+formated_data;	
		}
		
		System.out.println(formated_data);
		return formated_data;
        }
}
