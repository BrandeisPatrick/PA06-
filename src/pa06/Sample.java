package pa06;

import java.util.ArrayList;

/**
 * A Sample represents a vector of doubles to be used in a clustering algorithm...
 * @author presenting
 *Added a toString() and a Distance() method
 */

public class Sample implements Comparable<Sample> {
	public ArrayList<Double> sample;
	
	public Sample(double[] values) {
		this.sample = new ArrayList<Double>();
		for (int i=0; i<values.length; i++) {
			sample.add(values[i]);
		}
		
	}

	public Sample(int[] values) {
		this.sample = new ArrayList<Double>();
		for (int i=0; i<values.length; i++) {
			sample.add((double) values[i]);
		}

	}

	public Sample() {
		this.sample = new ArrayList<Double>();
	}


	public String toString() {
		String output = "{";
		for(double n : this.sample){   // more efficient because iterator method is used. (instead of get() )
			output += n + ", ";
		}
		output = output.substring(0,output.length()-3);
		output += "}";
		return output;
	}
	
	public double DistanceTo(Sample s2) { //needs interface if your parameter is assumed to be Sample type
		double total = 0;
		for(int i = 0; i<s2.sample.size(); i++) {
			total += Math.sqrt(Math.abs(this.sample.get(i)-s2.sample.get(i)));
		}
		return Math.sqrt(total);
	}

	
	public static void main(String[] args) {
		System.out.println("testing for the Sample class.");
		double[] p1 = {1d, 2d, 3.14, 2.71};
		double[] p2 = {0.1, 1.1, 2.1, 3.1};
		Sample s1 = new Sample(p1);
		Sample s2 = new Sample(p2);
		System.out.println("s1="+s1.toString());
		System.out.println("s2="+s2.toString());
		
	}
	


}
