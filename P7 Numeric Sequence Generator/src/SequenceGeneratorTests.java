/**
 * The class SequenceGeneratorTests is used to test the functions of Sequence
 * class with other important classes. This class has multiple test methods,
 * each test focuses on a specific method, check whether the result is exactly
 * what we want.
 */
public class SequenceGeneratorTests {

	/**
	 * This method checks if either the constructor or hasNext() or next() method
	 * implemented in GeometricSequenceGenerator class return the expected output.
	 * 
	 * @return true when test verifies correct functionality, and false otherwise.
	 */
	public static boolean geometricSequenceGeneratorTest() {
		boolean passed = false;
		try {
			new GeometricSequenceGenerator(1, 1, -1);
		} catch (IllegalArgumentException e) {
			// If no problem occurs, set passed to true
			if (e.getMessage().equals("WARNING: CANNOT create a sequence with size <= zero."))
				passed = true;
		}
		GeometricSequenceGenerator test = new GeometricSequenceGenerator(1, 2, 4);
		// If problem occurs, set passed to false
		if (!(test.hasNext() && test.next() == 1))
			passed = false;
		return passed;
	}

	/**
	 * This method checks if either the constructor or hasNext() or next() method
	 * implemented in FibonacciSequenceGenerator class return the expected output.
	 * 
	 * @return true when test verifies correct functionality, and false otherwise.
	 */
	public static boolean fibonacciSequenceGeneratorTest() {
		boolean passed = false;
		try {
			new FibonacciSequenceGenerator(-1);
		} catch (IllegalArgumentException e) {
			// If no problem occurs, set passed to true
			if (e.getMessage().equals("WARNING: CANNOT create a sequence with size <= zero."))
				passed = true;
		}
		FibonacciSequenceGenerator test = new FibonacciSequenceGenerator(5);
		// If problem occurs, set passed to false
		if (!(test.hasNext() && test.next() == 0))
			passed = false;
		return passed;
	}

	/**
	 * This method should return true if DigitProductSequenceGenerator allows the
	 * user to create a digit-product sequence with the provided initial number and
	 * the provided size. Make sure that the sequence is stored in the sequence
	 * instance field, getIterator() method returns an Iterator over the generated
	 * sequence, and the constructor of DigitProductSequenceGenerator throws the
	 * appropriate exceptions with the appropriate error messages if the provided
	 * parameters to generate this sequence are NOT valid
	 * 
	 * @return true when test verifies correct functionality, and false otherwise.
	 */
	public static boolean digitProductSequenceGeneratorTest() {
		boolean passed = false;
		try {
			new DigitProductSequenceGenerator(1, -1);
		} catch (IllegalArgumentException e) {
			// If no problem occurs, set passed to true
			if (e.getMessage().equals("WARNING: CANNOT create a sequence with size <= zero."))
				passed = true;
		}
		DigitProductSequenceGenerator test = new DigitProductSequenceGenerator(1, 5);
		// If problem occurs, set passed to false
		if (test.getSequence().get(1) != 2)
			passed = false;
		return passed;
	}

	/**
	 * 
	 * Testing main. Runs each test and prints which (if any) failed. If no problem
	 * occurs, print a single line showing "All tests passed!".
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int fails = 0;
		if (!geometricSequenceGeneratorTest()) {
			System.out.println("geometricSequenceGeneratorTest failed");
			fails++;
		}
		if (!fibonacciSequenceGeneratorTest()) {
			System.out.println("fibonacciSequenceGeneratorTest failed");
			fails++;
		}
		if (!digitProductSequenceGeneratorTest()) {
			System.out.println("digitProductSequenceGeneratorTest failed");
			fails++;
		}
		// If no problem occurs, print a single line showing "All tests passed!".
		if (fails == 0)
			System.out.println("All tests passed!");
	}
}
