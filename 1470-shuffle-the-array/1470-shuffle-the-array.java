class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int i = 0; int j = n;
        int[] ans = new int[n*2];
        int idx = 0;
        while(i < n || j < n*2){
            if(idx % 2 == 0 && i < n){
                ans[idx] = nums[i];
                i++;
            }else if(j < n*2){
                ans[idx] = nums[j];
                j++;
            }
            idx++;
        }
        return ans;
    }
}