class Solution {

  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    int[] count = new int[1001];
    for (int i : arr1) {
      count[i]++;
    }
    int i = 0;
    for (int k = 0; k < arr2.length; k++) {
      while (count[arr2[k]]-- > 0) {
        arr1[i++] = arr2[k];
      }
    }
    for (int k = 0; k < count.length; k++) {
      while (count[k]-- > 0) {
        arr1[i++] = k;
      }
    }
    return arr1;
  }
}