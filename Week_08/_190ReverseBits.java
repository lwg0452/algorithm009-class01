public class Solution {

  // you need treat n as an unsigned value
  public int reverseBits(int n) {
    int res = 0, power = 31;
    for (int i = 0; i < 32; i++) {
      res += (n & 1) << power;
      n >>= 1;
      power--;
    }
    return res;
  }
}