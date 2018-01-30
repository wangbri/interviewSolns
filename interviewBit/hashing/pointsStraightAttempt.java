import javafx.util.*;

public class Solution {
	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
	    HashMap<Pair<Integer, Integer>, Integer> mapSlopes = new HashMap<>();
	    
	    int overlap = 0;
	    int vertical = 0;
	    int horizontal = 0;
	    int maximum = 0;
	    int maxPoint = 0;
	    
	    if (a.size() == 1) {
	        return 1;
	    } else if (a.size() == 2) {
	        return 2;
	    }
	    
	    for (int i = 0; i < a.size(); i++) {
	        maximum = 0;
	        overlap = 0;
	        vertical = 0;
	        horizontal = 0;
	        
	        for (int j = i + 1; j < a.size(); j++) {
	            if (isEqual(a, b, i, j)) { // both points are overlapping
	                overlap++;
	            } else if (b.get(i) == b.get(j)) {
	                horizontal++;
	            } else if (a.get(i) == a.get(j)) {
	                vertical++;
	            } else {
	                int yDiff = b.get(j) - b.get(i);
	                int xDiff = a.get(j) - a.get(i);
	                int tempX = xDiff;
	                int tempY = yDiff;
	                
	                if (xDiff < 0) {
	                    tempX = -1*xDiff;
	                }
	                
	                if (yDiff < 0) {
	                    tempY = -1*yDiff;
	                }
	                
	                if (xDiff < 0 && yDiff < 0) {
	                    xDiff = -1*xDiff;
	                    yDiff = -1*yDiff;
	                }
	                
	                int g = gcd(tempX, tempY);
	                
	                if (g != 0) {
    	                yDiff = yDiff/g;
    	                xDiff = xDiff/g;
	                }
	                
	                Pair<Integer, Integer> p = new Pair(yDiff, xDiff);
	                
	                if (mapSlopes.containsKey(p)) {
	                    mapSlopes.put(p, mapSlopes.get(p) + 1);
	                } else {
	                    mapSlopes.put(p, 1);
	                }
	                
	                maximum = Math.max(maximum, mapSlopes.get(p));
	            }
	            
	            maximum = Math.max(maximum, Math.max(vertical, horizontal));
	        }
	    
	        maxPoint = Math.max(maxPoint, maximum + overlap + 1);
	        mapSlopes.clear();
	    }
	    
	    return maxPoint;
	}
	
	public boolean isEqual(ArrayList<Integer> a, ArrayList<Integer> b, int i, int j) {
	    if ((a.get(i) == a.get(j)) && (b.get(i) == b.get(j))) {
	        return true;
	    }
	    
	    return false;
	}
	
	public int gcd(int a, int b) {
	    if (a == 0 || b == 0) {
	        return 0;
	    }
	    
	    if (a == b) {
	        return a;
	    }
	    
	    if (a > b) {
	        return gcd(a-b, b);
	    }
	    
	    return gcd(a, b-a);
	}
}

