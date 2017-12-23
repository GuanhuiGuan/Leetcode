class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // use set to deal with duplicates
        Set pre = new HashSet(), re = new HashSet();
        for(int i = 0; i+9 < s.length(); i++){
            String sub = s.substring(i, i+10);
            if(!pre.add(sub)){
                re.add(sub);
            }
        }
        return new ArrayList(re);
    }
}

// class Solution {
//     public List<String> findRepeatedDnaSequences(String s) {
//         List<String> list = new ArrayList<>();
//         Map<String, Integer> map = new HashMap<>();
//         if(s.length() < 10) return list;
        
//         int n = s.length();
//         for(int i = 0; i+9 < n; i++){
//             String sub = s.substring(i, i+10);
//             if(map.containsKey(sub) && map.get(sub) == 0){
//                 list.add(sub);
//                 map.put(sub, 1);
//             }
//             else if(!map.containsKey(sub)){
//                 map.put(sub, 0);
//             }
//         }
//         return list;
//     }
// }