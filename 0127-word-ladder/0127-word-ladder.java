import java.util.*;

class Solution { 
    public int ladderLength(String beginWord, String endWord, List<String> wordList) { 
        Set<String> wordSet = new HashSet<>(wordList); 
         if (!wordSet.contains(endWord)) return 0; 
        
        Queue<String> queue = new LinkedList<>(); 
        queue.add(beginWord); 
        
        int steps = 1; 
        
      while (!queue.isEmpty()) { 
            int size = queue.size(); 
            
            for (int i = 0; i < size; i++) { 
                String word = queue.poll(); 
                
              if (word.equals(endWord)) return steps; 
                
               char[] chars = word.toCharArray(); 
                
                for (int j = 0; j < chars.length; j++) { 
                    char originalChar = chars[j]; 
                    
                    for (char k = 'a'; k <= 'z'; k++) { 
                        chars[j] = k; 
                        String nextWord = new String(chars); 
                        
                        if (wordSet.contains(nextWord)) { 
                            queue.add(nextWord); 
                            wordSet.remove(nextWord);
                        } 
                    } 
                    chars[j] = originalChar;
                       } 
            } 
            steps++; 
        } 
        
        return 0;
    } 
}
