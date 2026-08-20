Distribute Elements Into Two Arrays I

Problem

Given a 1-indexed array of distinct integers nums, distribute all elements into two arrays, arr1 and arr2, using the following rules:

Put nums[0] into arr1.

Put nums[1] into arr2.

For every remaining element:

If the last element of arr1 is greater than the last element of arr2, append the current element to arr1.

Otherwise, append it to arr2.

Return the result obtained by concatenating arr1 and arr2.

Approach

This problem is a straightforward simulation problem.

We maintain two ArrayList<Integer> objects:

ArrayList<Integer> arr1 = new ArrayList<>();
ArrayList<Integer> arr2 = new ArrayList<>();

For every element starting from index 2, compare the last elements of both arrays:

arr1.get(arr1.size() - 1)
arr2.get(arr2.size() - 1)

The expression

list.get(list.size() - 1)

is used to access the last element of an ArrayList.

After distributing all elements, copy arr1 followed by arr2 into the final int[] result.

Java Solution

import java.util.ArrayList;

class Solution {
public int[] resultArray(int[] nums) {

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        // First two elements are fixed
        arr1.add(nums[0]);
        arr2.add(nums[1]);

        // Distribute remaining elements
        for (int i = 2; i < nums.length; i++) {

            int last1 = arr1.get(arr1.size() - 1);
            int last2 = arr2.get(arr2.size() - 1);

            if (last1 > last2) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        // Concatenate arr1 and arr2
        int[] result = new int[nums.length];
        int index = 0;

        for (int value : arr1) {
            result[index++] = value;
        }

        for (int value : arr2) {
            result[index++] = value;
        }

        return result;
    }

}

Example

Input

nums = [5, 4, 3, 8]

Distribution

Initially:

arr1 = [5]
arr2 = [4]

For 3:

5 > 4

So:

arr1 = [5, 3]
arr2 = [4]

For 8:

3 > 4 -> false

So:

arr1 = [5, 3]
arr2 = [4, 8]

Finally concatenate:

result = [5, 3, 4, 8]

Complexity

Time: O(n)

Space: O(n)

Each element is processed exactly once, and the two arrays together contain all n elements.

Pattern

Primary Pattern: Simulation

The problem directly gives a sequence of operations, so we simply simulate those operations using two dynamic arrays.

Why not Stack?

Although we repeatedly need the last element, there is no pop() or LIFO behavior. We only need to inspect the last element while keeping all previously inserted elements.

Therefore, ArrayList is more appropriate than Stack.

Why not Two Pointers?

There are no two positions moving through the input array based on a pointer condition. Instead, we are maintaining the state of two separate result arrays.

Key Java Pattern

list.get(list.size() - 1)

means:

Get the last element of the ArrayList.

This pattern is useful whenever an ArrayList is being used and we need access to its last element.
