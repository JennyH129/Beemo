//Team Octopi *insert octpus emoji here* -- Maria Acuna, Eric Li, Gilvir Gil
//APCS2 pd3
//HW32 -- Getting Past the Red Velvet Rope
//2017-04-19

import java.util.ArrayList;
//ensures that only comparables are used but gives full access to the generic lements so they don't need to be typecasted outside
//to stop a warning: Comparable<? super T> means that the comparable is of type T or one of it's super classes (represented by the ? placeholder).
//ie T is a subclass of a comparable that can be compared to any class that is a superclass of T
public class ArrayPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {
    private ArrayList<T> _list;
    public ArrayPriorityQueue() {
        _list = new ArrayList<T>();
    }
    public ArrayPriorityQueue(int n) {
        _list = new ArrayList<T>(n);
    }

    //O(n). Add an element to a presorted arraylist
    public void add(T c ) {
        //start from the very first element, and check to see if it is greater than or equal to the next element
        //if so, sort it
        //remember the order is MAX-->MIN
        for (int i = 0; i < _list.size(); i++) {
            //if the compareTo is non-negative, the thing being inserted is greater than or equal to. You want it inserted to the left to maintain fifo
            //if c >= i
            if (c.compareTo(_list.get(i)) >= 0) {
                //add c where i was and shift everything to the right
                _list.add(i, c);
                return;
            }
        }
        //if c is not greater than anything, then add it to the end. This accounts for the empty case aswell
        _list.add(c);
        return;
    }
    //O(1). Return if the size of the array is 0
    public boolean isEmpty() {
        return (_list.size() <= 0);
    }
    //O(1). Peek the last index, which will be the min element
    public T peekMin() {
        return _list.get(_list.size()-1);
    }
    //O(1). Pop last index, which will be the min element
    public T popMin() {
        return _list.remove(_list.size()-1);
    }
    //for testing purposes
    public String toString() {
        String ret = new String();
        for (int i = 0; i < _list.size(); i++) {
            ret+=_list.get(i).toString() + " ";
        }
        return ret;
    }
    public static void main(String [] args){
	ArrayPriorityQueue<Integer> testAPQ = new ArrayPriorityQueue<Integer>(20);
	if(testAPQ.isEmpty()){
	    System.out.println("This APQ is empty.");
	    System.out.println("Now filling....");
	}
	else{
	    System.out.println("This APQ is NOT empty.");
	    System.out.println("Now adding....");
	}
	for(int n = 10; n > 0; n--){
	    testAPQ.add((int) (Math.random()*n));
	    System.out.println(testAPQ);
	}
	System.out.println(testAPQ);
	System.out.println("The minimum value is: " + testAPQ.peekMin());
	System.out.println("Now removing minimum value...");
	testAPQ.popMin();
	System.out.println(testAPQ);
    //now test with strings for fifo.
    ArrayPriorityQueue<String> strAPQ = new ArrayPriorityQueue<String>();
    //use 3 strings:
    String str1 = new String();
    String str2 = new String();
    String str3 = new String();
    //print hex codes of each:
    str1+="a";
    str2+="a";
    str3+="c";
    System.out.println("1: "+System.identityHashCode(str1));
    System.out.println("2: "+System.identityHashCode(str2));
    System.out.println("3: "+System.identityHashCode(str3));
    strAPQ.add(str1);
    strAPQ.add(str2);
    strAPQ.add(str3);
    System.out.println(strAPQ);
    //make sure the hexcode matches:
    System.out.println("Make sure the order of the hash codes are 1, 2, 3:");
    System.out.println(System.identityHashCode(strAPQ.popMin()));
    System.out.println(System.identityHashCode(strAPQ.popMin()));
    System.out.println(System.identityHashCode(strAPQ.popMin()));
    }
}
