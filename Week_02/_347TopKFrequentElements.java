import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

  public int[] topKFrequent(int[] nums, int k) {
    int[] res = new int[k];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
        (a, b) -> b.getValue() - a.getValue());
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      maxHeap.offer(entry);
    }
    for (int i = 0; i < k; i++) {
      res[i] = maxHeap.poll().getKey();
    }
    return res;
  }
}