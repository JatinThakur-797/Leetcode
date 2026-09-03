class Solution {
    public boolean checkInclusion(String p, String s) {
        
        Map<Character , Integer> map = new HashMap<>();
        // Count the freq of p
        for(char c : p.toCharArray()){
            map.put(c , map.getOrDefault(c , 0) + 1);
        }
        int counter = map.size();
        int st = 0 , end = 0;
        // List<Integer> result = new ArrayList<>();
        while(end < s.length()){
            char c = s.charAt(end);

            if(map.containsKey(c)){
                map.put(c , map.get(c) -1);
                if(map.get(c) == 0)counter--;
            }
            end++;
            
            while(counter == 0){
                char ch = s.charAt(st);
                 if(end - st == p.length()) return true;

                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch) + 1);
                    if(map.get(ch) > 0) counter++;
                }

               
                st++;
            }
        }

       return false;
        
    }
}