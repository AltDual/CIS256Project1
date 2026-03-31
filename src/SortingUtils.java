public final class SortingUtils {
    private SortingUtils() {};
    
    public static void insertationSort(String[] s) {
        for (int i = 1; i < s.length; i++) {
            int j = i;
            while (j > 0 && (s[j].compareTo(s[j - 1]) < 0)) {
                String temp = s[j];
                s[j] = s[j - 1];
                s[j - 1] = temp;
                j--;
            }
        }
    }

    public static void mergeSort(String[] s, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(s, l, m);
            mergeSort(s, m + 1, r);

            merge(s, l, m, r);
        }
    }

    private static void merge(String[] s, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        String L[] = new String[n1];
        String R[] = new String[n2];
        
        for (int i = 0; i < n1; i++) {
            L[i] = s[l+i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = s[m + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                s[k] = L[i];
                i++;
            }
            else {
                s[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            s[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            s[k] = R[j];
            j++;
            k++;
        }
    }
}