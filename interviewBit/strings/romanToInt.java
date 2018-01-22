public class Solution {
    public int romanToInt(String A) {
        int solution = 0;
        HashMap<Character, Integer> numerals = new HashMap<>();
        numerals.put('I', 1);
        numerals.put('V', 5);
        numerals.put('X', 10);
        numerals.put('L', 50);
        numerals.put('C', 100);
        numerals.put('D', 500);
        numerals.put('M', 1000);
        
        if (A.length() == 1) {
            return numerals.get(A.charAt(0));
        }
        
        for (int i = 0; i < A.length() - 1; i++) {
            int numeralAfter = numerals.get(A.charAt(i + 1));
            int numeralCurrent = numerals.get(A.charAt(i));
            
            if (numeralCurrent < numeralAfter) {
                solution += numeralAfter - numeralCurrent;
                i++;
                
                if (i == A.length() - 2) {
                    solution += numerals.get(A.charAt(A.length() - 1));
                }
            } else {
                solution += numeralCurrent;
                
                if (i == A.length() - 2) {
                    solution += numeralAfter;
                }
            }
        }
        
        return solution;
    }
}

