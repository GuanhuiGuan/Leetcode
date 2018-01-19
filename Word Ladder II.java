class Solution {
    List<List<String>> re = new ArrayList<>();
    Map<String, List<String>> graph = new HashMap<>();
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> sSet = new HashSet<>(), eSet = new HashSet<>();
        sSet.add(beginWord);
        eSet.add(endWord);
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))  return re;
        
        BFS(sSet, eSet, wordSet, false);
        // add beginWord first cause it's not in graph
        DFS(beginWord, endWord, new ArrayList<>(Arrays.asList(beginWord)));
        return re;
    }
    
    // search valid adjacent words
    public void BFS(Set<String> sSet, Set<String> eSet, Set<String> wordSet, boolean flip) {
        
        // flip?
        if(sSet.size() > eSet.size()) {
            // Set<String> ts = sSet;
            // sSet = eSet;
            // eSet = ts;
            BFS(eSet, sSet, wordSet, !flip);
            return;
        }
        
        // dead end
        if(sSet.isEmpty())  return;
        
        // avoid duplicate
        wordSet.removeAll(sSet);
        wordSet.removeAll(eSet);
        
        Set<String> nextSet = new HashSet<>();
        boolean terminate = false;
        for(String s: sSet) {
            char[] cs = s.toCharArray();
            for(int i = 0; i < cs.length; i++) {
                char oc = cs[i];
                for(char c = 'a'; c <= 'z'; c++) {
                    cs[i] = c;
                    String ns = String.valueOf(cs);
                    
                    // determine key/val with flip
                    String key = flip? ns: s;
                    String val = flip? s: ns;
                    
                    List<String> children = new ArrayList<>();
                    if(graph.containsKey(key))  children = graph.get(key);
                    
                    // terminate
                    if(eSet.contains(ns)) {
                        terminate = true;
                        children.add(val);
                        graph.put(key, children);
                    }
                    
                    // not terminate but in wordset
                    if(!terminate && wordSet.contains(ns)) {
                        nextSet.add(ns);
                        children.add(val);
                        graph.put(key, children);
                    }
                }
                cs[i] = oc;
            }
        }
        // sSet = nextSet;
        if(!terminate)   BFS(nextSet, eSet, wordSet, flip);
    }
    
    // record paths
    public void DFS(String bw, String ew, List<String> path) {
        if(bw.equals(ew)) {
            re.add(new ArrayList<String>(path));
        }
        else if(!graph.containsKey(bw)) return;
        else {
            for(String ns: graph.get(bw)) {
                path.add(ns);
                DFS(ns, ew, path);
                path.remove(path.size()-1);
            }
        }
    }
}