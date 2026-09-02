class Solution {
    public int[][] matrixBlockSum(int[][] matrix, int k) {
        // mat =  [[1,2,3],
        //         [4,5,6],
        //         [7,8,9]], 
                
        // prefix  [1,  3,  6], ans  [[12,21,16],
        //         [5, 12, 21],       [27,45,33],
        //         [12, 27, 45]       [24,39,28]]
        
        // (0,1) r = -1->1
        //       c = 0->2
        // (0,2) r= -1, 1
        //       c = 1, 3
        
         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix ;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
      
       int[][] prefix = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefix[i][j] = matrix[i - 1][j - 1] 
                             + prefix[i - 1][j] 
                             + prefix[i][j - 1] 
                             - prefix[i - 1][j - 1];
            }
        }


        for(int i = 0 ; i<rows ; i++){
            int sRow = (i-k) < 0 ? 0 : i-k;
            int eRow = (i+k) >=rows ? rows-1 : i+k;
            for(int j = 0 ; j<cols ; j++){
                int sCol = (j - k) < 0 ? 0 : j-k;
                int eCol = (j + k) >= cols ? cols-1 : j+k;

                matrix[i][j] = sumRegion(sRow, sCol, eRow, eCol, prefix);

            }
        }

    return matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2, int[][] prefix) {
        return prefix[row2 + 1][col2 + 1] 
             - prefix[row1][col2 + 1] 
             - prefix[row2 + 1][col1] 
             + prefix[row1][col1];
    }
}