class Solution {
    public int bulbSwitch(int n) {
        // bulbs at square numbers must be on, others are off
        return (int)Math.sqrt(n);
    }
}