class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0, n = timeSeries.length;
        if(n == 0)  return 0;
        // simulate an interval
        int start = timeSeries[0], end = start + duration;
        
        for(int t: timeSeries) {
            if(t <= end) {
                start = Math.min(start, t);
                end = Math.max(end, t+duration);
            }
            else {
                sum += end - start;
                start = t;
                end = start + duration;
            }
        }
        sum += end - start;
        return sum;
    }
}