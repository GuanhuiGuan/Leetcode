class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] time = new int[n];
        // Let prev marks the beginning of the time unit
        int prev = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(String log: logs) {
            String[] ls = log.split(":");
            int func = Integer.parseInt(ls[0]);
            int timestamp = Integer.parseInt(ls[2]);
            String status = ls[1];
            
            // Add time interval(not including the unit at timestamp)
            if(!stack.isEmpty())    time[stack.peek()] += (timestamp - prev);
            // Update prev
            prev = timestamp;
            // status == start: push in func
            if(status.equals("start"))  stack.push(func);
            // status == end: pop func, include the current timestamp, advance prev
            else {
                time[stack.pop()]++;
                prev++;
            }
        }
        return time;
    }
}