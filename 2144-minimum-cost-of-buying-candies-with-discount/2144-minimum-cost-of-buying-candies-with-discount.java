class Solution {
    public void reverse(int[] arr){
        int st = 0; int end= arr.length-1;
        while(st < end){
            int temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;end--;
        }
    }
    public int minimumCost(int[] arr) {
        Arrays.sort(arr);
        reverse(arr);
        int cost = 0;
        int count = 0;
        for(int i = 0 ; i<arr.length ; i++){
            if(count == 2){
                count = 0;
                continue;
            }
            cost += arr[i];
            count++;
        }
        return cost;

    }
}