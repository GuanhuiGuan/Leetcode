class TwoSum {
    private List<Integer> list;
    private Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSum() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        map.clear();
        for(Integer item: list){
            if(map.containsKey(item)){
                return true;
            }
            else{
                map.put(value-item, item);
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
