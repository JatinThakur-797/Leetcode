class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        
    //    List<Integer> set = new ArrayList<Integer>();
    //     int[] ans = new int[arr.length];
    //     ans[0] = 1;
    //     for(int num : arr){
    //         set.add(num);
    //     }
    //     System.out.println(arr.length);

    //     set.remove(Integer.valueOf(1));
    //     int max = 1;
    //     for(int i = 1; i<ans.length; i++){
    //         int neg = Math.abs(ans[i-1] - 1);
    //         int pos = ans[i-1] + 1;
            
    //         for(int j = neg ; j<= pos ; j++ ){
    //             if(set.contains(j)){
    //                 ans[i] = j;
    //                 set.remove(Integer.valueOf(j));
    //                 break;                
    //             }
    //         }
    //         if(ans[i] == 0){
    //             ans[i] = pos;
    //             // System.out.print(ans[i] + " ,");
    //         }
    //        max = Math.max(ans[i] , max);
    //     }
    //     for(int i = ans.length - 1; i>= ans.length / 2 ; i--){
    //         System.out.print(ans[i] + ", ");
    //     }   
    
        Arrays.sort(arr);
        arr[0] = 1;
        for(int i = 1 ; i< arr.length ; i++ ){
            if(arr[i] > arr[i-1] + 1){
                arr[i] = arr[i-1] + 1;
            }
        }
        return arr[arr.length - 1];
       
    }
}