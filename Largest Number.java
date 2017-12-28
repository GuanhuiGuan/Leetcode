class Solution {
    public String largestNumber(int[] nums) {
        if(nums.length == 0)    return "0";
        // change to string array
        String[] str = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            str[i] = String.valueOf(nums[i]);
        }
        
        Comparator<String> cmp = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String str1 = s1+s2;
                String str2 = s2+s1;
                return str2.compareTo(str1);
                // return the larger one
            }
        };
            
        
        Arrays.sort(str, cmp);
        
        // if all 0 -> 0
        if(str[0].equals("0"))   return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String s: str){
            sb.append(s);
        }
        return sb.toString();
    }
}