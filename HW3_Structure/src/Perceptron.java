/**
 * You should implement your Perceptron in this class. 
 * Any methods, variables, or secondary classes could be added, but will 
 * only interact with the methods or variables in this framework.
 * 
 * You must add code for at least the 3 methods specified below. Because we
 * don't provide the weights of the Perceptron, you should create your own 
 * data structure to store the weights.
 * 
 */
public class Perceptron {
	
	/**
	 * The initial value for ALL weights in the Perceptron.
	 * We fix it to 0, and you CANNOT change it.
	 */
	public final double INIT_WEIGHT = 0.0;
	
	/**
	 * Learning rate value. You should use it in your implementation.
	 * You can set the value via command line parameter.
	 */
	public final double ALPHA;
	
	/**
	 * Training iterations. You should use it in your implementation.
	 * You can set the value via command line parameter.
	 */
	public final int EPOCH;
	
	// TODO: create weights variables, input units, and output units.
	
	/**
	 * Constructor. You should initialize the Perceptron weights in this
	 * method. Also, if necessary, you could do some operations on
	 * your own variables or objects.
	 * 
	 * @param alpha
	 * 		The value for initializing learning rate.
	 * 
	 * @param epoch
	 * 		The value for initializing training iterations.
	 * 
	 * @param featureNum
	 * 		This is the length of input feature vector. You might
	 * 		use this value to create the input units.
	 * 
	 * @param labelNum
	 * 		This is the size of label set. You might use this
	 * 		value to create the output units.
	 */
	public Perceptron(double alpha, int epoch, int featureNum, int labelNum) {
		this.ALPHA = alpha;
		this.EPOCH = epoch;
		
		// TODO: add your code here
	}
	
	/**
	 * Train your Perceptron in this method.
	 * 
	 * @param trainingData
	 */
	public void train(Dataset trainingData) {
		
		// TODO: add your code here
	}
	
	/**
	 * Test your Perceptron in this method. Refer to the homework documentation
	 * for implementation details and requirement of this method.
	 * 
	 * @param testData
	 */
	public void classify(Dataset testData) {
		
		// TODO: add your code here
	}
	
}