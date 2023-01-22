/// 347. Top K Frequent Elements
/// https://leetcode.com/problems/top-k-frequent-elements/description/
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
public class Solution {
    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
        @Override
        public int compareTo(Freq another) {
            if(this.freq < another.freq)
                return 1;
            else if (this.freq > another.freq)
                return -1;
            else
                return 0;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 统计频次
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        // 利用优先队列求出前k个元素
        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key: map.keySet()) {
            if(pq.getSize() < k)
                pq.enqueue(new Freq(key, map.get(key)));
            else if(map.get(key) > pq.getFront().freq) {
                // 优先队列里已经有k个元素了。当前遍历到的元素的优先级(频次)更高一些
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }
        // 将k个元素放在
        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.dequeue().e);
        return res;
    }
}
