class Solution {
    public int maxProduct(int num) {
        // [1,2,3,4,5,6,7,8,9]
         int[] digits = Integer.toString(num)
                              .chars()
                              .map(c -> c - '0')
                              .toArray();

        Arrays.sort(digits);

        int n = digits.length;
        return digits[n-1] * digits[n-2];
    }
}