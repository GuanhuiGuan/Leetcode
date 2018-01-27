public class Solution{
	int index = 0;
	public String decodeString(String s) {
		StringBuilder re = new StringBuilder();
        int n = 0;
        
        while(index < s.length()) {
            // is digit
            if(Character.isDigit(s.charAt(index))) {
                while(Character.isDigit(s.charAt(index))) {
                    n = 10*n + s.charAt(index++)-'0';
                }
                // skip "["
                index++;
                String nested = decodeString(s);
                while(n > 0) {
                    n--;
                    re.append(nested);
                }
            }
            // is letter
            else if(Character.isLetter(s.charAt(index))) {
                re.append(s.charAt(index++));
            }
            // is ], skip
            else if(s.charAt(index++) == ']')   return re.toString();
        }
        return re.toString();
	}
}