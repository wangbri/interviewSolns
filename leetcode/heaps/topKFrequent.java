class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if (words.length == 0) {
            return new ArrayList<String>();
        }
        
        List<String> soln = new ArrayList<>();
        HashMap<String, Integer> counts = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for (int i = 0; i < words.length; i++) {
            if (counts.containsKey(words[i])) {
                counts.put(words[i], counts.get(words[i]) + 1);
            } else {
                counts.put(words[i], 1);
            }
        }
        
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        
        int i = 0;
        while (i < k && pq.size() > 0) {
            soln.add(pq.poll().word);
            i++;
        }
        
        return soln;
    }
}

class Pair implements Comparable<Pair> {
    public String word;
    public int count;
    
    public Pair(String word, int count) {
        this.word = word;
        this.count = count;
    }
    
    // reverse compareTo since PriorityQueue is minHeap and want maxHeap
    public int compareTo(Pair p) {
        if (p.count - this.count == 0) { // if same use alphabetical
            return this.word.compareTo(p.word);
        } else {
            return p.count - this.count;
        }
    }
}
