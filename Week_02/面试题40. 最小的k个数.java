import java.util.PriorityQueue;

class Solution {

  public int[] getLeastNumbers(int[] arr, int k) {
    if (arr == null || arr.length < k || k <= 0) {
      return new int[0];
    }
    int[] res = new int[k];
    PriorityQueue<Integer> pq = new PriorityQueue<>(k);

    for (int i = 0; i < arr.length; i++) {
      pq.offer(arr[i]);
    }
    for (int i = 0; i < k; i++) {
      res[i] = pq.poll();
    }
    return res;
  }
}