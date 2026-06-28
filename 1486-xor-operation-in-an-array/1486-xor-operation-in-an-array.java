class Solution {
    public int xorOperation(int n, int start) {
        
        int xor = 0;
        for(int i = 0; i<n ; i++)
        {
            int val = start + 2 * i;;
            xor ^= val;
        }
        return xor;
    }
}