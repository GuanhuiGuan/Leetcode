class Solution {
    private String ma = "ma", aStr = "a";
    private List<Character> vowels;
    
    public String toGoatLatin(String S) {
        vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        // String[] ss = S.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(String s: S.split(" ")) {
            if(sb.length() != 0)    sb.append(' ');
            // consonant
            if(!vowels.contains(s.toLowerCase().charAt(0))) {
                s = s.substring(1) + s.charAt(0);
            }
            sb.append(s).append(ma).append(aStr);
            aStr = aStr + 'a';
        }
        return sb.toString();
    }
}