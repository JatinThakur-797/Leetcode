class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        char[][] ch = new char[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            ch[i] = strs[i].toCharArray();
        }
        for(char[] c : ch){
            Arrays.sort(c);
        }
        String[] str = new String[strs.length];
         for (int i = 0; i < ch.length; i++) {
            str[i] = String.valueOf(ch[i]);
        }
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i<str.length ; i++){
            String s = str[i];
            map.computeIfAbsent(s, k -> new ArrayList<>()).add(i);
        }
        List<List<Integer>> values = new ArrayList<>(map.values());
        List<List<String>> ans = new ArrayList<>();
        for(List<Integer> v : values){
            List<String> curr = new ArrayList<>(); 
            for(int i : v){
                curr.add(strs[i]);
            }
            ans.add(curr);
        }
        return ans;
        
    }
}