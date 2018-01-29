class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        
        int s = 0, e = num.length()-1;
        while(s <= e) {
            if(!map.containsKey(num.charAt(s))
               || map.get(num.charAt(s)) != num.charAt(e))  return false;
            s++;
            e--;
        }
        return true;
        
//         List<Character> letters = 
//             new ArrayList<Character>(Arrays.asList('0', '1', '8'));
//         char[] cs = num.toCharArray();
        
//         int s = 0, e = cs.length-1;
//         while(s < e) {
//             if(cs[s] == '6' && cs[e] == '9'
//                || cs[s] == '9' && cs[e] == '6'
//                || cs[s] == cs[e] && letters.contains(cs[s])) {
//                 s++;
//                 e--;
//                 continue;
//             }
//             else    return false;
//         }
//         if(s == e)  return letters.contains(cs[s]);
//         return true;
    }
}