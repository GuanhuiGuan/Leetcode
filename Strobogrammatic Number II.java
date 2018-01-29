class Solution {
    // Recursive expand from center, check size for adding 0
    public List<String> findStrobogrammatic(int n) {
        return build(n, n);
    }
    
    // max marks the boundary of total string, avoid 00
    public List<String> build(int n, int max) {
        if(n == 0)  return new ArrayList<>(Arrays.asList(""));
        if(n == 1)  return new ArrayList<>(Arrays.asList("0", "1", "8"));
        // get list of center substrings
        List<String> subs = build(n-2, max);
        List<String> cur = new ArrayList<>();
        for(String sub: subs) {
            if(n != max)    cur.add("0" + sub + "0");
            cur.add("1" + sub + "1");
            cur.add("6" + sub + "9");
            cur.add("8" + sub + "8");
            cur.add("9" + sub + "6");
        }
        return cur;
    }
    
//     // BT method
//     Map<String, String> map = new HashMap<>();
//     List<String> re = new ArrayList<>();
    
//     public List<String> findStrobogrammatic(int n) {
//         map.put("0", "0");
//         map.put("1", "1");
//         map.put("6", "9");
//         map.put("8", "8");
//         map.put("9", "6");
//         String[] centers = {"0", "1", "8"};
        
//         if(n <= 0)  return re;
//         if(n%2 == 0)    dfs("", n);
//         else {
//             for(String c: centers) {
//                 dfs(c, n);
//             }
//         }
//         return re;
//     }
    
//     public void dfs(String s, int n) {
//         if(s.length() == n) {
//             // avoid starting from 0
//             if(s.length() > 1 && s.charAt(0) == '0')  return;
//             re.add(s.toString());
//             return;
//         }
//         for(String key: map.keySet()) {
//             String ns = key + s + map.get(key);
//             dfs(ns, n);
//         }
//     }
}