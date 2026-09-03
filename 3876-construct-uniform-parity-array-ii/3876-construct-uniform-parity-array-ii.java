class Solution {
    public boolean uniformArray(int[] nums1) {

      boolean even = true;
    int min = Integer.MAX_VALUE;
    for(int n : nums1){
        if(n < min)min = n;
    }
    if(min % 2 == 0){
        for(int n : nums1 ){
            if(n % 2 == 1) return false;
        }
    }
    return true;
    }
}