class Solution {
    public String longestPalindrome(String s) {
        int n= s.length();

        String result = s.substring(0,1);
        for(int i = 0 ; i<n ; i++){
            String odd = extend(s, i, i);
            String even = extend(s, i, i+1);
             if(odd.length() > result.length()){
                result = odd;
             }
             if(even.length() > result.length()){
                result = even;
             }
        }
        return result;
    }
    public String extend(String s , int left , int right){
        while(left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}