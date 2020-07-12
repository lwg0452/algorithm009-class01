class Solution {

  int mask;
  int count;

  public int totalNQueens(int n) {
    mask = (1 << n) - 1; //n个1
    count = 0;
    dfs(0, 0, 0, 0, n);
    return count;
  }

  //row表示当前行
  //col，pie，na的二进制位表示当前行是否被攻击
  private void dfs(int row, int col, int pie, int na, int n) {
    if (row == n) {
      count++;
      return;
    }
    //col | pie | na ==> 为0表示可以放置，为1表示不能放置
    //~(col | pie | na) 取反后为1表示可以放置，为0表示不能放置，还需要&上mask，过滤出前n位
    int position = (~(col | pie | na)) & mask;
    while (position != 0) {
      //取最后一位1
      int p = position & (-position);
      //将该行的1加到col，pie，na上，然后drill down
      dfs(row + 1, col | p, (pie | p) << 1, (na | p) >> 1, n);
      //打掉最后一位1
      position &= (position - 1);
    }
  }
}