import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class RBTMapTests {
    @Test
    public void insertNew() {
        RBTMap<Integer, String> m = new RBTMap<Integer, String>();
        m.put(1, "Hi");
        assertNotNull(m.search(1));
        assertEquals("Hi", m.search(1).value);
    }

    @Test 
    public void updateValue() {
        RBTMap<Integer, String> m = new RBTMap<Integer, String>();
        m.put(1, "Hi");
        m.put(1, "World");
        assertEquals("World", m.search(1).value);
    }

    @Test
    public void searchMiss() {
        RBTMap<Integer, String> m = new RBTMap<Integer, String>();
        m.put(1, "Hi");
        assertNull(m.search(2));
    } 
}
