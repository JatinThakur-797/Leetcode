class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
        long ans  = 0;
        int start = -1, min = -1, max = -1;
        for(int i = 0 ; i<nums.length ; i++){
                if(nums[i] < minK || nums[i] > maxK) start = i;
                if(nums[i] == maxK) max = i;
                if(nums[i] == minK ) min = i;
                int valid = Math.max(0, Math.min(min, max) - start);
                ans+= valid;
            }
        
        return ans;
    }
}