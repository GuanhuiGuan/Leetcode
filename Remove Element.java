class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int n: nums){
            if(n != val){
                nums[index++] = n;
            }
        }
        return index;
    }
}

// original
// class Solution {
//     public int removeElement(int[] nums, int val) {
//         int i = 0;
//         for(; i < nums.length; i++){
//             if(nums[i] == val){
//                 int j = i+1;
//                 while(j < nums.length && nums[j] == val){
//                     j++;
//                 }
//                 if(j == nums.length){
//                     break;
//                 }
//                 else{
//                     swap(nums, i, j);
//                 }
//             }
//         }
//         return i;
//     }
    
//     public void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }