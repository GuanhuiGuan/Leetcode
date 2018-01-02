class Solution {
    public int lengthLongestPath(String input) {
        int n = input.length();
        if(n == 0)  return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxL = 0;
        String[] strs = input.split("\n");
        
        for(String str: strs){
            // num of tabs(first one from back), if no, return -1+1=0
            int tabs = str.lastIndexOf("\t")+1;
            // stack size = num of tabs + 1 = the parent lvl we're looking for
            while(tabs+1 < stack.size()){
                stack.pop();
            }
            // minus \t and add /
            int cnt = stack.peek() + (str.length()-tabs+1);
            stack.push(cnt);
            // reach the end: update max path
            if(str.contains(".")){
                // cnt-1 because the last one does not have /
                maxL = Math.max(maxL, cnt-1);
            }
        }
        return maxL;
    }
}