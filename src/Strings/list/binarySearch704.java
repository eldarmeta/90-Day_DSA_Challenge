package Strings.list;

public class binarySearch704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        binarySearch704 bs = new binarySearch704();
        int[] nums = {-1, 0, 3, 5, 9, 12};

        System.out.println(bs.search(nums, 9));
        System.out.println(bs.search(nums, 2));
    }
}
