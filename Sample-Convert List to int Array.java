    static int[] oddNumbers(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for(int i = l; i <= r; i++) {
            if(i%2 != 0)    list.add(i);
        }
        int[] re = list.stream().mapToInt(i->i).toArray();
        return re;
    }