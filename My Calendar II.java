class MyCalendarTwo {
    // O(n)
    List<int[]> calendar, overlap;

    public MyCalendarTwo() {
        calendar = new ArrayList<int[]>();
        overlap = new ArrayList<int[]>();
    }
    
    public boolean book(int start, int end) {
        // check overlap
        for(int[] ovl: overlap) {
            // if not disjoint
            if(!(start >= ovl[1] || end <= ovl[0])) return false;
        }
        
        // insert, record intersections
        for(int[] itv: calendar) {
            int s = Math.max(start, itv[0]);
            int e = Math.min(end, itv[1]);
            if(s < e)   overlap.add(new int[] {s, e});
        }
        calendar.add(new int[] {start, end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */