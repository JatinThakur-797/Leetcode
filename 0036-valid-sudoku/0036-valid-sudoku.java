class Solution {
    public boolean isValidSudoku(char[][] board) {
       @SuppressWarnings("unchecked")
        HashSet<Character>[] rows = (HashSet<Character>[]) new HashSet[9];
        @SuppressWarnings("unchecked")
        HashSet<Character>[] cols = (HashSet<Character>[]) new HashSet[9];
        @SuppressWarnings("unchecked")
        HashSet<Character>[] box = (HashSet<Character>[]) new HashSet[9];
         for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }
       for(int i = 0 ; i<9 ; i++){
        for(int j = 0 ; j<9 ; j++){
            char c = board[i][j];
            if(c == '.') continue;
            
            int boxIndex = (i / 3) * 3 + (j / 3);

            if(rows[i].contains(c) || box[boxIndex].contains(c) || cols[j].contains(c)){
                return false;
            }

            rows[i].add(c);
            box[boxIndex].add(c);
            cols[j].add(c);
        }
       }
        return true;
       
    }
}