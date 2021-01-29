import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents a sequence generator for a Digit Product Sequence This
 * class does not implement any interface, but can return a iterator through
 * getIterator method
 */
public class DigitProductSequenceGenerator {
	private final int INIT; // initial number
	private final int SIZE; // size of sequence
	private ArrayList<Integer> sequence; // ArrayList object storing the sequence

	/**
	 * constructor Generates a DigitProduct Sequence
	 * 
	 * @param init initial value
	 * @param size number of elements in the sequence
	 */
	public DigitProductSequenceGenerator(int init, int size) {
		// check for the precondition: size > 0, throw an IllegalArgumentException if
		// this precondition is not satisfied
		if (size <= 0)
			throw new IllegalArgumentException("WARNING: " + "CANNOT create a sequence with size <= zero.");
		// check for the validity of init (>0), throw an IllegalArgumentException if
		// these two parameters are not valid
		if (init < 0)
			throw new IllegalArgumentException("WARNING: The starting element for digit product sequence"
					+ " cannot be less than or equal to zero.");

		// set the instance fields
		this.SIZE = size;
		this.INIT = init;
		sequence = new ArrayList<Integer>();
		generateSequence();

	}

	/**
	 * Generate the DigitProduct sequence using loop(s) store the value in the
	 * ArrayList sequence
	 */
	public void generateSequence() {
		sequence = new ArrayList<Integer>(); // clear the arrayList every time this method is called
		Integer now = INIT; // set the initial current value to INIT
		for (int i = 0; i < SIZE; i++) {
			sequence.add(now); // add the current value to sequence
			int product = 1; // set the initial product to 1
			String[] nowString = now.toString().split(""); // transform the Integer value to String
			// then split it to String Array, each String represents a single digit
			for (int j = 0; j < nowString.length; j++) {
				int temp = Integer.parseInt(nowString[j]); // transform each String to int
				if (temp == 0)
					temp = 1;
				product *= temp; // multiply every digit to get the product
			}
			now += product; // after getting the product, add it to now to get the next number
		}
	}

	/**
	 * return an Iterator to iterate over the ArrayList sequence field
	 * 
	 * @return an Iterator to iterate over the ArrayList sequence field
	 */
	public Iterator<Integer> getIterator() {
		return sequence.iterator();
	}

	public ArrayList<Integer> getSequence() {
		return sequence;
	}
}
