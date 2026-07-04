class Solution {
    private static int max = 100001;
    private static int[] dp = new int[max] , prefix = new int[max];
    static{
        for(int i = 100 ; i<max ; i++){
            int r = i % 10;
            int m = (i / 10) % 10;
            int l = (i / 100) % 10;

             int isWave = m > Math.max(l, r) || m < Math.min(l, r) ? 1 : 0;
             dp[i] = dp[i/10] + isWave;
             prefix[i] = prefix[i-1] + dp[i];
        }
    }
    
    public int totalWaviness(int num1, int num2) {
       return prefix[num2] - prefix[num1-1];
    }
  
}