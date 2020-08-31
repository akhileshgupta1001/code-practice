package Practice.LinkedList;

public class Test extends  LinkedListProgram{
    public static void main (String[] args) {
/*
        LinkedListProgram.addNodeAtLast ( 20 );
        LinkedListProgram.addNodeAtLast ( 30 );
        LinkedListProgram.addNodeAtLast ( 400 );
        LinkedListProgram.addNodeAtLast ( 50 );
        LinkedListProgram.addNodeAtLast ( 60 );
        LinkedListProgram.addNodeAtLast ( 1000 );
        LinkedListProgram.addNode ( 10 );
       // LinkedListProgram.addNode ( 5 );
       // LinkedListProgram.countNode ();
       // LinkedListProgram.addNodeAtMiddle ( 55 );
       // LinkedListProgram.bubbleSort ();
       // LinkedListProgram.printList ();
*/

       //TraversingOfLinkedList.reverseOfLL();

        LinkedListProgram listProgram = new LinkedListProgram();
        listProgram.head = new LinkedListProgram.Node(5);
        listProgram.head.next = new LinkedListProgram.Node(10);
        listProgram.head.next.next = new LinkedListProgram.Node(15);
        listProgram.head.next.next.next = new LinkedListProgram.Node(20);
       // TraversingOfLinkedList.reverseOfLL();
       // TraversingOfLinkedList.reverseOfLinkedListUsingRecurison(head  );
       // LinkedListProgram.printList();
       // DeletionOfLinkedList.deleteAtFront();
       // DeletionOfLinkedList.deleteAtEnd();
       DeletionOfLinkedList.deleteAtMiddle();
       // DeletionOfLinkedList.deleteAtPosition( 3 );
        LinkedListProgram.printList();
    }
}
