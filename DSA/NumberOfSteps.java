public class NumberOfSteps {

    // ------------------------------------------
    // 1. Iterative Approach (Simple Simulation)
    // ------------------------------------------
    public int numberOfStepsIterative(int num) {
        int steps = 0;

        while (num > 0) {
            if (num % 2 == 0) { // even
                num /= 2;
            } else { // odd
                num -= 1;
            }
            steps++;
        }

        return steps;
    }

    // ------------------------------------------
    // 2. Recursive Approach
    // ------------------------------------------
    public int numberOfStepsRecursive(int num) {
        return helper(num, 0);
    }

    private int helper(int num, int steps) {
        if (num == 0)
            return steps;

        if (num % 2 == 0) {
            return helper(num / 2, steps + 1);
        } else {
            return helper(num - 1, steps + 1);
        }
    }

    // ------------------------------------------
    // 3. Bit Manipulation Optimized Approach
    // ------------------------------------------
    public int numberOfStepsBitManipulation(int num) {
        int steps = 0;

        while (num > 0) {
            if ((num & 1) == 0) { // even
                num >>= 1; // divide by 2
            } else {
                num -= 1; // subtract 1
            }
            steps++;
        }

        return steps;
    }

    // ------------------------------------------
    // Main method for manual testing
    // ------------------------------------------
    public static void main(String[] args) {
        NumberOfSteps solution = new NumberOfSteps();

        int num = 14;

        System.out.println("Iterative Result: " + solution.numberOfStepsIterative(num));
        System.out.println("Recursive Result: " + solution.numberOfStepsRecursive(num));
        System.out.println("Bit Manipulation Result: " + solution.numberOfStepsBitManipulation(num));
    }
}
