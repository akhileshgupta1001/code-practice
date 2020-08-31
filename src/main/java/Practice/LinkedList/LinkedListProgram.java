package Practice.LinkedList;

public class LinkedListProgram {

    static Node head;

    static class Node {
        Node next;
        int data;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printList () {
        while ( head != null ) {
            System.out.print ( head.data + " " );
            head = head.next;
        }
    }

    static Node addNode (int data) {
        Node newNode = new Node ( data );
        newNode.next = head;
       return  head         = newNode;
    }

    static void addNodeAtLast (int data) {
        if ( head == null ) {
            head = new Node ( data );
            return;
        }
        Node newNode = new Node ( data );
        Node last = head;

        while ( last.next != null )
            last = last.next;

        last.next = newNode;
    }

    static int countNode () {
        return countNode ( false );
    }

    static int countNode (boolean nodeCountPrint) {
        int count = 0;
        Node node = head;
        while ( node != null ) {
            count++;
            node = node.next;
        }
        if ( nodeCountPrint )
            System.out.println ( "Todal node =" + count );
        return count;
    }

    public static Node addNodeAtMiddle (int data) {
        Node node = head;
        if ( node == null )
            node = new Node ( data );
        else {
            Node middle = new Node ( data );
            int count = countNode () / 2;

            while ( count > 1 ) {
                node = node.next;
                count--;
            }
            middle.next = node.next;
            node.next   = middle;
        }
        return node;
    }

    public  static void bubbleSort(){
        for(Node i =head; i.next!=null ; i=i.next){
            for( Node j = i.next;j != null;j=j.next){
                if(i.data > j.data){
                    int temp = i.data;
                    i.data = j.data;
                    j.data= temp;
                }
            }
        }
    }

}
