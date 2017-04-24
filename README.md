# Beemo
Gilvir Gill, Jenny Han, Maria Acuna

## Design:

Tickets: Each ticket has an id, name, priority, and then a problem, solution, and status attached to it. The lower the number on the priority, the lower it's compareTo() value, the closer it is to the top of the PriorityQueue. It also has get() methods for all of those previously listed values, aswell as modifiers for solution and status

PriorityQueue: The PriorityQueue, called "tickets" inside the HelpDesk class, is made with an array in Max->Min order via its comparables. Elements are peek()'d and pop()'d from the end, to garuntee O(1) runtime for both operations, which are more frequently used in HelpDesk class. Elements are add()'d to maintain order from right to left. By using a linear insertion, newer elements with the same comparable value are inserted to the right of older ones always, garunteeing fifo-ness.

Desk: The desk has the openTicket() method, which prompts the user for information through the console using System.in and Scanner (which is used in the style of a more complicated Iterable). It also has a closeTicket() method, which modifies the solution and solvedness of the ticket in the front of the queue, which had to have been the last one that was dealt with in the doTicket() method, which prompts the user of basic information and then calls closeTicket() once they have been called.

### Additional Features:

The HelpDesk also features a linkedlist which is used as an archive 
