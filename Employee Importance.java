/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees)  map.put(e.id, e);
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        int res = 0;
        
        while(!q.isEmpty()) {
            Employee e = map.get(q.poll());
            visited.add(e.id);
            res += e.importance;
            
            List<Integer> sub = e.subordinates;
            if(sub == null) continue;
            for(int i: sub) {
                if(!visited.contains(i))    q.offer(i);
            }
        }
        return res;
    }
}