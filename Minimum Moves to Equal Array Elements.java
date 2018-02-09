class Solution {
    public int minMoves(int[] nums) {
        // math, think the other way, equivalent to subtracting 1 for 1 element every move
        // the quickest way is keep subtracting until all are equal to min element
        int sum = 0, min = Integer.MAX_VALUE;
        for(int num: nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return sum - nums.length*min;
    }
}