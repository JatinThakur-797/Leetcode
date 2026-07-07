class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int n = nums.length;
        int st = 0;
        int end = n-1;

        int[] ans = new int[n];
        int last = n-1;
        while(st<=end){
            int s = Math.abs(nums[st]);
            int e = Math.abs(nums[end]);
            
            if(s < e){
                ans[last] = e*e;
                last--;
                end--;
            }else{
                ans[last] = s*s;
                last--;
                st++;
            }
        }

    return ans;
    }
}