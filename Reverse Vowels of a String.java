class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        int i = 0, j = s.length()-1;
        char[] cs = s.toCharArray();
        while(i < j){
            while(!vowels.contains(cs[i]) && i < j)    i++;
            while(!vowels.contains(cs[j]) && i < j)    j--;

            char t = cs[i];
            cs[i] = cs[j];
            cs[j] = t;
            i++;
            j--;
        }
        return new String(cs);
    }
}