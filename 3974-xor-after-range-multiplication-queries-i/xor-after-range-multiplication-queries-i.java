class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long MOD = 1000000007L;

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];

            for (int i = l; i <= r; i += k) {
                nums[i] = (int)((nums[i] * 1L * v) % MOD);
            }
        }

        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        return ans;
    }
}