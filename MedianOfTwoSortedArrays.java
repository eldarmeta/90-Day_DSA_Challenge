import java.util.*;

public class MedianOfTwoSortedArrays {
    // LeetCode 4: Median of Two Sorted Arrays (Hard)
    // Time: O(log(min(n, m))), Space: O(1)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int n = nums1.length, m = nums2.length;
        int low = 0, high = n;
        int half = (n + m + 2) / 2; // size of left partition
        
        while (low <= high) {
            int i = (low + high) >>> 1;     // cut in nums1
            int j = half - i;               // cut in nums2
            
            int L1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int R1 = (i == n) ? Integer.MAX_VALUE : nums1[i];
            int L2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int R2 = (j == m) ? Integer.MAX_VALUE : nums2[j];
            
            if (L1 <= R2 && L2 <= R1) {
                // Found correct partition
                if (((n + m) & 1) == 1) {
                    return Math.max(L1, L2);
                } else {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                }
            } else if (L1 > R2) {
                high = i - 1; // move left in nums1
            } else {
                low = i + 1;  // move right in nums1
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }
    
    // Demo
    public static void main(String[] args) {
        int[] a = {1, 3, 8};
        int[] b = {7, 9, 10, 11};
        System.out.println(findMedianSortedArrays(a, b)); // 8.0
        
        int[] c = {1, 2};
        int[] d = {3, 4};
        System.out.println(findMedianSortedArrays(c, d)); // 2.5
    }
}
