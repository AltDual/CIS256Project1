import java.util.*;

public class PerformanceTest {
  public static void main(String[] args) {
    System.out.println("Testing sorting algorithms");
    String[] words = generateWords(50000);
    String[] words1 = words.clone();
    System.out.println("Generated " + words.length + " unique words.");
    testMergeSort(words);
    testInsertationSort(words1);

    System.out.println("Testing searching algorithms");
    words = generateWords(50000);
    Random rand = new Random();
    int randomIndex = rand.nextInt(words.length);
    String target = words[randomIndex];
    int i = testLinearSearch(words, target);
    if (i != -1 && words[i].equals(target)) {
      System.out.println("Linear Search Passed!");
    }
    Arrays.sort(words);
    int j = testBinarySearch(words, target);
    if (j != -1 && words[i].equals(target)) {
      System.out.println("Binary Search Passed!");
    }

    System.out.println("Testing search between BST, HashMap, AVL, and RBT");
    Tokenizer t = new Tokenizer("documents/long_sorted.txt");
    LinkedList<String> l = t.tokenize();
    LinkedListNode<String> current = l.head;
    AVLMap<String, Integer> a = new AVLMap<String, Integer>();
    RBTMap<String, Integer> r = new RBTMap<String, Integer>();
    HashMap<String, String> h = new HashMap<String, String>();
    BSTMap<String, Integer> b = new BSTMap<String, Integer>();
    while (current != null) {
      a.put(current.data, 1);
      r.put(current.data, 1);
      h.insert(current.data, current.data);
      b.put(current.data, 1);
      current = current.next;
    }
    testAVLSearch(a, "watermelon");
    testBSTSearch(b, "watermelon");
    testHashMapSearch(h, "watermelon");
    testRBTSearch(r, "watermelon");
  }

  public static void testAVLSearch(AVLMap<String, Integer> a, String target) {
    long startTime = System.nanoTime();
    AVLNode<String, Integer> node = a.get(target);
    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    System.out.println("Time for AVLTree to search:" + duration);
    if (node.key.equals(target)) {
      System.out.println("AVL pass");
    }
  }

  public static void testRBTSearch(RBTMap<String, Integer> r, String target) {
    long startTime = System.nanoTime();
    RBTNode<String, Integer> node = r.search(target);
    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    System.out.println("Time for RBTTree to search:" + duration);
    if (node.key.equals(target)) {
      System.out.println("RBT pass");
    }
  }

  public static void testHashMapSearch(HashMap<String, String> h, String target) {
    long startTime = System.nanoTime();
    String node = h.search(target);
    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    System.out.println("Time for HashMap to search:" + duration);
    if (node.equals(target)) {
      System.out.println("HashMap pass");
    }
  }

  public static void testBSTSearch(BSTMap<String, Integer> b, String target) {
    long startTime = System.nanoTime();
    BSTMapNode<String, Integer> node = b.get(target);
    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    System.out.println("Time for BSTMap to search:" + duration);
    if (node.key.equals(target)) {
      System.out.println("BSTMap pass");
    }
  }

  public static int testBinarySearch(String[] words, String target) {
    long startTime = System.nanoTime();
    int index = SearchingUtils.binarySearch(words, target);
    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    System.out.println("Time for binarySearch to search:" + duration);
    return index;
  }

  public static int testLinearSearch(String[] words, String target) {
    long startTime = System.nanoTime();
    int index = SearchingUtils.linearSearch(words, target);
    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    System.out.println("Time for linearSearch to search:" + duration);
    return index;
  }

  public static void testMergeSort(String[] words) {
    long startTime = System.nanoTime();
    SortingUtils.mergeSort(words, 0, words.length - 1);
    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    System.out.println("Time for mergeSort to sort " + words.length + " words: " + duration);
  }

  public static void testInsertationSort(String[] words) {
    long startTime = System.nanoTime();
    SortingUtils.insertationSort(words);
    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    System.out.println("Time for insertationSort to sort " + words.length + " words: " + duration);
  }

  public static String[] generateWords(int target) {
    Set<String> uniqueSet = new HashSet<>();
    Random random = new Random();
    String alphabet = "abcdefghijklmnopqrstuvwxyz";

    while (uniqueSet.size() < target) {
      StringBuilder sb = new StringBuilder();
      int length = 5 + random.nextInt(6);
      for (int i = 0; i < length; i++) {
        sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
      }
      uniqueSet.add(sb.toString());
    }

    return uniqueSet.toArray(new String[0]);
  }
}
