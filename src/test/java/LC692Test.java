import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LC692Test {

    @org.junit.Test
    public void topKFrequentWords() {

        List<String> actual1 = LC692.topKFrequentWords(new String[] {"i","love","leetcode","i","love","coding"},2);
        List<String> actual2 = LC692.topKFrequentWords(new String[] {"the","day","is","sunny","the","the","the","sunny","is","is"},4);

        List<String> expected1 = new ArrayList<>();
        expected1.add("i");
        expected1.add("love");

        List<String> expected2 = new ArrayList<>();
        expected2.add("the");
        expected2.add("is");
        expected2.add("sunny");
        expected2.add("day");

        assertEquals(actual1,expected1);
        assertEquals(actual2,expected2);
    }
}