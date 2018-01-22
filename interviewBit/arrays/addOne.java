public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        boolean carryOne = true;
        boolean allNines = true;
        
        for (int i = A.size() - 1; i >= 0; i--) {
            if (carryOne) {
                if (A.get(i) != 9) { // check corner case
                    allNines = false;
                }
                
                if (A.get(i) + 1 > 9) {
                    A.set(i, 0);
                    carryOne = true;
                } else {
                    A.set(i, A.get(i) + 1);
                    carryOne = false;
                }
            }
        }
        
        if (allNines) {
            A.add(0);
            A.set(0, 1);
        }
        
        while (A.get(0) == 0) {
            A.remove(0);
        }
        
        return A;
    }
}

