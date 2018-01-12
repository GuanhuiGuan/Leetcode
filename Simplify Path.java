class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        
        for(String str: path.split("/")) {
            if(str.equals("..") && !stack.isEmpty())    stack.pop();
            else if(!skip.contains(str))    stack.push(str);
        }
        
        String re = "";
        while(!stack.isEmpty()) {
            re = "/" + stack.pop() + re;
        }
        if(re.length() == 0)    return "/";
        return re;
    }
}