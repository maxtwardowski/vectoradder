import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class VectorAdder {

	static void AddVectors(MathVector vector1, MathVector vector2) {

		if (vector1.getNumberOfComponents() == vector2.getNumberOfComponents()){
			ArrayList<Integer> componentsSum = new ArrayList<>();

			for (int i = 0; i < vector1.components.size(); i++)
				componentsSum.add(vector1.components.get(i) + vector2.components.get(i));

			System.out.println(componentsSum);

			final String FNAME = "vectoradderoutput.txt";

			try (BufferedWriter writer = new BufferedWriter (new FileWriter (FNAME))) {
				for (int line : componentsSum) {
					writer.write(line + "\n");
				}
				writer.close();
			} catch (IOException exception) {
				throw new RuntimeException("Saving the result to the file failed", exception);
			}

		} else {
			try {
				throw new DifferentVectorsLengthException("Different number of dimensions!");
			} catch (DifferentVectorsLengthException exception) {
				System.out.println(exception.getMessage());
			}
		}

	}

	public static void main(String[] args) {

		MathVector myvec1 = new MathVector();
		MathVector myvec2 = new MathVector();
		myvec1.setComponents();
		myvec2.setComponents();

		AddVectors(myvec1, myvec2);

	}
}
