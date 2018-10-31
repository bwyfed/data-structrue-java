public class Array<E> {
    private E[] data;
    private int size; // 当前数组中有多少个有效元素
    // 构造函数，传入数组的容量capacity来构造Array
    public Array(int capacity) {
//        data = new int[capacity];
        data = (E[])new Object[capacity];
        size = 0;
    }
    // 默认构造函数。无参的构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
    }
    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }
    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }
    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }
    // 在第index个位置插入一个元素e
    public void add(int index, E e) {

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Required index >=0 && index <= size.");
        // 当数组容量不够时，对数组进行扩容，这里扩容为以前容量的2倍
        if(size == data.length)
            resize(2 * data.length);
        for(int i = size-1; i >= index; i--)
            data[i+1] = data[i];
        data[index] = e;
        size ++;
    }
    // 向所有元素后添加一个新元素
    public void addLast(E e) {
//        if(size == data.length)
//            throw new IllegalArgumentException("AddLast failed, Array is full.");
//        data[size] = e;
//        size++;
        // 更加简洁的写法
        add(size, e);
    }
    // 在数组头部插入一个元素
    public void addFirst(E e) {
        add(0, e);
    }
    // 获取index索引位置的数组元素
    public E get(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }
    // 修改index索引位置的元素为e
    public void set(int index, E e) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }
    // 查找数组中是否存在元素e
    public boolean contains(E e) {
        for(int i = 0; i < size; i++) {
            if(data[i].equals(e)) // equals是值比较
                return true;
        }
        return false;
    }
    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for(int i = 0; i < size; i++) {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }
    // 从数组中删除index位置的元素，返回删除的元素
    public E remove(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        E ret = data[index];
        for(int i = index + 1; i < size; i++)
            data[i-1] = data[i];
        size--;
        data[size] = null; // loitering objects存在，并不意味着memory leak. 这一行使得java的垃圾回收机制起作用，这句不是必须的
        // 当前元素个数小于一定值时，对数组容量进行缩小
        // 这里使用了Lazy策略来缩小数组容量
        if(size == data.length / 4 && data.length / 2 != 0)
            resize(data.length/2);
        return ret;
    }
    // 从数组中删除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }
    // 从数组中删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size-1);
    }
    // 从数组中删除元素e(删除第一个e元素)
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }
    // 覆盖父类的方法
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(); // 拼接一个字符串
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }
}
