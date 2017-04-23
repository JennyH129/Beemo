public class Ticket implements Comparable<Ticket> {
    private String _id;
    private boolean _solved;
    private int _priority;
    private String _name;
    private String _problem;
    private String _solution;
    public Ticket(String id, String name, int priority, String problem) {
        _name = name;
        _id = id;
        _priority = priority;
        _problem = problem;
    }
    //the one with lower priority will have a return a lower value because the APQ works in Minimum first order
    public int compareTo(Ticket other) {
        return this._priority - other.getPriority();
    }
    public int getPriority() {
        return _priority;
    }
}
