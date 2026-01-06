class Solution {
    public int maxLevelSum(TreeNode root) {

        // Queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;                // Current level number
        int answerLevel = 1;          // Level with maximum sum
        int maxSum = Integer.MIN_VALUE;

        // Traverse tree level by level
        while (!queue.isEmpty()) {

            int size = queue.size();  // Number of nodes in current level
            int levelSum = 0;         // Sum of current level

            // Process all nodes of this level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val;

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            // Update maximum level sum and corresponding level
            if (levelSum > maxSum) {
                maxSum = levelSum;
                answerLevel = level;
            }

            level++;
        }

        // Return smallest level with maximum sum
        return answerLevel;
    }
}
// ### Summary – Max Level Sum (POTD)

// * The problem asks for the **smallest level number** in a binary tree whose **node-value sum is maximum**.
// * The correct approach is **Level Order Traversal (BFS)** using a **queue**.
// * Each BFS iteration processes **one full level** by using the queue’s current size.
// * For every level:

//   * Compute `levelSum`
//   * Compare it with `maxSum`
//   * Update the answer only if `levelSum` is **strictly greater**, ensuring the smallest level is returned in case of ties.
// * `Integer.MIN_VALUE` is used to safely handle trees with negative values.
// * Time Complexity: **O(N)** (each node visited once)
// * Space Complexity: **O(N)** (queue in worst case)

// **In one line:**
// The solution uses BFS to calculate level-wise sums and returns the smallest level with the maximum sum efficiently.
