import java.util.HashMap;
import java.util.Map;

class Solution {

    private static final long MOD = 1_000_000_007L;

    public int countTrapezoids(int[][] points) {

        // Step 1: Count how many points exist at each Y-level
        Map<Integer, Integer> yFreq = new HashMap<>();
        for (int[] p : points) {
            yFreq.put(p[1], yFreq.getOrDefault(p[1], 0) + 1);
        }

        // Step 2: For each level having k points, compute C(k, 2) = k * (k-1) / 2
        // Maintain total sum of C(k,2) and sum of squares
        long sumC = 0;     // Σ C(k,2)
        long sumCSq = 0;   // Σ C(k,2)^2

        for (int count : yFreq.values()) {
            if (count >= 2) {
                long c = ((long) count * (count - 1) / 2) % MOD;
                sumC = (sumC + c) % MOD;
                sumCSq = (sumCSq + (c * c) % MOD) % MOD;
            }
        }

        // Step 3: If we do not have at least two valid levels, no trapezoids exist
        if (sumC == 0) return 0;

        // Step 4: Compute trapezoids count using:
        // Answer = (sumC^2 – Σ c_i^2) / 2  (under modulo)
        long sumCSquare = (sumC * sumC) % MOD;
        long diff = (sumCSquare - sumCSq) % MOD;
        if (diff < 0) diff += MOD;

        long inv2 = (MOD + 1) / 2; // Modular inverse of 2 under MOD
        long result = (diff * inv2) % MOD;

        return (int) result;
    }
}
