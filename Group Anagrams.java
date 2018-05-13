class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str: strs) {
            String key = toSetString(str);
            List<String> list = map.get(key);
            if(list == null)    list = new ArrayList<>();
            list.add(str);
            map.put(key, list);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
    
    public String toSetString(String str) {
        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }
}