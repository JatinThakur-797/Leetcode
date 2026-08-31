class Solution {
    
    public boolean valid(int[] piles , int val, int h ){
        long currHour = 0;
        int n = piles.length;
        
        for(int i = 0 ; i<n ; i++){
            if(piles[i] % val == 0){
                currHour += piles[i] / val;
            }else {
                currHour += piles[i] / val + 1;
            }
        }
        // System.out.println(val + " " + currHour);
        return currHour <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        

        int st = 1;
        int end = Integer.MIN_VALUE;
        for(int p : piles){
            if(p > end){
                end = p;
            }
        }
        int ans = end;
        while(st <= end){
            int mid = st + (end - st)/2;

            if(valid(piles, mid, h)){
                ans = Math.min(ans, mid);
                end = mid-1;
            }else{
                st = mid+1;
            }
        }
    return ans;
    }
}