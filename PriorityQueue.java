public interface PriorityQueue<T> {
    void add (T c);
    boolean isEmpty();
    T peekMin();
    T popMin();
}
