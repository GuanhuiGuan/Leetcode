class Solution {
    public boolean isNumber(String s) {
        boolean dotFlag = false, signFlag = false, digitFlag = false;
        int ePos = -1;
        s = s.trim();
        if(s.length() == 0) return false;
        char[] cs = s.toCharArray();
        
        // sign, digit, dot, e
        for(int i = 0; i < cs.length; i++) {
            char c = cs[i];
            
            // sign: only 1 at each part start
            if(c == '+' || c == '-') {
                if(signFlag)    return false;
                if(i == 0 || i == ePos+1 && i < cs.length) {
                    signFlag = true;
                }
                else    return false;
            }
            
            // e: only 1, can't be first, reset sign and digit, digit before and after(after is check at the end)
            else if(c == 'e') {
                if(ePos != -1 || i == 0 || !digitFlag) return false;
                signFlag = false;
                digitFlag = false;
                ePos = i;
            }
            
            // dot: only 1 at integer part, digit before or after
            else if(c == '.') {
                if(dotFlag || ePos != -1)    return false;
                if(digitFlag || i != cs.length-1 && Character.isDigit(cs[i+1])) {
                    dotFlag = true;
                }
                else    return false;
            }
            
            // digits
            else if(Character.isDigit(c)) {
                digitFlag = true;
            }
            
            else    return false;
        }
        // check if no digit after e
        return ePos==-1 || digitFlag;
    }
}