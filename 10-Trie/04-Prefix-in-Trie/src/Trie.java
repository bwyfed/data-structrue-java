import java.util.TreeMap;

public class Trie {
    private class Node{
        public boolean isWord; // 找到这个node的时候，是否已经构成了一个单词
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }
    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }
    // 获得Trie中存储的单词数量
    public int getSize(){
        return size;
    }
    // 向Trie中添加一个新的单词word。非递归实现
    public void add(String word){
        Node cur = root; // 初始的时候在root位置
        for(int i = 0 ; i < word.length() ; i ++){
            char c = word.charAt(i);
            // 检查当前cur的next映射中是否已经包含了c到下一个节点的映射，没有的话则新建一个节点。
            if(cur.next.get(c) == null)
                cur.next.put(c, new Node());
            // 有的话就走到下一个节点
            cur = cur.next.get(c);
        }

        if(!cur.isWord){
            cur.isWord = true;
            size ++;
        }
    }
    // 查询单词word是否在Trie中.和添加过程逻辑一致.
    public boolean contains(String word){
        Node cur = root;
        for(int i = 0 ; i < word.length() ; i ++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }
    // 查询是否在Trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix) {
        Node cur = root;

        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return true;
    }
}





