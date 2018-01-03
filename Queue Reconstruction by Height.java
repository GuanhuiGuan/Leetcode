class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // rank by height(des), number(asc)
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                return (p1[0]!=p2[0])? (p2[0]-p1[0]): (p1[1]-p2[1]);
            }
        });
        List<int[]> re = new ArrayList<>();
        for(int[] person: people){
            // insert person based on people count before him, the shorter the more in the front
            re.add(person[1], person);
        }
        // specify what to be transformed
        return re.toArray(new int[people.length][2]);
    }
}