class Solution {

  public int majorityElement(int[] nums) {
    if (nums == null || nums.length == 0) {
      throw new IllegalStateException();
    }
    int candidate = nums[0];
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (count == 0) {
        candidate = nums[i];
      }
      if (nums[i] == candidate) {
        count++;
      } else {
        count--;
      }
    }
    return candidate;
  }
}