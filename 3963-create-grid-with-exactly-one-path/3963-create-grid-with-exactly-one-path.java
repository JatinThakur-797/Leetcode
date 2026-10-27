class Solution {
    public String[] createGrid(int m, int n) {

        String[] ans = new String[m];

        StringBuilder firstRow = new StringBuilder();
        for(int i = 0 ; i<n ; i++){
            firstRow.append('.');
        }
        ans[0] = firstRow.toString();

        StringBuilder remainingRow = new StringBuilder();
        for(int i = 0; i<n-1; i++){
            remainingRow.append('#');
        }
        remainingRow.append('.');

        String otherRow = remainingRow.toString();
        for(int i =1 ; i<m ; i++){
            ans[i] = otherRow;
        }
        return ans;
    }
}