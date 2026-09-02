class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        
        int[][] ans = new int[n][n];

        for(int[] q : queries){
            int sRow = q[0], sCol = q[1];
            int eRow = q[2], eCol = q[3];

            for(int i = sRow ; i<=eRow ; i++){
                for(int j = sCol ; j<= eCol ; j++){
                    ans[i][j]++;
                }
            }
        }
        return ans;
    }
}