import java.util.Scanner;
public class HelpDesk {
    private PriorityQueue<Ticket> tickets;
    private int tick_count;
    public HelpDesk() {
        tickets = new ArrayPriorityQueue<Ticket>();
        tick_count= 0;
    }


    public void openTicket() {
        //generate an id: just have it be an integer
        String id = "" + (++tick_count);
        //ticket needs the following information:

        //Ask them their name
        String name = promptWord("Enter your name");
        //priority. Ask them their priority
        int priority = promptInt("Enter your priority, " + name);

        String problem = promptWord("Enter your problem");
        //open their ticket
        tickets.add(new Ticket(id, name, priority, problem));
        //Ask if theres someone else to create another ticket
    }


    public void doTicket() {

    }



    //USER INPUT METHODS
    public String promptWord(String s) {
        System.out.print(s+": ");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext()) {
        }
        System.out.print("\n");
        return sc.next();

    }
    public int promptInt(String s) {
        System.out.print(s+": ");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid base 10 arabic numeral");
            sc.next();
        }
        return sc.nextInt();
    }
    //asks yes or no, returns true or falses
    public boolean YoN(String s) {
        String ans = promptWord(s);
        //keep prompting them until their answer contains yes or no.
        while ((ans.indexOf("yes") == -1) &&
        (ans.indexOf("no") == -1)) {
            System.out.println("Yes or no please");
            promptWord(s);
        }
        //if they said no:
        if (ans.indexOf("no") != -1) return false;
        return true;
    }

    public static void main(String[] a) {
        //open up a helpdesk
        HelpDesk desk = new HelpDesk();
        while (desk.YoN("Does someone have a ticket")) desk.openTicket();

    }

}
