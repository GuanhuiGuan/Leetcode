class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean block = false;
        
        for(String s: source) {
            // Sweep every line for /*, */, //
            for(int i = 0; i < s.length(); i++) {
                // Block comment mode on
                if(block) {
                    // Uncomment
                    if(isPattern(s, i, new char[] {'*', '/'})) {
                        block = false;
                        // Skip '/'
                        i++;
                    }
                }
                // Block comment mode off
                else {
                    // Skip line
                    if(isPattern(s, i, new char[] {'/', '/'}))  break;
                    
                    // Start block comment mode
                    else if(isPattern(s, i, new char[] {'/', '*'})) {
                        block = true;
                        // Skip '*'
                        i++;
                    }
                    
                    // Collect other chars
                    else {
                        sb.append(s.charAt(i));
                    }
                }
            }
            // Only insert to res if block comment mode is off and sb is not empty
            if(!block && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }
    
    public boolean isPattern(String s, int i, char[] cs) {
        return s.charAt(i) == cs[0] && i+1 < s.length() && s.charAt(i+1) == cs[1];
    }
}