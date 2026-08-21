class Solution {
    int transform(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return -1;
        }

        int n = s1.length();

        // Check if both strings contain the same characters
        int[] freq = new int[256];

        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }

        for (int count : freq) {
            if (count != 0) {
                return -1;
            }
        }

        // Match s2 from right to left
        int i = n - 1;
        int j = n - 1;

        while (i >= 0) {

            if (s1.charAt(i) == s2.charAt(j)) {
                j--;

                if (j < 0) {
                    break;
                }
            }

            i--;
        }

        // Characters s2[0 ... j] need to be moved
        return j + 1;
    }
}