class Solution {
    public int bulbSwitch(int n) {
        // Math
        // for Prime nums, they're only switched twice(1st and theirs), off
        // others are on if switched odd times(1st, theirs, plus odd num)
        // those with sqrt would work, only those x*x <= n
        return (int)(Math.sqrt(n));
    }
}