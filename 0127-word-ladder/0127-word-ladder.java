class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int ans = 1;
        Set<String> set = new HashSet<>();
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i<size ; i++){
                String val = q.poll();
                if(val.equals(endWord)) return ans;
                for(String s : wordList){
                    if(set.contains(s)) continue;
                   int count = 0;

                    for(int j = 0 ; j<s.length() ; j++){
                        if(val.charAt(j) != s.charAt(j)){
                            count++;
                        }
                    }
                    if(count == 1){
                        q.add(s);
                        set.add(s);
                    }
                }

            }
            ans++;
        }
        return 0;
    }
}