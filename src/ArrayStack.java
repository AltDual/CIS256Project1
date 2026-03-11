public class ArrayStack<T> {
  private T[] stack;
  private int length;
  private int maxLength;

  public ArrayStack() {
    this(-1);
  }

  public ArrayStack(int maximumLength) {
    stack = new T[1];
    length = 0;
    maxLength = maximumLength;
  }

}
