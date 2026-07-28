class Solution {
    public String smallestPalindrome(String s) {
        // babab -> aaabbb, bbbaaa, 
        // acbbca baab 
        // i = n -i - 1;
        // [e,c, d, a , a ,c ,d, e]


        int n = s.length();
        
        int[] freq = new int[26];
      for (int i = 0; i < n / 2; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i<26 ; i++){
            while(freq[i] > 0){
                sb.append((char) (i + 'a'));
                freq[i]--;
            }
        }
        String sortedHalf = sb.toString();
        String midChar = (n % 2 == 1) ? String.valueOf(s.charAt(n / 2)) : "";
        String reversedHalf = sb.reverse().toString(); 

        return sortedHalf + midChar + reversedHalf;
    }
}