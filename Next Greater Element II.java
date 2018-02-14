class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        // stack store index
        
        // one loop but 2 passes
        for(int i = 0; i < 2*n; i++) {
        	// the wrap around index
        	int index = i%n;
            while(!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                res[stack.pop()] = nums[index];
            }
            // only insert new indices in the first pass
            if(i < n)	stack.push(i);
        }
        return res;
        
        
        
//         int[] res = new int[nums.length];
//         Arrays.fill(res, -1);
//         Stack<Integer> stack = new Stack<>();
//         // stack store index
        
//         for(int i = 0; i < nums.length; i++) {
//             while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
//                 res[stack.pop()] = nums[i];
//             }
//             stack.push(i);
//         }
        
//         // the remaining descends, all marked to the first in stack
//         List<Integer> temp = new ArrayList<>();
//         while(stack.size() > 1) {
//             temp.add(stack.pop());
//         }
//         int fstInd = stack.pop();
//         res[fstInd] = -1;
//         for(int i: temp)    res[i] = nums[fstInd];
        
//         return res;
    }
}