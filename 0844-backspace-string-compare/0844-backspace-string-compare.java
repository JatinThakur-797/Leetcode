class Solution {
    public boolean backspaceCompare(String s, String t) {
      
      int ps = s.length() - 1;
      int pt = t.length() - 1;

        while(ps >=0 || pt>=0){
            
            ps = getValidIndex(s, ps);
            pt = getValidIndex(t, pt);

            if(ps < 0 && pt < 0) return true;
            if(ps<0 || pt <0) return false;

           else if(s.charAt(ps) != t.charAt(pt)) return false;

            ps--;
            pt--;
        }
        return true;
    }

        public int getValidIndex(String s , int idx){
            int backSpace = 0;
            while(idx >= 0){
                if(s.charAt(idx) == '#'){
                    backSpace++;
                }else if(backSpace > 0){
                    backSpace--;
                }else{
                    break;
                }
                idx--;
            }
            return idx;
        }

}