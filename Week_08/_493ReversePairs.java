class Solution {

  public int reversePairs(int[] nums) {
    return mergeSort(nums, 0, nums.length - 1);
  }

  private int mergeSort(int[] nums, int begin, int end) {
    if (begin >= end) {
      return 0;
    }
    int mid = begin + (end - begin) / 2;
    int res = mergeSort(nums, begin, mid) + mergeSort(nums, mid + 1, end);
    for (int i = begin, j = mid + 1; i <= mid; i++) {
      while (j <= end && nums[i] / 2.0 > nums[j]) {
        j++;
      }
      res += (j - (mid + 1));
    }
    merge(nums, begin, mid, end);
    return res;
  }

  private void merge(int[] arr, int begin, int mid, int end) {
    int[] temp = new int[end - begin + 1];
    int i = begin, j = mid + 1, k = 0;
    while (i <= mid && j <= end) {
      temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
    }
    while (i <= mid) {
      temp[k++] = arr[i++];
    }
    while (j <= end) {
      temp[k++] = arr[j++];
    }
    for (int p = 0; p < temp.length; p++) {
      arr[begin + p] = temp[p];
    }
  }
}