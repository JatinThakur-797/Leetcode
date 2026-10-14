class Solution { 
    public String maxSumOfSquares(int num, int sum) { 
        if (sum == 0) {
            return num == 1 ? "0" : "";
        }
        
        if (sum > num * 9) {
            return "";
        }
        
        StringBuilder ans = new StringBuilder();
        
        while (num > 0) {
            if (sum >= 9) {
                ans.append("9");
                sum -= 9;
            } else if (sum > 0) {
                ans.append(sum);
                sum = 0;
            } else {
                ans.append("0");
            }
            num--;
        }
        
        return ans.toString();
    } 
}
