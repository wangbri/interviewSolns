public class Solution {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        int size = (A - 1)*2 + 1;
        ArrayList<ArrayList<Integer>> concRect = new ArrayList<ArrayList<Integer>>();
        int curCount = A;
        int baseCount = A;
        
        for (int i = 0; i < size/2 + 1; i++) {
            ArrayList<Integer> innerRect = new ArrayList<Integer>();
            
            for (int j = 0; j < size/2 + 1; j++) {
                if (curCount > baseCount) {
                    innerRect.add(curCount);
                    curCount--;
                } else {
                    innerRect.add(curCount);
                }
            }
            
            ArrayList<Integer> innerRectCopy = new ArrayList<Integer>(innerRect);
            Collections.reverse(innerRectCopy);
            innerRectCopy.remove(0);
            
            innerRect.addAll(innerRectCopy);
            
            curCount = A;
            baseCount--;
            
            concRect.add(innerRect);
        }
		        
        ArrayList<ArrayList<Integer>> concRectCopy = new ArrayList<ArrayList<Integer>>(concRect);
        Collections.reverse(concRectCopy);
        concRectCopy.remove(0);
        
        concRect.addAll(concRectCopy);
       
        return concRect;
    }
}

