package Practice.LinkedList;

public class TraversingOfLinkedList  extends LinkedListProgram{

    public  static void printLinkedListUsingRecursion(Node node) {

        if (node == null)
            return;
        else
            while (node != null) {
                System.out.print( node.data + " " );
                printLinkedListUsingRecursion( node.next );
            }
    }

    public static void reverseOfLinkedListUsingRecurison(Node node){
        if(node == null){
            return;
        }else {
            reverseOfLinkedListUsingRecurison( node.next );
            System.out.print(node.data + " ");

        }
    }

    public  static  void reverseOfLL(){

        Node previous = null ,
                current = head ,
                next = current.next;

        while (current != null){
            next = current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        head = previous;
        while (head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
}
