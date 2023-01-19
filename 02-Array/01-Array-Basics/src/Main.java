public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10]; // 必须声明数组中有多少个元素
        for(int i = 0; i < arr.length; i++)
            arr[i] = i;

        int[] scores = new int[]{100, 99, 66, 55};
        for(int i = 0; i < scores.length; i++)
            System.out.println((scores[i]));

        scores[0] = 98;
        for(int i = 0; i < scores.length; i++)
            System.out.println((scores[i]));
        // for each模式遍历数组
     //   for(int score:scores)
//            System.out.println(score);
    }
}
