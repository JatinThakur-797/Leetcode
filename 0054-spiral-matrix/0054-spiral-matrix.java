class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int sRow = 0, sCol = 0;
        int eRow = m - 1, eCol = n - 1;
        List<Integer> res = new ArrayList<>();
        while(sRow <= eRow && sCol <= eCol){
            //Go right --> 
            for(int i = sCol ; i<= eCol ; i++){
                res.add(matrix[sRow][i]);
            }

            //Go Down 
            for(int i = sRow + 1 ; i<= eRow ; i++){
                res.add(matrix[i][eCol]);
            }

            //Go Left 
            if(sRow < eRow)
            for(int i = eCol-1 ; i>= sCol ; i--){
                res.add(matrix[eRow][i]);
            }

            //Go up
            if(sCol < eCol)
            for(int i = eRow-1 ; i>sRow ; i--){
                res.add(matrix[i][sCol]);
            }

            sRow++; sCol++; eRow--; eCol--;

        } 
return res;
    }
}