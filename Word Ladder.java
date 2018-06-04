class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // return oneBFS(beginWord, endWord, wordList);
        return twoBFS(beginWord, endWord, wordList);
    }
    
    public int twoBFS(String bw, String ew, List<String> wl) {
        if(!wl.contains(ew))    return 0;
        
        // use wordset to store wordlist to speed up
        Set<String> start = new HashSet<>(), end = new HashSet<>(), used = new HashSet<>(), ws = new HashSet<>(wl);
        start.add(bw);
        end.add(ew);
        
        int k = 1;
        while(!start.isEmpty() && !end.isEmpty()) {
            if(start.size() > end.size()) {
                Set<String> t = start;
                start = end;
                end = t;
            }
            
            Set<String> next = new HashSet<>();
            for(String word: start) {
                char[] cs = word.toCharArray();
                for(int i = 0; i < cs.length; i++) {
                    char ori = cs[i];
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(c == ori)    continue;
                        cs[i] = c;
                        // String nw = new String(cs);
                        String nw = String.valueOf(cs);
                        // one extra step is made
                        if(end.contains(nw)) return k + 1;
                        if(used.contains(nw))   continue;
                        if(ws.contains(nw)) {
                            next.add(nw);
                            used.add(nw);
                        }
                    }
                    cs[i] = ori;
                }
            }
            start = next;
            k++;
        }
        return 0;
    }
    
    public int oneBFS(String bw, String ew, List<String> wl) {
        if(!wl.contains(ew))    return 0;
        Queue<String> q = new LinkedList<>();
        Set<String> used = new HashSet<>();
        q.offer(bw);
        int k = 1;
        
        while(!q.isEmpty()) {
            for(int cur = q.size(); cur > 0; cur--) {
                String word = q.poll();
                if(word.equals(ew)) return k;

                char[] cs = word.toCharArray();
                for(int i = 0; i < cs.length; i++) {
                    char ori = cs[i];
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(c == ori)    continue;
                        cs[i] = c;
                        String nw = new String(cs);
                        if(used.contains(nw))   continue;
                        used.add(nw);
                        if(wl.contains(nw)) q.offer(nw);
                    }
                    cs[i] = ori;
                }
            }
            k++;
        }
        return 0;
    }
}