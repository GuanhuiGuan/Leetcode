class Solution {
    public String intToRoman(int num) {
        // find all key values, if >= key, add corresponding string
        int[] unit = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] ss = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder re = new StringBuilder();
        int i = 0;
        while(i < unit.length && num > 0) {
            if(num >= unit[i]) {
                re.append(ss[i]);
                num -= unit[i];
            }
            else    i++;
        }
        return re.toString();
    }
}