//n不为0的时候res++，然后打掉n的最后一位1，重复上述过程
public class Solution {

  public int hammingWeight(int n) {
    int res = 0;
    while (n != 0) {
      res++;
      n &= n - 1; //打掉n的最后一位1
    }
    return res;
  }
}

////如果最后一位是1，res++，然后n右移一位，重复上述过程
//public class Solution {
//
//  public int hammingWeight(int n) {
//    int res = 0;
//    for (int i = 0; i < 32; i++) {
//      res += n & 1;
//      n >>= 1;
//    }
//    return res;
//  }
//}