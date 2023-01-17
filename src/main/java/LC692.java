import java.util.*;

public class LC692 {

    public static void main(String[] args) {
        System.out.println(topKFrequentWords(new String[] {"i","love","leetcode","i","love","coding"},2));
        System.out.println(topKFrequentWords(new String[] {"the","day","is","sunny","the","the","the","sunny","is","is"},4));
    }

    //692. Top K Frequent Words
    //Medium
    //6.6K
    //310
    //Companies
    //Given an array of strings words and an integer k, return the k most frequent strings.
    //
    //Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
    //
    //
    //
    //Example 1:
    //
    //Input: words = ["i","love","leetcode","i","love","coding"], k = 2
    //Output: ["i","love"]
    //Explanation: "i" and "love" are the two most frequent words.
    //Note that "i" comes before "love" due to a lower alphabetical order.
    //Example 2:
    //
    //Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
    //Output: ["the","is","sunny","day"]
    //Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
    //
    //
    //Constraints:
    //
    //1 <= words.length <= 500
    //1 <= words[i].length <= 10
    //words[i] consists of lowercase English letters.
    //k is in the range [1, The number of unique words[i]]
    //
    //
    //Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?

    public static List<String> topKFrequentWords(String[] words, int k){
        Map<String, Integer> map = new HashMap<>();

        for(String str: words){
            map.put(str, map.getOrDefault(str,0)+1);
        }
        //O(n)

        PriorityQueue<Map.Entry<String,Integer>> heap = new PriorityQueue<>((a, b) -> {
            if((b.getValue() - a.getValue()) == (a.getValue() - b.getValue())){
                return a.getKey().compareTo(b.getKey());
            }
            return b.getValue() - a.getValue();
        });
        //O(n * log(n))

        for(Map.Entry<String,Integer> entry: map.entrySet()){
            heap.add(entry);
        }
        //O(n)

        List<String> res = new ArrayList<>();

        while(k>0){
            String str = heap.remove().getKey();
            res.add(str);
            k--;
        }
        //O(k)
        return res;
    }
}
