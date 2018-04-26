import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class VectorAdder {

	static void AddVectors(MathVector vector1, MathVector vector2) throws DifferentVectorsLengthException {

		if (vector1.getNumberOfComponents() == vector2.getNumberOfComponents()) {
			ArrayList<Integer> componentsSum = new ArrayList<>();

			for (int i = 0; i < vector1.components.size(); i++)
				componentsSum.add(vector1.components.get(i) + vector2.components.get(i));

			System.out.println(componentsSum);

			final String FNAME = "vectoradderoutput.txt";
			VectorSumWriter writer = new VectorSumWriter(FNAME, componentsSum);

		} else {
			throw new DifferentVectorsLengthException("Different lengths!", vector1.getNumberOfComponents(), vector2.getNumberOfComponents());
		}

	}

	public static void main(String[] args) {

		MathVector myvec1 = new MathVector();
		MathVector myvec2 = new MathVector();
		myvec1.setComponents();
		myvec2.setComponents();

		boolean done = false;

		while (!done) {
			try {
				AddVectors(myvec1, myvec2);
				done = true;
			} catch (DifferentVectorsLengthException exception) {
				System.out.println(exception.getMessage() + " --> " + exception.getLength1() + ", " + exception.getLength2());
				myvec1.components.clear();
				myvec2.components.clear();
				myvec1.setComponents();
				myvec2.setComponents();
			}
		}
	}
}
