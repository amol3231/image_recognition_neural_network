/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Start
{
     public static void main(String arg[])
     {
         BackpropagationNet d = new BackpropagationNet();

         d.addNeuronLayer(2);
         d.addNeuronLayer(2);
         d.addNeuronLayer(1);
         d.connectLayers();
     }
}
