import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Tokenizer {
  // TODO: Construtor with filestream in, and a method to create a linked list of
  // the words
  private final String fileName;

  public Tokenizer(String fileName) {
    this.fileName = fileName;
  }

  public LinkedList<String> tokenize() {
    LinkedList<String> stringList = new LinkedList<String>();
    File f = new File(fileName);
    try (Scanner scnr = new Scanner(f)) {
      while (scnr.hasNext()) {
        String s = scnr.next();
        stringList.append(s);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return stringList;
  }
}
