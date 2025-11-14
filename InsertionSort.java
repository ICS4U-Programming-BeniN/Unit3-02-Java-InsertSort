import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class InsertionSort {
    private InsertionSort() { } // Prevent instantiation

    /**
     * Calculates class average.
     * @param args Command-line arguments (not used).
     */
    public static void main(final String[] args) {

        try {
            // Input file
            File inputFile = new File("input.txt");
            Scanner scanner = new Scanner(inputFile);

            // Output file
            PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));

            // Process each line
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                // Split into numbers
                String[] parts = line.trim().split(" ");
                int[] numbers = new int[parts.length];

                for (int i = 0; i < parts.length; i++) {
                    numbers[i] = Integer.parseInt(parts[i]);
                }

                // Sort using insertion sort
                insertionSort(numbers);

                // Write sorted line to output.txt
                for (int num : numbers) {
                    writer.print(num + " ");
                }
                writer.println();  // New line
            }

            // Close files
            writer.close();
            scanner.close();

            System.out.println("Sorting complete. Check output.txt");

        } catch (FileNotFoundException e) {
            // If file not found
            System.out.println("Error: input.txt not found.");
        } catch (IOException e) {
            // If error writing to file
            System.out.println("Error writing to output.txt");
        }
    }

    /**
     * Performs insertion sort on an integer array.
     *
     * @param arr The array to sort
     */
    public static void insertionSort(final int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            // Shift larger elements to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert key
            arr[j + 1] = key;
        }
    }
}
