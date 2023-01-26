import java.util.ArrayList;
import java.util.Random;

public class Main3 {
    public static void main(String[] args) {

        int n = 20000000; // 2千万个数据

        ArrayList<Integer> testData = new ArrayList<>();
//        for(int i = 0; i < n; i++)
        for(int i = n; i > 0; i--)
            testData.add(i);

        // Test BST
//        long startTime = System.nanoTime();
//
//        BST<Integer, Integer> bst = new BST<>();
//        for(Integer x: testData)
//            bst.add(x, null);
//
//        long endTime = System.nanoTime();
//
//        double time = (endTime - startTime) / 1000000000.0;
//        System.out.println("BST: " + time + " s");

        // Test AVL
        long startTime = System.nanoTime();

        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for(Integer x: testData)
            avl.add(x, null);

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL: " + time + " s");

        // Test RBTree
        startTime = System.nanoTime();

        RBTree<Integer, Integer> rbt = new RBTree<>();
        for(Integer x: testData)
            rbt.add(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("RBTree: " + time + " s");

    }
}
