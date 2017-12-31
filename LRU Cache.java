class LRUCache {
    DLNode head = new DLNode(0, 0), tail = new DLNode(0, 0);
    Map<Integer, DLNode> map = new HashMap<>();
    int cap;
    

    public LRUCache(int capacity) {
        cap = capacity;
        head.next= tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DLNode node = map.get(key);
            node.pop();
            insertTop(node);
            return node.value;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        // input
        DLNode node = map.get(key);
        if(node == null){
            node = new DLNode(key, value);
        }
        else{
            node.value = value;
            node.pop();
        }
        insertTop(node);
        map.put(key, node);
        // check capacity
        if(map.size() > cap){
            DLNode pop = popTail();
            map.remove(pop.key);
        }
    }
    
    public DLNode popTail() {
        DLNode pop = tail.pre;
        DLNode pre = pop.pre;
        pre.next = tail;
        tail.pre = pre;
        return pop;
    }
    
    public void insertTop(DLNode node) {
        node.next = head.next;
        node.pre = head;
        
        head.next.pre = node;
        head.next = node;
    }
    
    class DLNode {
        int key, value;
        DLNode pre = null, next = null;
        public DLNode(int k, int v) {
            key = k;
            value = v;
        }
        
        public void pop(){
            // delete from original position
            DLNode pre = this.pre, next = this.next;
            pre.next = next;
            next.pre = pre;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */