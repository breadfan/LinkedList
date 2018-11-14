package prod;

public class LinkedList<T> {


    public LinkedNode head;
    public LinkedNode tail;
    public int size = 0;


    public int getSize() {
        return size;
    }


    public void addfront(T elem) {         //adds el to front
        LinkedNode newNode = new LinkedNode(elem);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;     //separation head and tail, for making connection between them
            head = newNode;
        }
        ++size;
    }

    public void insertAfter(T elem, int ind) {
        if (isEmpty() || ind < -1 || ind > (size - 1))
            System.out.println("List is empty or list doesn't have this element");
        else if (ind == -1)
            addfront(elem);
        else if (ind == (size - 1))
            append(elem);
        else {
            LinkedNode n = head;
            LinkedNode newNode = new LinkedNode(elem);
            while (ind-- > 0)
                n = n.next;
            n.next.prev = newNode;
            newNode.next = n.next;
            n.next = newNode;
            newNode.prev = n;
            ++size;
        }
    }

    public void append(T elem) {       //adds el to end
        LinkedNode newNode = new LinkedNode(elem);

        if (size == 0) {
            head = newNode;     //we have one element, so head == tail
            tail = newNode;
        } else {
            newNode.prev = tail;        //newNode prev == head
            tail.next = newNode;
            tail = newNode;
        }
        ++size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T popBack() {
        if (!isEmpty()) {
            --size;
            T temp = tail.info;
            tail = tail.prev;
            tail.next = null;
            return temp;
        } else {
            System.out.println("List is empty");
            return null;
        }
    }

    public T popFront() {
        if (!isEmpty()) {
            --size;
            T temp = head.info;
            head = head.next;
            return temp;
        } else {
            System.out.println("List is empty");
            return null;
        }
    }

    public void printList() {
        LinkedNode n = head;
        while (n != null) {
            System.out.print(n.info + " ");
            n = n.next;
        }
        System.out.println();
    }


    public class LinkedNode {
        public T info;
        public LinkedNode next;
        public LinkedNode prev;

        public LinkedNode(T info) { //construct
            this.info = info;
            //prev = null;
        }


        public void setInfo(T info) {
            this.info = info;
        }

        public void setNext(LinkedNode next) {
            this.next = next;
        }

        public void setPrev(LinkedNode prev) {
            this.prev = prev;
        }

        public LinkedNode getNext() {
            return next;
        }

        public LinkedNode getPrev() {
            return prev;
        }
    }

    /*
    public static void main(String[] args){
        LinkedList LList = new LinkedList();

        LList.append(1);
        LList.addfront(0);
        LList.addfront(-9999);
        LList.insertAfter(2, 0);
        LList.printList();
        LList.insertAfter(3, -1);
        LList.printList();
        LList.insertAfter(10, 10);
        LList.popBack();
        LList.printList();

        //LList.popFront();
        //LList.printList();

        //System.out.print(LList.tail.info + " ");
        //System.out.print(LList.head.info);

    }
    */
}