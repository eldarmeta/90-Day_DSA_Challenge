public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        int missing = missingNumber(nums);
        System.out.println(missing); // Вот этого не хватало
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int i = 0; i < nums.length; i++) {
            actualSum = actualSum + nums[i];
        }

        return expectedSum - actualSum;
    }
}
