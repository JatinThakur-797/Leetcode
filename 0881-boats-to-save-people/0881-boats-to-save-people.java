class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        int ans = 0;
        int n = arr.length;
        boolean[] visit = new boolean[n];
       int st = 0, end = n-1;
       while(st<end){
        int sum = arr[st] + arr[end];
        if( sum <= limit){
            visit[st] = true;
            visit[end] = true;
            st++; end--;
            ans++;
        }
        else{
            end--;
        }
       }
      for(boolean val : visit){
        if(!val){
            ans++;
        }
      }
    return ans;
    }


}