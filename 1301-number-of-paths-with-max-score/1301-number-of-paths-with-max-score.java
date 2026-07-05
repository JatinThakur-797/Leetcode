class Solution {
    Integer[][][] memo;
    int m, n;
    int MOD = 1_000_000_007;
    public int[] helper(List<String> board, int i , int j){
        
        if (i >= m || j >= n) {
            return new int[]{-1, 0};
        }

        char cell = board.get(i).charAt(j);
        if(cell == 'X') return new int[]{-1, 0};

        if(cell == 'S'){
            return new int[]{0, 1};
        }
        if(memo[i][j][0] != null){  return new int[]{memo[i][j][0], memo[i][j][1]};}

        int maxScore = -1;
        int count = 0;
        int[][] dirc = new int[][]{{1,0}, {0,1} , {1,1}};

        for(int[] dir :dirc ){
            int newRow = dir[0] + i;
            int newCol = dir[1] + j;
            int[] arr = helper(board, newRow, newCol);

            int nextScore = arr[0];
            int nextCount= arr[1];

            if(nextScore != -1){
                if(nextScore > maxScore){
                    maxScore = nextScore;
                    count = nextCount;
                }else if(nextScore == maxScore){
                    count = (count + nextCount ) % MOD;
                }
            }
                         
        }

        if(maxScore != -1){
            int currVal = (cell == 'E' || cell == 'S') ? 0 : (cell - '0');
            memo[i][j][0] = maxScore + currVal;
            memo[i][j][1] = count;
        }else{
            memo[i][j][0] = -1;
            memo[i][j][1] = 0;
        }
        return new int[]{memo[i][j][0], memo[i][j][1]};
       
    }

    public int[] pathsWithMaxScore(List<String> board) {
      
        m = board.size();
        n = board.get(0).length();
        memo = new Integer[m][n][2];

        int[] result = helper(board, 0, 0);

        if (result[1] == 0) {
            return new int[]{0, 0};
        }
        return result;
    
    }
}