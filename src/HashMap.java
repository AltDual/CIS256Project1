class Item<K, V> {
  public K key;
  public V value;
  public Item<K, V> next;

  Item(K itemKey, V itemValue) {
    key = itemKey;
    value = itemValue;
    next = null;
  }
}

public class HashMap<K, V> {
  private Item<K, V>[] table;

  public HashMap(int capacity) {
    table = (Item<K, V>[]) new Object[capacity];
  }

  public HashMap() {
    this(11);
  }

  protected int hash(K key) {
    long keyHash = key.hashCode();
    if (keyHash < 0) {
      keyHash += 2147483648L;
    }

    return (int) keyHash;
  }

  public boolean insert(K key, V value) {
    int index = hash(key) % table.length;
    Item<K, V> item = table[index];
    Item<K, V> previous = null;
    while (item != null) {
      if (key.equals(item.key)) {
        item.value = value;
        return true;
      }
      previous = item;
      item = item.next;
    }

    if (table[index] == null) {
      Item<K, V> i = new Item<K, V>(key, value);
      table[index] = i;
    } else {
      previous.next = new Item<K, V>(key, value);
    }
    return true;
  }

  public boolean remove(K key) {
    int index = hash(key) % table.length;
    Item<K, V> item = table[index];
    Item<K, V> previous = null;

    while (item != null) {
      if (key.equals(item.key)) {
        if (previous == null) {
          table[index] = item.next;
        } else {
          previous.next = item.next;
        }
        return true;
      }
      previous = item;
      item = item.next;
    }
    return false;
  }

  public V search(K key) {
    int index = hash(key) % table.length;

    Item<K, V> item = table[index];
    while (item != null) {
      if (key.equals(item.key)) {
        return item.value;
      }
      item = item.next;
    }
    return null;
  }
}
