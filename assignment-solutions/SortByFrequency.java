package sorting.assignment_solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Sort array elements by decreasing frequency.
 * If frequency is equal, smaller elements come first.
 *
 * Approach:
 * - Count frequencies using HashMap
 * - Sort pairs manually
 * - Rebuild array
 */
public class SortByFrequency {

    public static void sortByFrequency(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) freq.put(x, freq.getOrDefault(x, 0) + 1);

        int n = freq.size();
        int[][] pairs = new int[n][2];
        int idx = 0;
        for (int key : freq.keySet()) {
            pairs[idx][0] = key;
            pairs[idx][1] = freq.get(key);
            idx++;
        }

        // Sort by freq desc, then value asc
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (pairs[i][1] < pairs[j][1] ||
                        (pairs[i][1] == pairs[j][1] && pairs[i][0] > pairs[j][0])) {
                    int[] temp = pairs[i];
                    pairs[i] = pairs[j];
                    pairs[j] = temp;
                }
            }
        }

        // Rebuild array
        idx = 0;
        for (int[] p : pairs) {
            for (int i = 0; i < p[1]; i++) arr[idx++] = p[0];
        }
    }
}
