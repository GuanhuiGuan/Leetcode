class Solution {
    public List<Integer> grayCode(int n) {
        // ref: https://leetcode.com/problems/gray-code/discuss/29881
        // binary to gray code: G(i) = i ^ (i>>1)
        
        List<Integer> re = new ArrayList<>();
        for(int i = 0; i < 1<<n; i++){
            re.add(i ^ (i>>1));
        }
        return re;
        
        /*
        if(n == 0){
            re.add(0);
            return re;
        }
        StringBuilder sb = new StringBuilder();
        bt(re, sb, n);
        return re;
    }
    
    public void bt(List<Integer> re, StringBuilder sb, int n){
        if(sb.length() == n){
            re.add(Integer.parseInt(sb.toString(), 2));
            return;
        }
        for(int i = 0; i < 2; i++){
            sb.append(i);
            bt(re, sb, n);
            sb.deleteCharAt(sb.length()-1);
        }
        */
    }
}