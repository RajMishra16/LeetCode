class Solution {

    private int count = 0;

    public int totalNQueens(int n) {

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];

        backtrack(0, n, cols, diag1, diag2);

        return count;
    }

    private void backtrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {

        if (row == n) {
            count++;
            return;
        }

        for (int c = 0; c < n; c++) {

            int diagIDX1 = row - c + n;
            int diagIDX2 = row + c;

            if (cols[c] || diag1[diagIDX1] || diag2[diagIDX2])
                continue;

            cols[c] = true;
            diag1[diagIDX1] = true;
            diag2[diagIDX2] = true;

            backtrack(row + 1, n, cols, diag1, diag2);

            cols[c] = false;
            diag1[diagIDX1] = false;
            diag2[diagIDX2] = false;
        }
    }
}