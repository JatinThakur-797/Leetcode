class Solution {
  

    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        long MOD = 1000000007L;

        // Precompute powers of 10 modulo MOD to speed up queries
        long[] pow10 = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // Prefix arrays using 1-based indexing for convenience
        int[] sumD = new int[m + 1];    // Prefix sum of digits
        int[] cntN0 = new int[m + 1];   // Prefix count of non-zero digits
        long[] prefX = new long[m + 1]; // Prefix non-zero integer hashes

        for (int i = 0; i < m; i++) {
            int digit = s.charAt(i) - '0';

            if (digit != 0) {
                sumD[i + 1] = sumD[i] + digit;
                cntN0[i + 1] = cntN0[i] + 1;
                prefX[i + 1] = (prefX[i] * 10 + digit) % MOD;
            } else {
                // If it is 0, carry forward the previous states directly
                sumD[i + 1] = sumD[i];
                cntN0[i + 1] = cntN0[i];
                prefX[i + 1] = prefX[i];
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int L = queries[i][0];
            int R = queries[i][1];

            // 1. Get sum of digits within the range [L, R]
            long currentSum = sumD[R + 1] - sumD[L];

            // 2. Count non-zero digits in range to compute the shifting power
            int k = cntN0[R + 1] - cntN0[L];

            // 3. Extract the concatenated non-zero value 'x' modulo MOD
            long x = (prefX[R + 1] - (prefX[L] * pow10[k]) % MOD + MOD) % MOD;

            // 4. Calculate final answer for the query
            ans[i] = (int) ((x * currentSum) % MOD);
        }

        return ans;}

}