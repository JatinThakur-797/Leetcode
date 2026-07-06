class Solution {
    public int numSplits(String s) {
        
        int good = 0;
        // -> [a,a,c,a,b,a]=[1,1,2,2,3,3] [3,3,3,2,2,1]
        int[] prefix = new int[s.length()];
        int[] sufix = new int[s.length()];
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        prefix[0] = 1;
        
        for(int i = 1; i<s.length() ; i++){
            char curr = s.charAt(i);
            if(!set.contains(curr)){
                prefix[i] = prefix[i-1] + 1;
                set.add(curr);
            }else{
                prefix[i] = prefix[i-1];
            }
        }

        set.clear();
        char last = s.charAt(s.length() -1);
        set.add(last);
        sufix[s.length() -1 ] = 1;
        for(int j = s.length() -2 ; j>= 0 ; j--){
            char curr = s.charAt(j);
            if(!set.contains(curr)){
                sufix[j] = sufix[j+1] + 1;
                set.add(curr);
            }else{
                sufix[j] = sufix[j+1];
            }
        }

       
        for(int i = 0 ; i<s.length()-1 ; i++){
            if(prefix[i] == sufix[i+1]){
                good++;
            }
        }
        return good;
    }
}