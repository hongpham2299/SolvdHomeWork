package hotelProject;

public class CustomLinkedList <T> {

    private Node head;
    private Node tail;

    class Node {
        private T value;
        private Node next;

        private Node (T value){
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void addFirst(T val){
        if(isEmpty()){
            head = new Node(val);
            tail = head;
            return;
        }
        Node newNode = new Node(val);//this is case is not empty
        newNode.next = head;//the new node will point to the head
        head = newNode;// now the new node will become a head
    }

    public void addLast(T val){
        if(isEmpty()){
            head = new Node(val);
            tail = head;
            return;
        }
        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;

    }

    public void addAtGivenPosition (int pos, T val){
        if(pos == 1){
            addFirst(val);
            return;
        }
        Node nodeToBeInserted = new Node(val);
        Node node = head;
        for(int i=0; i<pos - 1; i++){
            node = node.getNext();
        }
        nodeToBeInserted.setNext(node.getNext());
        node.setNext(nodeToBeInserted);

    }

    public boolean isEmpty(){
        return head == null;
    }

    public void print(){
        Node current = head;
        while(current != null){
            System.out.println(current.value + " ");
            current = current.next;//move to next node
        }
    }
}
