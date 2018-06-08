class Solution {
    public int leastInterval(char[] tasks, int n) {
        // record the occurrences of 26 tasks
        int[] counts = new int[26];
        for(char c: tasks) {
            counts[c - 'A']--;
        }
        Arrays.sort(counts);
        
        // find the second most occurred task
        int i = 0;
        while(i < 26 && counts[i] == counts[0]) i++;
        
        // at least original size
        // or (maxCount-1) * (n+1) plus those with same maxCount
        // (maxCount-1) because the last one is included in later part
        return Math.max(tasks.length, (n+1)*(-counts[0]-1) + i);
    }
}