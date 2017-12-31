class NumArray {
    // segment tree
    STNode root;

    public NumArray(int[] nums) {
        root = build(0, nums.length-1, nums);
    }
    
    public void update(int i, int val) {
        udNode(root, i, val);
    }
    
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    // ________________segment tree and helpers________________
    class STNode {
        int start, end;
        STNode left = null, right = null;
        int sum = 0;
        public STNode(int s, int e) {
            start = s;
            end = e;
        }
    }
    
    public STNode build(int start, int end, int[] nums) {
        if(start > end) return null;
        
        STNode node = new STNode(start, end);
        if(start == end){
            node.sum = nums[start];
        }
        else{
            int mid = start + (end-start)/2; //avoid overflow
            node.left = build(start, mid, nums);
            node.right = build(mid+1, end, nums);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }
    
    public void udNode(STNode node, int i, int val){
        if(node == null || i < node.start || i > node.end)  return;
        if(node.start == node.end){
            node.sum = val;
        }
        else{
            int mid = node.start + (node.end-node.start)/2;
            if(i <= mid)    udNode(node.left, i, val);
            else    udNode(node.right, i, val);
            
            node.sum = node.left.sum + node.right.sum;
        }
    }
    
    public int sumRange(STNode node, int i, int j){
        if(i > j || node == null)   return 0;
        if(node.start == i && node.end == j)    return node.sum;
        
        int mid = node.start + (node.end-node.start)/2;
        if(j <= mid) return sumRange(node.left, i, j);
        if(i > mid)   return sumRange(node.right, i, j);
        return sumRange(node.left, i, mid) + sumRange(node.right, mid+1, j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */