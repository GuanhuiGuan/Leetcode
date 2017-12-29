class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0)    return "";
        if(numerator == 0)  return "0";
        
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        // sign
        sb.append(((numerator > 0)^(denominator > 0))? "-": "");
        long nmr = Math.abs((long)numerator);
        long dnm = Math.abs((long)denominator);
        long qte = nmr/dnm;
        long rmd = nmr%dnm;
        
        // integer part
        sb.append(qte);
        if(rmd == 0)    return sb.toString();
        
        // decimal part
        sb.append('.');
        map.put(rmd, sb.length());
        while(rmd != 0){
            rmd *= 10;
            sb.append(rmd/dnm);
            rmd %= dnm;
            // find if repeating
            if(map.get(rmd) != null){
                int index = map.get(rmd);
                sb.insert(index, '(');
                sb.append(')');
                break;
            }
            else{
                map.put(rmd, sb.length());
            }
        }
        
        return sb.toString();
    }
}