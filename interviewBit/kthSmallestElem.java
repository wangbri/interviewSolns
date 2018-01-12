public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int kthsmallest(final List<Integer> A, int B) {
        int low = Collections.min(A);
        int high = Collections.max(A);
        
        while (low <= high) {
            int mid = low + (high - low)/2;
            int numLess = 0;
            int numEqual = 0;
            
            for (int i = 0; i < A.size(); i++) {
                if (A.get(i) < mid) {
                    numLess++;
                } else if (A.get(i) == mid) {
                    numEqual++;
                }
                
                if (numLess >= B) {
                    break;
                }
            }
            
            if (numLess < B && numLess + numEqual >= B) {
                return mid;
            } else if (numLess >= B) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return -1;
    }
}

