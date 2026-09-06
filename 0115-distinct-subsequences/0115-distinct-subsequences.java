class Solution {

    int[][] dp ;
    public int helper(String s , String t , int i, int j){
        if(j == t.length()){
            return 1;
        }
        if(i == s.length()){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        // System.out.println(s.charAt(i) + " " + t.charAt(j) + " " + i + " " + j);
        
        if(s.charAt(i) != t.charAt(j)) return helper(s,t,i+1, j);
        int add =  helper(s,t,i+1, j+1);
        int skip = helper(s,t,i+1, j);
        
        return dp[i][j] = add+skip;
    }

    public int numDistinct(String s, String t) {
        // s = "rabbbit", t = "rabbit"
        // -> rabb b it
        // -> ra b bb it
        // -> rab b bit
        // Output: 3
        
        // i = 0 j = 0 i-> s.length and j -> t.length
        // i == j i++, j++;
        // i != j i++

        // if(j == t.length) count++;

        // r add -> a add -> b add
        //                   b skip
        //          a skip
        // r skip 

        dp = new int[s.length()][t.length()];

        for(int[] d : dp){
            Arrays.fill(d , -1);
        }
        return helper(s, t, 0 , 0);

    }
}