import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class BSTMapTests {
    @Test
    public void insertNew() {
        BSTMap<Integer, String> m = new BSTMap<Integer, String>();
        m.put(1, "Hi");
        assertNotNull(m.get(1));
        assertEquals("Hi", m.get(1).value);
    }

    @Test 
    public void updateValue() {
        BSTMap<Integer, String> m = new BSTMap<Integer, String>();
        m.put(1, "Hi");
        m.put(1, "World");
        assertEquals("World", m.get(1).value);
    }

    @Test
    public void searchMiss() {
        BSTMap<Integer, String> m = new BSTMap<Integer, String>();
        m.put(1, "Hi");
        assertNull(m.get(2));
    }
}
