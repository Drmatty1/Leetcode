class Solution {
    public int hammingWeight(int n) {
        return (int)Integer.toBinaryString(n).chars().filter(c->c=='1').count();
    }
}