package hash.table.and.set._15ThreeSum;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[nums.length - 1] * 2 < 0) {
                continue;
            }
            if (nums[i] * 3 > 0) {
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int expectedSum = -nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == expectedSum) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (nums[left] + nums[right] < expectedSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
