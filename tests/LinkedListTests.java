import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class LinkedListTests {
    @Test
    public void appendOnEmptyList() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.append(1);

        assertNotNull(l.head);
        assertEquals(Integer.valueOf(1), l.head.data);
        assertEquals(l.head, l.tail);
        assertEquals(1, l.size());
    }
    
    @Test
    public void prependOnEmptyList() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.prepend(1);

        assertNotNull(l.head);
        assertEquals(Integer.valueOf(1), l.head.data);
        assertEquals(l.head, l.tail);
        assertEquals(1, l.size());
    }
}
