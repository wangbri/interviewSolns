public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> soln = new ArrayList<ArrayList<Integer>>();
        permute(soln, A, 0, A.size() - 1);
        
        return soln;
    }
    
    public void permute(ArrayList<ArrayList<Integer>> soln, ArrayList<Integer> A, int l, int r) {
        int i;
        
        if (l == r) {
            soln.add(new ArrayList<Integer>(A));
        } else {
            for (i = l; i <= r; i++) {
                swap(A, l, i);
                permute(soln, A, l+1, r);
                swap(A, l, i);
            }
        }
    }
    
    public void swap(ArrayList<Integer> A, int pos1, int pos2) {
        int temp = A.get(pos1);
        A.set(pos1, A.get(pos2));
        A.set(pos2, temp);
    }
}

