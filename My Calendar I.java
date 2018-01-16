class MyCalendar {
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        // s<=start, e>start
        Integer lowKey = map.floorKey(start);
        if(lowKey != null && map.get(lowKey) > start)   return false;
        // s>=start, s<end
        Integer highKey = map.ceilingKey(start);
        if(highKey != null && highKey < end)    return false;
        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */