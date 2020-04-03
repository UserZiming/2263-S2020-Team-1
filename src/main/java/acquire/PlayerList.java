package acquire;

// @author Austin Lyman
// Code for Nodes taken from pages 126 and 127 in the book.

public class PlayerList <E> {
    private int size = 0;
    private Node head = null;
    private Node current= null;
    private Node tail = null;

    private static class Node<E>{
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }


        //returns the value
        public E getElement(){
            return element;
        }

        //goes to the next
        public Node<E> getNext(){
            return next;
        }

        //sets the value in the node
        public void setNext(Node<E> n){
            next = n;
        }
    }

    public Object first() {
        if (this.isEmpty()) {
            System.out.println("The List is empty");
            return null;
        } else {

            return head.getElement();
        }
    }

    public void addLast(Object element) {
        //creates a new node, sets the previous tail point to the new tail, and makes current tail point to new tail.
        if(this.valueNotNull(element)) {
            if (this.headExists()) {
                Node toAdd = new Node(element, null);
                tail.setNext(toAdd);
                tail = toAdd;
                tail.setNext(this.head);
                this.size++;
            } else {
                addFirst(element);
            }
        }

    }

    private void addFirst(Object element) {
        //makes a new element that points to the head, and makes it the new head
        if(this.valueNotNull(element)) {
            if (this.headExists()) {
                Node toAdd = new Node(element, this.head);
                this.head = toAdd;
            } else {
                this.head = new Node(element, this.head);
                this.tail = this.head;
            }
            this.size++;
        }

    }

    public int size() {

        return this.size;
    }

    public boolean isEmpty() {
        if (size <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void printList() {
        //goes through each value ( until it hits the null ) and prints the element

        //checks to make sure head exists
        if (head == null) {
            System.out.println("There is nothing in the list");
        } else {
            Node current = head;
            for (int i = 0; i < size; i++) {
                System.out.println(current.getElement());
                current = current.getNext();
            }

        }
    }

    private boolean sizeOk(int index){
        //returns a bool telling whether or not the list can have something inserted there.

        //checks if the index is larger than the size or less than 0
        if(index >= this.size || index < 0){
            System.out.println("List is not that big and the index and size are respective " + index + this.size);
            return false;
        }else{
            return true;
        }
    }

    private boolean headExists(){
        if(this.head != null){
            return true;
        }else{
            return false;
        }
    }

    private boolean valueNotNull(Object element){
        if(element != null){
            return true;
        }else{
            return false;
        }

    }

    public Object getNext(){
        if(this.current != null){
            this.current = this.current.getNext();
        }else{
            this.current = this.head;
        }

        return this.current;
    }
}
