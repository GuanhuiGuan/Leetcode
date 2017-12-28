class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] num = new Integer[rowIndex+1];
        // adding previous, but from back to front
        Arrays.fill(num, 1);
        for(int i = 0; i < rowIndex; i++){
            for(int j = i; j > 0; j--){
                // don't alter the first 1
                num[j] += num[j-1];
            }
        }
        return Arrays.asList(num);
        
        
        
        // for(int i = 0; i <= rowIndex; i++){
        //     int pre = 1, cur;
        //     for(int j = 1; j < num.size(); j++){
        //         cur = num.get(j);
        //         num.set(j, pre+num.get(j));
        //         pre = cur;
        //     }
        //     num.add(1);
        // }
        // return num;
    }
}