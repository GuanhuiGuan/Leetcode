class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // Union find, use email as object
        Map<String, String> roots = new HashMap<>(), names = new HashMap<>();
        Map<String, TreeSet<String>> map = new HashMap<>(); // treeset for sorted set
        
        // 1st pass to set up names and initial groups
        for(List<String> acc: accounts) {
            for(int i = 1; i < acc.size(); i++) {
                roots.put(acc.get(i), acc.get(1));
                names.put(acc.get(i), acc.get(0));
            }
        }
        // 2nd pass to merge emails in each initial group
        for(List<String> acc: accounts) {
            String root = find(roots, acc.get(1));
            for(int i = 1; i < acc.size(); i++) {
                // Caution! Merge the root of the element
                roots.put(find(roots, acc.get(i)), root);
            }
        }
        // 3rd pass to save groups in treesets
        for(List<String> acc: accounts) {
            String root = find(roots, acc.get(1));
            if(!map.containsKey(root))  map.put(root, new TreeSet<String>());
            for(int i = 1; i < acc.size(); i++) {
                map.get(root).add(acc.get(i));
            }
        }
        // 4th pass to construct output
        List<List<String>> re = new ArrayList<>();
        for(String key: map.keySet()) {
            List<String> list = new ArrayList<>();
            list.add(names.get(key));
            for(String email: map.get(key)) {
                list.add(email);
            }
            re.add(list);
        }
        return re;
    }
    
    public String find(Map<String, String> roots, String s) {
        if(roots.get(s).equals(s))  return s;
        return find(roots, roots.get(s));
    }
}