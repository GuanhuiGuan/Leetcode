class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 2-way BFS, swap start with end if end size < start
        Set<String> ss = new HashSet<>(), se = new HashSet<>();
        Set<String> used = new HashSet<>(), ws = new HashSet<>(wordList);
        
        if(!ws.contains(endWord))   return 0;
        ss.add(beginWord);
        se.add(endWord);
        
        // ss to se is at least 1 step away
        int len = 1;
        while(!ss.isEmpty() && !se.isEmpty()) {
            // swap if size check failed
            if(ss.size() > se.size()) {
                Set<String> temp = ss;
                ss = se;
                se = temp;
            }
            
            // new set to save new found words, swap with ss at the end of this lvl
            Set<String> next = new HashSet<>();
            for(String s: ss) {
                
                
                
                char[] cs = s.toCharArray();
                for(int i = 0; i < s.length(); i++) {
                    char t = cs[i];
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(c == t)  continue;
                        cs[i] = c;
                        String ns = String.valueOf(cs);
                        
                        // one extra step has been made in this double loop
                        if(se.contains(ns))    return len+1;
                        // in ws and not in used
                        if(ws.contains(ns) && used.add(ns))   next.add(ns);
                    }
                    cs[i] = t;
                }
            }
            // move on to next lvl
            ss = next;
            len++;
        }
        return 0;
    }
}

// // one way BFS
// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         Set<String> used = new HashSet<>(), ws = new HashSet<>(wordList); // set wordlist saves time
//         int count = 1; // when return, count is still at last iteration, thus initial set to 1
//         Queue<String> q = new LinkedList<>();
        
//         q.offer(beginWord);
//         while(!q.isEmpty()) {
//             // visit all in this lvl in order to count lvls to find target
//             for(int k = q.size(); k > 0; k--) {
//                 String s = q.poll();
//                 if(s.equals(endWord))   return count;
                
//                 // check every char of word, for 26 letters
//                 char[] cs = s.toCharArray();
//                 for(int i = 0; i < s.length(); i++) {
//                     char c = cs[i];
//                     for(char nc = 'a'; nc <= 'z'; nc++) {
//                         if(nc == c) continue;
//                         cs[i] = nc;
//                         // use valueOf() to merge them into string, otherwise toString() keeps commas
//                         String ns = String.valueOf(cs);
//                         // in list and not visited
//                         if(ws.contains(ns) && used.add(ns))   q.offer(ns);
//                     }
//                     cs[i] = c;
//                 }
//             }
//             count++;
//         }
//         return 0;
//     }
// }