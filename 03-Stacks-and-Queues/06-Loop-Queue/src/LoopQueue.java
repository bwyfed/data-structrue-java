public class LoopQueue<E> implements Queue<E> {
    private E[] data; // 从基本数组类型开始实现循环队列
    private int front, tail; // 队首索引，队尾元素的下一个位置
    private int size; // 队列元素的个数

    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity + 1]; // 注意这里要多一个元素
        front = 0;
        tail = 0;
        size = 0;
    }
    public LoopQueue() {
        this(10);
    }
    public int getCapacity() {
        return data.length - 1; // 数组中有一个元素是浪费的
    }
    @Override
    public boolean isEmpty() {
        return front == tail;
    }
    @Override
    public int getSize() {
        return size;
    }
    // 下一小节再做具体实现
    @Override
    public void enqueue(E e) {}
    // 下一小节再做具体实现
    @Override
    public E dequeue() {
        return null;
    }
    // 下一小节再做具体实现
    @Override
    public E getFront() {
        return null;
    }
}
