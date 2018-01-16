public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        int lastWordLength = 0;
        int wordLength = 0;
        boolean isWord = true;
        
        for (int i = 0; i < A.length(); i++) {
            char curChar = A.charAt(i);
            
            if (curChar != ' ' && (curChar <= 'z' && curChar >= 'a') || (curChar <= 'Z' && curChar >= 'A')) {
                wordLength += 1;
                isWord = true;
                lastWordLength = wordLength;
            } else {
                wordLength = 0;
                isWord = false;
            }
        }
        
        if (isWord) {
            return wordLength;
        } else {
            return lastWordLength;
        }
    }
}

