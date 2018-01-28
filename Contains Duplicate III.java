class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // Bucket of width t+1 to store values, keep map of size k
        // cmp with cur bucket and neighboring buckets
        if(k < 1 || t < 0)  return false;
        // the element is remapped to start from Integer.MIN_VALUE
        Map<Long, Long> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            // remap num to start from Integer.MIN_VALUE
            long remap = (long)nums[i] - Integer.MIN_VALUE;
            // key of bucket
            long bucket = remap/((long)t+1);
            
            // has bucket || has prev/next bucket and value range <= t
            if(map.containsKey(bucket)
               || map.containsKey(bucket-1) && remap-map.get(bucket-1) <= t 
               || map.containsKey(bucket+1) && map.get(bucket+1)-remap <= t) {
                return true;
            }
            // maintain map as size k(act even ==k since cur element will be added)
            if(map.size() >= k) {
                // find key of earliest bucket
                long fstRemap = (long)nums[i-k] - Integer.MIN_VALUE;
                long fstBucket = fstRemap/((long)t+1);
                map.remove(fstBucket);
            }
            // add cur bucket/element
            map.put(bucket, remap);
        }
        return false;
    }
}