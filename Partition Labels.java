class Solution {
    // O(n)
    public List<Integer> partitionLabels(String S) {
        // record the last index of each character
        // sweep and record when i == end(max end of current interval)
        if(S == null || S.length() == 0) return new ArrayList<>();
        
        int[] map = new int[26];
        for(int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < S.length(); i++) {
            end = Math.max(end, map[S.charAt(i) - 'a']);
            if(i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
    
    
//     // O(nlogn)
//     public List<Integer> partitionLabels(String S) {
//         Map<Character, int[]> map = new HashMap<>();
//         for(int i = 0; i < S.length(); i++) {
//             char c = S.charAt(i);
//             int[] expand = new int[] {i, i};
//             if(map.containsKey(c)) {
//                 expand = map.get(c);
//                 expand[1] = i;
//             }
//             map.put(c, expand);
//         }
        
//         List<int[]> intervals = new ArrayList<>(map.values());
//         intervals.sort(new Comparator<int[]>() {
//             @Override
//             public int compare(int[] i1, int[] i2) {
//                 return i1[0] == i2[0]? i1[1] - i2[1] : i1[0] - i2[0];
//             }
//         });
        
//         List<Integer> res = new ArrayList<>();
//         if(intervals.isEmpty()) return res;
//         int start = -1, end = -1;
//         for(int[] interval: intervals) {
//             if(end == -1) {
//                 start = interval[0];
//                 end = interval[1];
//             }
//             else if(end >= interval[0]) {
//                 start = Math.min(start, interval[0]);
//                 end = Math.max(end, interval[1]);
//             }
//             else {
//                 res.add(end - start + 1);
//                 start = interval[0];
//                 end = interval[1];
//             }
//         }
//         res.add(end - start + 1);
//         return res;
//     }
}