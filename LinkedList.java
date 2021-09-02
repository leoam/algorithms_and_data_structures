public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        return this.size;
    }

    public void insertFirst(Object data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    public Node deleteFirst() {
        if (this.head != null) {
            Node temp = this.head;
            this.head = this.head.next;
            this.size--;
            return temp;
        } else {
            return null;
        }
    }

    /*
    public static void main(String[] args) {
        // Create an empty linked list
        LinkedList linked_list = new LinkedList();

        // Insert some elements in the list
        linked_list.insertFirst(3);
        linked_list.insertFirst(8);
        linked_list.insertFirst(9);
        linked_list.insertFirst(1);

        // Get and print the size of the list.
        // It should match the number of elements we inserted
        int size = linked_list.size();

        System.out.println(size);
    }
    */
}
