class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        boolean[] inResult = new boolean[26];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']--; 
            if (inResult[c - 'a']) {
                continue;
            }

            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > c && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                char popped = sb.charAt(sb.length() - 1);
                inResult[popped - 'a'] = false; 
                sb.deleteCharAt(sb.length() - 1); 
            }

            sb.append(c);
            inResult[c - 'a'] = true;
        }

        return sb.toString();
    }
}
