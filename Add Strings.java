class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int forward = 0;
        
        for(int i = num1.length()-1, j = num2.length()-1; i >= 0 || j >= 0; i--, j--) {
            int sum = forward;
            if(i >= 0) {
                sum += num1.charAt(i)-'0';
            }
            if(j >= 0) {
                sum += num2.charAt(j)-'0';
            }
            forward = sum/10;
            sb.insert(0, sum%10);
        }
        if(forward != 0) {
            sb.insert(0, forward);
        }
        return sb.toString();
    }
}