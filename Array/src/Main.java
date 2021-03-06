public class Main {

    public static void main(String[] args) {
        /*
        int[] arr = new int[20];
        for(int i = 0; i < arr.length; i++)
            arr[i] = i;
        // 定义时初始化
        int[] scores = new int[]{100, 99, 66};
        for(int i = 0; i < scores.length; i++)
            System.out.println(scores[i]);

        scores[0] = 98;

        // 数组具有可遍历（可迭代）能力
        for(int score: scores)
            System.out.println(score);
        */
        // 使用自定义数组类Array
        Array<Integer> arr = new Array<>(); // int类型的包装类是Integer
        for(int i = 0; i < 10; i++)
            arr.addLast(i);
        System.out.println(arr);
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.add(1, 100);
        System.out.println(arr);
        // [0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.addFirst(-1);
        System.out.println(arr);
        // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.remove(2);
        System.out.println(arr);
        // [-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.removeElement(4);
        System.out.println(arr);
        // [-1, 0, 1, 2, 3, 5, 6, 7, 8, 9]

        arr.removeFirst();
        System.out.println(arr);
        // [0, 1, 2, 3, 5, 6, 7, 8, 9]
    }
}
