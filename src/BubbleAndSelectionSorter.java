import java.util.Scanner;

public class BubbleAndSelectionSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] powerLevels = new int[10];


        System.out.println("Enter 10 power levels of creatures:");
        for (int i = 0; i < powerLevels.length; i++) {
            powerLevels[i] = scanner.nextInt();
        }


        int[] bubbleSorted = powerLevels.clone();
        bubbleSort(bubbleSorted);
        System.out.println("Bubble Sort (Ascending):");
        displayArray(bubbleSorted);


        int[] selectionSorted = powerLevels.clone();
        selectionSort(selectionSorted);
        System.out.println("Selection Sort (Descending):");
        displayArray(selectionSorted);


        analyzeArray(powerLevels);
    }

    // Bubble Sort Algorithm
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {

            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
    }


    private static void displayArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void analyzeArray(int[] arr) {
        int sumEven = 0;
        int sumOdd = 0;
        int min = arr[0];
        int max = arr[0];

        for (int num : arr) {
            if (num % 2 == 0) {
                sumEven += num;
            } else {
                sumOdd += num;
            }
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        System.out.println("Analysis:");
        System.out.println("Sum of Even Numbers: " + sumEven);
        System.out.println("Sum of Odd Numbers: " + sumOdd);
        System.out.println("Minimum Power Level: " + min);
        System.out.println("Maximum Power Level: " + max);
    }
}
