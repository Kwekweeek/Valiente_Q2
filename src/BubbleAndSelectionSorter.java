import java.util.Scanner;

public class BubbleAndSelectionSorter {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Initialize an array to store the power levels of creatures
        int[] powerLevels = new int[10];

        // Prompt the user to input 10 power levels
        System.out.println("Enter 10 power levels of creatures:");
        for (int i = 0; i < powerLevels.length; i++) {
            powerLevels[i] = scanner.nextInt(); // Read each power level
        }

        // Clone the original array for Bubble Sort to avoid modifying the original data
        int[] bubbleSorted = powerLevels.clone();
        bubbleSort(bubbleSorted); // Sort the array using Bubble Sort (ascending order)
        System.out.println("\n  - - { { [ Bubble Sort (Ascending ] } } - -\n");
        displayArray(bubbleSorted); // Display the sorted array

        // Clone the original array for Selection Sort
        int[] selectionSorted = powerLevels.clone();
        selectionSort(selectionSorted); // Sort the array using Selection Sort (descending order)
        System.out.println("\n- - { { [ Selection Sort (Descending ] } } - -\n");
        displayArray(selectionSorted); // Display the sorted array

        // Analyze the original array to calculate statistics
        analyzeArray(powerLevels);
    }

    // Bubble Sort Algorithm: Sorts the array in ascending order
    private static void bubbleSort(int[] arr) {
        int n = arr.length; // Length of the array
        for (int i = 0; i < n - 1; i++) { // Loop for passes
            for (int j = 0; j < n - i - 1; j++) { // Compare adjacent elements
                if (arr[j] > arr[j + 1]) { // Swap if the current element is greater
                    int temp = arr[j]; // Temporary variable to hold the value
                    arr[j] = arr[j + 1]; // Swap elements
                    arr[j + 1] = temp; // Complete the swap
                }
            }
        }
    }

    // Selection Sort Algorithm: Sorts the array in descending order
    private static void selectionSort(int[] arr) {
        int n = arr.length; // Length of the array
        for (int i = 0; i < n - 1; i++) { // Loop for passes
            int maxIdx = i; // Assume the current index is the max
            for (int j = i + 1; j < n; j++) { // Find the maximum in the unsorted part
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j; // Update the index of the maximum element
                }
            }
            // Swap the found maximum with the first element of the unsorted part
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // Utility function to display an array
    private static void displayArray(int[] arr) {
        for (int num : arr) { // Iterate through the array
            System.out.print(num + " "); // Print each element separated by a space
        }
        System.out.println(); // Print a newline at the end
    }

    // Analyze the array for statistical properties
    private static void analyzeArray(int[] arr) {
        int sumEven = 0; // Sum of even numbers
        int sumOdd = 0; // Sum of odd numbers
        int min = arr[0]; // Initialize minimum value
        int max = arr[0]; // Initialize maximum value

        // Iterate through the array to calculate the properties
        for (int num : arr) {
            if (num % 2 == 0) { // Check if the number is even
                sumEven += num; // Add to the sum of even numbers
            } else { // Otherwise, it's odd
                sumOdd += num; // Add to the sum of odd numbers
            }
            if (num < min) { // Update the minimum value if the current number is smaller
                min = num;
            }
            if (num > max) { // Update the maximum value if the current number is larger
                max = num;
            }
        }

        // Display the calculated properties
        System.out.println("\n\t  - - { { [ Analysis ] } } - -\n");
        System.out.println("Sum of Even Numbers: " + sumEven);
        System.out.println("Sum of Odd Numbers: " + sumOdd);
        System.out.println("Minimum Power Level: " + min);
        System.out.println("Maximum Power Level: " + max);
    }
}
