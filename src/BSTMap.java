public class BSTMap<K extends Comparable<K>, V> {
  public BSTMapNode<K, V> root;

  public BSTMap() {
    root = null;
  }

  public BSTMapNode<K, V> get(K key) {
    BSTMapNode<K, V> current = root;
    while (current != null) {
      if (current.key.equals(key)) {
        return current;
      } else if (key.compareTo(current.key) < 0) {
        current = current.left;
      } else {
        current = current.right;
      }
    }
    return null;
  }

  public void put(K key, V value) {
    BSTMapNode<K, V> node = new BSTMapNode<K, V>(key, value);
    if (root == null) {
      root = node;
    } else {
      BSTMapNode<K, V> current = root;
      while (current != null) {
        if (current.key.equals(key)) {
          current.value = value;
          return;
        }
        if (key.compareTo(current.key) < 0) {
          if (current.left == null) {
            current.left = node;
            node.parent = current;
            current = null;
          } else {
            current = current.left;
          }
        } else {
          if (current.right == null) {
            current.right = node;
            node.parent = current;
            current = null;
          } else {
            current = current.right;
          }
        }
      }
    }
  }

  public boolean remove(K key) {
    BSTMapNode<K, V> parent = null;
    BSTMapNode<K, V> nodeToRemove = root;
    while (nodeToRemove != null) {
      if (nodeToRemove.key.equals(key)) {
        if (nodeToRemove.left == null && nodeToRemove.right == null) {
          if (parent == null) {
            root = null;
          } else if (parent.left == nodeToRemove) {
            parent.left = null;
          } else {
            parent.right = null;
          }
          return true;
        } else if (nodeToRemove.left != null && nodeToRemove.right == null) {
          if (parent == null) {
            root = nodeToRemove.left;
          } else if (parent.left == nodeToRemove) {
            parent.left = nodeToRemove.left;
          } else {
            parent.right = nodeToRemove.left;
          }
          return true;
        } else if (nodeToRemove.left == null && nodeToRemove != null) {
          if (parent == null) {
            root = nodeToRemove.right;
          } else if (parent.left == nodeToRemove) {
            parent.left = nodeToRemove.right;
          } else {
            parent.right = nodeToRemove.right;
          }
          return true;
        } else {
          BSTMapNode<K, V> successor = nodeToRemove.right;
          while (successor.left != null) {
            successor = successor.left;
          }
          nodeToRemove.key = successor.key;
          parent = nodeToRemove;
          nodeToRemove = nodeToRemove.right;
          key = successor.key;
        }
      } else if (nodeToRemove.key.compareTo(key) < 0) {
        parent = nodeToRemove;
        nodeToRemove = nodeToRemove.right;
      } else {
        parent = nodeToRemove;
        nodeToRemove = nodeToRemove.left;
      }
    }
    return false;
  }

  public boolean contains(K key) {
    return get(key) != null;
  }
}
