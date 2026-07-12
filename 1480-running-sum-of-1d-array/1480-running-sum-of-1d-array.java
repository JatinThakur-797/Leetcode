class Solution {
    public int[] runningSum(int[] nums) {
        int prev = nums[0];
        for(int i = 1 ; i<nums.length ; i++){
            nums[i] = nums[i] + prev;
            prev = nums[i];
        }
        return nums;
    }
}