class Solution {
    // use bit to store what char each word has, int 32 bit enough for 26 chars
    public int maxProduct(String[] words) {
        // record each words' chars, bit shift and or
        int[] cs = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            int bit = 0;
            for(int j = 0; j < words[i].length(); j++) {
                bit |= (1<<(words[i].charAt(j)-'a'));
            }
            cs[i] = bit;
        }
        // cmp every two words, use and
        int maxPd = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {
                if((cs[i]&cs[j]) == 0) {
                    int mul = words[i].length() * words[j].length();
                    maxPd = Math.max(maxPd, mul);
                }
            }
        }
        return maxPd;
    }
    
//     // cmp strings directly
//     public int maxProduct_cmpStrings(String[] words) {
//         Map<String, Set<Character>> map = new HashMap<>();
//         int maxPd = 0;
        
//         for(int i = 0; i < words.length; i++) {
//             for(int j = i+1; j < words.length; j++) {
//                 boolean valid = true;
//                 for(int k = 0; k < words[j].length(); k++) {
//                     if(words[i].contains(words[j].substring(k, k+1))) {
//                         valid = false;
//                         break;
//                     }
//                 }
//                 if(valid)   maxPd = Math.max(maxPd, words[i].length() * words[j].length());
//             }
//         }
//         return maxPd;
//     }
}