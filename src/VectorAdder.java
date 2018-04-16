import java.util.Scanner;

class DifferentVectorsLengthException extends Exception {

	private static final long serialVersionUID = 1L;

	public DifferentVectorsLengthException() {}
	
	public DifferentVectorsLengthException(String message) {
		super(message);
	}
	
}

class Vector {
	int xAxisComponent, yAxisComponent, zAxisComponent;
	
	void setComponents() {
		@SuppressWarnings("resource")
		Scanner componentScanner = new Scanner(System.in);
		String input;
		
		//Setting X-axis component
		while (true) {
			System.out.println("Input X-axis component:");
			input = componentScanner.nextLine();
			try {
				xAxisComponent = Integer.parseInt(input);
				break;
			} catch (NumberFormatException exception) {
				System.out.println("Wrong input, try again!");
			}

		}
		
		//Setting Y-axis component
		while (true) {
			System.out.println("Input Y-axis component:");
			input = componentScanner.next();
			try {
				yAxisComponent = Integer.parseInt(input);
				break;
			} catch (NumberFormatException exception) {
				System.out.println("Wrong input, try again!");
			}

		}
		//Setting Z-axis component
		while (true) {
			System.out.println("Input Z-axis component:");
			input = componentScanner.next();
			
			try {
				zAxisComponent = Integer.parseInt(input);
				break;
			} catch (NumberFormatException exception) {
				System.out.println("Wrong input, try again!");
			}
		}
	}
	
	
	void DisplayValues() {
		System.out.println(xAxisComponent + ", " + yAxisComponent + ", " + zAxisComponent);
	}
	
	int getNumberOfDimensions() {
		int NumberOfDimensions = 0;
		if (xAxisComponent != 0)
			NumberOfDimensions++;
		if (yAxisComponent != 0)
			NumberOfDimensions++;
		if (zAxisComponent != 0)
			NumberOfDimensions++;
		return NumberOfDimensions;
	}
	
}

public class VectorAdder {
	
	static void AddVectors(Vector vec1, Vector vec2) {
		
		if (vec1.getNumberOfDimensions() == vec2.getNumberOfDimensions()) {
			int xSum = vec1.xAxisComponent + vec2.xAxisComponent,
				ySum = vec1.yAxisComponent + vec2.yAxisComponent,
				zSum = vec1.zAxisComponent + vec2.zAxisComponent;
			System.out.printf("The product vector is: %d, %d, %d", xSum, ySum, zSum);
		} else {
			try {
				throw new DifferentVectorsLengthException("The number of dimensions don't match!");
			} catch (DifferentVectorsLengthException exception) {
				System.out.println(exception.getMessage());
				//exception.printStackTrace();
				vec1.setComponents();
				vec2.setComponents();
				AddVectors(vec1, vec2);
			}
		}
	}
	
	public static void main(String[] args) {
		
		Vector vector1 = new Vector();
		Vector vector2 = new Vector();
		vector1.setComponents();
		vector2.setComponents();
		AddVectors(vector1, vector2);
	}
}
