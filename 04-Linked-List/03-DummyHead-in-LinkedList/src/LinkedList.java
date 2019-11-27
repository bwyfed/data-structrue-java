public class LinkedList<E> {
    // 设计一个私有内部类表示节点
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e) {
            this(e, null);
        }
        public Node() {
            this(null, null);
        }
        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node dummyHead; // 虚拟链表头节点
    private int size; // 链表中元素的个数

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }
    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }
    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }
    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用:)
    public void add(int index, E e) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Node prev = dummyHead; // dummyHead为索引为0的元素的前驱节点
        for(int i = 0; i < index; i++)
            prev = prev.next;

        prev.next = new Node(e, prev.next);
        size++;
    }
    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }
    public void addLast(E e) {
        add(size, e);
    }
}
