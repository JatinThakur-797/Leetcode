class Solution {
    public int compress(char[] ch) {
        
        int i = 0, j = i+1;
        int idx = 0;
        int n = ch.length;
        while(i<n){
            j = i+1;
            while(j<n && ch[j] == ch[i]) j++;
            int val = j - i;
            if(val == 1){
                ch[idx] = ch[i];
                i = j;
                idx++;
            }
            else {
                if(val < 10){
                    ch[idx] = ch[i];
                    idx++;
                    ch[idx] = (char) (val + '0');
                    idx++;
                    i = j;
                }
                else{
                    ch[idx] = ch[i];
                    idx++;
                    String v = String.valueOf(val);
                    for(char c : v.toCharArray()){
                        ch[idx++] = c;
                    }
                    i= j;
                }
            }

        }
        return idx;
    }
}