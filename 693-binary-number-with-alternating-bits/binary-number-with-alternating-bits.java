class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n >> 1;
        x = x ^ n;
        int mask = x + 1;
        return ((x & mask) == 0) ? true : false;
    }
}