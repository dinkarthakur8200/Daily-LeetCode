class Solution {

    // Utility function to check if a number is "No-Zero"
    private boolean isNoZero(int num) {
        while (num > 0) {
            if (num % 10 == 0) {  // agar koi digit 0 hai
                return false;
            }
            num /= 10;
        }
        return true;
    }

    public int[] getNoZeroIntegers(int n) {
        // Loop through possible a values
        for (int a = 1; a < n; a++) {
            int b = n - a;
            // Check if both a and b are No-Zero integers
            if (isNoZero(a) && isNoZero(b)) {
                return new int[]{a, b};
            }
        }
        // Problem guarantee karta hai ke ek solution hamesha milega
        return new int[]{}; 
    }

    // ✅ Test Example
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] ans1 = sol.getNoZeroIntegers(2);
        System.out.println(ans1[0] + ", " + ans1[1]); // [1, 1]

        int[] ans2 = sol.getNoZeroIntegers(11);
        System.out.println(ans2[0] + ", " + ans2[1]); // [2, 9] or any valid
    }
}
