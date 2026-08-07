class Solution {
    public static String longestPalindrome(String s) {
        int maxLen = 0;
        int sp = 0;
        int[][] memo = new int[s.length()][s.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (solve(i, j, s,memo) == 1) {
                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        sp = i;
                    }
                }
            }
        }

        return s.substring(sp, sp + maxLen);
    }

    public static int solve(int i, int j, String s ,int[][] memo) {
        if (i >= j) {
            return 1;
        }
        if (memo[i][j] != -1){
            return memo[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            return memo[i][j] = solve(i + 1, j - 1, s,memo);
        }
        return 0;
    }
}