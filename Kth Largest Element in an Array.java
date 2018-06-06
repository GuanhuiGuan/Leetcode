class Solution {
    Random rand = new Random();
    
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        shuffle(nums);
        
        int s = 0, e = nums.length-1;
        while(s < e) {
            int m = partition(nums, s, e);
            if(m == k)  return nums[m];
            if(m < k)   s = m + 1;
            else    e = m - 1;
        }
        return nums[s];
    }
    
    public int partition(int[] nums, int s, int e) {
        if(s == e)  return s;
        int i = s, j = s;
        while(j < e) {
            if(nums[j] <= nums[e]) {
                swap(nums, i++, j);
            }
            j++;
        }
        swap(nums, i, e);
        return i;
    }
    
    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    
    public void shuffle(int[] nums) {
        for(int i = nums.length-1; i > 0; i--) {
            swap(nums, i, rand.nextInt(i));
        }
    }
}