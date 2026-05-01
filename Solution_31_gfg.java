import java.util.*;

class Solution_31_gfg {
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        // Min-heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : arr) {
            // Add current element to the heap
            minHeap.add(num);

            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }

            // If heap has fewer than k elements, k-th largest doesn't exist
            if (minHeap.size() < k) {
                result.add(-1);
            } else {
                // The root of the min-heap is the k-th largest element
                result.add(minHeap.peek());
            }
        }

        return result;
    }
}
