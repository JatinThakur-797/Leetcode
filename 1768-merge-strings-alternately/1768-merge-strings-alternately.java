class Solution {
    public String mergeAlternately(String word1, String word2) {
         StringBuilder sb = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();

        int minLength = Math.min(len1, len2);

        for(int i=0; i<minLength; i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        if(len1 > minLength){
            sb.append(word1.substring(minLength));
        }else if(len2 > minLength){
            sb.append(word2.substring(minLength));
        }

        return sb.toString();
    }
}