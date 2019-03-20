# image_recognition_neural_network
Java Project using neural network for image recognition 

4.1.2 	Proposed system

The proposed system is called “Face Recognition System”.  This proposed system has both facilities used in the old system as well as some additional  features.This project, focuses on  the structure of a face first. Then some enhancement and compression using image processing technology is done . Finally, image matching is done.
                    An automatic face recognition system normally consists of two stages. The first is the registration stage and the second is the identification stage. In the registration stage, the register's image and personal information are enrolled and features, such as minutiae, are extracted. The personal information and the extracted features are then used to form a file record that is saved into a database for subsequent image identification. Present day automatic face recognition systems may contain several hundred thousand to many millions of such file records. 
                   In the identification stage, image features from an individual and personal information are extracted to form what is typically referred to as a search record. The search record is then compared with the enrolled file records in the database of the image matching system. In a typical search scenario, a search record may be compared against millions of file records that are stored in the database and a list of matched scores are generated after the matching process. Candidate records are sorted according to matched image scores. A matched score is a measurement of the similarity of the image features of the identified search and file records. The higher the score is, the more similar the file and search records are determined to be. Thus, a top candidate is the one that has the closest match. 
This system provide the facilities such as 
Add new criminal profile
Add new user
Add new image
Comparison of images
Changing passwords
Calculating error ratio.
Print  results  etc.
Large volumes of face images are collected and stored everyday in a wide range of applications including forensics, access control, and driver license registration. An automatic recognition of people based on face images requires that the input face be matched with a large number of face images in a database (FBI database contains approximately 70 million faces!). To reduce the search time and computational complexity, it is desirable to classify these face in an accurate and consistent manner so that the input image is required to be matched only with a subset of the images in the database. 

4.2 Functional Specification

The project has 3 steps.	
Extraction
Neural n/w
Identification

4.2.1 Extraction
               In this the extraction of a matrix takes place, i.e, from an image we will extract a matrix area and then it is converted into black & white, which is then converted to a binary matrix.Then rowsum,columnsum is calculated and it is provided as the input for neural network.
                In this phase firstly we extract a 49*49 matrix area from the image. Then we calculate the total average and the average of one pixel.After that we compare the total  average with the average of one pixel.If the average of one pixel is greater than the total average its value is assigned as black else white.Then we calculate rowsum and columnsum.The result is given as input to the neural network.

4.2.2 Neural network
                 The second section is the neural n/w which takes this input and it gives a binary output after the calculation.This binary o/p is compared  with the data stored and if a match is found,the details is displayed.
                                   Neural N/W is a concept that is used in AI to help the AI system to take decisions .So Neural N/W is used to identify a matter it can be 1D,2D or NDimensional.Here in this project we have the Neural N/W to identify a face or to be specific,it identifies a person. Neural N/W has 3 phases

Training phase
Storing phase.
Implementation phase

       Training phase is the phase that trains the neural network to identify a person.it comprises of the following steps.First neural n/w is provided with known input &known o/p & then it is trained so that when an i/p is provided it gives the required o/p.In this stage we provide  multiple images of the person.After the training phase comes the next phase called storing where the data is stored into the database  .The final phase is called the implementation and in that phase the image obtained is compared with the stored data and  a match is found.
          An artificial neural network (ANN), also called a simulated neural network (SNN) or commonly just neural network (NN) is an interconnected group of artificial neurons that uses a mathematical or computational model for information processing based on a connectionistic approach to computation. In most cases an ANN is an adaptive system that changes its structure based on external or internal information that flows through the network.
           In more practical terms neural networks are non-linear statistical data modeling or decision making tools. They can be used to model complex relationships between inputs and outputs or to find patterns in data.
            An artificial neural network involves a network of simple processing elements (artificial neurons) which can exhibit complex global behaviour, determined by the connections between the processing elements and element parameters. One classical type of artificial neural network is the Hopfield net.
          In a neural network model simple nodes, which can be called variously "neurons", "neurodes", "Processing Elements" (PE) or "units", are connected together to form a network of nodes — hence the term "neural network". While a neural network does not have to be adaptive per se, its practical use comes with algorithms designed to alter the strength (weights) of the connections in the network to produce a desired signal flow.
            In modern software implementations of artificial neural networks the approach inspired by biology has more or less been abandoned for a more practical approach based on statistics and signal processing. In some of these systems neural networks, or parts of neural networks (such as artificial neurons) are used as components in larger systems that combine both adaptive and non-adaptive elements.The concept of a neural network appears to have first been proposed by Alan Turing in his 1948 paper "Intelligent Machinery".
             The utility of artificial neural network models lies in the fact that they can be used to infer a function from observations and also to use it. This is particularly useful in applications where the complexity of the data or task makes the design of such a function by hand impractical.

4.2.3 Identification
              Identification by fingerprints relies on pattern matching followed by the detection of certain ridge characteristics, also so known as Galton details, points of identity, or minutiae, and the comparison of the relative positions of these minutiae points with a reference print, usually an inked impression of a suspect's print. There are three basic ridge characteristics, the ridge ending, the bifurcation and the dot (or island). 
              Identification points consist of bifurcations, ending ridges, dots, ridges and islands. A single rolled fingerprint may have as many as 100 or more identification points that can be used for identification purposes. There is no exact size requirement as the number of points found on a image depend on the location of the print. As an example the area immediately surrounding a delta will probably contain more points per square millimetre than the area near the tip of the finger which tends to not have that many points. 
               The binary output obtained from neural network is compared  with the data stored in the database and if a match is found,the details are displayed. Fingerprint matching process compares data from the input search print against all appropriate records in the database to determine if a probable match exists. Minutia relationships, one to another are compared. False positives are easily rejected when ID is not possible.

4.3 	User Characteristics
               The various users of the Face Recognition System are
System Administrator
User
4.3.1 	System administrator

                The system administrator is a  wide  base  role and  is  a  super  user of the     system. The responsibility of a system administrator include
Creation of the various actors (users) of the system etc.
Editing the database etc.
User

	 The user is the person who is having limited rights such as comparing, and add criminal profiles etc.

4.4  System Specification


4.4.1  Software specification for development,implementation 

	Operating System		 :  Windows 98 and above
Programming Language          :  Microsoft Visual C#
Relational Database                 :  SQL SERVER 2000

Hardware specification for development,implementation

           Processor			: Pentium Processor
Ram		                        : 128 MB
Power Supply	 	            : 300v
Adapter Type	: VGA Or SVGA
Floppy Drive			: 1.44 Mb
Cd-ROM Drive                       : Samsung CD-ROM Sc-152c
Hard Disc			: 20GB (Seagate)
             Mouse                                	: Logitech Mouse
Keyboard                           	: TVS Gold 104 Keyboard
Driver Adapter	           : IDE Type 47
