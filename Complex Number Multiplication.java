class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] ac = parseCN(a), bc = parseCN(b);
        int[] res = new int[2];
        res[0] = ac[0]*bc[0] - ac[1]*bc[1];
        res[1] = ac[0]*bc[1] + ac[1]*bc[0];
        return res[0] + "+" + res[1] + "i";
    }
    
    // parse a complex number to real and imaginary parts
    public int[] parseCN(String s) {
        int[] res = new int[2];
        String[] ss = s.split("\\+");
        res[0] = Integer.parseInt(ss[0]);
        res[1] = Integer.parseInt(ss[1].replace("i", ""));
        return res;
    }
}