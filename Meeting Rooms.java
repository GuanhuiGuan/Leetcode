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
    public boolean canAttendMeetings(Interval[] intervals) {
        Comparator<Interval> cmp = new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
                // mono-increasing: -1, 0, 1
            }
        };
        
        Arrays.sort(intervals, cmp);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i-1].end)    return false;
        }
        return true;
    }
}