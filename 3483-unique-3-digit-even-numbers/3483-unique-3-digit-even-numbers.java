class Solution {
    public int totalNumbers(int[] digits) {
        // -> 2,4 -> 1,2,3,4
        //     -> last digit 2,4
        //         1-> 2,3,4
        //         2-> 1,3
        //         3-> 1,2,4
        //         4-> 1,3
        // int count = 0;
        // int n = digits.length;
        // Set<Integer> set = new HashSet<>();
        // for(int i = 0 ; i<n ;i++){
        //     if(digits[i] == 0) continue;
        //     for(int j = 0 ; j<n; j++){
        //         if(i == j)continue;
        //         for(int k = 0 ; k<n ; k++){
        //             if(i==k || j == k) continue;
        //             int val = 100*digits[i] + 10*digits[j] + digits[k];
        //             if(val % 2 == 0){
        //                 if(set.contains(val))continue;
        //                 System.out.println(val);
        //                 count++;
        //                 set.add(val);
        //             }
        //         }
        //     }
        // }
        // return count;


    int count = 0;
    int[] freq = new int[10];
    for(int digit : digits){
        freq[digit]++;
    }

    for(int i = 1 ; i<10 ; i++){
        for(int j = 0; j<10; j++ ){
            for(int k = 0 ; k<9; k+=2){

                int[] temp = new int[10];
                temp[i]++;
                temp[j]++;
                temp[k]++;

                if(freq[i] >= temp[i] && freq[j] >= temp[j] && freq[k] >= temp[k]){
                    count++;
                }
            }
        }
    }

    return count;

    }
}