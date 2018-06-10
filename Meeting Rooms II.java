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
    public int minMeetingRooms(Interval[] intervals) {
        // sort meetings with start time
        // heap to store rooms sorted with end time
        if(intervals == null || intervals.length == 0)   return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        
        Queue<Interval> heap = new PriorityQueue<>(new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        
        heap.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            Interval o = intervals[i], cur = heap.poll();
            if(o.start < cur.end)   heap.offer(o);
            else    cur.end = o.end;
            heap.offer(cur);
        }
        return heap.size();
    }
}