class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            int count = 0;
            int sum = 0;

            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    int d1 = i;
                    int d2 = num / i;

                    count++;
                    sum += d1;

                    if (d1 != d2) {
                        count++;
                        sum += d2;
                    }
                    // early exit...
                    if (count > 4) break;
                }
            }
            if (count == 4) {
                totalSum += sum;
            }
        }

        return totalSum;
    }
}
