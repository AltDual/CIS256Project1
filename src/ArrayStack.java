public class ArrayStack<T> {
  private T[] stack;
  private int length;
  private int maxLength;

  public ArrayStack() {
    this(-1);
  }

  public ArrayStack(int maximumLength) {
    stack = (T[]) new Object[1];
    length = 0;
    maxLength = maximumLength;
  }

  public int getLength() {
    return length;
  }

  public int getMaxLength() {
    return maxLength;
  }

  public boolean push(T item) {
    if (length == maxLength) {
      return false;
    }

    if (length == stack.length) {
      resize();
    }
    stack[length] = item;
    length++;
    return true;
  }

  public T pop() {
    length--;
    return stack[length];
  }

  public T peek() {
    return stack[stack.length - 1];
  }

  private void resize() {
    T[] newArray = (T[]) new Object[stack.length * 2];
    for (int i = 0; i < length; i++) {
      newArray[i] = stack[i];
    }
    stack = newArray;
  }

}
