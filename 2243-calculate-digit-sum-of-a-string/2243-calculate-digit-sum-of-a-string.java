class Solution {
    public String digitSum(String s, int k) {
        
        while(s.length() > k){
            int j = 0;
            int sum = 0;
            StringBuilder temp = new StringBuilder();
            for(int i =  0 ; i<s.length() ; i++){
                sum+= s.charAt(i) - '0';
                if(i == j+k-1 || i == s.length()-1){
                    // System.out.println(sum + " i : "+ i + " j : "+ j);
                    temp.append(sum);
                    sum = 0;
                    j=i+1;
                }
            }
            // System.out.println("\n" + temp);
            s = temp.toString();
        }
        return s;
    }
}