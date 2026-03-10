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

  public LinkedListNode<T> search(T data) {
    LinkedListNode<T> currentNode = this.head;
    while (currentNode != null) {
      if (currentNode.data.equals(data)) {
        return currentNode;
      }
      currentNode = currentNode.next;
    }
    return null;
  }

  // All insertation operations
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

  public boolean insertAfter(T nodeData, T dataToInsert) {
    LinkedListNode<T> node = search(nodeData);
    if (node != null) {
      LinkedListNode<T> newNode = new LinkedListNode<T>(dataToInsert);
      insertNodeAfter(node, newNode);
      return true;
    }
    return false;
  }

  private void insertNodeAfter(LinkedListNode<T> currentNode, LinkedListNode<T> newNode) {
    if (head == null) {
      this.head = newNode;
      this.tail = newNode;
    } else if (currentNode == tail) {
      currentNode.next = newNode;
      this.tail = newNode;
    } else {
      newNode.next = currentNode.next;
      currentNode.next = newNode;
    }
  }

  // All removal opertaions
  public boolean removeNode(T data) {
    LinkedListNode<T> previous = null;
    LinkedListNode<T> current = this.head;

    while (current != null) {
      if (current.data.equals(data)) {
        removeNodeAfter(previous);
      }
      previous = current;
      current = current.next;
    }
    return false;
  }

  // TODO: Finish implementing method below
  public void removeNodeAfter(LinkedListNode<T> node) {

  }
}
