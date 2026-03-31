import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SearchingTests {
   @Test
   public void linearSearch() {
        String[] s = {"c", "a", "b"};
        assertEquals(1,SearchingUtils.linearSearch(s, "a"));
   }

   @Test
   public void binarySearch() {
        String[] s = {"a", "b", "c", "d","f"};
        assertEquals(1, SearchingUtils.binarySearch(s, "b"));
   }

   @Test
   public void binarySearchMiss() {
        String[] s = {"a", "b", "c", "d", "f"};
        assertEquals(-1, SearchingUtils.binarySearch(s, "z"));
   }
}
