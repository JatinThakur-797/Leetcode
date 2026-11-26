class Solution {
    int[] dp;
    public int helper(int[] nums, int i){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        int take = helper(nums, i+2) + nums[i];
        int skip = helper(nums, i+1);

        return dp[i] =  Math.max(take, skip);
    }



    public int rob(int[] nums) {
        dp = new int[nums.length + 1];
        Arrays.fill(dp , -1);
        return helper(nums, 0);
    }
}