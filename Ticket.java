public class Ticket implements Comparable<Ticket> {
    private int _id;
    private boolean _solved;
    private int _priority;
    private String _name;
    private String _problem;
    private String _solution;
    public Ticket(int id, String name, int priority, String problem) {
        _name = name;
        _id = id;
        _priority = priority;
        _problem = problem;
        _solved = false;
    }
    //the one with lower priority will have a return a lower value because the APQ works in Minimum first order
    public int compareTo(Ticket other) {
        return this._priority - other.getPriority();
    }
    public int getPriority() {
        return _priority;
    }
    public String getProblem() {
        return _problem;
    }
    public String getSolution() {
        return _solution;
    }
    public boolean isSolved() {
        return _solved;
    }
    public int getId() {
        return _id;
    }
    public String getName() {
        return _name;
    }

    public void close(String s, boolean solved) {
        _solution = s;
        _solved = solved;
    }
}
