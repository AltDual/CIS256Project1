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

  public void insertNodeAfter(LinkedListNode<T> currentNode, LinkedListNode<T> newNode) {
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
        return true;
      }
      previous = current;
      current = current.next;
    }
    return false;
  }

  public void removeNodeAfter(LinkedListNode<T> node) {
    if (node == null && head != null) {
      head = head.next;
      if (head == null) {
        tail = null;
      }
    } else if (node.next != null) {
      LinkedListNode<T> nextNode = node.next.next;
      node.next = nextNode;
      if (nextNode == null) {
        tail = node;
      }
    }
  }

  // Size opertaions

  public int size() {
    if (this.head == null) {
      return 0;
    }
    LinkedListNode<T> currentNode = this.head;
    int size = 0;
    while (currentNode != null) {
      size++;
      currentNode = currentNode.next;
    }
    return size;
  }

  // Traversal operations
  // Not sure what you meant by traversal opertations here, so I am just going to
  // create the print method

  public void print() {
    if (this.head == null) {
      return;
    }
    LinkedListNode<T> currentNode = this.head;
    while (currentNode != null) {
      System.out.println(currentNode.data);
      currentNode = currentNode.next;
    }
  }
}
