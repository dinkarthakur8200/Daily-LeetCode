// # Add Java Solution for Cinema Seat Allocation

// ## Problem

// Add a Java solution for **LeetCode 1386 — Cinema Seat Allocation**.

// ## Pattern Used

// **Sparse Data + HashMap + Bitmask**

// ### Key Observation

// * `n` can be as large as `10^9`, so iterating through every row is not feasible.
// * Only rows present in `reservedSeats` are affected.
// * An unaffected row can always accommodate **2 groups**.
// * For affected rows, we only need to check three possible seat blocks:

//   * `2–5`
//   * `4–7`
//   * `6–9`

// Since each row has only 10 seats, a **bitmask** can efficiently represent reserved seats.

// ## Approach

// 1. Store reserved seats for each affected row using a `HashMap<Integer, Integer>`.
// 2. Represent each reserved seat using one bit in the row's mask.
// 3. For every affected row:

//    * If seats `2–5` and `6–9` are both available → add `2`.
//    * Otherwise, if any one of `2–5`, `4–7`, or `6–9` is available → add `1`.
// 4. Add `2` groups for every row that has no reservations.

// ## Java Implementation

// ```java
// import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Integer> map = new HashMap<>();

        // Store reserved seats using bitmask
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            // Only seats 2 to 9 matter
            if (col >= 2 && col <= 9) {
                int bit = 1 << col;
                map.put(row, map.getOrDefault(row, 0) | bit);
            }
        }

        int affectedRows = map.size();

        // Every unaffected row can accommodate 2 groups
        int answer = (n - affectedRows) * 2;

        // Masks for the three possible blocks
        int left = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int middle = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int right = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        for (int mask : map.values()) {

            boolean canLeft = (mask & left) == 0;
            boolean canMiddle = (mask & middle) == 0;
            boolean canRight = (mask & right) == 0;

            if (canLeft && canRight) {
                answer += 2;
            } else if (canLeft || canMiddle || canRight) {
                answer += 1;
            }
        }

        return answer;
    }
}
// ```

// ## Complexity

// Let `m = reservedSeats.length`.

// * **Time:** `O(m)`
// * **Space:** `O(m)`

// The solution does not depend on `n`, which can be as large as `10^9`.

// ## Type of Change

// * [x] New DSA solution
// * [x] Java implementation
// * [x] HashMap pattern
// * [x] Bitmask pattern
// * [x] Sparse-data optimization
