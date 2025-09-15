public class LC278_FirstBadVersion {
    private static int bad = 4;

    private static boolean isBadVersion(int version) {
        return version >= bad;
    }

    public static int firstBadVersion(int n) {
        return helper(1, n);
    }

    private static int helper(int left, int right) {
        if (left == right) return left;
        int mid = left + (right - left) / 2;
        if (isBadVersion(mid)) {
            return helper(left, mid);
        } else {
            return helper(mid + 1, right);
        }
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
}