class Solution {

  //双指针 Time:O(n) Space:O(1)
  public void moveZeroes(int[] nums) {
    int zeroIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        if (zeroIndex != i) {
          nums[zeroIndex] = nums[i];
          nums[i] = 0;
        }
        zeroIndex++;
      }
    }
  }
}
