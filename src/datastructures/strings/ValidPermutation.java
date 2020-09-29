package datastructures.strings;

import java.util.HashMap;
import java.util.Scanner;

public class ValidPermutation {

    public static final Scanner scanner = new Scanner(System.in);
    public static final int NO_OF_CHARS = 256;

    //Time Complexity: O(a + b)
    //with charCountMap.contains we iterate over all char keys
    public static boolean isPermutation(String a, String b) {
        HashMap<Character, Integer> aCharCountMap = getCharCountMap(a);
        boolean isPermutation = true;
        int charCount;
        Character bChar;
        for (int i = 0; i < b.length(); i++) {
            bChar = b.charAt(i);
            if (!aCharCountMap.containsKey(bChar)) {
                isPermutation = false;
                break;
            } else {
                charCount = aCharCountMap.get(bChar);
                charCount--;
                if (charCount == 0) {
                    aCharCountMap.remove(bChar);
                } else {
                    aCharCountMap.put(bChar, charCount);
                }
            }
        }
        if (!aCharCountMap.isEmpty()) isPermutation = false;
        return isPermutation;
    }

    private static HashMap<Character, Integer> getCharCountMap(String s) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        int charCount;
        Character c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!charCountMap.containsKey(c)) {
                charCountMap.put(c, 1);
            } else {
                charCount = charCountMap.get(c);
                charCountMap.put(c, ++charCount);
            }
        }
        return charCountMap;
    }

    //Time Complexity: O(a + b) & Space Complexity: O(1)
    //we directly access the count of char using arrays
    public static boolean isPermutationBetter(String a, String b) {
        boolean isPermutation = true;
        
        int aCharArray[] = new int[NO_OF_CHARS];
        int bCharArray[] = new int[NO_OF_CHARS];

        for (int i = 0; i < a.length(); i++) {
            aCharArray[a.charAt(i)] += 1;
        }
        for (int i = 0; i < b.length(); i++) {
            bCharArray[b.charAt(i)] += 1;
        }

        for (int i = 0; i < NO_OF_CHARS; i++) {
            if (aCharArray[i] != bCharArray[i]) {
                isPermutation = false;
                break;
            }
        }
        
        return isPermutation;
    }



    public static void main(String[] args) {
        System.out.println("Enter string a: ");
        String a = scanner.nextLine();

        System.out.println("Enter string b: ");
        String b = scanner.nextLine();


        System.out.println("String a is permutation of string b: " + isPermutation(a, b));
        System.out.println("String a is permutation of string b (efficient): " + isPermutationBetter(a, b));
    }

}
