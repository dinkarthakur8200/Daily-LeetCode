class Solution {

    public long findKthSmallest(int[] coins, int k) {

        long minCoin = Integer.MAX_VALUE;

        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }

        long low = 1;
        long high = minCoin * (long) k;

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins) {

        int n = coins.length;
        long total = 0;

        // Enumerate every non-empty subset
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    bits++;

                    lcm = lcm(lcm, coins[i]);

                    // LCM is already larger than x
                    if (lcm > x) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) {
                continue;
            }

            long count = x / lcm;

            // Odd subset -> add
            // Even subset -> subtract
            if (bits % 2 == 1) {
                total += count;
            } else {
                total -= count;
            }
        }

        return total;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}