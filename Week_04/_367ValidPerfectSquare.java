class Solution {

  public boolean isPerfectSquare(int num) {
    if (num == 0 || num == 1) {
      return true;
    }
    int l = 1;
    int r = num;
    int mid;
    while (l <= r) {
      mid = l + (r - l) / 2;
      double test = num / (double) mid;
      if (mid == test) {
        return true;
      } else if (mid < test) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return false;
  }
}