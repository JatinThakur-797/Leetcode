class Solution {
    public int[] findErrorNums(int[] nums) {
        // Arrays.sort(nums);
        // int[] ans = new int[2];
        // for(int i = 1; i<nums.length ; i++)
        // {
        //     if(nums[i] == nums[i-1]){
        //         ans[0] = nums[i];
        //         ans[1] = i+1;
        //         break;
        //     }
        // }
        // -> 1 to n long sum 
        int n = nums.length;
        int[] count = new int[n+1];
        for(int num : nums){
            count[num]++;
        }
        int[] ans = new int[2];
        for(int i = 1; i<=n ; i++){
            if(count[i] == 2){
                ans[0] = i;
            }
            if(count[i] == 0){
                ans[1] = i;
            }
        }

        
        return ans;
    }
}