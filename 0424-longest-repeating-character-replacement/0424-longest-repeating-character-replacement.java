class Solution {
    public int characterReplacement(String s, int k) {
        // s = "AABABBA", k = 1
        
        int left = 0;
        int[] freq = new int[26];
        int maxLen = 0;
        for(int right = 0 ; right<s.length() ; right++)
        {
            freq[s.charAt(right) - 'A']++;
            int max = getMax(freq);

            while(right-left + 1 - max > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);


        }
        return maxLen;
    }

    public int getMax(int[] arr){
        int max = 0;
        for(int val : arr){
            if(val > max) max = val;
        }
        return max;
    }
}