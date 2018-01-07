public class Solution {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>(A);
        sort(A, 0, A.size() - 1);
        
        for (int i = 0; i < B.size(); i++) {
            int nextGreatestIndex = A.indexOf(B.get(i));
            
            if (nextGreatestIndex != B.size() - 1) {
                B.set(i, A.get(nextGreatestIndex + 1));
            } else {
                B.set(i, -1);
            }
        }
        
        return B;
    }
    
    public void merge(ArrayList<Integer> A, int s, int m, int l) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        ArrayList<Integer> C = new ArrayList<Integer>();
        
        int sizeB = m - s + 1;
        int sizeC = l - m;
        
        for (int i = 0 ; i < sizeB; i++) {
            B.add(A.get(s + i));
        }
        
        for (int i = 0; i < sizeC; i++) {
            C.add(A.get(m + 1 + i));
        }
        
        int i = 0; 
        int j = 0;
        int k = s;
        
        while (i < B.size() && j < C.size()) {
            if (B.get(i) <= C.get(j)) {
                A.set(k, B.get(i));
                i++;
            } else {
                A.set(k, C.get(j));
                j++;
            }
            
            k++;
        }
        
        while (i < B.size()) {
            A.set(k, B.get(i));
            i++;
            k++;
        }
        
        while (j < C.size()) {
            A.set(k, C.get(j));
            j++;
            k++;
        }
    }
    
    public void sort(ArrayList<Integer> A, int s, int l) {
        if (s < l) {
            int mid = (s + l)/2;
            
            sort(A, s, mid);
            sort(A, mid + 1, l);
            
            merge(A, s, mid, l);
        }
    }
}

