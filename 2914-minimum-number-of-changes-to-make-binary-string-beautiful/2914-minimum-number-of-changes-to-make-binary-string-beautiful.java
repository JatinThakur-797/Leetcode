class Solution {
    public int minChanges(String s) {
        if(s.length() == 2){
            if(s.charAt(0) != s.charAt(1) ){
                return 1;
            }else return 0;
        }
       
       int ans = 0;

       for(int i =0 ; i<s.length(); i+=2){
        if(s.charAt(i) != s.charAt(i+1)){
            ans++;
        }
       }
      
        return ans;
        

        
    }
}