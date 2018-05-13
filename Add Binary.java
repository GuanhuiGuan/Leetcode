class Solution {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int i = a.length()-1, j = b.length()-1, forward = 0;
        while(i >= 0 || j >= 0 || forward != 0) {
            int next = forward;
            next += i < 0? 0: a.charAt(i--) - '0';
            next += j < 0? 0: b.charAt(j--) - '0';
            str.insert(0, next % 2);
            forward = next / 2;
        }
        return str.toString();
    }
}