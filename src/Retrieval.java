
import java.io.FileInputStream;

public class Retrieval
{
    static BackpropagationNet bpn;
    static int count=0;
        public static float a[][];
        public static float retwht1[][],retwht2[][];

     static void retrievedoutput () {
		StringBuffer sb = new StringBuffer();
		String recall, accuracy;
		sb.append( "\n\rcycle:\n\n\rinput:\t\t\t\t\t\toutput:  \n\r" );
		sb.append( "\n\r" );
		for ( int r=0; r<bpn.getNumberOfPatterns(); r++ ) {
			recall = bpn.recall( bpn.getInputPattern(r) );
                        if(recall.equals(identify.id2retrieve))
                            count++;
			sb.append( "  recalling count'"+r+" )   " + bpn.getInputPattern(r) + "': " + recall+ "\n\r" );
		}

		System.out.println( sb );
	}



     void retrieve(String weight_1,String weight_2,String extract)
     {
                System.out.println("\n\n\nInside reteivelllllllllllllllllllllll\n\n");
                        bpn = new BackpropagationNet();
                        System.out.print( "Reading conversion file ..." );
			bpn.readConversionFile( "ascii2bin.cnv" );	// 1 ascii value -> 6 binary values
			System.out.println( "OK" );

			System.out.print( "Creating neuron layers ..." );
			bpn.addNeuronLayer( 49 );	// input layer
                        bpn.addNeuronLayer(21);
			bpn.addNeuronLayer( 7 );	// output layer
			System.out.println( "OK" );




                        //////////////////READING WEIGHTS FROM FILE ///////////////////////////
              System.out.println("Printing from a file .1nn ");
                        byte weightmat1[];
                        String ss1="";
                        try
                        {
                           FileInputStream weight1=new FileInputStream(weight_1);
                           weightmat1=new byte[weight1.available()];
                           weight1.read(weightmat1);
                           ss1=new String(weightmat1);
                           System.out.println(ss1);

                        }
                        catch(Exception e)
                        {
                           e.printStackTrace();
                        }

                        String sss1[]=ss1.split("\n");
                        System.out.print("length of natrix "+sss1.length);
                        String t1[]=sss1[0].split(" ");
                        
                        
                        
                       retwht1=new float[sss1.length][t1.length];
                        int j=0;
                        for(int i=0;i<sss1.length;i++)
                        {
                            String ssss1[]=sss1[i].split(" ");
                            for(j=0;j<ssss1.length;j++)
                            {
                                retwht1[i][j]=Float.parseFloat(ssss1[j]);
                            }
                            
                        }

            System.out.println("Printing from a file .2nn ");
                        byte weightmat2[];
                        String ss2="";
                        try
                        {
                           FileInputStream weight2=new FileInputStream(weight_2);
                           weightmat2=new byte[weight2.available()];
                           weight2.read(weightmat2);
                           ss2=new String(weightmat2);
                           System.out.println(ss2);

                        }
                        catch(Exception e)
                        {
                           e.printStackTrace();
                        }

                        String sss2[]=ss2.split("\n");
                        System.out.print("length of matrix "+sss2.length);
                        String t2[]=sss2[0].split(" ");

                        retwht2=new float[sss2.length][t1.length];
                        j=0;
                        for(int i=0;i<sss2.length;i++)
                        {
                            String ssss2[]=sss2[i].split(" ");
                            for(j=0;j<ssss2.length;j++)
                            {
                                retwht2[i][j]=Float.parseFloat(ssss2[j]);
                            }
                            
                        }
                        
                      System.out.println("No of rows of retwht"+retwht1.length);
                       System.out.println("No of cols of retwht"+retwht1[0].length);

                       System.out.println("Printing retrieved weight from 1st layer\n\n\n");
                        for(int i=0;i<retwht1.length;i++)
                        {
                            for(j=0;j<retwht1[0].length;j++)
                            {
                               System.out.print(retwht1[i][j]);
                            }
                            System.out.println();
                        }
                      System.out.println("No of rows of retwht"+retwht2.length);
                       System.out.println("No of cols of retwht"+retwht2[0].length);

                       System.out.println("Printing retrieved weight from 2nd layer\n\n\n");
                        for(int i=0;i<retwht2.length;i++)
                        {
                            for(j=0;j<retwht2[0].length;j++)
                            {
                               System.out.print(retwht2[i][j]);
                            }
                            System.out.println();
                        }
                        
                        
                        
                       

                /////////////////////////////////////////////////////

			System.out.print( "Connecting neuron layers ..." );
			bpn.connectLayersToRetrieve();
			System.out.println( "OK" );

			System.out.println( "\n\rNet structure:" );
			for ( int i=0; i<bpn.getNumberOfLayers(); i++ )
                        {
				System.out.println( "layer " + i + ": " + bpn.getNumberOfNeurons(i) + " neurons" );
                          
                                 System.out.println("\n\n");
                        }
			System.out.println( "weights: " + bpn.getNumberOfWeights() + "\n\r" );

			System.out.print( "Reading pattern file ..." );
			bpn.readPatternFile(extract);
			System.out.println( "OK - patterns: " + bpn.getNumberOfPatterns() );

			// some optional method calls
			bpn.setLearningRate( 0.25 );
			bpn.setMinimumError( 0.0005 );
			bpn.setAccuracy( 0.2 );
			bpn.setMaxLearningCycles( -1 );	// -1 = no maximum cycle
			bpn.setDisplayStep( Integer.parseInt( "5" ) );	// get the argument

			System.out.print( "\n\rallright, let's learn...\n\r" );
			bpn.resetTime();
			
				bpn.retrieve();						
			
			retrievedoutput();
                       


     }



}
