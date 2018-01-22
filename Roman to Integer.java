class Solution {
    public int romanToInt(String s) {
        // I V X L C D M
        
        
        // 2-pass, special case and normal case
        int num = 0;
        if(s.indexOf("IV") != -1)   num -= 2;
        if(s.indexOf("IX") != -1)   num -= 2;
        if(s.indexOf("XL") != -1)   num -= 20;
        if(s.indexOf("XC") != -1)   num -= 20;
        if(s.indexOf("CD") != -1)   num -= 200;
        if(s.indexOf("CM") != -1)   num -= 200;
        
        char[] cs = s.toCharArray();
        for(char c: cs) {
            if(c == 'I')    num += 1;
            if(c == 'V')    num += 5;
            if(c == 'X')    num += 10;
            if(c == 'L')    num += 50;
            if(c == 'C')    num += 100;
            if(c == 'D')    num += 500;
            if(c == 'M')    num += 1000;
        }
        return num;
        
        // char[] cs = s.toCharArray();
        // int ic = 0, xc = 0, cc = 0;
        // int num = 0;
        // for(char c: cs) {
        //     if(c == 'I') {
        //         num += 1;
        //         ic++;
        //     }
        //     else if(c == 'V') {
        //         num += 5;
        //         num -= 2*ic;
        //     }
        //     else if(c == 'X') {
        //         num += 10;
        //         num -= 2*ic;
        //         xc++;
        //     }
        //     else if(c == 'L') {
        //         num += 50;
        //         num -= 2*xc*10;
        //     }
        //     else if(c == 'C') {
        //         num += 100;
        //         num -= 2*xc*10;
        //         cc++;
        //     }
        //     else if(c == 'D') {
        //         num += 500;
        //         num -= 2*cc*100;
        //     }
        //     else if(c == 'M') {
        //         num += 1000;
        //         num -= 2*cc*100;
        //     }
        // }
        // return num;
    }
}