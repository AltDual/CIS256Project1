import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

    @Test
    public void insertationOnList() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.prepend(1);

        l.prepend(2);
        assertEquals(Integer.valueOf(2), l.head.data);
        assertEquals(Integer.valueOf(1), l.tail.data);

        l.append(3);
        assertEquals(Integer.valueOf(3), l.tail.data);
        
        l.insertAfter(1, 4);

        LinkedListNode<Integer> node = l.search(4);

        assertNotNull(node);
        assertEquals(Integer.valueOf(3), node.next.data);
    }

    @Test
    public void removeOnAListWithOneItem() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.append(67);

        l.removeNode(67);
        assertNull(l.head);
        assertNull(l.tail);
    }

    @Test
    public void removeOnAnEmptyList() {
        LinkedList<Integer> l = new LinkedList<Integer>();

        assertEquals(false, l.removeNode(67));
    }

    @Test
    public void removalOnList() {
        LinkedList<Integer> l = new LinkedList<Integer>();

        l.append(1);
        l.append(2);
        l.append(3);
        l.append(4);
        l.append(5);

        l.removeNode(1);
        assertEquals(Integer.valueOf(2), l.head.data);

        l.removeNode(5);
        assertEquals(Integer.valueOf(4), l.tail.data);
        l.removeNodeAfter(l.head);
        
        assertNull(l.search(3));
    }

    @Test
    public void testListSize() {
        LinkedList<Integer> l = new LinkedList<Integer>();

        l.append(1);
        l.append(2);
        l.append(3);
        assertEquals(3, l.size());
        l.removeNode(2);
        assertEquals(2, l.size());
        l.append(4);
        l.append(5);
        assertEquals(4, l.size());
        l.removeNode(1);
        assertEquals(3, l.size());
    }
}
