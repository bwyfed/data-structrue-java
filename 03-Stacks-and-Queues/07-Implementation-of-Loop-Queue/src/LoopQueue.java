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
    @Override
    public void enqueue(E e) {
        // 队列为满的情况下，需要进行扩容操作
        if((tail+1) % data.length == front)
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        // 将原队列的数据搬移到新队列中，从新队列初始位置开始
        for(int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size; // 扩容操作没有影响数组中元素个数
    }
    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        // 缩容
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }
    // 下一小节再做具体实现
    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        return data[front];
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front; i != tail; i = (i+1) % data.length) {
            res.append(data[i]);
            if((i+1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
