import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class HashMapTests {
    @Test
    public void insertNew() {
        HashMap<Integer, String> m = new HashMap<Integer, String>();
        m.insert(1, "Hi");
        assertNotNull(m.search(1));
        assertEquals("Hi", m.search(1));
    }

    @Test 
    public void updateValue() {
        HashMap<Integer, String> m = new HashMap<Integer, String>();
        m.insert(1, "Hi");
        m.insert(1, "World");
        assertEquals("World", m.search(1));
    }

    @Test
    public void searchMiss() {
        HashMap<Integer, String> m = new HashMap<Integer, String>();
        m.insert(1, "Hi");
        assertNull(m.search(2));
    }
}
