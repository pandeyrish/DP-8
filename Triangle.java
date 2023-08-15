// Time Complexity : O(n^2)
// Space Complexity : O(n^2) 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach: The minimumTotal method calculates the minimum path sum from the top to the bottom of a triangle represented by a list of lists (triangle). It uses dynamic programming to compute the minimum sum at each position by considering the values from the previous row. The final result is the minimum path sum found at the last row of the triangle. The method handles edge cases where the triangle is empty or null, returning 0 in such cases.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }

        int rows = triangle.size();

        // Convert the triangle to a 2D array for easier access
        int[][] dp = new int[rows][];
        for (int i = 0; i < rows; i++) {
            dp[i] = new int[triangle.get(i).size()];
            // System.out.println(Arrays.deepToString(dp));
        }

        // Initialize the top row of the dp array
        dp[0][0] = triangle.get(0).get(0);

        // Calculate the minimum path sum using dynamic programming
        for (int row = 1; row < rows; row++) {
            List<Integer> currentRow = triangle.get(row);
            for (int col = 0; col < currentRow.size(); col++) {
                if (col == 0) {
                    dp[row][col] = dp[row - 1][col] + currentRow.get(col);
                } else if (col == currentRow.size() - 1) {
                    dp[row][col] = dp[row - 1][col - 1] + currentRow.get(col);
                } else {
                    dp[row][col] = currentRow.get(col) + Math.min(dp[row - 1][col], dp[row - 1][col - 1]);
                }
            }
        }

        // Find the minimum value in the last row of dp array
        int minPathSum = dp[rows - 1][0];
        for (int col = 1; col < dp[rows - 1].length; col++) {
            minPathSum = Math.min(minPathSum, dp[rows - 1][col]);
        }

        return minPathSum;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        Triangle solution = new Triangle();
        int minTotal = solution.minimumTotal(triangle);

        System.out.println("Minimum total path sum: " + minTotal);
    }
}
