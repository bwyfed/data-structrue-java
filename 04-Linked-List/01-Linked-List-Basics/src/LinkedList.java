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
}
