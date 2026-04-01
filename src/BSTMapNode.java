public class BSTMapNode<K extends Comparable<K>, V> {
  public K key;
  public V value;
  public BSTMapNode<K, V> left;
  public BSTMapNode<K, V> right;
  public BSTMapNode<K, V> parent;

  public BSTMapNode(K nodeKey, V nodeValue) {
    key = nodeKey;
    value = nodeValue;
    left = null;
    right = null;
    parent = null;
  }

  public BSTMapNode(K nodeKey, V nodeValue, BSTMapNode<K, V> leftChild, BSTMapNode<K, V> rightChild,
      BSTMapNode<K, V> nodeParent) {
    key = nodeKey;
    value = nodeValue;
    left = leftChild;
    right = rightChild;
    parent = nodeParent;
  }
}
