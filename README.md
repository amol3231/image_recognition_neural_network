# image_recognition_neural_network
‘image_recognition_neural_network’ is implemented using artificial neural networks.
A neural net is an artificial representation of the human brain that tries to simulate its learning process.
Like the human brain, a neural net also consists of neurons and connections between them. The neurons are transporting 
incoming information on their outgoing connections to other neurons. In neural net terms these connections are called weights.
The "electrical" information is simulated with specific values stored in those weights. By simply changing these weight values
the changing of the connection structure can also be simulated.

Information (called the input) is sent to the neuron on its incoming weights. This input is processed by a propagation 
function that adds up the values of all incoming weights.The resulting value is compared with a certain threshold value by 
the neuron’s activation function. If the input exceeds the threshold value, the neuron will be activated, otherwise it will 
be inhibited. If activated, the neuron sends an output on its outgoing weights to all connected neurons and so on. In a neural
net, the neurons are grouped in layers, called neuron layers. Usually each neuron of one layer is connected to all neurons of 
the preceding and the following layer (except the input layer and the output layer of the net). The information given to a 
neural net is propagated layer-by-layer from input layer to output layer through none, one or more hidden layers. Depending on 
the learning algorithm, it is also possible that information is propagated backwards through the net.


# Supervised and unsupervised learning

The learning algorithm of a neural network can either be supervised or unsupervised.
A neural net is said to learn supervised, if the desired output is already known. Example: pattern association. Suppose, 
a neural net shall learn to associate the following pairs of patterns. The input patterns are decimal numbers, each
represented in a sequence of bits. The target patterns are given in form of binary values of the decimal numbers:


 Input pattern   Target pattern
   0001           001
   0010           010
   0100           011
   1000           100
   
 While learning, one of the input patterns is given to the net's input layer. This pattern is propagated through the net 
 (independent of its structure) to the net's output layer. The output layer generates an output pattern which is then 
 compared to the target pattern.
 
  Depending on the difference between output and target, an error value is computed. This output error indicates the 
  net's learning effort, which can be controlled by the "imaginary supervisor". The greater the computed error value is, 
  the more the weight values will be changed.
  
  
 # Two types of modes are used this system.
1. Administrator mode
2. User mode

# Administrator
The administrator is given a user name and a password with which he/she can log in to the account. Password and user 
name verified with the one stored in the database. Once it is verified the administrator is given the following privileges.
• Training
• User management
• Record management 
• User Management

# Training
To train an image, we give the file name and id and call the train function in the train.java class.

Train(filename, startposition, x, y, id)
Then the pixel grabbing and conversion to 3D array takes place. The Red, Blue, Green values will be stored in the 3D array. 
These values will then be converted to binary and stored in an array. The binary values along with the id will be written 
to a file.

The control is then passed to bnp.java class. Here the following events take place.

One ASCII value is converted to six binary values. Function used
readConversionFile(filename)

49 x6(multiplication factor)input neurons and 7 output neurons created. Function used
addNeuronLayer(number)

Then these neurons are connected using connectLayers() function. We use two algorithms for training of the network
• Forward Propagation 
• Backpropagation

# Forward Propagation

Forward propagation is a supervised learning algorithm and describes the "flow of
information" through a neural net from its input layer to its output layer. 

The algorithm works as follows:
1. Set all weights to random values ranging from -1.0 to +1.0
2. Set an input pattern (binary values) to the neurons of the net's input layer
3. Activate each neuron of the following layer:
4. Multiply the weight values of the connections leading to this neuron with the
output values of the preceding neurons.
5. Add up these values.
6. Pass the result to an activation function, which computes the output value of this
neuron.
7. Repeat this until the output layer is reached
8. Compare the calculated output pattern to the desired target pattern and compute
an error value
9. Change all weights by adding the error value to the (old) weight values
10. Gotostep2
11. The algorithm ends, if all output patterns match their target patterns

First, the weight values are set to random values (0.35 and 0.81).

The learning rate of the net is set to 0.25.Next, the values of the first input pattern (0 1) are set to the neurons of the input layer (the output of the input layer is the same as its input).The neurons in the following layer (only one neuron in the output layer) are activated:

Input1ofoutputneuron: 0*0.35=0

Input 2 of output neuron : 1 * 0.81 = 0.81

Add the inputs: 0 + 0.81 = 0.81(= output)

Compute an error value by subtracting output from target: 0 - 0.81 =-0.81 Value for changing weight 1 : 0.25 * 0 * (-0.81) = 0 (0.25 = learning rate) Value for changing weight 2: 0.25 * 1 * (-0.81) = -0.2025

Change weight 1: 0.35 + 0 = 0.35 (not changed)

Change weight 2: 0.81 + (-0.2025) = 0.6075

Now that the weights are changed, the second input pattern (1 1) is set to the input 
layer's neurons and the activation of the output neuron is performed again, now with 
the new weight values:

Input 1 of output neuron: 1 * 0.35 = 0.35

Input 2 of output neuron: 1 * 0.6075 = 0.6075

Add the inputs: 0.35 + 0.6075 = 0.9575 (= output)

Compute an error value by subtracting output from target: 1 - 0.9575 =0.0425

Value for changing weight 1: 0.25 * 1 * 0.0425 = 0.010625

Value for changing weight 2: 0.25 * 1 * 0.0425 = 0.010625

Change weight 1:  0.35 + 0.010625 = 0.360625

Change weight 2: 0.6075+0.010625 =0.618125
  

That was one learning step. Each input pattern had been propagated through the net 
and the weight values were changed.

The error of the net can now be calculated by adding up the squared values of 
the output errors of each pattern:

Compute the net error: (-0.81) + (0.0425) = 0.65790625

By performing this procedure repeatedly, this error value gets smaller and smaller.

 
# Backpropagation

Backpropagation is a supervised learning algorithm and is mainly used by Multi-Layer- 
Perceptrons to change the weights connected to the net’s hidden neuron layer(s).
The backpropagation algorithm uses a computed output error to change the weight values 
in backward direction.
To get this net error, a forward propagation phase must have been done before. 
While propagating in forward direction, the neurons are being activated using the 
sigmoid activation function
The formula of sigmoid activation is: f(x) = 1/(1+exp(-x))


The algorithm works as follows:
1. Perform the forward propagation phase for an input pattern and calculate the output
error
2. Change all weight values of each weight matrix using the formula
weight(old) + learning rate * output error * output (neurons i) * output(neurons i+1) * ( 1 – output(neurons i+1) )
3. Go to step 1
4. The algorithm ends, if all output patterns match their target patterns

Example:
Suppose you have the following 3-layered Multi-Layer-Perceptron: Patterns to be learned:

Input Target
010
111

First, the weight values are set to random values: 0.62, 0.42, 0.55, -0.17 for weight matrix 1 and 0.35, 0.81 for weight matrix 2.
The learning rate of the net is set to 0.25.Next, the values of the first input pattern (0 1) are set to the neurons of the input layer (the output of the input layer is the same as its input).
The neurons in the hidden layer are activated:


Input of hidden neuron 1: 0*0.625 + 1*0.55 = 0.55

Input of hidden neuron 2: 0*0.42+ 1*(-0.17) =0.17

Output of hidden neuron 1: 1/(1+exp(-0.55))= 0.634135591

Output of hidden neuron 2: 1/(1+exp(1+exo(0.17))=0.457602059

The neurons in the output layer are activated:

Input of output neuron: 0.634135591 * 0.35 + 0.457602059 * 0.81 =0.592605124 

Output of output neuron: 1 / ( 1 + exp(-0.592605124) ) = 0.643962658

Compute an error value by subtracting output from target: 0 – 0.643962658 =- 0.643962658

Now that we got the output error, let’s do the backpropagation. We start with changing the weights in weight matrix 2:

Value for changing weight 1: 0.25 * (-0.643962658) * 0.634135591* 0.643962658 * (1-0.643962658) = -0.023406638

Value for changing weight 2: 0.25 * (-0.643962658) * 0.457602059* 0.643962658 * (1- 0.643962658) = -0.016890593

Change weight 1: 0.35 + (-0.023406638) = 0.326593362 Change weight 2: 0.81 + (-0.016890593) = 0.793109407 Now we will change the weights in weight matrix 1:

Value for changing weight 1 : 0.634135591) = 0

Value for changing weight 2 : 0.457602059) = 0

Value for changing weight 3: 0.634135591) = -0.037351064

0.25 * (-0.643962658) * 0* 0.634135591 * (1- 0.25 * (-0.643962658) * 0* 0.457602059 * (1- 0.25 * (-0.643962658) * 1* 0.634135591 * (1-

0 * 0.62 + 1 * 0.55 = 0.55 0 * 0.42 + 1 * (-0.17) = -0.17

1 / ( 1 + exp(-0.55) ) = 0.634135591 1 / ( 1 + exp(+0.17) ) = 0.457602059

Value for changing weight 4: 0.25 * (-0.643962658) * 1* 0.457602059 * (1- 0.457602059) = -0.039958271

Change weight 1: 0.62 + 0 = 0.62 (not changed)

Change weight 2: 0.42 + 0 = 0.42 (not changed)

Change weight 3: 0.55 + (-0.037351064) = 0.512648936

Change weight 4: -0.17+(-0.039958271)=0.209958271

The first input pattern had been propagated through the net.
The same procedure is used for the next input pattern, but then with the changed 
weight values.

After the forward and backward propagation of the second pattern, one learning step 
is complete and the net error can be calculated by adding up the squared output errors
of each pattern.

By performing this procedure repeatedly, this error value gets smaller and smaller. 
The algorithm is successfully finished, if the net error is zero (perfect) or 
approximately zero.


