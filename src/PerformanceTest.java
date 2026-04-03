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
