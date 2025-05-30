import java.util.*;

public class ShortestCompletingWord {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        int[] targetCount = getCharCount(licensePlate);

        String result = null;

        for (String word : words) {
            if (isCompletingWord(word, targetCount)) {
                if (result == null || word.length() < result.length()) {
                    result = word;
                }
            }
        }

        return result;
    }

    // Convert a string to a character count array
    private static int[] getCharCount(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                count[Character.toLowerCase(c) - 'a']++;
            }
        }
        return count;
    }

    // Check if a word satisfies the character count requirement
    private static boolean isCompletingWord(String word, int[] targetCount) {
        int[] wordCount = new int[26];
        for (char c : word.toCharArray()) {
            wordCount[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (wordCount[i] < targetCount[i]) {
                return false;
            }
        }
        return true;
    }

    // Example usage
    public static void main(String[] args) {
        String licensePlate = "1s3 PSt";
        String[] words = {"step", "steps", "stripe", "stepple"};

        System.out.println(shortestCompletingWord(licensePlate, words));  // Output: steps
    }
}
