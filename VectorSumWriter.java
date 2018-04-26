import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class VectorSumWriter {

    final String FNAME;
    ArrayList<Integer> componentsSum;

    public VectorSumWriter(String FNAME, ArrayList<Integer> componentsSum) {
        this.FNAME = FNAME;
        this.componentsSum = componentsSum;
        writeToFile();
    }

    public void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter (new FileWriter (this.FNAME))) {
            for (int line : this.componentsSum)
                writer.write(line + "\n");
            writer.close();
        } catch (IOException exception) {
            throw new RuntimeException("Saving the result to the file failed", exception);
        }
    }

}
