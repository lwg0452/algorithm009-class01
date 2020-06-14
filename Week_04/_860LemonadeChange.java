class Solution {

  public boolean lemonadeChange(int[] bills) {
    if (bills == null || bills.length == 0 || bills[0] == 10 || bills[0] == 20) {
      return false;
    }
    int five = 0;
    int ten = 0;
    for (int i = 0; i < bills.length; i++) {
      switch (bills[i]) {
        case 5:
          five++;
          break;
        case 10:
          if (five > 0) {
            five--;
            ten++;
            break;
          } else {
            return false;
          }
        case 20:
          if (ten > 0 && five > 0) {
            ten--;
            five--;
            break;
          } else if (five >= 3) {
            five -= 3;
            break;
          } else {
            return false;
          }
        default:
          return false;
      }
    }
    return true;
  }
}
