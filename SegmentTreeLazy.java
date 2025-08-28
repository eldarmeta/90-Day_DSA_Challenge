import java.io.*;
import java.util.*;

public class SegmentTreeLazy {
    private final int n;
    private final long[] tree;
    private final long[] lazy;

    public SegmentTreeLazy(long[] arr) {
        n = arr.length;
        tree = new long[4 * n];
        lazy = new long[4 * n];
        build(1, 0, n - 1, arr);
    }

    private void build(int v, int tl, int tr, long[] a) {
        if (tl == tr) {
            tree[v] = a[tl];
            return;
        }
        int tm = (tl + tr) >>> 1;
        build(v << 1, tl, tm, a);
        build(v << 1 | 1, tm + 1, tr, a);
        tree[v] = tree[v << 1] + tree[v << 1 | 1];
    }

    private void push(int v, int tl, int tr) {
        if (lazy[v] == 0 || tl == tr) return;
        int tm = (tl + tr) >>> 1;
        long val = lazy[v];
        apply(v << 1, tl, tm, val);
        apply(v << 1 | 1, tm + 1, tr, val);
        lazy[v] = 0;
    }

    private void apply(int v, int tl, int tr, long add) {
        tree[v] += add * (tr - tl + 1);
        lazy[v] += add;
    }

    public void add(int l, int r, long x) {
        if (l > r) return;
        add(1, 0, n - 1, l, r, x);
    }

    private void add(int v, int tl, int tr, int l, int r, long x) {
        if (l > r) return;
        if (l == tl && r == tr) {
            apply(v, tl, tr, x);
            return;
        }
        push(v, tl, tr);
        int tm = (tl + tr) >>> 1;
        add(v << 1, tl, tm, l, Math.min(r, tm), x);
        add(v << 1 | 1, tm + 1, tr, Math.max(l, tm + 1), r, x);
        tree[v] = tree[v << 1] + tree[v << 1 | 1];
    }

    public long sum(int l, int r) {
        if (l > r) return 0;
        return sum(1, 0, n - 1, l, r);
    }

    private long sum(int v, int tl, int tr, int l, int r) {
        if (l > r) return 0;
        if (l == tl && r == tr) return tree[v];
        push(v, tl, tr);
        int tm = (tl + tr) >>> 1;
        return sum(v << 1, tl, tm, l, Math.min(r, tm))
             + sum(v << 1 | 1, tm + 1, tr, Math.max(l, tm + 1), r);
    }

    public static void main(String[] args) {
        long[] a = {1, 2, 3, 4, 5};
        SegmentTreeLazy st = new SegmentTreeLazy(a);
        System.out.println(st.sum(0, 4));
        st.add(1, 3, 10);
        System.out.println(st.sum(0, 4));
        System.out.println(st.sum(2, 2));
        st.add(0, 4, -5);
        System.out.println(st.sum(0, 4));
    }
}
