class Solution {
    char[] opts = {'+', '-', '*'};
    List<String> res = new ArrayList<>();
    
    public List<String> addOperators(String num, int target) {
        bt("", num, 0, target, 0, 0);
        return res;
    }
    
    public void bt(String newStr, String num, int start, int target, long sum, long mul) {
        if(start == num.length()) {
            if(sum == target)   res.add(newStr);
        }
        else {
            for(int i = start; i < num.length(); i++) {
                // avoid multi-digit starting from 0
                if(i != start && num.charAt(start) == '0')  break;
                
                long cur = Long.parseLong(num.substring(start, i+1));
                // if the first number
                if(start == 0) {
                    bt(newStr + cur, num, i+1, target, sum + cur, cur);
                }
                else {
                    bt(newStr + '+' + cur, num, i+1, target, sum + cur, cur);
                    bt(newStr + '-' + cur, num, i+1, target, sum - cur, -cur);
                    bt(newStr + '*' + cur, num, i+1, target, sum - mul + mul * cur, mul * cur);
                }
            }
        }
    }
}