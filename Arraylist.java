//arraylist operations

import java.util.*;

public class Arraylist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        List<Integer> list = new ArrayList<>();
        
        // Read elements from user
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        //List<Integer> inputList = new ArrayList<>(Arrays.asList(10, 20, 10, 15, 40, 15, 40));
        
        //Collections.addAll(list, 10, 20, 10, 15, 40, 15, 40);
        
        // Remove duplicates
        List<Integer> uniqueList = removeDuplicates(list);
        System.out.println("Unique values: " + uniqueList);
        
                // I. Check if an element exists in ArrayList
                System.out.print("Enter an element to check existence: ");
                int element = scanner.nextInt();
                System.out.println("Element exists: " + list.contains(element));
        
                // II. Add element at a particular index
                System.out.print("Enter element to add: ");
                int newElement = scanner.nextInt();
                System.out.print("Enter index to add the element at: ");
                int index = scanner.nextInt();
                list.add(index, newElement);
                System.out.println("ArrayList after adding element: " + list);
        
                // III. Remove element at a particular index
                System.out.print("Enter index to remove the element from: ");
                int removeIndex = scanner.nextInt();
                list.remove(removeIndex);
                System.out.println("ArrayList after removing element: " + list);
        
                // IV. Sort a given ArrayList
                ArrayList<Integer> sortedList = new ArrayList<>(list);
                Collections.sort(sortedList);
                System.out.println("Sorted ArrayList: " + sortedList);
        
                // V. Reverse elements in an ArrayList
                ArrayList<Integer> reversedList = new ArrayList<>(list);
                Collections.reverse(reversedList);
                System.out.println("Reversed ArrayList: " + reversedList);
        
                // VI. Compare two ArrayLists
                ArrayList<Integer> anotherList = new ArrayList<>();
                anotherList.add(10);
                anotherList.add(20);
                anotherList.add(15);
                anotherList.add(40);
                System.out.println("Another ArrayList: " + anotherList);
                System.out.println("ArrayLists are equal: " + list.equals(anotherList));
        
                // VII. Find first and last occurrence of repeated elements
                System.out.print("Enter element to find occurrences: ");
                int findElement = scanner.nextInt();
                int firstOccurrence = list.indexOf(findElement);
                int lastOccurrence = list.lastIndexOf(findElement);
                //to check repeated elements compare first and last occurance of elements 
                System.out.println("First occurrence of " + findElement + ": " + firstOccurrence);
                System.out.println("Last occurrence of " + findElement + ": " + lastOccurrence);
        
        scanner.close();
    }

     static List<Integer> removeDuplicates(List<Integer> list) {
        List<Integer> uniqueList = new ArrayList<>();

        for (Integer element : list) {
            if (!uniqueList.contains(element)) {
                uniqueList.add(element);
            }
        }

        return uniqueList;
    }
    
    
}
