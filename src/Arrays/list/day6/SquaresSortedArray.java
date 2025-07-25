package Arrays.list.day6;

public class SquaresSortedArray {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0, right = n - 1, pos = n - 1;

        while (left <= right) {
            int l = nums[left] * nums[left];
            int r = nums[right] * nums[right];

            if (l > r) {
                result[pos--] = l;
                left++;
            } else {
                result[pos--] = r;
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        int[] squared = sortedSquares(nums);

        for (int num : squared) {
            System.out.print(num + " ");
        }
    }
}
