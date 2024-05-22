//rotate array, rearrange even odd

import java.util.*;

public class Arrayrotate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        System.out.print("Enter the range of values (0 to N): ");
        int range = scanner.nextInt();

        int[] array = generateRandomArray(size, range);
        System.out.println("Generated array: ");
        printArray(array);

        System.out.print("Enter the number of positions to rotate the array to the right: ");
        int positions = scanner.nextInt();
        rotateRight(array, positions);
        System.out.println("Array after right rotation: ");
        printArray(array);

        int[] arrayWithDuplicates = generateRandomArray(size, range);
        System.out.println("Array with duplicates: ");
        printArray(arrayWithDuplicates);
        int[] uniqueArray = removeDuplicates(arrayWithDuplicates);
        System.out.println("Array after removing duplicates: ");
        printArray(uniqueArray);

        int[] arrayToRearrange = generateRandomArray(size, range);
        System.out.println("Array before rearranging: ");
        printArray(arrayToRearrange);
        rearrangeEvenOdd(arrayToRearrange);
        System.out.println("Array after rearranging even and odd numbers: ");
        printArray(arrayToRearrange);

        scanner.close();
    }

    public static int[] generateRandomArray(int size, int range) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(range + 1);
        }
        return array;
    }

    public static void rotateRight(int[] array, int positions) {
        int n = array.length;
        positions = positions % n;
        reverse(array, 0, n - 1);
        reverse(array, 0, positions - 1);
        reverse(array, positions, n - 1);
    }

    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static int[] removeDuplicates(int[] array) {
        ArrayList<Integer> uniqueList = new ArrayList<>();
        for (int value : array) {
            if (!uniqueList.contains(value)) {
                uniqueList.add(value);
            }
        }
        int[] uniqueArray = new int[uniqueList.size()];
        for (int i = 0; i < uniqueList.size(); i++) {
            uniqueArray[i] = uniqueList.get(i);
        }
        return uniqueArray;
    }

    public static void rearrangeEvenOdd(int[] array) {
        ArrayList<Integer> evenList = new ArrayList<>();
        ArrayList<Integer> oddList = new ArrayList<>();
        for (int value : array) {
            if (value % 2 == 0) {
                evenList.add(value);
            } else {
                oddList.add(value);
            }
        }
        int index = 0;
        for (int value : evenList) {
            array[index++] = value;
        }
        for (int value : oddList) {
            array[index++] = value;
        }
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
