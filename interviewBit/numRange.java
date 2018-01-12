public class Solution {
    public int numRange(ArrayList<Integer> A, int B, int C) {
        int seqCount = 0;
        int sum = 0;
        int startElem = 0;
        
        for (int i = 0; i < A.size(); i++) {
            startElem = A.get(i);
            
            if (startElem < B || (startElem >= B && startElem <= C)) { // possible subsequence
                sum = startElem;
                
                if (startElem >= B && startElem <= C) {
                    seqCount++;
                }
                
                if (i != A.size() - 1) { // if element is not last in array
                    for (int j = i + 1; j < A.size(); j++) {
                        sum += A.get(j);
                        
                        if (sum >= B && sum <= C) { // if subsequence sum is within range
                            seqCount++;
                        } else if (sum > C) { // if subsequence sum exceeds range
                            break;
                        }
                    }
                }
                
                sum = 0;
            }
        }
        
        return seqCount;
    }
}

