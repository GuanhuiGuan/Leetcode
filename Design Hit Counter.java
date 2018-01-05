class HitCounter {
    int[] hitTime, hits;

    /** Initialize your data structure here. */
    public HitCounter() {
        hitTime = new int[300];
        hits = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int t = timestamp%300;
        // not in the same loop, reset
        if(hitTime[t] != timestamp){
            hitTime[t] = timestamp;
            hits[t] = 1;
        }
        // otherwise increment
        else{
            hits[t]++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int sum = 0;
        for(int i = 0; i < 300; i++){
            if(timestamp-hitTime[i] < 300)  sum += hits[i];
        }
        return sum;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */