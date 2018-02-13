class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // ______________O(n)_____________
        // store descending order sequence in the stack
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int num: nums2) {
            while(!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        while(!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        
        int[] res = new int[nums1.length];
        for(int i = 0; i < res.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
        
//         // _____________O(n^2)________________
//         Map<Integer, Integer> map = new HashMap<>();
//         for(int i = 0; i < nums2.length; i++) {
//             int cur = nums2[i];
//             for(int j = i+1; j < nums2.length; j++) {
//                 if(nums2[j] > cur) {
//                     map.put(cur, nums2[j]);
//                     break;
//                 }
//             }
//             if(!map.containsKey(cur))   map.put(cur, -1);
//         }
        
//         int[] res = new int[nums1.length];
//         for(int i = 0; i < res.length; i++) {
//             res[i] = map.get(nums1[i]);
//         }
//         return res;
    }
}