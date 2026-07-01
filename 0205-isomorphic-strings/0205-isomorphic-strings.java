class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        
        for(int i  = 0 ; i<s.length() ; i++){
            char sc = s.charAt(i);
            char st = t.charAt(i);
            if(map.containsKey(sc)){
               char temp = map.get(sc);
               if(st != temp) return false;
            }
            if(map.containsValue(st)){
                if(map.containsKey(sc)){
               char temp = map.get(sc);
               if(st != temp) return false;
                }else return false;
            }

            map.put(sc,st);
        }
        return true;

    }
}