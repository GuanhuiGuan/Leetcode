class Solution {
    static Map<Character, List<Character>> map = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        // map.put('2', new char[] {'a', 'b', 'c'});
        // map.put('3', new char[] {'d', 'e', 'f'});
        // map.put('4', new char[] {'g', 'h', 'i'});
        // map.put('5', new char[] {'j', 'k', 'l'});
        // map.put('6', new char[] {'m', 'n', 'o'});
        // map.put('7', new char[] {'p', 'q', 'r', 's'});
        // map.put('8', new char[] {'t', 'u', 'v'});
        // map.put('9', new char[] {'w', 'x', 'y', 'z'});
        char letter = 'a';
        for(char c = '2'; c <= '9'; c++) {
            List<Character> list = new ArrayList<>();
            int k = 3;
            if(c == '7' || c == '9')    k = 4;
            for(int i = 0; i < k; i++) {
                list.add(letter);
                letter++;
            }
            map.put(c, list);
        }
        
        if(digits == null || digits.length() == 0) return res;
        bt("", digits);
        return res;
    }
    
    public void bt(String cur, String digits) {
        if((digits.equals(""))) {
            res.add(cur);
            return;
        }
        String next = digits.length() > 1? digits.substring(1, digits.length()): "";
        List<Character> list = map.get(digits.charAt(0));
        for(char c: list) {
            bt(cur + c, next);
        }
    }
}