class Solution {
    // 10 ->  1000000000

   static List<Integer> pre = new ArrayList<>();
    static{
        int st = 10;
        int end = 1000000000;
       for(int j = 1 ; j<9 ; j++){
            pre.add(j);
       }

        int idx = 0;
        int val = 0;
       while(idx < pre.size() &&  val < end ){
            val = pre.get(idx);
            int digit = val % 10;
            if(digit == 9){idx++; continue;}
            pre.add(val * 10 + (digit + 1));
            idx++;           
        }
        
    } 
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>() ;
        for(int val : pre){
            if(val >= low && val <= high){
                ans.add(val);
            }
        }
        return ans;
    }
}