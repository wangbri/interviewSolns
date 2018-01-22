public class Solution {
	public void nextPermutation(ArrayList<Integer> a) {
	    boolean isDescending = true;
	    
	    for (int i = 0; i < a.size() - 1; i++) {
	        if (a.get(i) < a.get(i + 1)) {
	            isDescending = false;
	            break;
	        }
	    }
	    
	    if (isDescending) {
	        Collections.sort(a);
	    } else {
	        for (int i = a.size() - 1; i > 0; i--) {
	            int potentialSwap = a.get(i - 1);
	            int smallestValue = a.get(i);
	            int smallestIndex = i;
	            boolean foundSwap = false;
	            
                for (int j = i; j < a.size(); j++) { // find smallest in sublist
                     //System.out.println("Checking " + potentialSwap);
                     if (a.get(j) <= smallestValue && a.get(j) > potentialSwap) {
                         //System.out.println("Found " + potentialSwap + " with " + a.get(j));
                         smallestValue = a.get(j);
                         smallestIndex = j;
                         foundSwap = true;
                     }
                }
                
                if (foundSwap) {
                    int temp = a.get(i - 1);
                    a.set(i - 1, a.get(smallestIndex));
                    a.set(smallestIndex, temp);
                    Collections.sort(a.subList(i, a.size()));
                    break;
                }
	        }
	    }
	    
	}
}

