class Solution {
    public boolean canConstruct(String r, String m) {
        int[] rf = new int[26];
        int[] mf = new int[26];

        for(char c : r.toCharArray()){
            rf[c-'a']++;
        }
        
        for(char c : m.toCharArray()){
            mf[c-'a']++;
        }

        for(int i = 0 ; i<26 ; i++){
            if(mf[i] == rf[i]) rf[i] = 0;
            else if(rf[i] > 0 && mf[i] > rf[i]) rf[i] = 0;
        }

        for(int i = 0 ; i<26 ; i++){
            if(rf[i] > 0) return  false;
        }
        return true;
    }
}