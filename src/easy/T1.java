package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 田付成
 * @date 2021/5/21 10:39
 */

public class T1 {
    public static void main(String[] args) {
        int[] a = {3, 2, 4};
        int[] ints = twoSum1(a, 6);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }


    }


    static int[] twoSum(int[] nums, int target) {
        int num = nums.length;
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return nums;
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(10);
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return nums;
    }
}

