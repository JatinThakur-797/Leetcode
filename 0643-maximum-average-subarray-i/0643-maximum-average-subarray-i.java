class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        for(int i = 1 ; i<n ; i++){
            nums[i] += nums[i-1];
        }
        double ans = Double.NEGATIVE_INFINITY;
        int st = 0 , end = k-1;
        while(end < n){
            double sum = st > 0 ? nums[end] - nums[st-1] : nums[end];
            double avg = sum/k;
            ans = Math.max(ans, avg);
            st++;
            end++;
        }
        return ans;
    }
}