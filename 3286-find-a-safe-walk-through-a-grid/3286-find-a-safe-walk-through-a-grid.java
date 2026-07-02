class Solution {
     private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        
        int m = grid.size();
        int n = grid.get(0).size();
        Queue<int[]> q = new LinkedList<>();
        int startHealth = health -  grid.get(0).get(0);
        if(startHealth <= 0) return false; 
         int[][] max = new int[m][n];
        for (int[] row : max) {
            Arrays.fill(row, -1); 
        }
        q.add(new int[]{0,0, startHealth});
        max[0][0] = startHealth;
        while(!q.isEmpty()){
            
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int currHealth = curr[2];

            if(r == m-1 && c == n-1){
                return true;
            }

            if(currHealth < max[r][c]){
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nextRow = r + dRow[d];
                int nextCol = c + dCol[d];
                

                if(nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol<n ){

                    int nextHealth = currHealth - grid.get(nextRow).get(nextCol);
                    
                    if(nextHealth > 0 && nextHealth > max[nextRow][nextCol]){
                        max[nextRow][nextCol] = nextHealth;
                        q.offer(new int[]{nextRow, nextCol , nextHealth});
                    }
                }
                }
        }

    return false;
    }
}