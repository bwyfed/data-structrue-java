import java.util.Random;
public class Main {
    // 测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
    private static double testQueque(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i = 0; i < opCount; i++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0; i < opCount; i++)
            q.dequeue();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
    public static void main(String[] args) {
	// 测试数组队列和循环队列的性能
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueque(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueque(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueque(linkedListQueue, opCount);
        System.out.println("LinkedListQueue, time: " + time3 + " s");
    }
}
