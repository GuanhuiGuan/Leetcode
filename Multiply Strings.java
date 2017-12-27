class Solution {
    public String multiply(String num1, String num2) {
        /* ref: https://leetcode.com/problems/multiply-strings/discuss/17605/ */
        // product of pair n1[i], n2[j] is at n[i+j, i+j+1]
        int m = num1.length(), n = num2.length();
        int[] num = new int[m + n];
        
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                int pro = (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
                pro += num[i+j+1];
                num[i+j] += pro/10;
                num[i+j+1] = pro%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int d: num){
            // avoid x*0 = 00...00
            if(!(sb.length()==0 && d == 0)){
                sb.append(d);
            }
        }
        return sb.length() == 0? "0": sb.toString();
    }
}