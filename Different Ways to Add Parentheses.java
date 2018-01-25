class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        // recursion, split on every operator
        List<Integer> re = new ArrayList<>();
        if(input.length() == 0) return re;
        
        for(int i = 0; i < input.length(); i++) {
            // split on operators
            if(input.charAt(i) == '+' || 
               input.charAt(i) == '-' ||
               input.charAt(i) == '*') {
                String s1 = input.substring(0, i);
                String s2 = input.substring(i+1);
                // recurse to get sub-results
                List<Integer> l1 = diffWaysToCompute(s1), l2 = diffWaysToCompute(s2);
                // find every combinations
                char opr = input.charAt(i);
                for(int e1: l1) {
                    for(int e2: l2) {
                        if(opr == '+')  re.add(e1+e2);
                        if(opr == '-')  re.add(e1-e2);
                        if(opr == '*')  re.add(e1*e2);
                    }
                }
            }
        }
        // no sign, just add integer
        if(re.isEmpty())    re.add(Integer.parseInt(input));
        return re;
    }
}