
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;



public class BPN {

	static BackpropagationNet bpn;
       
        public static float a[][];
        public static float retwht1[][];
       

	
	////// compares two patterns and returns an accuracy value
	 
	static String compare ( String recallPattern, String targetPattern ) {
		int acc = 0, len = recallPattern.length();
		char[] rp, tp = new char[len];
		rp = recallPattern.toCharArray();
		tp = targetPattern.toCharArray();
		for ( int i=0; i<len; i++ ) if ( rp[i] == tp[i] ) acc++;
		if ( acc == len ) return ( "  GOT IT!" );
		return ( "  (" + acc + "/" + len + ": " +  String.valueOf( (int)(acc*100)/len ) + "%)" );
	}


	
	 ////// shows the results
	 
	static void output () {
		StringBuffer sb = new StringBuffer();
		String recall, accuracy;
		sb.append( "\n\rcycle: " + bpn.getLearningCycle() + "\n\n\r  input:       target:  output:    error:\n\r" );
		for ( int x=0; x<bpn.getNumberOfPatterns(); x++ )
			sb.append(	"  " + bpn.getInputPattern(x) + "   " + bpn.getTargetPattern(x) + "  " + bpn.getOutputPattern(x) + "    " + bpn.getPatternError(x) + "\n\r" );

		sb.append( "\n\r" );
		for ( int r=0; r<bpn.getNumberOfPatterns(); r++ ) {
			recall = bpn.recall( bpn.getInputPattern(r) );
                       
			accuracy = compare( recall, bpn.getTargetPattern(r) );
			sb.append( "  recalling '" + bpn.getInputPattern(r) + "': " + recall + accuracy + "\n\r" );
		}

		double neterror = bpn.getError();
		String acc = (neterror>1.0) ? "2 bad" : String.valueOf((1.0-neterror)*100)+"%";
		sb.append( "\n\rminerror: " + bpn.getMinimumError() + "\n\rneterror: " + neterror + "\n\raccuracy: " + acc + "\n\rtime    : " + bpn.getElapsedTime() + " sec" );
		sb.append( "\n\r-----------------------------------------------------" );
		System.out.println( sb );
                
                
	}       


	/*
	 * here's the action...
	 */
	public BPN( String fname) 
        {
	     System.out.println( "\n\n\rSTARTING TRAINING FOR "+fname+"\n");	
          System.out.println( "---------------------------------------------\n\n\n" );
              
                       
	                bpn = new BackpropagationNet();

			System.out.print( "Reading conversion file ..." );
			bpn.readConversionFile( "ascii2bin.cnv" );	//// 1 ascii value -> 6 binary values
			System.out.println( "OK" );

			System.out.print( "Creating neuron layers ..." );
			bpn.addNeuronLayer( 49 );	//// input layer
			bpn.addNeuronLayer( 7 );	//// output layer
			System.out.println( "OK" );

			System.out.print( "Connecting neuron layers ..." );
			bpn.connectLayers();
			System.out.println( "OK" );

			System.out.println( "\n\rNet structure:" );
			for ( int i=0; i<bpn.getNumberOfLayers(); i++ )
                        {
				System.out.println( "layer " + i + ": " + bpn.getNumberOfNeurons(i) + " neurons" );
                           
                                 System.out.println("\n\n");
                        }
			System.out.println( "weights: " + bpn.getNumberOfWeights() + "\n\r" );

			System.out.print( "Reading pattern file ..." );
			bpn.readPatternFile( fname );
			System.out.println( "OK - patterns: " + bpn.getNumberOfPatterns() );

			// some optional method calls
			bpn.setLearningRate( 0.25 );
			bpn.setMinimumError( 0.0005 );
			bpn.setAccuracy( 0.2 );
			bpn.setMaxLearningCycles( -1 );	// -1 = no maximum cycle
			bpn.setDisplayStep( Integer.parseInt( "5" ) );	// get the argument

			System.out.print( "\n\rallright, let's learn...\n\r" );
			bpn.resetTime();
			while ( !bpn.finishedLearning() ) {		// while the net learns
				bpn.learn();						// perform one learning step
				if ( bpn.displayNow() ) output();	// display the current results
			}
                        
			output();
                       

                        //////////////////////////////////////////////////////////////////////////
                        
                        System.out.println("Length of weight matrix array "+bpn.weightMatrixArray.length);
                        for(int i=0;i<bpn.weightMatrixArray.length;i++)
                        {
                            System.out.println(" "+bpn.weightMatrixArray[i]);
                        }

                       a=bpn.getWeightValues(0);


                        System.out.println("\n\nPrinting 1st weight matrix ......\n");
                        System.out.println("\nNo of rows = "+a.length);
                        System.out.println("\nNo of cols = "+a[0].length);

                        for(int i=0;i<a.length;i++)
                        {
                            for(int j=0;j<a[0].length;j++)
                            {
                               System.out.print(a[i][j]);
                            }
                            System.out.println();
                        }

                        try
                        {
                          String str="";
                           FileOutputStream file4weight1 = new FileOutputStream(fname+".nn");
                           for(int i=0;i<a.length;i++)
                          {
                            for(int j=0;j<a[0].length;j++)
                            {
                               str=str+a[i][j];
                               str=str+" ";

                            }
                           str=str+"\n";
                          }
                           file4weight1.write(str.getBytes());
                           
                           str="";
                        }
                        catch(Exception e)
                        {
                            System.out.println("Error during filling "+e);
                        }                       

			System.out.println( "\n\rFINISHED." );
                       

	}
}



