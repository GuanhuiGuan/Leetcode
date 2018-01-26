class Solution {
    // node pairs; paths among node pairs(k, 1/k)
    Map<String, List<String>> pairs = new HashMap<>();
    Map<String, List<Double>> paths = new HashMap<>();
    double[] re;
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        re = new double[queries.length];
        
        // create graphs(mapping to each other)
        for(int i = 0; i < equations.length; i++) {
            String[] eqt = equations[i];
            if(!pairs.containsKey(eqt[0]))  pairs.put(eqt[0], new ArrayList<>());
            if(!paths.containsKey(eqt[0]))  paths.put(eqt[0], new ArrayList<>());
            if(!pairs.containsKey(eqt[1]))  pairs.put(eqt[1], new ArrayList<>());
            if(!paths.containsKey(eqt[1]))  paths.put(eqt[1], new ArrayList<>());
            pairs.get(eqt[0]).add(eqt[1]);
            pairs.get(eqt[1]).add(eqt[0]);
            paths.get(eqt[0]).add(values[i]);
            paths.get(eqt[1]).add(1/values[i]);
        }
        
        // DFS
        for(int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            re[i] = dfs(query[0], query[1], new HashSet<>(), 1.0);
            if(re[i] == 0.0)    re[i] = -1.0;
        }
        return re;
    }
    
    public double dfs(String s, String e, Set<String> set, double val) {
        // set contains those found along the path; avoid cycle/contradiction
        if(set.contains(s)) return 0.0;
        // non-existence
        if(!pairs.containsKey(s))   return 0.0;
        if(s.equals(e)) return val;
        
        set.add(s);
        List<String> nbrs = pairs.get(s);
        List<Double> ps = paths.get(s);
        double next = 0;
        
        for(int j = 0; j < nbrs.size(); j++) {
            next = dfs(nbrs.get(j), e, set, val*ps.get(j));
            if(next != 0)   break;
        }
        set.remove(s);
        return next;
    }
}