import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Tokenizer {
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
        s = s.replaceAll("\\p{Punct}", "");
        s = s.toLowerCase();
        stringList.append(s);
      }
    } catch (FileNotFoundException e) {
      System.err.println("File not found " + fileName);
    }
    return stringList;
  }
}
