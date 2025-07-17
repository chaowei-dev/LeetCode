class Solution {
    public int rob(int[] nums) {
        int prevPrevMax = 0;
        int prevMax = 0;

        for (int num : nums) {
            int currMax = Math.max(num + prevPrevMax, prevMax);

            prevPrevMax = prevMax;
            prevMax = currMax;
        }

        return prevMax;

    }
}