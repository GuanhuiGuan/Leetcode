class Solution {
    String[] twenties = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
                         "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        
        String res = "";
        int i = 0;
        
        while(num > 0) {
            // avoid multiple meaningless thousand units
            if(num % 1000 != 0) res = less(num % 1000) + thousands[i] + " " + res;
            
            i++;
            num /= 1000;
        }
        
        return res.trim();
    }
    
    public String less(int num) {
        if(num == 0)    return "";
        else if(num < 20)   return twenties[num] + " ";
        else if(num < 100)  return tens[num / 10] + " " + less(num % 10);
        else    return less(num / 100) + "Hundred" + " " + less(num % 100);
    }
}