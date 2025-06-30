public class removeDuplicates {
    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 3, 3, 4, 5, 5, 9};

        int uniqueLength = removeDuplicates(nums); // вызываем метод

        // Печатаем результат
        System.out.println("Number of unique elements: " + uniqueLength);

        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < uniqueLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int insertPos = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        return insertPos;
    }
}
