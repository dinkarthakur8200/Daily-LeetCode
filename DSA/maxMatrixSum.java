class Solution {
    public long maxMatrixSum(int[][] matrix) {
        // Commit 1: Initialize tracking variables
        // We need long for totalSum because sum can exceed int range
        long totalSum = 0;
        
        // Commit 2: Track count of negative numbers
        // This determines if we can make all numbers positive
        int negativeCount = 0;
        
        // Commit 3: Track minimum absolute value
        // If we must keep one negative, it should be the smallest
        int minAbsValue = Integer.MAX_VALUE;

        // Commit 4: Traverse entire matrix to collect information
        // Time Complexity: O(n*m) where n = rows, m = columns
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int value = matrix[i][j];

                // Commit 5: Add absolute value to total sum
                // We assume we can make everything positive first
                totalSum += Math.abs(value);

                // Commit 6: Count negative numbers
                // Even count = all can be positive
                // Odd count = one must remain negative
                if (value < 0) {
                    negativeCount++;
                }

                // Commit 7: Track minimum absolute value across entire matrix
                // This is the best candidate to keep negative (if needed)
                minAbsValue = Math.min(minAbsValue, Math.abs(value));
            }
        }

        // Commit 8: Handle odd negative count case
        // If odd negatives, one MUST stay negative
        // Choose smallest absolute value to minimize loss
        if (negativeCount % 2 == 1) {
            // Subtract twice because we already added it once
            totalSum -= 2 * minAbsValue;
        }

        // Commit 9: Return maximum possible sum
        return totalSum;
    }
    
    // Test cases with detailed explanation
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        System.out.println("=== TEST CASE 1 ===");
        int[][] matrix1 = {
            {1, -1},
            {-1, 1}
        };
        long result1 = solution.maxMatrixSum(matrix1);
        System.out.println("Matrix:");
        printMatrix(matrix1);
        System.out.println("Negative count: 2 (even)");
        System.out.println("All negatives can be eliminated!");
        System.out.println("Result: " + result1);
        System.out.println("Expected: 4 (all positive: 1+1+1+1)");
        System.out.println();
        
        System.out.println("=== TEST CASE 2 ===");
        int[][] matrix2 = {
            {1, 2, 3},
            {-1, -2, -3},
            {1, 2, 3}
        };
        long result2 = solution.maxMatrixSum(matrix2);
        System.out.println("Matrix:");
        printMatrix(matrix2);
        System.out.println("Negative count: 3 (odd)");
        System.out.println("One negative must remain!");
        System.out.println("Keep smallest absolute value (1) negative");
        System.out.println("Result: " + result2);
        System.out.println("Expected: 16 (1+2+3+1+2+3+(-1)+2+3)");
        System.out.println();
        
        System.out.println("=== TEST CASE 3 ===");
        int[][] matrix3 = {
            {-5}
        };
        long result3 = solution.maxMatrixSum(matrix3);
        System.out.println("Matrix:");
        printMatrix(matrix3);
        System.out.println("Negative count: 1 (odd)");
        System.out.println("Single element - must stay negative");
        System.out.println("Result: " + result3);
        System.out.println("Expected: -5");
        System.out.println();
        
        System.out.println("=== TEST CASE 4 ===");
        int[][] matrix4 = {
            {2, 9, 3},
            {5, 4, -4},
            {1, 7, 1}
        };
        long result4 = solution.maxMatrixSum(matrix4);
        System.out.println("Matrix:");
        printMatrix(matrix4);
        System.out.println("Negative count: 1 (odd)");
        System.out.println("Minimum absolute value: 1");
        System.out.println("Keep 1 negative, others positive");
        System.out.println("Result: " + result4);
        System.out.println("Sum = 2+9+3+5+4+4+1+7+1 - 2*1 = 34");
        System.out.println();
    }
    
    // Helper method to print matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%4d ", val);
            }
            System.out.println();
        }
    }
}

/* 
 * ═══════════════════════════════════════════════════════════════
 *                    DETAILED COMMIT HISTORY
 * ═══════════════════════════════════════════════════════════════
 * 
 * Commit 1: Initialize totalSum with long type
 * ────────────────────────────────────────────────────────────────
 * WHY: Matrix can be up to 250x250 with values up to 10^5
 *      Max sum = 250 * 250 * 10^5 = 6.25 * 10^9 > Integer.MAX_VALUE
 * LEARNING: Always consider data type limits for accumulation
 * 
 * ═══════════════════════════════════════════════════════════════
 * Commit 2: Track negative count
 * ────────────────────────────────────────────────────────────────
 * WHY: Key insight - parity of negatives determines solution
 *      - Even negatives: All can become positive
 *      - Odd negatives: Exactly one must remain negative
 * LEARNING: Sometimes counting is more important than values
 * 
 * ═══════════════════════════════════════════════════════════════
 * Commit 3: Track minimum absolute value
 * ────────────────────────────────────────────────────────────────
 * WHY: If one negative must remain, choose smallest to maximize sum
 * EXAMPLE: [-1, -2, -3] → Make [-1] negative, others positive
 *          Sum = -1 + 2 + 3 = 4 (better than -3 + 1 + 2 = 0)
 * LEARNING: Greedy choice - minimize the unavoidable loss
 * 
 * ═══════════════════════════════════════════════════════════════
 * Commit 4: Matrix traversal O(n*m)
 * ────────────────────────────────────────────────────────────────
 * WHY: Must examine every element exactly once
 * OPTIMIZATION: Single pass collects all needed information
 * LEARNING: Combine multiple operations in one pass when possible
 * 
 * ═══════════════════════════════════════════════════════════════
 * Commit 5: Add absolute values to sum
 * ────────────────────────────────────────────────────────────────
 * WHY: Optimistically assume all can be made positive
 * LOGIC: If even negatives, this IS the answer
 *        If odd negatives, we'll adjust later
 * LEARNING: Start with ideal case, adjust for constraints
 * 
 * ═══════════════════════════════════════════════════════════════
 * Commit 6: Count negatives for parity check
 * ────────────────────────────────────────────────────────────────
 * WHY: Parity determines if perfect solution is possible
 * MATH: Each operation flips 2 signs → parity preserved
 *       Start with n negatives, can only reach 0 or 1 negative
 * LEARNING: Parity is often key in flip/toggle problems
 * 
 * ═══════════════════════════════════════════════════════════════
 * Commit 7: Track minimum for worst-case scenario
 * ────────────────────────────────────────────────────────────────
 * WHY: Min absolute value is the "sacrifice" if needed
 * INVARIANT: minAbsValue is always the smallest |element| seen
 * LEARNING: Track extremes while iterating
 * 
 * ═══════════════════════════════════════════════════════════════
 * Commit 8: Adjust for odd negative count
 * ────────────────────────────────────────────────────────────────
 * WHY: Can't eliminate all negatives with odd count
 * MATH: totalSum = Σ|values| (all positive)
 *       To make one negative: -|x| instead of +|x|
 *       Difference: -|x| - |x| = -2|x|
 * EXAMPLE: [1, -2, 3] → Total = 1+2+3 = 6
 *          Keep 1 negative: 6 - 2*1 = 4 = (-1+2+3)
 * LEARNING: Subtract twice when flipping contribution
 * 
 * ═══════════════════════════════════════════════════════════════
 * Commit 9: Return result
 * ────────────────────────────────────────────────────────────────
 * WHY: Final sum is maximum achievable
 * GUARANTEE: This is provably optimal by greedy strategy
 * LEARNING: Sometimes optimal solution is surprisingly simple
 * 
 * ═══════════════════════════════════════════════════════════════
 */
