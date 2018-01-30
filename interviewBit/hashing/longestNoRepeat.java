public class Solution {
    public int lengthOfLongestSubstring(String A) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        int length = 0;
        int longest = 0;
        int longestIndex = 0; // start with substring beginning at 0
        int i = 0;
        
        if (A.length() == 1) {
            return 1;
        }
        
        while (i < A.length()) {
            char current = A.charAt(i);
            
            if (charCount.containsKey(current)) { //
                if (length > longest) {
                    longest = length;
                    longestIndex = i;
                }
                
                charCount.put(current, 2);
                char temp = A.charAt(--i);
                while (charCount.get(temp) != 2) {
                    temp = A.charAt(--i);
                }
                
                //System.out.println("Restarting at " + A.charAt(i+1));         
                i++;
                length = 1;
                charCount.clear();
                charCount.put(A.charAt(i), 1);
            } else {
                charCount.put(current, 1);
                length++;
                
                //System.out.println("Placing " + current);
            }
            
            i++;
        }
        
        if (length > longest) {
            longest = length;
        }
        
        //System.out.println("Longest " + longest + " @ " + longestIndex);
        
        return longest;
    }
}

