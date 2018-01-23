class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        
        // count instead of modulo
        int fizz = 0, buzz = 0;
        for(int i = 1; i <= n; i++) {
            fizz++;
            buzz++;
            if(fizz == 3 && buzz == 5) {
                list.add("FizzBuzz");
                // reset when equals
                fizz = 0;
                buzz = 0;
            }
            else if(fizz == 3) {
                list.add("Fizz");
                fizz = 0;
            }
            else if(buzz == 5) {
                list.add("Buzz");
                buzz = 0;
            }
            else    list.add(String.valueOf(i));
        }
        return list;
    }
}