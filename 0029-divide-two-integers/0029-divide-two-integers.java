class Solution {
    public int divide(int dividend, int divisor) {
         // Handle the specific overflow edge case explicitly
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Use long types to easily prevent any conversion overflows
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int ans = 0;

        // Shift divisor left until it's just under the dividend
        while (a >= b) {
            long temp = b;
            long multiple = 1;
            
            // Double the subtraction chunk size exponentially
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            
            a -= temp;
            ans += multiple;
        }

        // Determine sign: if signs match, result is positive. Otherwise negative.
        boolean isNegative = (dividend < 0) ^ (divisor < 0);
        return isNegative ? -ans : ans;
    }
}