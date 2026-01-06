// Uses BFS to compute level sums and a min-heap to track the k largest sums efficiently

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {

        // Queue for level-order (BFS) traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Min-heap to keep track of k largest level sums
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        // Traverse the tree level by level
        while (!queue.isEmpty()) {

            int size = queue.size();   // Number of nodes at current level
            long levelSum = 0;         // Sum of current level

            // Process all nodes of the current level
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                levelSum += curr.val;

                // Add children for next level
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            // Add current level sum to heap
            minHeap.offer(levelSum);

            // Maintain only k largest level sums
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // If there are fewer than k levels
        if (minHeap.size() < k) {
            return -1;
        }

        // Top of min-heap is the k-th largest level sum
        return minHeap.peek();
    }
}
// Uses BFS to compute level sums and a min-heap to track the k largest sums efficiently
