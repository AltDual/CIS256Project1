import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ArrayStackTests {
    @Test
    public void pushOneItem() {
        ArrayStack<Integer> s = new ArrayStack<Integer>();
        s.push(1);
        assertEquals(Integer.valueOf(1), s.peek());
        assertEquals(1, s.getLength());
    }

    @Test
    public void pushAndPop() {
        ArrayStack<Integer> s = new ArrayStack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);

        s.pop();
        assertEquals(Integer.valueOf(2), s.peek());
        assertEquals(2, s.getLength());
    }

    @Test
    public void popOneItem() {
        ArrayStack<Integer> s = new ArrayStack<Integer>();
        s.push(1);

        s.pop();
        assertEquals(0, s.getLength());
    }

    @Test
    public void pushAndPeekOnEmptyStack() {
        ArrayStack<Integer> s = new ArrayStack<Integer>();
        assertNull(s.pop());
        assertNull(s.peek());
    }
}
