package dynamic.programming._264UglyNumberII;

class Solution {

  public int nthUglyNumber(int n) {
    if (n < 1) {
      return -1;
    }
    int factor2 = 2, factor3 = 3, factor5 = 5;
    int p2 = 0, p3 = 0, p5 = 0;  //指针,开始时指向第一个丑数(index = 0)
    int[] ugly = new int[n];
    ugly[0] = 1;
    for (int i = 1; i < n; i++) {
      ugly[i] = Math.min(Math.min(factor2, factor3), factor5);
      //if的作用：移动指针  不用else if的原因：去重
      if (ugly[i] == factor2) {
        p2++;
        factor2 = 2 * ugly[p2];
      }
      if (ugly[i] == factor3) {
        p3++;
        factor3 = 3 * ugly[p3];
      }
      if (ugly[i] == factor5) {
        p5++;
        factor5 = 5 * ugly[p5];
      }
    }
    return ugly[n - 1];
  }
}
