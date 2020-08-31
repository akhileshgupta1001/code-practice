package Practice.LinkedList;

public class DeletionOfLinkedList extends  LinkedListProgram {

    public static  void deleteAtFront(){
        Node temp = head;
         head =head.next;
         LinkedListProgram.printList();
    }
    public static void deleteAtEnd(){
        Node node = null;
        Node temp = head;
        while (temp.next != null){
            node = temp;
            temp = temp.next;
        }
        node.next = null;

    }

    public  static  void deleteAtMiddle(){
        int middle = LinkedListProgram.countNode()/2;
        Node prev = head , nextNode ;

        while(middle>1){
            middle--;
            prev = prev.next;
        }
        nextNode=prev.next;
        prev.next=nextNode.next;
    }

    public  static void deleteAtPosition(int position){

        Node node = head;
        if(position ==1){
            head = head.next;
            return;
        }
        for(int i = 0;i<position-2;i++){
            node = node.next;
        }
        Node nextNode=node.next;
        node.next=nextNode.next;

    }
}
