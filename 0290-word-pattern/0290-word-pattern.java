class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] st = s.split(" ");
        if(st.length != pattern.length()) return false;

        for(int i = 0 ; i<pattern.length() ; i++){
            char c = pattern.charAt(i);
            String str = st[i];
            if(map.containsKey(c) && !map.get(c).equals(str)){
                return false;
            }
            if(map.containsValue(str) && !map.containsKey(c)){
                return false;
            }
            map.put(c, str);
            }
    return true;
    }
}