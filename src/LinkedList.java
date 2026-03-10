public class LinkedList<T> {
  public LinkedListNode<T> head;
  public LinkedListNode<T> tail;

  public LinkedList() {
    this.head = null;
    this.tail = null;
  }

  public LinkedList(LinkedListNode<T> node) {
    this.head = node;
    this.tail = node;
  }

  public void append(T data) {
    LinkedListNode<T> newNode = new LinkedListNode<T>(data);
    if (tail == null) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      tail.next = newNode;
      this.tail = newNode;
    }
  }

  public void prepend(T data) {
    LinkedListNode<T> newNode = new LinkedListNode<T>(data);
    if (head == null) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.next = this.head;
      this.head = newNode;
    }
  }
  // TODO: Add insertNodeAfter, removeNode, removeNodeAfter
}
