class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new ArrayList<int[]>();
        }
        
        List<int[]> soln = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.add(new Pair(nums1[i] + nums2[j], new int[]{nums1[i], nums2[j]}));
            }
        }
        
        int i = 0;
        while (i < k && pq.size() > 0) {
            soln.add(pq.poll().values);  
            i++;
        }
        
        return soln;
    }
}

class Pair implements Comparable<Pair>{
    public int sum;
    public int[] values;
    
    public Pair(int sum, int[] values) {
        this.sum = sum;
        this.values = values;
    }
    
    public int compareTo(Pair p) {
        return this.sum - p.sum;
    }
}
