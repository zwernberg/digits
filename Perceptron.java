import java.util.List;

/**
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
	private double inputs[];
	private double outputs[];
	private double[][] weights;
	private int[] pVals;
	private int[] tVals;
	private double correct;
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
		this.inputs = new double[featureNum+1];
		//initial bias input as bottom of input list
		this.inputs[this.inputs.length-1] = 1.0;
		this.outputs = new double[labelNum];
		this.tVals = new int[labelNum];
		this.pVals = new int[labelNum];
		this.weights = new double[featureNum+1][labelNum];
		for (int i=0;i<weights.length;i++){
			for (int j=0;j<weights[i].length;j++){
				weights[i][j] = INIT_WEIGHT;
			}
		}
	}

	/**
	 * Train your Perceptron in this method.
	 * 
	 * @param trainingData
	 */
	public void train(Dataset trainingData) {
		//main loop
		for(int i=0;i<EPOCH;i++){
			this.correct = 0.0;
			for (int k=0;k<trainingData.instanceList.size();k++){
				//initialize inputs
				List<Double> testFeatures = trainingData.instanceList.get(k).getFeatureValue();
				for (int j=0;j<testFeatures.size();j++){
					this.inputs[j] = testFeatures.get(j);
				}
				//keep track of highest value and the index of that value
				int eVal = Integer.parseInt(trainingData.instanceList.get(k).getLabel());
				//System.out.println("expected value is " + eVal);
				int highest = 0;
				double hVal = 0.0;
				for(int j=0;j<this.outputs.length;j++){
					this.outputs[j] = sigmoid(j);
					if (this.outputs[j] > hVal){
						highest = j;
						hVal = this.outputs[j];
					}
				}
				for (int j=0;j<this.outputs.length;j++){
					if (j == highest){
						this.pVals[j] = 1;
					}
					else{
						this.pVals[j] = 0;
					}

					if(j == eVal){
						this.tVals[j] = 1;
					}
					else{
						this.tVals[j] = 0;
					}
				}
				//System.out.println("predicted value is " + highest);
				updateWeights();
				if (highest == eVal){
					correct++;
				}
			}

		}
		//System.out.println("% correct is " + (correct/trainingData.instanceList.size())* 100);
	}

	private double sigmoid(int j) {
		double in = 0.0;
		for (int i=0;i<inputs.length;i++){
			in += (this.inputs[i] * this.weights[i][j]);
		}
		return (1 / (1 + Math.exp(-in)));
	}
	private void updateWeights(){
		for (int i=0;i<this.inputs.length;i++){
			for (int j=0;j<this.outputs.length;j++){
				this.weights[i][j] += (this.ALPHA * (this.tVals[j] - this.outputs[j]) * this.outputs[j] * (1-this.outputs[j]) * this.inputs[i]);
			}
		}

		return;
	}
	/**
	 * Test your Perceptron in this method. Refer to the homework documentation
	 * for implementation details and requirement of this method.
	 * 
	 * @param testData
	 */
	public void classify(Dataset testData) {
		this.correct = 0.0;
		for (int k=0;k<testData.instanceList.size();k++){
			//initialize inputs
			List<Double> testFeatures = testData.instanceList.get(k).getFeatureValue();
			for (int j=0;j<testFeatures.size();j++){
				this.inputs[j] = testFeatures.get(j);
			}
			//keep track of highest value and the index of that value
			int eVal = Integer.parseInt(testData.instanceList.get(k).getLabel());
			int highest = 0;
			double hVal = 0.0;
			for(int j=0;j<this.outputs.length;j++){
				this.outputs[j] = sigmoid(j);
				if (this.outputs[j] > hVal){
					highest = j;
					hVal = this.outputs[j];
				}
			}
			for (int j=0;j<this.outputs.length;j++){
				if (j == highest){
					this.pVals[j] = 1;
				}
				else{
					this.pVals[j] = 0;
				}

				if(j == eVal){
					this.tVals[j] = 1;
				}
				else{
					this.tVals[j] = 0;
				}
			}
			//System.out.println("predicted value is " + highest);
			updateWeights();
			if (highest == eVal){
				correct++;
			}
			System.out.println(highest);
		}
		double accuracy = ((correct/testData.instanceList.size()));
		System.out.printf("%6.4f\n", accuracy);
	}

}