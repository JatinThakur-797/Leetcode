class Solution {
    public int maxVowels(String s, int k) {
        //  "leetcode", k = 3

        // Approch 1

        // how to get vowels count in substring 
        //  Can we use prefix sum somehow:
        // [0, 1, 2, 3, 4, 5, 6, 7]
        // [0, 1, 2, 2, 2, 3, 3, 4]
        // int[] pre = new int[s.length()];
        // pre[0] = isVowel(s.charAt(0)) ? 1 : 0;
        // for(int i = 1 ; i<s.length() ; i++ ){
        //     char c = s.charAt(i);
        //     pre[i] = pre[i-1] + (isVowel(c) ? 1 : 0);
        // }
        
        // int st = 0 , end = k-1;
        // int ans = Integer.MIN_VALUE;
        // while(end < s.length()){

        //     int vowel = pre[end] - (st == 0 ? 0 : pre[st-1]);
        //     ans = Math.max(vowel , ans);
        //     st++; end++;
                    
        // }


        // Approch 2

        int st = 0;
        int ans = Integer.MIN_VALUE;
        int count = 0;

        for(int end = 0 ; end < s.length() ; end++){
            char ch = s.charAt(end);
            if(isVowel(ch)){
                count++;
            }

            if(end - st + 1 == k){
                ans = Math.max(count, ans);
                if(isVowel(s.charAt(st)))count--;
                st++;
            }
        }

    return ans;

    }

    public static boolean isVowel(char c) {
    return "aeiou".indexOf(c) != -1;
}
}