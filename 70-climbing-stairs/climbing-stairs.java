class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        // 1, 1, 2, 3, 5, 8, 13, ...
        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}