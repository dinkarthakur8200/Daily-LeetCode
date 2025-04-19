# Balanced Binary Tree

This Java project checks whether a given binary tree is height-balanced. A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differs by more than one.

## 📌 Problem Definition

> Given a binary tree, determine if it is height-balanced.

A binary tree is balanced if:
- The left and right subtrees' heights differ by no more than 1 **for every node**.
- Both left and right subtrees are also balanced.

## ✅ Solution Overview

The algorithm uses a bottom-up recursive approach:
- Traverse the tree and calculate the height of each subtree.
- If the difference in height between any two subtrees is more than 1, return `-1` to indicate unbalance.
- Otherwise, return the actual height.

This approach ensures an optimal **O(n)** time complexity, where **n** is the number of nodes in the tree.

## 🧠 Code Structure

### `TreeNode` class
A basic structure for a node in a binary tree.

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
```

### `BalancedBinaryTree` class
Contains the core logic to check whether a binary tree is balanced.

#### `isBalanced(TreeNode root)`
Returns `true` if the tree is balanced, otherwise `false`.

#### `checkHeight(TreeNode node)`
Helper method that recursively checks the height and balance of subtrees.

## 🧪 Test Cases

Three test trees are provided:
1. **Balanced Tree** – returns `true`
2. **Unbalanced Tree** – returns `false`
3. **Empty Tree (null)** – returns `true`

### Sample Output:
```
Tree 1 is balanced: true
Tree 2 is balanced: false
Tree 3 is balanced: true
```

## 💻 How to Run

1. Clone the repository or copy the code into your Java project.
2. Compile and run the `BalancedBinaryTree` class.
3. Observe the output in the console for the given examples.

## 📂 Package

The code is placed inside the `BalancedBinaryTree` package for modularity. Make sure your project folder structure reflects this:
```
src/
└── BalancedBinaryTree/
    └── BalancedBinaryTree.java
```

## 📘 Topics Covered

- Binary Trees
- Tree Traversal
- Depth-first Search (DFS)
- Recursion
- Time & Space Complexity
