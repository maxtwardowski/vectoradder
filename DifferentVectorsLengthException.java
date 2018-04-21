public class DifferentVectorsLengthException extends Exception {

	private int length1, length2;

	public DifferentVectorsLengthException() {

	}

	public DifferentVectorsLengthException(String message) {
		super(message);
	}

	public DifferentVectorsLengthException(String message, int length1, int length2) {
		super(message);
		this.length1 = length1;
		this.length2 = length2;
	}

	public int getLength(int lengthNumber) {
		if (lengthNumber == 1)
			return length1;
		else if (lengthNumber == 2)
			return length2;
		else
			return 0;
	}

}
