class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;
        for(int right = 0; right<s.length() ; right++){
            char c = s.charAt(right);
            map.put(c , map.getOrDefault(c, 0) + 1);

            while(map.get(c) > 1){
                char l = s.charAt(left);
                // System.out.println(l + " count : " + map.get(c) + "\n");
                map.put(l, map.get(l) - 1);
                left++;

            }
            int len = right - left + 1;
            // System.out.println(len + " " + c + " left : " + left + " right :" + right);
            ans = Math.max(len , ans);
            
        }
       return ans;
    }
}