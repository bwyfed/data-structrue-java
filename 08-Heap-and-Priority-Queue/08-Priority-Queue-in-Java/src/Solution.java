/// 347. Top K Frequent Elements
/// https://leetcode.com/problems/top-k-frequent-elements/description/
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Solution {
    private class Freq {
        int e, freq;
        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }


    }
    // 定义一个比较器
    private class FreqComparator implements Comparator<Freq> {
        @Override
        public int compare(Freq a, Freq b) {
            return a.freq - b.freq; // 谁的频率小，谁就靠前
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
//        PriorityQueue<Freq> pq = new PriorityQueue<>(new FreqComparator());
        // 使用匿名类
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

        for(int key: map.keySet()) {
            if(pq.size() < k)
                pq.add(key);
            else if(map.get(key) > pq.peek()) {
                // 优先队列里已经有k个元素了。当前遍历到的元素的优先级(频次)更高一些
                pq.remove();
                pq.add(key);
            }
        }
        // 将k个元素放在List中
        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.remove().e);
        return res;
    }
}
