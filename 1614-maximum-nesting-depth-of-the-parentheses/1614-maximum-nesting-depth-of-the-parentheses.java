class Solution {
    public int maxDepth(String str) {
        Stack<Character> s = new Stack<>();
        int ans = 0;
        for(char c : str.toCharArray()){
            if(c == '('){
                s.push(c);
            }
            if(c == ')'){
                ans = Math.max(ans, s.size());
                s.pop();
            }
        }
        return ans;
    }
}