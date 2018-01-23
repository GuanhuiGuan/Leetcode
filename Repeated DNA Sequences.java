class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // transfer them into bits to save space
        Set<Integer> seq = new HashSet<>(), dpcSeq = new HashSet<>();
        List<String> re = new ArrayList<>();
        int[] map = new int[26];
        map['A'-'A'] = 0;
        map['C'-'A'] = 1;
        map['G'-'A'] = 2;
        map['T'-'A'] = 3;
        
        // left shift 2 every time
        int i = 0, j = 0;
        for(; i < s.length()-9; i++) {
            int bit = 0;
            for(j = 0; j < 10; j++) {
                bit |= map[s.charAt(i+j)-'A'];
                bit <<= 2;
            }
            if(!seq.add(bit) && dpcSeq.add(bit))    re.add(s.substring(i, i+j));
        }
        return re;
        
        
//         // not optimal
//         List<String> re = new ArrayList<>();
//         int n = s.length();
//         if(n < 10)  return re;
//         Set<String> set = new HashSet<>();
        
//         for(int i = 0; i+9 < n; i++) {
//             String sub = s.substring(i, i+10);
//             // if duplicate
//             if(!set.add(sub)) {
//                 // check if already added
//                 if(!re.contains(sub))   re.add(sub);
//             }
//         }
        
//         return re;
    }
}