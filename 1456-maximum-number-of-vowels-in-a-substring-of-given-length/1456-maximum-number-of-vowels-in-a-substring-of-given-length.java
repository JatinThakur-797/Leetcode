class Solution {
    public int maxVowels(String s, int k) {
        //  "leetcode", k = 3

        // how to get vowels count in substring 
        //  Can we use prefix sum somehow:
        // [0, 1, 2, 3, 4, 5, 6, 7]
        // [0, 1, 2, 2, 2, 3, 3, 4]
        int[] pre = new int[s.length()];
        pre[0] = isVowel(s.charAt(0)) ? 1 : 0;
        for(int i = 1 ; i<s.length() ; i++ ){
            char c = s.charAt(i);
            pre[i] = pre[i-1] + (isVowel(c) ? 1 : 0);
        }
        
        int st = 0 , end = k-1;
        int ans = Integer.MIN_VALUE;
        while(end < s.length()){

            int vowel = pre[end] - (st == 0 ? 0 : pre[st-1]);
            ans = Math.max(vowel , ans);
            st++; end++;
                    
        }
    return ans;

    }

    public static boolean isVowel(char c) {
    return "aeiou".indexOf(c) != -1;
}
}