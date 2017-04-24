import java.util.Scanner;
//import java linkedlist as an archive
import java.util.List;
import java.util.LinkedList;
public class HelpDesk {
    //actual tickets
    private PriorityQueue<Ticket> tickets;
    //archive of tickets, could be any datatype
    private List<Ticket> archive;
    private int tick_count;
    public HelpDesk() {
        tickets = new ArrayPriorityQueue<Ticket>();
        archive = new LinkedList<Ticket>();
        tick_count= 0;
    }

    public boolean isEmpty() {
        return tickets.isEmpty();
    }
    public void openTicket() {
        //generate an id: just have it be an integer
        int id = (++tick_count);
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

    //close a ticket, specify the message to close it with. Closing it effectively means take them off the queue, and store it in another priority queue
    public void closeTicket(String solution, boolean isSolved) {
        Ticket ticket = tickets.popMin();
        //set the tickets solution to whatever it was, and state whether it was solved or not.
        ticket.close(solution, isSolved);
        //now, you can add it to the list containing the closed tickets
        archive.add(ticket);

    }

    //answer a ticket and close it when done
    public void doTicket() {
        Ticket ticket = tickets.peekMin();
        String problem = ticket.getProblem().toLowerCase();
        //if it isn't a computer problem, then wrong place.
        if ((problem.indexOf("pc") == -1) && (problem.indexOf("computer") == -1) && (problem.indexOf("mac") == -1)) {
            System.out.println("Dear " + ticket.getName() + ", we cannot solve your problem. Sorry");
            closeTicket("Not a computer problem, can't fix", false);
            return;
        }
        //if their computer is working, great job problem solved
        if (YoN("Is your computer working, "+ ticket.getName())) {
            closeTicket("Computer is functional", true);
        }
        //if not, have them turn it on and off again
        else if (!YoN("Have you tried turning it on and off again or ensuring it's plugged in")) {
            System.out.println("Try that");
            //restart the question loop
            doTicket();
            return;
        }
        else {
            System.out.println("Sorry, we can't help you any further.");
            closeTicket("Too complicated", false);
        }
        System.out.println("Thanks, come again!");

    }



    //USER INPUT METHODS
    //returns the thing the user typed in
    public String promptWord(String s) {
        System.out.print(s+": ");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextLine()) {
        }
        System.out.print("\n");
        //this just gets their first name
        return sc.nextLine();

    }
    //gets an int
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
        String ans = promptWord(s).toLowerCase();
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

        //now that you have your tickets, do them until the priority queue is empty
        while (!desk.isEmpty()) desk.doTicket();
    }

}
