import java.util.*;

    public class FindAllcountVer {
        public static void main(String[] args) {
            int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
            Solut sol = new Solut();
            List<Integer> result = sol.findDisappearedNumbers(nums);
            System.out.println("Пропущенные числа: " + result);
        }
    }

    class Solut {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            int[] count = new int[n];

            for (int num : nums) {
                count[num - 1]++;
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (count[i] == 0) {
                    result.add(i + 1);
                }
            }

            return result;
        }
    }

