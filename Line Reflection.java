class Solution {
    public boolean isReflected(int[][] points) {
        // record coordinates, 2nd pass check if hor-symmetric coordinate exists
        Set<String> set = new HashSet<>();
        
        // min, max record both ends of x axis
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int[] point: points) {
            min = Math.min(min, point[0]);
            max = Math.max(max, point[0]);
            String key = point[0] + "+" + point[1];
            set.add(key);
        }
        int sum = min + max;
        
        // hor-symmetric of x = sum-x
        for(int[] point: points) {
            String key = (sum-point[0]) + "+" + point[1];
            if(!set.contains(key))  return false;
        }
        return true;
    }
}