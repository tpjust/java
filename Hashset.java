//Hashset 

import java.util.*;

class WordCounter {

    // Method to count unique words in the input text
    static int countUniqueWords(String text) {
        // Split the text into words using whitespace as delimiter
        String[] words = text.split("\\s+");

        // Create a HashSet to store unique words
        HashSet<String> uniqueWords = new HashSet<>();

        // Add each word to the HashSet
        for (String word : words) {
            uniqueWords.add(word);
        }

        // Return the size of the HashSet, which represents the count of unique words
        return uniqueWords.size();
    }

}

public class Hashset {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate the WordCounter class

        // Prompt the user to input a text string
        System.out.print("Enter a text string: ");
        String inputText = scanner.nextLine();

        // Count the number of unique words using the WordCounter class
        int uniqueWordCount=WordCounter.countUniqueWords(inputText);

        // Display the result
        System.out.println("Number of unique words: " + uniqueWordCount);

        scanner.close();
    }
}
