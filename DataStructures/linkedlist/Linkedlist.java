package DataStructures.linkedlist;

public class Linkedlist {

    private Node head;
    private Node tail;
    private int size;

    public class Node {
        public int data;
        public Node next;
    
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Linkedlist(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty(){
         return size == 0;
    }

    public void printList(){
        if(!isEmpty()) {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.print("NULL\n");
            return;
        }
        System.out.println("The list is empty");
    }

    public void Prepend(int data) {
         Node newNode = new Node(data);
         if(isEmpty()) {
            head = newNode;
            tail = newNode;
         }else {
            newNode.next = head;
            head = newNode;
         }
         size++;
    }

    public void Append(int data) {
         Node newNode = new Node(data);
         if(isEmpty()) {
              head = newNode;
              tail = newNode;
         }else {
            tail.next = newNode;
            tail = newNode;
         }
         size++;
    }

    public Node removeFirst(){
        if(isEmpty()) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        size--;
        if(isEmpty()) {
            tail = null;
        }
        return temp;
    }

    public Node removeLast(){
        if(isEmpty()) return null;
        Node temp = head;
        Node prev = head;

        while(temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        tail = prev;
        tail.next = null;
        size--;
        if(isEmpty()) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node remove(int index) {
        if(index < 0 || index > size) return null;

        if(index == 0) {
            Node removed = get(0);
            removeFirst();
            size--;
            return removed;
        }

        if(index == size - 1) {
            Node removed = get(size);
            removeLast();
            size--;
            return removed;
        }
        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;

        size--;

        return temp;
    }

    public Node get(int index) {
        int trackPos = 0;

        if(isEmpty()) return null;
        if(index == 0)  return head;
        if(index == size) return tail;
        
        Node temp = head;
        while(temp != null) {
            if(trackPos == index) {
                return temp;
            }
            temp = temp.next;
            trackPos++;
        }
        return null;
    }

    public boolean set(int index , int data) {
        Node temp = get(index);
        if(temp == null) {
            return false;
        }
        else {
            temp.data = data;
            return true;
        }
    }

    public boolean insert(int index , int data) {
        if(index < 0 || index > size) return false;

        if(index == 0) {
           Prepend(data);
           return true;
        }

        if(index == size) {
            Append(data);
            return true;
        }

        Node newNode = new Node(data);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode; 
        size++;

        return true;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;

        for(int i = 0 ; i < size ; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
} 
