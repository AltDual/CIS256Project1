import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SortingTests {
    @Test
    public void emptyListInsertation() {
        String[] s = {};
        String[] expected = {};
        SortingUtils.insertationSort(s);
        assertArrayEquals(s, expected);
    } 
    @Test
    public void emptyListMerge() {
        String[] s = {};
        String[] expected = {};
        SortingUtils.mergeSort(s, 0, s.length - 1);
        assertArrayEquals(s, expected);
    } 
    @Test
    public void oneItemInsertation() {
        String[] s = {"a"};
        String[] expected = {"a"};
        SortingUtils.insertationSort(s);
        assertArrayEquals(s, expected);
    } 
    @Test 
    public void oneItemMerge() {
        String[] s = {"a"};
        String[] expected = {"a"};
        SortingUtils.mergeSort(s, 0, s.length - 1);
        assertArrayEquals(s, expected);
    } 
    @Test
    public void preSortedInsertation() {
        String[] s = {"a", "b", "c"};
        String[] expected = {"a", "b", "c"};
        SortingUtils.insertationSort(s);
        assertArrayEquals(s, expected);
    } 
    @Test 
    public void preSortedMerge() {
        String[] s = {"a", "b", "c"};
        String[] expected = {"a", "b", "c"};
        SortingUtils.mergeSort(s, 0, s.length - 1);
        assertArrayEquals(s, expected);
    }
    @Test
    public void reverseInsertation() {
        String[] s = {"c", "b", "a"};
        String[] expected = {"a", "b", "c"};
        SortingUtils.insertationSort(s);
        assertArrayEquals(s, expected);
    } 
    @Test 
    public void reverseMerge() {
        String[] s = {"c", "b", "a"};
        String[] expected = {"a", "b", "c"};
        SortingUtils.mergeSort(s, 0, s.length - 1);
        assertArrayEquals(s, expected);
    }
    @Test
    public void duplicateInsertation() {
        String[] s = {"a","c","c", "b", "a"};
        String[] expected = {"a", "a", "b", "c", "c"};
        SortingUtils.insertationSort(s);
        assertArrayEquals(s, expected);
    } 
    @Test 
    public void duplicateMerge() {
        String[] s = {"a", "c", "c", "b", "a"};
        String[] expected = {"a", "a", "b", "c", "c"};
        SortingUtils.mergeSort(s, 0, s.length - 1);
        assertArrayEquals(s, expected);
    }
}
