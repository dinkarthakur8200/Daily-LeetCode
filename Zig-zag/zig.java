class zig {
    public String convert(String s, int numRows) {
        // Validate numRows
        if (numRows <= 0) {
            throw new IllegalArgumentException("numRows must be greater than 0");
        }

        // Special case: no zigzag possible
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Create a StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Traverse through the input string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Change direction if we hit top or bottom
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move up or down
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}