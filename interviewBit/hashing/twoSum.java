public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        ArrayList<Integer> solution = new ArrayList<Integer>();
        int smallestIndex2 = A.size() - 1;
        int smallestIndex1 = A.size() - 1;
        boolean containsPair = false;
        
        for (int i = 0; i < A.size(); i++) {
            if (hm.containsKey(A.get(i))) {
                List<Integer> entry = hm.get(A.get(i));
                entry.add(i);
                hm.put(A.get(i), entry);
            } else {
                List<Integer> entry = new ArrayList<>();
                entry.add(i);
                hm.put(A.get(i), entry);
            }
        }
        
        for (Map.Entry<Integer, List<Integer>> entry : hm.entrySet()) {
            int number = entry.getKey();
            List<Integer> list = entry.getValue();
            int desiredNum = B - number;
     
            if (hm.containsKey(desiredNum)) {
                List<Integer> desiredList = hm.get(desiredNum);
                Collections.sort(desiredList); // grab minimum indices
                Collections.sort(list);
                
                int desIndex = desiredList.get(0);
                int listIndex = list.get(0);
                
                if (list.size() == 1 && number*2 == B) {
                    continue;
                } else {
                    if (desIndex == listIndex) { // if both refer to the same index
                        desIndex = desiredList.get(1);
                    }
                }
                
                if (desIndex > listIndex) {
                    if (desIndex < smallestIndex2) {
                        smallestIndex2 = desIndex;
                        smallestIndex1 = listIndex;
                    } else if (desIndex == smallestIndex2) {
                        if (listIndex < smallestIndex1) {
                            smallestIndex1 = listIndex;
                            smallestIndex2 = desIndex;
                        }
                    }
                } else {
                    if (listIndex < smallestIndex2) {
                        smallestIndex2 = listIndex;
                        smallestIndex1 = desIndex;
                    } else if (listIndex == smallestIndex2) {
                        if (desIndex < smallestIndex1) {
                            smallestIndex1 = desIndex;
                            smallestIndex2 = listIndex;
                        }
                    }
                }
                
                containsPair = true;
            }
        }
        
        if (containsPair) {
            solution.add(smallestIndex1 + 1);
            solution.add(smallestIndex2 + 1);
        }
        
        return solution;
    }
}

