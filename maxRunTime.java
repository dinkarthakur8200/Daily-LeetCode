class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries)
            sum += b;

        long low = 0, high = sum / n, ans = 0;

        while (low <= high) {
            long mid = (low + high) / 2;

            long total = 0;
            for (int b : batteries)
                total += Math.min(b, mid);

            if (total >= mid * n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
