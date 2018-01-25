class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 0)  return 0;
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        // modify triangle as min path ending with this node, could go upwards or downwards
        for(int i = 1; i < triangle.size(); i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < triangle.get(i).size(); j++) {
                if(j == 0)  triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j));
                else if(j == triangle.get(i).size()-1)  triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
                else {
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)));
                }
                dp[i] = Math.min(dp[i], triangle.get(i).get(j));
            }
        }
        return dp[n-1];
    }
}