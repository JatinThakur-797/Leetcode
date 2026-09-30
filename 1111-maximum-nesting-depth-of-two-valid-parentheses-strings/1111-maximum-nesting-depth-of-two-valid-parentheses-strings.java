class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int depth = 0;
        int i = 0;
        for(char c : seq.toCharArray()){
            if(c == '('){
                depth++;
                ans[i]  = depth % 2;
            }else{
                ans[i] = depth % 2;
                depth--;
            }
            i++;
        }
        return ans;
    }
}