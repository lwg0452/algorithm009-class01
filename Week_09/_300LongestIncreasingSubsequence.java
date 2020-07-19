//贪心+二分 Time：O(nlogn)
class Solution {

  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] tails = new int[nums.length]; //tails[i]表示当前长度为i + 1的最长上升子序列的最后一个元素的最小值
    tails[0] = nums[0];
    int len = 1; //len为结果，同时指向tails[]中的第一个未添加位置
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > tails[len - 1]) { //长度增加
        tails[len++] = nums[i];
      } else {  //长度未增加，需要修改tails[]
        int l = 0, r = len - 1;
        while (l != r) {
          int mid = l + (r - l) / 2;
          if (tails[mid] < nums[i]) {
            l = mid + 1;
          } else {
            r = mid;
          }
        }
        tails[l] = nums[i];
      }
    }
    return len;
  }
}

//import java.util.Arrays;
//
////DP time:O(n^2)
//class Solution {
//
//  public int lengthOfLIS(int[] nums) {
//    if (nums == null || nums.length == 0) {
//      return 0;
//    }
//    int res = 1;
//    int[] dp = new int[nums.length];
//    Arrays.fill(dp, 1);
//    for (int i = 1; i < nums.length; i++) {
//      for (int j = 0; j < i; j++) {
//        if (nums[j] < nums[i]) {
//          dp[i] = Math.max(dp[i], dp[j] + 1);
//        }
//      }
//      res = Math.max(res, dp[i]);
//    }
//    return res;
//  }
//}