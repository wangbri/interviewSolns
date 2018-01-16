public class Solution {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    HashMap<Integer, Integer> numCounts = new HashMap<>();
	    
	    for (int i = 0; i < a.size(); i++) {
	        if (numCounts.containsKey(a.get(i))) {
	            return a.get(i);
	        } else {
	            numCounts.put(a.get(i), 1);
	        }
	    }
	    
	    return -1;
	}
}

