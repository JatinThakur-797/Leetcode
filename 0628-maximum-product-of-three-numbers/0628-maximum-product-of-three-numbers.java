class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        // -3, -2, -1 2 two neg or one positive
        int n = nums.length;
        if(nums[n-1] < 0) return nums[n-1] * nums[n-2] * nums[n-3];

        int prod1 = nums[0] * nums[1] * nums[n-1];
        int prod2 = nums[n-1] * nums[n-2] * nums[n-3];

        return prod1>prod2 ? prod1 : prod2;
        
        
        
    }
}