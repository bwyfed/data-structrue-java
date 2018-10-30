public class Array {
    private int[] data;
    private int size; // 当前数组中有多少个有效元素
    // 构造函数，传入数组的容量capacity来构造Array
    public Array(int capacity) {
        data = new int[capacity];
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
    // 向所有元素后添加一个新元素
    public void addLast(int e) {
//        if(size == data.length)
//            throw new IllegalArgumentException("AddLast failed, Array is full.");
//        data[size] = e;
//        size++;
        // 更加简洁的写法
        add(size, e);
    }
    // 在数组头部插入一个元素
    public void addFirst(int e) {
        add(0, e);
    }
    // 在第index个位置插入一个元素e
    public void add(int index, int e) {
        if(size == data.length)
            throw new IllegalArgumentException("Add failed. Array is full.");
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Required index >=0 && index <= size.");

        for(int i = size-1; i >= index; i--)
            data[i+1] = data[i];
        data[index] = e;
        size ++;
    }
    // 获取index索引位置的数组元素
    public int get(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }
    // 修改index索引位置的元素为e
    public void set(int index, int e) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }
    // 查找数组中是否存在元素e
    public boolean contains(int e) {
        for(int i = 0; i < size; i++) {
            if(data[i] == e)
                return true;
        }
        return false;
    }
    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(int e) {
        for(int i = 0; i < size; i++) {
            if(data[i] == e)
                return i;
        }
        return -1;
    }
    // 从数组中删除index位置的元素，返回删除的元素
    public int remove(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        int ret = data[index];
        for(int i = index + 1; i < size; i++)
            data[i-1] = data[i];
        size--;
        return ret;
    }
    // 从数组中删除第一个元素，返回删除的元素
    public int removeFirst() {
        return remove(0);
    }
    // 从数组中删除最后一个元素，返回删除的元素
    public int removeLast() {
        return remove(size-1);
    }
    // 从数组中删除元素e(删除第一个e元素)
    public void removeElement(int e) {
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
}
