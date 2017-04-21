public class Ticket implements Comparable<Ticket> {
    private String _id;
    private int _status;
    private int _priority;
    private String _name;
    private String _problem;
    public Ticket(String id, int priority, int name, String problem) {
        _id = id;
        _priority = priority;
        _problem = problem;
    }
    public int compareTo(Ticket other) {
        return this._priority - other.getPriority();
    }
    public int getPriority() {
        return _priority;
    }
}
