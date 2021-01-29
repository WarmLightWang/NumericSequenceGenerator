import java.util.Iterator;

/**
 * This class represents a sequence generator for a Fibonacci Sequence This
 * class implements the Iterator<Integer> interface and digit product sequences
 */
public class FibonacciSequenceGenerator implements Iterator<Integer> {
	private final int SIZE; // number of elements in this sequence
	private int prev; // previous item in the sequence with respect to the current iteration
	private int next; // next item in the sequence with respect to the current iteration
	private int generatedCount; // number of items generated so far

	/**
	 * constructor Generates a Fibonacci Sequence
	 * 
	 * @param size number of elements in the sequence
	 */
	public FibonacciSequenceGenerator(int size) {
		// check for the precondition: size > 0, throws an IllegalArgumentException if
		// this precondition
		// is not satisfied
		if (size <= 0)
			throw new IllegalArgumentException("WARNING: " + "CANNOT create a sequence with size <= zero.");

		// set the instance fields
		this.prev = 0;
		this.next = 1;
		// initializes next to the first element in this arithmetic progression
		this.SIZE = size;
		generatedCount = 0;
	}

	/**
	 * Checks if the iteration has a next element in this sequence
	 * 
	 * @return true if the current element in the iteration has a next element in
	 *         this sequence, false otherwise
	 */
	@Override
	public boolean hasNext() {
		// Time Complexity: O(1)
		return generatedCount < SIZE;
	}

	/**
	 * Returns the next element in this Fibonacci sequence iteration with respect to
	 * the numbers generated so far
	 * 
	 * @return the next element in this iteration
	 */
	@Override
	public Integer next() {
		// Time Complexity: O(1)
		if (!hasNext()) // check if the current element has a next element in this sequence
			return null;
		int current = prev; // set the current element to prev
		generatedCount++; // increment the number of generated elements so far
		prev = next; // set the prev element
		next = current + next; // set the next element (adds the current to the next)
		return current; // return the current number as the generated one
	}
}