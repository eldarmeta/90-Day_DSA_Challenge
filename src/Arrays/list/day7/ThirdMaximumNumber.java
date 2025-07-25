package Arrays.list.day7;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = {2, 3, 8, 9, 4, 8};
        System.out.println("Third max: " + thirdMax(nums));
    }

    public static int thirdMax(int[] nums) {
        Long first = null, second = null, third = null;

        for (int num : nums) {
            long n = num;

            // Skip if already assigned
            if ((first != null && n == first) ||
                    (second != null && n == second) ||
                    (third != null && n == third)) {
                continue;
            }

            if (first == null || n > first) {
                third = second;
                second = first;
                first = n;
            } else if (second == null || n > second) {
                third = second;
                second = n;
            } else if (third == null || n > third) {
                third = n;
            }
        }

        if (third != null) {
            return third.intValue();
        } else if (first != null) {
            return first.intValue();
        } else {
            return Integer.MIN_VALUE; // fallback for empty array
        }
    }
}
