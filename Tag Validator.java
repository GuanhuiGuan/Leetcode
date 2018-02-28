class Solution {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        String nonCTag = "<![CDATA[";
        
        // no general increment, increment seperately to avoid confusion
        for(int i = 0; i < code.length();) {
            // no outer tag wrapping
            if(i > 0 && stack.isEmpty()) return false;
            
            // special part
            else if(code.startsWith(nonCTag, i)) {
                int j = i + nonCTag.length();
                i = code.indexOf("]]>", j);
                if(i < 0)   return false;
                i += 3;
            }
            
            // ending tag
            else if(code.startsWith("</", i)) {
                int j = i+2;
                i = code.indexOf(">", j);
                // tag length limit
                if(i == j || i < 0 || i - j > 9)   return false;
                // uppercase limit
                for(int k = j; k < i; k++) {
                    if(!Character.isUpperCase(code.charAt(k))) return false;
                }
                String tag = code.substring(j, i);
                // same tag limit
                if(stack.isEmpty() || !stack.pop().equals(tag)) return false;
                i++;
            }
            
            // start tag
            else if(code.startsWith("<", i)) {
                int j = i+1;
                i = code.indexOf(">", j);
                // tag length limit
                if(i == j || i < 0 || i - j > 9)   return false;
                // uppercase limit
                for(int k = j; k < i; k++) {
                    if(!Character.isUpperCase(code.charAt(k))) return false;
                }
                String tag = code.substring(j, i);
                stack.push(tag);
                i++;
            }
            
            // others
            else    i++;
        }
        // balanced tags
        return stack.isEmpty();
    }
}