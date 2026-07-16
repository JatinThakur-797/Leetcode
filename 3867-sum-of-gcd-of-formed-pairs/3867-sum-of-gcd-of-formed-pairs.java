class Solution {
    public long gcdSum(int[] nums) {
        
        int max = nums[0];
        int n  = nums.length;
        int[] g = new int[n];
        for(int i = 0 ; i<n ; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            g[i] = gcd(nums[i] , max);
        }
        
        Arrays.sort(g);
        int st = 0 , end = n-1;
        long sum = 0;
        while(st < end){
            int val = gcd(g[st] , g[end]);
            sum += val;
            st++;end--;
        }
        return sum;
    }
    private int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
        }
}