class Solution {
    String[] digits = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    String[] tens = {"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    String[] thousands = {" ", "Thousand ", "Million ", "Billion "};
    StringBuilder sb = new StringBuilder();
    
    public String numberToWords(int num) {
        
        if(num == 0)    return "Zero";
        int i = 0;
        while(num > 0) {
            if(num%1000 != 0) {
                sb.insert(0, comp(num%1000) + thousands[i]);
            }
            num /= 1000;
            i++;
        }
        // eliminate last space
        return sb.toString().trim();
    }
    
    // compute those less than 1000
    public String comp(int num) {
        String s = "";
        while(num > 0) {
            if(num < 20) {
                s += digits[num];
                num = 0;
            }
            else if(num < 100) {
                s += tens[num/10];
                num %= 10;
            }
            else {
                s += digits[num/100] + "Hundred ";
                num %= 100;
            }
        }
        return s;
    }
}