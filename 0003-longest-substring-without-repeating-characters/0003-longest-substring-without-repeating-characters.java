class Solution {
    public int lengthOfLongestSubstring(String s) {
      Set<Character> set = new HashSet<>();
      int ans = 0;
      int left = 0;
    //   set.add(s.charAt(left));
      for(int i = 0 ; i<s.length() ; i++){
        while(set.contains(s.charAt(i))){
            set.remove(s.charAt(left));
            left++;
        }
        set.add(s.charAt(i));
        ans = Math.max(ans , i - left + 1);
      }
       return ans;
    }
}