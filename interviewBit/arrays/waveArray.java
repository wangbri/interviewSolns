public class Solution {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        ArrayList<Integer> finalWave = new ArrayList<Integer>();
        int evenIndex = 0;
        int oddIndex = 1;
        
        if (A.size() == 1) {
            return A;
        }
        
        Collections.sort(A);
        
        if (A.size() % 2 == 0) {
            while (evenIndex < A.size()) {
                finalWave.add(A.get(oddIndex));
                finalWave.add(A.get(evenIndex));
                
                oddIndex += 2;
                evenIndex += 2;
            }
        } else {
            while (oddIndex < A.size()) {
                finalWave.add(A.get(oddIndex));
                finalWave.add(A.get(evenIndex));
                
                oddIndex += 2;
                evenIndex += 2;
            }
            
            finalWave.add(A.get(evenIndex));
        }
        
        return finalWave;
    }
}

