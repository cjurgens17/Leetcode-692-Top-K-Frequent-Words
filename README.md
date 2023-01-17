# Leetcode-692-Top-K-Frequent-Words
Solution/test case for Leetcode 692

Intuition:

Need a way to find key + value frequencies, and then be able to pull k highest frequencies and return in lexiographical order. Max Heap comes to mind.

Approach
1. Map all frequenices into a hashmap
2. Set up our maxHeap to sort descending, and for edge cases of lexiographical order, we need to sort those as well
3. Iterate HashMap EntrySet and start adding to our maxHeap
4. Finally we take top k roots from heap and add them to our final list of strings


Time complexity:
O(n* logn)

Space complexity:
O(n)

Code
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        //Storing our frequencies
        for(String str: words){
            map.put(str, map.getOrDefault(str,0)+1);
        }
        //O(n)
        //Setting up our maxHeap
        //Sort based on freq descending
        //if we end up with same freq, the if statement sorts based on
        //String lexiograpical order

        PriorityQueue<Map.Entry<String,Integer>> heap = new PriorityQueue<>((a,b) -> {
            if((b.getValue() - a.getValue()) == (a.getValue() - b.getValue())){
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue() - a.getValue();
        });
        //O(n * log(n))

        //Fill up maxHeap
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            heap.add(entry);
        }
        //O(n)

        List<String> res = new ArrayList<>();

        //Grab max roots from heap
        while(k>0){
            String str = heap.remove().getKey();
           res.add(str);
            k--;
        }
        //O(+k)
        return res;
    }
}
