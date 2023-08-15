import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Dynamically allocate memory for the array
        int[] arr = new int[size];

        System.out.print("Enter " + size + " integers: ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Calculate the sum of elements in the array
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }

        System.out.println("Sum of elements in the array: " + sum);

        // Free the dynamically allocated memory (not needed in Java)
        // No need to manually free memory in Java, as the garbage collector manages it

        // Close the scanner
        scanner.close();
    }
}
