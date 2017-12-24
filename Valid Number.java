class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        
        int n = s.length();
        if(n == 0)  return false;
        
        boolean hasDigit = false;
        boolean digitAfterE = false;
        boolean hasE = false;
        boolean hasDot = false;
        
        
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                hasDigit = true;
                digitAfterE = true;
            }
            else if(s.charAt(i) == '.'){
                if(hasE || hasDot)  return false;
                hasDot = true;
            }
            else if(s.charAt(i) == 'e'){
                if(hasE || !hasDigit)    return false;
                // reset digit after e if e is found
                digitAfterE = false;
                hasE = true;
            }
            else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                if(i != 0 && s.charAt(i-1) != 'e')  return false;
            }
            else    return false;
        }
        
        return hasDigit && digitAfterE;
    }
}