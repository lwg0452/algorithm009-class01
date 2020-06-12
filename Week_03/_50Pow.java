class Solution {

  public double myPow(double x, int n) {
    if (x == 0 && n < 0) {
      throw new IllegalArgumentException();
    }
    if (n == 0) {
      return 1;
    }
    if (n == 1 || x == 1 || x == 0) {
      return x;
    }
    if (n < 0) {
      if (n == Integer.MIN_VALUE) {
        return 1 / x * myPow(1 / x, -(n + 1));
      }
      x = 1 / x;
      n = -n;
    }
    double temp = myPow(x, n / 2);
    if (n % 2 == 1) {
      return x * temp * temp;
    }
    return temp * temp;
  }
}