import DataStructures.linkedlist.Linkedlist;

public class Main {
    public static void main(String[] args) {
      Linkedlist list = new Linkedlist();

      list.Append(3);
      list.Append(1);
      list.Append(2);
      list.printList();
      list.Prepend(55);
      list.printList();
      list.Prepend(85);
      list.Append(95);
      list.printList();
      
      list.reverse();
      list.printList();

   }
}