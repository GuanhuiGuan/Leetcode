public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> i;
    Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    @Override
    public Integer next() {
        // hasNext();
        return j.next();
    }

    @Override
    public boolean hasNext() {
        // skip empty sublists/finishes one and goes for next when has next sublist
        while((j == null || !j.hasNext()) && i.hasNext()){
            j = i.next().iterator();
        }
        return j != null && j.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */


