public class ListQueue<T> extends LinkedList<T> {
  public ListQueue() {
    super();
  }

  public ListQueue(LinkedListNode<T> node) {
    super(node);
  }

  public void enqueue(T data) {
    super.append(data);
  }

  public T dequeue() {
    T data = head.data;
    this.head = head.next;
    if (head == null) {
      tail = null;
    }
    return data;
  }

  public T peek() {
    return head.data;
  }

  public boolean isEmpty() {
    if (head == null && tail == null) {
      return true;
    }
    return false;
  }

}
