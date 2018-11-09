public class Sum {
    // 使用递归方式来求和
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }
    // 计算arr[l...n)这个区间内所有数组的和
    private static int sum(int[] arr, int l) {
        // 求解最基本的问题
        if(l == arr.length) // 数组为空
            return 0;
        // 把原问题转化为更小的问题
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(nums));
    }
}
