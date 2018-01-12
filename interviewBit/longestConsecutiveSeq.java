public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestConsecutive(final List<Integer> A) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int longestLength = 1;
        
        for (int i = 0; i < A.size(); i++) {
            hs.add(A.get(i));
        }
        
        for (Integer i: hs) {
            if (!hs.contains(i - 1)) {
                int nextElem = i + 1;
                int length = 1;
                
                while (hs.contains(nextElem)) {
                    length++;
                    nextElem++;
                }
                
                if (length > longestLength) {
                    longestLength = length;
                }
            }
        }
        
        return longestLength;
    }
}

