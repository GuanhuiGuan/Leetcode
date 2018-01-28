// ___________________Binary Indexed Tree Solution____________________
class NumArray {
    int[] BIT, nums;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        this.nums = new int[n];
        BIT = new int[n+1];
        for(int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }
    
    // get delta, update num with val, update BIT with delta, move by i+(i&(-i))
    public void update(int i, int val) {
        int delta = val - nums[i];
        nums[i] = val;
        // update BIT
        i++;
        while(i <= n) {
            BIT[i] += delta;
            i += (i & (-i));
        }
    }
    
    public int sumRange(int i, int j) {
        return BITsum(j) - BITsum(i-1);
    }
    
    // BIT sum helper, sum 0 -> i
    public int BITsum(int i) {
        int sum = 0;
        i++;
        while(i > 0) {
            sum += BIT[i];
            i -= (i & (-i));
        }
        return sum;
    }
}

// // ___________________Segment Tree Solution_____________________
// class NumArray_SegmentTree {
//     // Segment tree(Augmenting tree)
//     SegTNode root;

//     public NumArray(int[] nums) {
//         root = build(0, nums.length-1, nums);
//     }
    
//     public void update(int i, int val) {
//         upd(i, val, root);
//     }
    
//     public int sumRange(int i, int j) {
//         return range(i, j, root);
//     }
    
//     // _____________Segment tree helpers_______________
//     class SegTNode {
//         int start, end;
//         int sum = 0;
//         SegTNode left, right;
//         public SegTNode(int s, int e) {
//             start = s;
//             end = e;
//         }
//     }
    
//     public SegTNode build(int i, int j, int[] nums) {
//         if(i > j)   return null;
//         SegTNode node = new SegTNode(i, j);
//         if(i == j) {
//             node.sum = nums[i];
//         }
//         else {
//             int mid = i + (j-i)/2;
//             node.left = build(i, mid, nums);
//             node.right = build(mid+1, j, nums);
//             node.sum = node.left.sum + node.right.sum;
//         }
//         return node;
//     }
    
//     public void upd(int i, int val, SegTNode node) {
//         if(node == null)    return;
//         if(i < node.start || i > node.end)  return;
//         if(node.start == node.end && node.start == i)   node.sum = val;
//         else {
//             int mid = node.start + (node.end-node.start)/2;
//             if(i <= mid) upd(i, val, node.left);
//             else    upd(i, val, node.right);
//             node.sum = node.left.sum + node.right.sum;
//         }
//     }
    
//     public int range(int i, int j, SegTNode node) {
//         if(i > j)   return 0;
//         if(node == null)    return 0;
//         if(node.start == i && node.end == j)    return node.sum;
//         int mid = node.start + (node.end-node.start)/2;
//         if(j <= mid)    return range(i, j, node.left);
//         if(i > mid) return range(i, j, node.right);
//         return range(i, mid, node.left) + range(mid+1, j, node.right);
//     }
// }

// /**
//  * Your NumArray object will be instantiated and called as such:
//  * NumArray obj = new NumArray(nums);
//  * obj.update(i,val);
//  * int param_2 = obj.sumRange(i,j);
//  */