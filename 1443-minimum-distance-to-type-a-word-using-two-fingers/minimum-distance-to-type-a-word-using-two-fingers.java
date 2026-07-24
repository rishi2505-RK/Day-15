import java.util.*;

class Solution {
    int[][] pos = new int[26][2];

    public int minimumDistance(String word) {

        for (int i = 0; i < 26; i++) {
            pos[i][0] = i / 6;
            pos[i][1] = i % 6;
        }

        int n = word.length();

        int[] dp = new int[27];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);

        dp[26] = 0;

        int prev = word.charAt(0) - 'A';

        for (int i = 1; i < n; i++) {
            int cur = word.charAt(i) - 'A';
            int[] next = new int[27];
            Arrays.fill(next, Integer.MAX_VALUE / 2);

            for (int other = 0; other <= 26; other++) {
                int cost = dp[other];

                next[other] = Math.min(next[other],
                        cost + distance(prev, cur));

                int moveCost = (other == 26) ? 0 : distance(other, cur);

                next[prev] = Math.min(next[prev],
                        cost + moveCost);
            }

            dp = next;
            prev = cur;
        }

        int ans = Integer.MAX_VALUE;
        for (int value : dp) {
            ans = Math.min(ans, value);
        }

        return ans;
    }

    private int distance(int a, int b) {
        return Math.abs(pos[a][0] - pos[b][0]) +
               Math.abs(pos[a][1] - pos[b][1]);
    }
}