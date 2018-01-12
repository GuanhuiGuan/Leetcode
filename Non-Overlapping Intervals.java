/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        // greedy
        int n = intervals.length;
        if(n == 0)  return 0;
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if(i1.end == i2.end) {
                    return i2.start - i1.start;
                }
                return i1.end - i2.end;
            }
        });
        
        int pos = intervals[0].end, del = 0;
        for(int i = 1; i < n; i++) {
            if(intervals[i].start < pos)    del++;
            else    pos = intervals[i].end;
        }
        return del;
    }
}