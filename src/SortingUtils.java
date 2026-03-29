public class SortingUtils {
    public int linearSearch(String[] list, String data) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(String[] list, String data) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list[mid].equals(data)) {
                return mid;
            } else if (list[mid].compareTo(data) < 0) {
                low = mid + 1;
            } else if (list[mid].compareTo(data) > 0) {
                high = mid - 1;
            }   
        }
        return -1;
    }
}
