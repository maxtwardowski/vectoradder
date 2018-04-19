import java.util.*;

public class MathVector {
	ArrayList<Integer> components = new ArrayList<>();

    void setComponents() {
        String input;
        Scanner inputScanner = new Scanner(System.in);
        int chceckedInput;

        System.out.println("Input vector's components one by one:");

        while (true) {
            input = inputScanner.nextLine();

            if (input.length() == 0)
                break;

            try {
                chceckedInput = Integer.parseInt(input);
                components.add(chceckedInput);
            } catch (NumberFormatException exception) {
                continue;
            }
        }

        inputScanner.close();

    }

}
