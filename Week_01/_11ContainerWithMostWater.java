class Solution {

//暴力解 Time：O(n^2) Space：O(1)
//  public int maxArea(int[] height) {
//    if (height == null || height.length <= 1) {
//      return 0;
//    }
//    int len = height.length;
//    int max = 0;
//    for (int i = 0; i < len - 1; i++) {
//      for (int j = i + 1; j < len; j++) {
//        max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
//      }
//    }
//    return max;
//  }

  //左右指针，从两边向里夹逼 Time：O(n) Space：O(1)
  public int maxArea(int[] height) {
    if (height == null || height.length <= 1) {
      return 0;
    }
    int max = 0;
    for (int i = 0, j = height.length - 1; i < j; ) {
      int h = height[i] < height[j] ? height[i++] : height[j--];
      max = Math.max(max, (j - i + 1) * h); //i或j在上面向里移动1，所以这里要加回来
    }
    return max;
  }
}
