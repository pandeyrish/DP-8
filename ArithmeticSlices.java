// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: The numberOfArithmeticSlices method counts the number of arithmetic slices in the given array nums, where an arithmetic slice consists of three or more elements with evenly spaced differences. It uses dynamic programming to track the number of valid slices ending at each position. By iterating through the array and comparing the differences between elements, it accumulates the count of valid arithmetic slices. Finally, it returns the total count of valid arithmetic slices found in the array.

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        int len = nums.length;
        int[] dp = new int[len];

        // for(int i =len-3; i>=0; i--){
        // if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i]){
        // dp[i] = dp[i+1] +1;
        // result += dp[i];
        // }
        // }
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                result += dp[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArithmeticSlices arithmeticSlices = new ArithmeticSlices();

        int[] nums1 = { 1, 2, 3, 4 };
        int result1 = arithmeticSlices.numberOfArithmeticSlices(nums1);
        System.out.println("Number of arithmetic slices: " + result1);

        int[] nums2 = { 1, 2, 3, 4, 5 };
        int result2 = arithmeticSlices.numberOfArithmeticSlices(nums2);
        System.out.println("Number of arithmetic slices: " + result2);
    }
}
