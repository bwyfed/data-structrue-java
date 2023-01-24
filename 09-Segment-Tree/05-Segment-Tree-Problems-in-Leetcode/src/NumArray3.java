/// Leetcode 307. Range Sum Query - Mutable
/// https://leetcode.com/problems/range-sum-query-mutable/description/
///
/// 使用sum数组的思路：TLE
class NumArray3 {
    private int[] data; // 数组的副本
    private int[] sum;
    public NumArray3(int[] nums) {

        data = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i ++)
            data[i] = nums[i];

        sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1 ; i <= nums.length ; i ++)
            sum[i] = sum[i - 1] + nums[i - 1];
    }
    public void update(int index, int val) {
        data[index] = val;
        // 这里很大的技巧就是从 index+1 这个位置开始更新就好了
        for(int i = index + 1 ; i < sum.length ; i ++)
            sum[i] = sum[i - 1] + data[i - 1];
    }
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }


}
