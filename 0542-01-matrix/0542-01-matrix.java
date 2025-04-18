class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int maxValue = (int) 1e4;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] != 0) {
                    int left = maxValue;
                    int top = maxValue;
                    if (r - 1 >= 0)
                        top = mat[r - 1][c];
                    if (c - 1 >= 0)
                        left = mat[r][c - 1];
                    mat[r][c] = Math.min(left, top) + 1;
                }
            }
        }
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (mat[r][c] != 0) {
                    int right = maxValue;
                    int bottom = maxValue;
                    if (c + 1 < n)
                        right = mat[r][c + 1];
                    if (r + 1 < m)
                        bottom = mat[r + 1][c];
                    mat[r][c] = Math.min(mat[r][c], Math.min(right, bottom)+1 );
                }

            }
        }
        return mat;
    }
}