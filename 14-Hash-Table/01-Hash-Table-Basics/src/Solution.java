class Solution {
    // 第一个不重复的字符
    public int firstUniqChar(String s) {

        int[] freq = new int[26];
        for(int i = 0 ; i < s.length() ; i ++)
            freq[s.charAt(i) - 'a'] ++;

        for(int i = 0 ; i < s.length() ; i ++)
            if(freq[s.charAt(i) - 'a'] == 1)
                return i;

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        StringBuilder sb1 = new StringBuilder("leetcode");
        int count1 =  solution.firstUniqChar(sb1.toString());
        System.out.println(sb1.toString() + ": " + count1);

        StringBuilder sb2 = new StringBuilder("loveleetcode");
        int count2 =  solution.firstUniqChar(sb2.toString());
        System.out.println(sb2.toString() + ": " + count2);
    }
}
