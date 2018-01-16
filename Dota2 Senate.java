class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>(), dire = new LinkedList<>();
        for(int i = 0; i < senate.length(); i++) {
            if(senate.charAt(i)=='D')   dire.offer(i);
            else    radiant.offer(i);
        }
        
        while(!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll(), d = dire.poll();
            if(r < d)   radiant.offer(r+senate.length());
            else    dire.offer(d+senate.length());
        }
        return radiant.isEmpty()? "Dire": "Radiant";
    }
}