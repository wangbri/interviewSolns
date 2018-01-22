public class Solution {
    public String convert(String A, int B) {
        StringBuilder solution = new StringBuilder();
        int curIndex = 0;
        int curRow = 0;
        
        if (B == 1) {
            return A;
        }
            
        for (int i = 0; i < B; i++) { // iterate through each row
            curIndex = i;
            curRow = i;
            
            if (curRow == 0 || curRow == B - 1) { // if top or bottom
                int skipCount = (B - 2) * 2 + 2;
                
                while (curIndex < A.length()) {
                    solution.append(A.charAt(curIndex));
                    curIndex += skipCount;
                }
            } else {
                int skipCountBot = ((B - 1) - (curRow + 1)) * 2 + 2; 
                int skipCountTop = (curRow - 1) * 2 + 2;
                boolean flag = true;
                
                while (curIndex < A.length()) {
                    solution.append(A.charAt(curIndex));
                    
                    if (flag) {
                        curIndex += skipCountBot;
                        flag = false;
                    } else {
                        curIndex += skipCountTop;
                        flag = true;
                    }
                }
            }
        }
        
        return solution.toString();
    }
}

