class Solution {
    public int longestConsecutive(int[] arr) {

        if(arr.length == 0) return 0;
       Arrays.sort(arr);
       int ans = 0;
       int count  = 1;
       int n = arr.length;
       for(int i = 1 ; i<n ; i++){
            ans = Math.max(ans, count);
            if(arr[i] == arr[i-1]) continue;
            if(arr[i] - 1 == arr[i-1]) count++;
            else count = 1;

       }
       ans = Math.max(ans, count);
       return ans;
    }
}