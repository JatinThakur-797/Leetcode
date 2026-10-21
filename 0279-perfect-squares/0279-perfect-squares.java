class Solution {
    int[] dp;
    public int helper(int n){
         if(n < 4) return n;
        if(dp[n] != -1) return dp[n];
         int ans = Integer.MAX_VALUE;
        for(int i = 1 ; i*i  <= n ; i++){
            int val = n - (i * i);
            int curr  = helper(val) + 1;
            // System.out.println(i + " " + ans);
            ans = Math.min(ans, curr);
        }

        dp[n] = ans;
        return dp[n];

    }
    public int numSquares(int n) {
        if(n < 4) return n;
        dp = new int[n+1];
        Arrays.fill(dp , -1);
        return helper(n);


    }
}