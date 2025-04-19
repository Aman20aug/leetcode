package LinkedList;

public class Linkedlist {

    static Node<String> head;

    public static void main(String[] args) {
        Linkedlist linkedlist = new Linkedlist();
        linkedlist.addNode("hello");
        linkedlist.addNode("world");
        linkedlist.addNode("Aman");
        linkedlist.addNode("deep");
        linkedlist.addNode("Singh");
        linkedlist.print();
        System.out.println("=======reverse=====");
        linkedlist.reverse();
        linkedlist.print();
        System.out.println("=======delete====");
        linkedlist.reverse();
        linkedlist.delete("Aman");
        linkedlist.print();
        System.out.println("=======addTop====");
        linkedlist.addTop("TopValue");
        linkedlist.print();

    }

    // add node in the beginning
    private void addTop(String value) {
        if (head == null) {
            head = new Node<>(value);
            return;
        }
        Node<String> addNode = new Node<>(value);
        addNode.setNext(head);
        head = addNode;
    }

    //add a node
    private void addNode(String value) {
        if (head == null) {
            head = new Node<>(value);
            return;
        }
        Node<String> curr = head;
        while (curr.getNext() != null) curr = curr.getNext();
        curr.setNext(new Node<>(value));
    }

    //print all the nodes
    private void print() {
        if (head == null) return;
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.getVal());
            curr = curr.getNext();
        }
    }

    //delete a node
    private void delete(String val) {
        if (head == null) return;
        if (head.getVal().equalsIgnoreCase(val)) {
            head = head.getNext();
            return;
        }
        Node<String> curr = head;
        while (curr.getNext() != null) {
            if (curr.getNext().getVal().equalsIgnoreCase(val)) {
                curr.setNext(curr.getNext().getNext());
                return;
            }
            curr = curr.getNext();
        }
    }

    private void reverse(){
        if (head == null) return;

        Node curr=head;
        Node prev = null,next=null;
        while (curr !=null){
            next=curr.getNext();
            curr.setNext(prev);
            prev=curr;
            curr=next;
        }
        head=prev;
    }

}

class Node<T> {
    private T val;
    private Node<T> next;

    public T getVal() {
        return val;
    }

    public Node(T val) {
        this.val = val;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}