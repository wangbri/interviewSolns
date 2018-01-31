public class Solution {
	public int searchInsert(ArrayList<Integer> a, int b) {
	    int start = 0;
	    int end = a.size() - 1;
	    int soln = a.size();
	    
	    while (start <= end) {
	        int mid = (start + end)/2;
	        
	        if (a.get(mid) == b) {
	            return mid;
	        }
	        
	        if (a.get(mid) > b) {
	            end = mid - 1;
	            soln = mid;
	        } else {
	            start = mid + 1;
	        }
	    }
	    
	    return soln;
	}
}

