//combine array intersect array

import java.util.*;
public class Intersectarray {
    static int[] intersect(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        
        // Create a new array to hold the combined elements
        int[] combinedArray = new int[len1 + len2];
        
        // Copy elements from arr1 to combinedArray
        for (int i = 0; i < len1; i++) {
            combinedArray[i] = arr1[i];
        }
        
        // Copy elements from arr2 to combinedArray
        for (int i = 0; i < len2; i++) {
            combinedArray[len1 + i] = arr2[i];
        }
        ArrayList<Integer> uniqueList = new ArrayList<>();
        for (int value : combinedArray) {
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

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 2, 6};
        
        int[] combinedArray = intersect(arr1, arr2);
        
        // Print the combined array
        for (int num : combinedArray) {
            System.out.print(num + " ");
        }
    }
}
