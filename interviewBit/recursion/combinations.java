public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> soln = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int[] temp = new int[B];
        
        if (A == 1 && B == 1) {
            arr.add(1);
            soln.add(arr);
            return soln;
        }
        
        for (int i = 0; i < A; i++) {
            arr.add(i + 1);
        }
        
        combineRecur(soln, arr, temp, 0, A-1, 0, B);
        return soln;
    }
    
    public void combineRecur(ArrayList<ArrayList<Integer>> soln, ArrayList<Integer> arr, int[] temp, int start, int end, int index, int B) {
        if (index == B) {
            ArrayList<Integer> temp2 = new ArrayList<Integer>();
            for (int i = 0; i < temp.length; i++) {
                temp2.add(temp[i]);
            }
            
            soln.add(temp2);
            return;
        }
        
        for (int i = start; i <= end && (end - i + 1 >= B - index); i++) {
            temp[index] = arr.get(i);
            combineRecur(soln, arr, temp, i+1, end, index+1, B);
        }
    }
}
