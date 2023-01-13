public class Solution {
    public static void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length;fast++) {
            if (nums[fast] == 0) {
                ++fast;
            } else {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        while (slow < nums.length) {
            nums[slow++] = 0;
        }

    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }

}