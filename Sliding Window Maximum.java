class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0)  return new int[0];
        int[] re = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i = 0; i < nums.length; i++){
            // omit first digit out of window
            if(!deque.isEmpty() && deque.peek() < i-k+1){
                deque.poll();
            }
            // omit those smaller than the new to-be-added digit
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            // add new digit
            deque.offer(i);
            if(i-k+1 >= 0){
                re[i-k+1] = nums[deque.peek()];
            }
        }
        return re;
    }
}