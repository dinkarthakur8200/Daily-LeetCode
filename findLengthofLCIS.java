🔍 Purpose:
Find the length of the Longest Continuous Increasing Subsequence (LCIS) in an array of integers.

✅ Key Concepts:
Continuous: Elements must be next to each other.

Strictly increasing: Each number must be greater than the previous one.

🔧 How it works:
Edge Case: If the array is empty, return 0.

Initialize:

maxLen = 1 → tracks the maximum increasing length.

curLen = 1 → tracks current increasing streak.

Loop through array from index 1:

If current element is greater than previous → increase curLen.

Else → reset curLen to 1.

Update maxLen if curLen is greater.

Return maxLen at the end.

📦 Time & Space Complexity:
Time: O(n) — single pass through the array.

Space: O(1) — uses only two variables.

📌 Example:
For input [1, 3, 5, 4, 7], LCIS is [1, 3, 5] → Output: 3.

Let me know if you want this in a PDF or need notes for another function!
