public class Solution {
    public int isPalindrome(String A) {
        String input = A.toUpperCase();
        int forwardIndex = 0;
        int reverseIndex = input.length() - 1;
        
        while (forwardIndex < input.length()) {
            while (forwardIndex < input.length() && !Character.isLetter(input.charAt(forwardIndex)) && !Character.isDigit(input.charAt(forwardIndex))) {
                forwardIndex++;
            }
            
            while (reverseIndex >= 0 && !Character.isLetter(input.charAt(reverseIndex)) && !Character.isDigit(input.charAt(reverseIndex))) {
                reverseIndex--;
            }
            
            if (forwardIndex < input.length() && reverseIndex >= 0 && input.charAt(forwardIndex) != input.charAt(reverseIndex)) {
                return 0;
            }
            
            forwardIndex++;
            reverseIndex--;
        }
        
        
        
        return 1;
    }
}

