// 677. 键值映射
// 设计一个 map ，满足以下几点:
// 字符串表示键，整数表示值
// 返回具有前缀等于给定字符串的键的值的总和
// https://leetcode.cn/problems/map-sum-pairs/

import java.util.TreeMap;

public class MapSum {

    private class Node{
        public int value; // 每个单词的权重值
        public TreeMap<Character, Node> next;
        public Node(int value){
            this.value = value;
            next = new TreeMap<>();
        }

        public Node(){
            this(0);
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {

        root = new Node();
    }

    public void insert(String word, int val) {
        Node cur = root;
        for(int i = 0 ; i < word.length() ; i ++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                cur.next.put(c, new Node()); // value值默认为0
            cur = cur.next.get(c);
        }
        cur.value = val; // cur指向word最后一个字母的节点
    }

    public int sum(String prefix) {
        // 从根节点开始，寻找前缀prefix最后一个字母对应的节点
        Node cur = root;
        for(int i = 0 ; i < prefix.length() ; i ++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
                return 0;
            cur = cur.next.get(c);
        }
        // 遍历以cur为根节点的所有子树所对应的value值
        return sum(cur);
    }

    private int sum(Node node){

        int res = node.value;
        for(char c: node.next.keySet())
            res += sum(node.next.get(c));
        return res;
    }
}
