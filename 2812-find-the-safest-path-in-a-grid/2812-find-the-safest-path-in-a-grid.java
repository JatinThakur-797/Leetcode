class Solution {

    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        int[][] dist = new int[n][n];
        Queue<int[]> q = new LinkedList<>();

        // Initialize distances
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Multi-source BFS from all thieves
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] d : DIRS) {
                int ni = curr[0] + d[0];
                int nj = curr[1] + d[1];

                if (ni >= 0 && nj >= 0 && ni < n && nj < n &&
                        dist[ni][nj] == Integer.MAX_VALUE) {

                    dist[ni][nj] = dist[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{ni, nj});
                }
            }
        }

        // Max Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[2] - a[2]);

        boolean[][] visited = new boolean[n][n];

        pq.offer(new int[]{0, 0, dist[0][0]});
        visited[0][0] = true;

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int x = curr[0];
            int y = curr[1];
            int safe = curr[2];

            if (x == n - 1 && y == n - 1)
                return safe;

            for (int[] d : DIRS) {

                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {

                    visited[nx][ny] = true;

                    pq.offer(new int[]{
                            nx,
                            ny,
                            Math.min(safe, dist[nx][ny])
                    });
                }
            }
        }

        return 0;
    }
}