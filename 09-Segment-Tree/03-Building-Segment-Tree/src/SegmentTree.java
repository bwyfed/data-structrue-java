public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;
    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;

        data = (E[])new Object[arr.length];
        for(int i = 0; i < arr.length; i++)
            data[i] = arr[i];

        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在 treeIndex 的位置创建表示区间[l...r]的线段树
     * @param treeIndex 根节点所对应的索引
     * @l 本节点所对应的区间的左端点
     * @r 本节点所对应的区间的右端点
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if(l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2; // 区间的中间位置
        buildSegmentTree(leftTreeIndex, l, mid); // 构建左子树
        buildSegmentTree(rightTreeIndex, mid + 1, r); // 构建右子树

        // 综合左右两个线段的信息得到根节点的信息。怎样综合，是由业务来决定的。
//        tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }
    public int getSize() {
        return data.length;
    }
    public E get(int index) {
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }
    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return 2*index + 1;
    }
    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return 2*index + 2;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0; i < tree.length; i++) {
            if(tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if(i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
