class Solution {
 
    int n;
    int[] dp;
    public int getNext(int[][] arr, int st , int e ){
        
        int end = n-1;
        int result = n;
        while(st<=end){
            int mid = st + (end - st)/2;

            if(arr[mid][0] >= e){ result = mid; end = mid-1;}
           else st = mid+1;
        }
        return result;
    }

    public int solve(int[][] arr, int i){
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        int next = getNext(arr, i+1, arr[i][1]);
        int taken = arr[i][2] + solve(arr, next);
        int notTaken = solve(arr, i+1);
        return dp[i] = Math.max(taken, notTaken);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        int[][] arr = new int[n][3];
        
        for(int i = 0 ; i<n ; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));

        return solve(arr, 0);

    }
}