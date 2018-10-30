public class Main {

    public static void main(String[] args) {
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
    }
}
