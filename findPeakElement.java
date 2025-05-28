public int findPeakElement(int[] nums) {
    int left = 0, right = nums.length - 1;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] > nums[mid + 1]) {
            // You're in the decreasing part — move left
            right = mid;
        } else {
            // You're in the increasing part — move right
            left = mid + 1;
        }
    }

    // Left and right have converged to a peak
    return left;
}
