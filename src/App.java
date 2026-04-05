import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;

public class App {
  public static void main(String[] args) {
    System.out.println("Program Initialized");
    HashMap<String, HashSet<String>> documents = new HashMap<String, HashSet<String>>();
    processDocuments(documents);
    Scanner scnr = new Scanner(System.in);
    while (true) {
      System.out.println("Press Q to query words, D to search through docmuents, and E to exit");
      if (scnr.nextLine().equalsIgnoreCase("q")) {
        System.out.println("What word do you want to search for: ");
        queryDocuments(documents, scnr);
      } else if (scnr.nextLine().equalsIgnoreCase("d")) {
        ArrayStack<String> forwardHistory = new ArrayStack<String>();
        ArrayStack<String> backwardHistory = new ArrayStack<String>();
        String currentFile = null;
        while (true) {
          System.out.println("Type S to look at a document, F to go foward in history, B to go back in history, and E to exit");
          if (scnr.nextLine().equalsIgnoreCase("e")) {
            break;
          }

          if ((scnr.nextLine().equalsIgnoreCase("s"))) {
            System.out.println("Type in the document you want to search for: ");
            String nextFile = scnr.nextLine();

            if (currentFile != null) {
              backwardHistory.push(currentFile);
            }
            for (int i = 0; i < forwardHistory.getLength(); i++) {
              forwardHistory.pop();
            }
              
            Tokenizer t = new Tokenizer("documents/" + currentFile);
            LinkedList<String> l = t.tokenize();
            l.print();
          } else if (scnr.nextLine().equalsIgnoreCase("b")) {
            if (backwardHistory.getLength() == 0) {
              System.out.println("No backward history");
            } else {
              forwardHistory.push(currentFile);
              currentFile = backwardHistory.pop();
              Tokenizer t = new Tokenizer("documents/" + currentFile);
              LinkedList<String> l = t.tokenize();
              l.print();
            }
          } else if (scnr.nextLine().equalsIgnoreCase("F")) {
            if (forwardHistory.getLength() == 0) {
              System.out.println("No forward history");
            } else {
              backwardHistory.push(currentFile);
              currentFile = forwardHistory.pop();
              Tokenizer t = new Tokenizer("documents/" + currentFile);
              LinkedList<String> l = t.tokenize();
              l.print();
            }
          } 
        }
      } else if (scnr.nextLine().equalsIgnoreCase("e")) {
        break;
      } else {
        continue;
      }
    }
  }
  
  public static void queryDocuments(HashMap<String, HashSet<String>> documents, Scanner scnr) {
    ArrayList<String> strings = new ArrayList<String>();
    String s = scnr.nextLine();
    Scanner stringScnr = new Scanner(s);
    while (stringScnr.hasNext()) {
      strings.add(stringScnr.next().toLowerCase());
    }
    if (documents.search(strings.get(0)) != null) {
      HashSet<String> docsToReturn = new HashSet<String>(documents.search(strings.get(0)));
      for (int i = 1; i < strings.size(); i++) {
        HashSet<String> set = new HashSet<String>(documents.search(strings.get(i)));
        docsToReturn.retainAll(set);
      }
      System.out.println(docsToReturn);
    } else {
      System.out.println("[]");
    }
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
