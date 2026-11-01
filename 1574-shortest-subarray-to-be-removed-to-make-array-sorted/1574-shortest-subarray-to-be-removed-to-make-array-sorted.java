class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0, right = n-1;

        while(left < n-1 && arr[left] <= arr[left+1]){
            left++;
        } 

        if(left == n-1) return 0;
        // System.out.println("arr[left] : " + arr[left]);

        while(right > 0 && arr[right] >= arr[right - 1]){
            right--;
        }
        // System.out.println("arr[right] : " + arr[right]);
        // System.out.println();

        int result = Math.min(n - left - 1 , right);
        
        int i = 0 , j = right;
        while(i <= left && j < n){
            // System.out.println(arr[i] + " " + arr[j] + " " + result);
            if(arr[i]  <= arr[j]){
                result = Math.min(result , j - i - 1);
                i++;
            }else{
                j++;
            }
        }

        return result;
        

    }
}