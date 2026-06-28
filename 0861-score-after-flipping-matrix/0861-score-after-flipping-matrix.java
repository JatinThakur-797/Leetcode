class Solution {
    public int matrixScore(int[][] arr) {
        int m= arr.length;
        int n = arr[0].length;

        for(int i = 0 ; i<m ; i++){
            if(arr[i][0] == 0){
                for(int j = 0 ; j<n ; j++){
                    arr[i][j] ^= 1;
                }
            }
        }

        for(int j = 1; j<n ; j++){
            int ones = 0, zeros = 0;
            for(int i = 0 ; i<m ; i++){
                if(arr[i][j] == 1) ones++;
                else zeros++;
            }
            if(ones<zeros){
                for(int i = 0; i<m ; i++){
                    arr[i][j] ^= 1;
                }
            }
        }
        int sum = 0;
        int pow = 1;
        for(int j = n - 1; j>= 0 ; j--){
            int count  = 0;
            for(int i = 0 ; i<m ; i++ ){
                if(arr[i][j] == 1){
                    count++;
                }
            }
            sum += count*pow;
            pow *= 2;
        }
    return sum;
    }
}