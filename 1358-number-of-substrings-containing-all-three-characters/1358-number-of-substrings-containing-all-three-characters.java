class Solution {
    public int numberOfSubstrings(String s) {
        if(s.length() < 3) return 0;
        int[] counts = new int[3];
        int left = 0;
        int count = 0;
        int n = s.length();
        for(int right = 0 ; right<n ; right++){
            counts[s.charAt(right) - 'a']++;

            while (counts[0] > 0 && counts[1] > 0 && counts[2] > 0) {
                count += n - right; 
                counts[s.charAt(left) - 'a']--;
                left++;
            }

            }      
            return count;
            } 
}