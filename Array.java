//array operations 
import java.util.*;

class ArrayOperations {//in array operation dont make different classes 
    
    static int[] initializeArray(int[] elements) {//static cause direct;y calling class method
        return Arrays.copyOf(elements, elements.length);
    }

    static int findSum(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    static int findMax(int[] array) {
        int max = array[0];
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    static int findMin(int[] array) {
        int min = array[0];
        for (int element : array) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    static void sortArray(int[] array) {
        //int[] sortedArray = Arrays.copyOf(array, array.length);//make a copy of array(orginal)
        // Arrays.sort(sortedArray);
        Arrays.sort(array);
        System.out.println("Array sorted in ascending order: " + Arrays.toString(array));
    }

    static void reverseArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
        System.out.println("Array reversed: " + Arrays.toString(array));
    }
}

public class Array{
    public static void main(String[] args) {
        //int[] elements = {3, 5, 1, 4, 2};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] elements = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            elements[i] = scanner.nextInt();
        }
        int[] array = ArrayOperations.initializeArray(elements);

        int sum = ArrayOperations.findSum(array);
        System.out.println("Sum of elements: " + sum);

        int max = ArrayOperations.findMax(array);
        System.out.println("Maximum element: " + max);

        int min = ArrayOperations.findMin(array);
        System.out.println("Minimum element: " + min);

        ArrayOperations.sortArray(array);
        ArrayOperations.reverseArray(array);

        scanner.close();


    }

}
