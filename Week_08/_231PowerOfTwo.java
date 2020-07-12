//2的幂的二进制表示中只有一位1
//打掉最后一位1，看结果是否为0
class Solution {

  public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }
}

////取出最后一位1，看是否和原数相等
//class Solution {
//
//  public boolean isPowerOfTwo(int n) {
//    return n > 0 && (n & (-n)) == n;
//  }
//}