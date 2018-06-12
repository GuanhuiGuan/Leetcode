class Solution {
    public String simplifyPath(String path) {
        String[] ss = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String s: ss) {
            if(s.equals("."))   continue;
            else if(s.equals("..")) {
                if(!stack.isEmpty())    stack.pop();
                else    continue;
            } 
            else if(s.length() != 0)    stack.push(s);
        }
        
        // Reconstruct
        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()) {
            str.insert(0, "/" + stack.pop());
        }
        return str.length() == 0? "/": str.toString();
    }
}