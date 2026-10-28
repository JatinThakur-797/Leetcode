import java.util.Arrays;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MAX_XOR = 1024;
        
        boolean[][][] dp = new boolean[m][n][MAX_XOR];
        
       
        dp[0][0][grid[0][0]] = true;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < MAX_XOR; k++) {
                    if (dp[i][j][k]) {
                       
                        if (j + 1 < n) {
                            dp[i][j + 1][k ^ grid[i][j + 1]] = true;
                        }
                        
                        if (i + 1 < m) {
                            dp[i + 1][j][k ^ grid[i + 1][j]] = true;
                        }
                    }
                }
            }
        }
        
       for (int k = 0; k < MAX_XOR; k++) {
            if (dp[m - 1][n - 1][k]) {
                return k;
            }
        }
        
        return -1;
    }
}
