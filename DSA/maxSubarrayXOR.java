class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int n = arr.length;
        
        // edge case if k is larger than array size 
        if (k > n) {
            return 0;
        }
        // step 1 : calculate XOR  of first k elements 
        int currentXOR = 0;
        for (int i = 0; i < k; i++) {
            currentXOR ^= arr[i];
        }
        
        // initialize maxXOR with the first window 
        int maxXOR = currentXOR;
        
        // step 2; slide the window through remainging elements 
        for (int i = k; i < n; i++) {
            // now , remove the elements going out of window (at position i - k)
            currentXOR ^= arr[i - k];
            
            // add , elements coming into window at position i
            currentXOR ^= arr[i];
            
            // update maximum
            maxXOR = Math.max(maxXOR, currentXOR);
        }
        
        return maxXOR;
    }
}
