class Solution {
    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        int maxFreq = 0;
        char max = 'a';
        for(int i = 0 ; i<26 ; i++ ){
            if(maxFreq < freq[i]){
                maxFreq = freq[i];
                max = (char)('a' + i);
            } 
        }
       int n = s.length();
    if (maxFreq > (n + 1) / 2) return "";
    char[] ans = new char[n];
    int idx = 0;
    while(freq[max - 'a'] > 0){
        ans[idx] = max;
        freq[max - 'a']--;
        idx +=2;
    }
    
    for(int i= 0 ; i<26 ; i++){
        while(freq[i] > 0){

            if(idx >= n){
                idx = 1;
            }
            ans[idx] = (char) ('a' + i);
            idx+=2;
            freq[i]--; 
        }
    }
    return String.valueOf(ans);
    } 
}