class Solution {
    private int[][][] dp;
    private final int MOD = 1_000_000_007;
    public int solve(int[] nums, int i , int gcd1 , int gcd2){
        if(i >= nums.length){
            if(gcd1 > 0 && gcd2>0 && gcd1 == gcd2 ){
                return 1;
            }
            return 0;
        }
        if(dp[i][gcd1][gcd2] != -1 ) return dp[i][gcd1][gcd2];
        int skip = solve(nums, i+1 , gcd1, gcd2);
        int take1 = solve(nums, i+1, gcd(gcd1, nums[i]) , gcd2);
        int take2 = solve(nums, i+1 , gcd1, gcd(gcd2, nums[i]));

        long total = (long) skip + take1 + take2;
        return dp[i][gcd1][gcd2] = (int) (total % MOD);
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
    public int subsequencePairCount(int[] nums) {
       int maxVal = 200; 
        int n = nums.length;
        dp = new int[n][maxVal + 1][maxVal + 1];
        for (int i = 0; i < n; i++) {
            for (int g1 = 0; g1 <= maxVal; g1++) {
                Arrays.fill(dp[i][g1], -1);
            }
        }
        return solve(nums, 0, 0 , 0);
    }
}