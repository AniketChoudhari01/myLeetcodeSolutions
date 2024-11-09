class Solution {

    public long minEnd(int n, int x) {
        long res = x;
        for (int i = 1; i < n; i++) {
            res = (res + 1) | x;
        }
        return res;
    }

}