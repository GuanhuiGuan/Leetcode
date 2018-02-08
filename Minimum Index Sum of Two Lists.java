class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        
        int minSum = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for(int j = 0; j < list2.length; j++) {
            if(map.containsKey(list2[j])) {
                int sum = j + map.get(list2[j]);
                // if smaller, clear list and add; if equal, add
                if(sum <= minSum) {
                    if(sum < minSum) {
                        list.clear();
                        minSum = sum;
                    }
                    list.add(list2[j]);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
}