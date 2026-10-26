import java.util.*;

class Solution {
    public int countIslands(int[][] grid, int k) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               
                if (grid[i][j] == 0 || visited[i][j]) continue;
               
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j});
                visited[i][j] = true; 
                
                
                long curr = 0; 
                
                while (!q.isEmpty()) {
                    int[] val = q.poll();
                    int r = val[0];
                    int c = val[1];
                    
                    curr += grid[r][c];
                    
                    for (int[] dir : dirs) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        
                       
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > 0 && !visited[nr][nc]) {
                            q.offer(new int[]{nr, nc});
                            visited[nr][nc] = true; 
                        }
                    }
                }
               
              
                if (curr % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
