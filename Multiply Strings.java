class Solution {
    public String multiply(String num1, String num2) {
        // num1[i] * num2[j] --> num[i + j], num[i + j + 1]
        int[] num = new int[num1.length() + num2.length()];
        
        for(int i = num1.length() - 1; i >= 0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                int t = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int lower = t + num[i + j + 1];
                num[i + j + 1] = lower % 10;
                num[i + j] += lower / 10;
            }
        }
        
        return toString(num);
    }
    
    public String toString(int[] num) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < num.length; i++) {
            if(str.length() == 0 && num[i] == 0)    continue;
            str.append(num[i]);
        }
        return str.length() == 0? "0": str.toString();
    }
}