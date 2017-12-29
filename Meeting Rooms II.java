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
        // use minimum heap(end) for merged intervals(meeting rooms)
        int n = intervals.length;
        if(n == 0)  return 0;
        
        Comparator<Interval> cmp_st = new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        };
        
        Comparator<Interval> cmp_end = new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.end - i2.end;
            }
        };
        
        Arrays.sort(intervals, cmp_st);
        Queue<Interval> mi = new PriorityQueue<>(cmp_end);
        mi.offer(intervals[0]);
        
        for(int i = 1; i < n; i++){
            // the room with earliest end time
            Interval room = mi.poll();
            if(room.end <= intervals[i].start){
                room.end = intervals[i].end;
            }
            else{
                mi.offer(intervals[i]);
            }
            mi.offer(room);
        }
        
        return mi.size();
    }
    
    /*
    // original AC solution
    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        if(n == 0)  return 0;
        
        List<Integer> endTime = new ArrayList<>();
        // endTime.add(intervals[0].end);
        
        Comparator<Interval> cmp = new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        };
        
        Arrays.sort(intervals, cmp);
        for(int i = 0; i < n; i++){
            int j = 0;
            while(j < endTime.size()){
                // can hold i in Room j
                if(intervals[i].start >= endTime.get(j)){
                    endTime.set(j, intervals[i].end);
                    break;
                }
                j++;
            }
            // can't find a meeting room
            if(j == endTime.size()){
                endTime.add(intervals[i].end);
            }
        }
        
        return endTime.size();
    }
    */
}