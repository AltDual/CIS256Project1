import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    HashMap<String, ArrayList<String>> documents = new HashMap<String, ArrayList<String>>();
    processDocuments(documents);
  }

  // Change filepath accordingly for your setup
  public static void processDocuments(HashMap<String, ArrayList<String>> map) {
    Tokenizer t = new Tokenizer("documents/doc1.txt");
    LinkedList<String> l = t.tokenize();
    LinkedListNode<String> current = l.head;
    while (current != null) {
      ArrayList<String> s = new ArrayList<String>();
      s.add("doc1.txt");
      map.insert(current.data, s);
      current = current.next;
    }
    t = new Tokenizer("documents/doc2.txt");
    l = t.tokenize();
    current = l.head;
    while (current != null) {
      if (map.search(current.data) != null) {
        map.search(current.data).add("doc2.txt");
      } else {
        ArrayList<String> s = new ArrayList<String>();
        s.add("doc2.txt");
        map.insert(current.data, s);
      }
    }
    t = new Tokenizer("documents/doc3.txt");
    l = t.tokenize();
    current = l.head;
    while (current != null) {
      if (map.search(current.data) != null) {
        map.search(current.data).add("doc3.txt");
      } else {
        ArrayList<String> s = new ArrayList<String>();
        s.add("doc3.txt");
        map.insert(current.data, s);
      }
    }
    t = new Tokenizer("documents/doc4.txt");
    l = t.tokenize();
    current = l.head;
    while (current != null) {
      if (map.search(current.data) != null) {
        map.search(current.data).add("doc4.txt");
      } else {
        ArrayList<String> s = new ArrayList<String>();
        s.add("doc4.txt");
        map.insert(current.data, s);
      }
    }
  }
}
