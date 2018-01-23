public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
        ArrayList<Map<Character, Integer>> wordCounts = new ArrayList<Map<Character, Integer>>();
        boolean foundGroup = false;
        
        for (String s : A) {
            Map<Character, Integer> charCounts = new HashMap<Character, Integer>();
            
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                
                if (charCounts.containsKey(c)) {
                    charCounts.put(c, charCounts.get(c) + 1);
                } else {
                    charCounts.put(c, 1);
                }
            }
            
            wordCounts.add(charCounts);
        }
        
        ArrayList<Integer> usedIndices = new ArrayList<Integer>();
        
        for (int i = 0; i < wordCounts.size() - 1; i++) {
            ArrayList<Integer> group = new ArrayList<Integer>();
            
            if (!usedIndices.contains(i)) {
                group.add(i + 1);
            } else {
                continue;
            }
            
            for (int j = i + 1; j < wordCounts.size(); j++) {
                if (!usedIndices.contains(j)) {
                    if ((wordCounts.get(i)).equals(wordCounts.get(j))) {
                        group.add(j + 1);
                        usedIndices.add(j);
                        foundGroup = true;
                    }
                }
            }
            
            if (foundGroup) {
                usedIndices.add(i);
                foundGroup = false;
            }
            
            solution.add(group);
        }
        
        if (!usedIndices.contains(wordCounts.size() - 1)) {
            ArrayList<Integer> group = new ArrayList<Integer>();
            group.add(wordCounts.size());
            
            solution.add(group);
        }
        
        return solution;
    }
}

