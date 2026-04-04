import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

public class App {
  public static void main(String[] args) {
    System.out.println("Program Initialized");
    HashMap<String, HashSet<String>> documents = new HashMap<String, HashSet<String>>();
    processDocuments(documents);
    while (true) {
      System.out.println("What word do you want to search for: ");
      queryDocuments(documents);
    }
  }

  public static void queryDocuments(HashMap<String, HashSet<String>> documents) {
    Scanner scnr = new Scanner(System.in);
    ArrayList<String> strings = new ArrayList<String>();
    String s = scnr.nextLine();
    Scanner stringScnr = new Scanner(s);
    while (stringScnr.hasNext()) {
      strings.add(stringScnr.next());
    }
    HashSet<String> docsToReturn = new HashSet<String>();
    for (int i = 0; i < strings.size(); i++) {
      HashSet<String> set = new HashSet<String>(documents.search(strings.get(i)));
      docsToReturn.retainAll(set);
    }
    System.out.println(docsToReturn);
    scnr.close();
    stringScnr.close();
  }

  // Change filepath accordingly for your setup
  public static void processDocuments(HashMap<String, HashSet<String>> map) {
    Tokenizer t = new Tokenizer("documents/doc1.txt");
    LinkedList<String> l = t.tokenize();
    LinkedListNode<String> current = l.head;
    while (current != null) {
      HashSet<String> s = new HashSet<String>();
      s.add("doc1.txt");
      map.insert(current.data, s);
      current = current.next;
    }
    System.out.println("Finished doc1");
    t = new Tokenizer("documents/doc2.txt");
    l = t.tokenize();
    current = l.head;
    while (current != null) {
      if (map.search(current.data) != null) {
        map.search(current.data).add("doc2.txt");
      } else {
        HashSet<String> s = new HashSet<String>();
        s.add("doc2.txt");
        map.insert(current.data, s);
      }
      current = current.next;
    }
    System.out.println("Finished doc2");
    t = new Tokenizer("documents/doc3.txt");
    l = t.tokenize();
    current = l.head;
    while (current != null) {
      if (map.search(current.data) != null) {
        map.search(current.data).add("doc3.txt");
      } else {
        HashSet<String> s = new HashSet<String>();
        s.add("doc3.txt");
        map.insert(current.data, s);
      }
      current = current.next;
    }
    System.out.println("Finished doc3");
    t = new Tokenizer("documents/doc4.txt");
    l = t.tokenize();
    current = l.head;
    while (current != null) {
      if (map.search(current.data) != null) {
        map.search(current.data).add("doc4.txt");
      } else {
        HashSet<String> s = new HashSet<String>();
        s.add("doc4.txt");
        map.insert(current.data, s);
      }
      current = current.next;
    }
    System.out.println("Finished doc4");
  }
}
