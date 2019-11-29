import java.util.ArrayList;

// 不带头节点的单链表
public class SinglyLinkedList<E> {
    // 定义结点
    private class Node {
        public E data;
        public Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
        public Node(E data) {
            this(data, null);
        }
        public Node() {
            this(null, null);
        }
        @Override
        public String toString() {
            return this.data.toString();
        }
    }
    // 定义链表
    private Node head; // 链表头指针
    private int size; // 链表中结点的个数
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    // 传入数组初始化链表 ??
    public SinglyLinkedList(E[] arr) {
        if (arr.length == 0)
            throw new IllegalArgumentException("Expect an non-null array.");
        Node cur = head;
        // 处理第一个节点
        cur = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            cur = new Node(arr[i]);
        }
    }
    // 表头插入
    public void insertToHead(E data) {
        Node newNode = new Node(data);
        insertToHead(newNode);
    }
    public void insertToHead(Node newNode) {
        if (head == null)
            head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }
    // 尾部插入
    public void insertToTail(E data) {
        Node node = new Node(data);
        insertToTail(node);
    }
    public void insertToTail(Node node) {
        if (head == null)
            head = node;
        else {
            // 遍历寻找最后一个结点
            Node cur = head;
            for (; cur.next != null; cur = cur.next) ;
            cur.next = node;
        }
    }
    // 在指定结点p后面插入新结点
    public void insertAfter(Node p, E value) {
        Node newNode = new Node(value);
        insertAfter(p, newNode);
    }
    public void insertAfter(Node p, Node newNode) {
        if (p == null) return;

        newNode.next = p.next;
        p.next = newNode;
    }
    // 找到指定结点的前驱结点
    public Node findPrevNodeByValue(E value) {
        if (head == null) return null;
        if (head.data == value) return head;
        Node prev = head;
        Node cur = head.next;
        while(cur != null && cur.data != value) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == null) return null;
        return prev;
    }
    // 找到指定值的结点
    public Node findNodeByValue(E value) {
        if (head == null) return null;
        Node cur = head;
        for (; cur != null && cur.data != value; cur = cur.next) ;
        if (cur == null) return null;
        return cur;
    }
    // 在指定结点p前面插入新结点
    public void insertBefore(Node p, Node newNode) {
        if (p == null) return;

        if (p == head) {
            insertToHead(newNode); // 这里不是head = newNode;
            return;
        }

        Node prev = head;
        // 这里的循环条件一定不能忘记prev != null
        for (; prev != null && prev.next != p; prev = prev.next) ;
        if (prev == null) return; // 前驱结点为空，而指定结点p不为空，这个不可能
        newNode.next = p;
        prev.next = newNode;
    }
    public void insertBefore(Node p, E value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }
    // 在指定的值beforeValue前面插入新结点value
    public void insertBeforeByValue(E beforeValue, E value) {
        if (head == null) return;
        if (head.data == beforeValue) {
            insertToHead(value);
            return;
        }
        Node prev = head;
        Node cur = head.next;
        while(cur != null && cur.data != beforeValue) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == null) return;
        Node newNode = new Node(value);
        newNode.next = cur;
        prev.next = newNode;
    }
    // 根据指定结点的指针删除结点
    public void deleteByNode(Node p) {
        if (p == null || head == null) return;

        if (p == head) { // 删除第1个结点
            head = head.next;
            return;
        }

        Node prev = head;
        for(; prev.next != p; prev = prev.next ) ;

        if (prev == null) return; // 没有找到对应的结点

        prev.next = prev.next.next;
    }
    public void deleteByValue(E value) {
        if (head == null) return;
        // 注意这里如何同时处理前驱结点和当前结点
        if (head.data.equals(value)) {
            // 第一个结点就是要删除的节点
            head = head.next;
        } else {
            // 要删除的节点在第一个结点后或者不存在
            Node prev = head;
            Node cur = head.next;
            while (cur != null && cur.data != value) {
                prev = cur;
                cur = cur.next;
            }
            if (cur != null) {
                // 找到要删除的节点cur
                prev.next = cur.next;
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("SinglyLinkedList: ");
        for (Node cur = head; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
//        for (int item: arr)
//            list1.insertToTail(item);
        System.out.println(list1);

        // 插入节点
        list1.insertToTail(1); // 尾部插入
        System.out.println(list1);
        list1.insertToHead(2); // 头部插入
        System.out.println(list1);
        list1.insertToHead(3); // 头部插入
        System.out.println(list1);
        list1.insertToTail(4); // 尾部插入
        System.out.println(list1);
        list1.insertBeforeByValue(4, 10);
        System.out.println(list1);
        list1.insertBeforeByValue(3, 9);
        System.out.println(list1);
        // ...需要测试insertBefore和insertAfter
        // 删除结点
        list1.deleteByValue(4);
        System.out.println(list1);
        list1.deleteByValue(6);
        System.out.println(list1);
        list1.deleteByValue(2);
        System.out.println(list1);
        list1.deleteByValue(3);
        System.out.println(list1);
    }
}
