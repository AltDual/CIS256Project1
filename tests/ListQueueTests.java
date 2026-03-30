import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ListQueueTests {
    @Test
    public void enqueueOneItem() {
        ListQueue<Integer> q = new ListQueue<Integer>();
        q.enqueue(1);

        assertEquals(Integer.valueOf(1), q.peek());
        assertEquals(1, q.size());
    }

    @Test
    public void enqueueMultipleItems() {
        ListQueue<Integer> q = new ListQueue<Integer>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.dequeue();

        assertEquals(Integer.valueOf(2), q.peek());
        assertEquals(2, q.size());
    }

    @Test
    public void dequeueOnOneItem() {
        ListQueue<Integer> q = new ListQueue<Integer>();
        q.enqueue(67);
        q.dequeue();
        assertEquals(true, q.isEmpty());
    }

    @Test
    public void peekAndDequeueOnAnEmptyList() {
        ListQueue<Integer> q = new ListQueue<Integer>();
        assertNull(q.peek());
        assertNull(q.dequeue());
    }
}
