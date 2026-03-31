import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TokenizerTests {
   @Test
   public void doc1() {
        // Might need to adjust this path the file structure on this machine is a little weird
        String path = System.getProperty("user.dir") + "/CIS256Project1/documents/doc1.txt";
        Tokenizer t = new Tokenizer(path);
        LinkedList<String> l = t.tokenize();
        l.print();
        LinkedListNode<String> current = l.head;
        assertEquals("the", current.data);
        current = current.next;
        assertEquals("quick", current.data); 
        current = current.next;
        assertEquals("brown", current.data); 
        current = current.next;
        assertEquals("fox", current.data); 
   }
   
   @Test
   public void doc2() {
        // Might need to adjust this path the file structure on this machine is a little weird
        String path = System.getProperty("user.dir") + "/CIS256Project1/documents/doc2.txt";
        Tokenizer t = new Tokenizer(path);
        LinkedList<String> l = t.tokenize();
        l.print();
        LinkedListNode<String> current = l.head;
        assertEquals("the", current.data);
        current = current.next;
        assertEquals("quick", current.data); 
        current = current.next;
        assertEquals("dog", current.data); 
        current = current.next;
        assertEquals("and", current.data); 
        current = current.next;
        assertEquals("the", current.data); 
        current = current.next;
        assertEquals("lazy", current.data); 
        current = current.next;
        assertEquals("fox", current.data); 
   }
   
   @Test
   public void doc3() {
        // Might need to adjust this path the file structure on this machine is a little weird
        String path = System.getProperty("user.dir") + "/CIS256Project1/documents/doc3.txt";
        Tokenizer t = new Tokenizer(path);
        LinkedList<String> l = t.tokenize();
        l.print();
        LinkedListNode<String> current = l.head;
        assertEquals("a", current.data);
        current = current.next;
        assertEquals("fast", current.data); 
        current = current.next;
        assertEquals("c", current.data); 
        current = current.next;
        assertEquals("program", current.data); 
        current = current.next;
        assertEquals("is", current.data); 
        current = current.next;
        assertEquals("a", current.data); 
        current = current.next;
        assertEquals("good", current.data); 
        current = current.next;
        assertEquals("c", current.data); 
        current = current.next;
        assertEquals("program", current.data); 
   }
   @Test
   public void doc4() {
        // Might need to adjust this path the file structure on this machine is a little weird
        String path = System.getProperty("user.dir") + "/CIS256Project1/documents/doc4.txt";
        Tokenizer t = new Tokenizer(path);
        LinkedList<String> l = t.tokenize();
        l.print();
        LinkedListNode<String> current = l.head;
        assertEquals("hello", current.data);
        current = current.next;
        assertEquals("world", current.data); 
        current = current.next;
        assertEquals("hello", current.data); 
        current = current.next;
        assertEquals("world", current.data); 
   }
   @Test
   public void empty() {
        // Might need to adjust this path the file structure on this machine is a little weird
        String path = System.getProperty("user.dir") + "/CIS256Project1/documents/empty.txt";
        Tokenizer t = new Tokenizer(path);
        LinkedList<String> l = t.tokenize();
        l.print();
        assertNull(l.head);
   }
   
}
