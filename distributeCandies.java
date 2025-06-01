class Solution {
    public long distributeCandies(int n, int limit) {
        long total = nCr(n + 2, 2); // Total ways without constraints

        for (int mask = 1; mask < 8; mask++) {
            int bits = Integer.bitCount(mask);  // 1, 2, or 3 children over limit
            int subtractCandies = (limit + 1) * bits;

            int remaining = n - subtractCandies;
            if (remaining < 0) continue;

            long ways = nCr(remaining + 2, 2);

            if (bits % 2 == 1) total -= ways;  // subtract for odd count (1, 3)
            else total += ways;               // add back for even count (2)
        }

        return Math.max(0, total); // Non-negative result
    }

    // Efficient nCr function (only for small r, i.e. r = 2 here)
    private long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - i + 1) / i;
        }
        return res;
    }
}
