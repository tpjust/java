//longest substring

import java.util.*;

public class Longestsubstring {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            System.out.print("Enter the string: ");
            String input = scanner.nextLine();
    
            int length = findLongestSubstringLength(input);
    
            System.out.println("Length of the longest substring without repeating characters: " + length);
            
            scanner.close();
        }
    
        public static int findLongestSubstringLength(String s) {
            Map<Character, Integer> charIndexMap = new HashMap<>();
            int maxLength = 0;
            int start = 0;
    
            for (int end = 0; end < s.length(); end++) {
                char currentChar = s.charAt(end);
    
                if (charIndexMap.containsKey(currentChar)) {
                    start = Math.max(charIndexMap.get(currentChar) + 1, start);
                }
    
                charIndexMap.put(currentChar, end);
                maxLength = Math.max(maxLength, end - start + 1);
            }
    
            return maxLength;
        }
    }
    
    

