class Solution {
    public boolean verifyPreorder(int[] preorder) {
        // use lower bound to mark minimum val
        int min = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        
        for(int node: preorder) {
            if(node < min)  return false;
            
            // update min, keep it min so that nothing else should be smaller
            while(!stack.isEmpty() && stack.peek() < node) {
                min = stack.pop();
            }
            stack.push(node);
        }
        return true;
    }
}