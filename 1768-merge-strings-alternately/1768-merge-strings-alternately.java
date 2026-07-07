class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;
        int count = 0;
        int w1 = word1.length();
        int w2 = word2.length();
        while(i<w1|| j<w2){
            if(i<w1 && count % 2 == 0  ){
                ans.append(word1.charAt(i));
                count++;
                i++;
                continue;
            }

           else if(j<w2 && count % 2 == 1){
                ans.append(word2.charAt(j));
                count++;
                j++;
                continue;
            }
           else if(i >= w1 && j<w2){
            ans.append(word2.charAt(j));
            j++;
           }
           else if(i<w1 && j>= w2){
            ans.append(word1.charAt(i));
            i++;
           }
            

            
        }
        return ans.toString();
    }
}