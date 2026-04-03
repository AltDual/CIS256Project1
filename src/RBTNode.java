public class RBTNode<K extends Comparable<K>, V> extends BSTMapNode<K,V>{
    public enum Color {
        RED, BLACK
    }
   
    public RBTNode<K,V> parent;
    public RBTNode<K,V> left;
    public RBTNode<K,V> right;
    public Color color;

    public RBTNode(K nodeKey, V nodeValue, RBTNode<K,V> parentNode, boolean isRed, RBTNode<K,V> leftChild, RBTNode<K,V> rightChild) {
        super(nodeKey, nodeValue, leftChild, rightChild, parentNode);
        color = isRed ? Color.RED : Color.BLACK;
    }

    public RBTNode(K nodeKey, V nodeValue, RBTNode<K,V> parentNode, boolean isRed) {
        this(nodeKey, nodeValue, parentNode, isRed, null, null);
    }

    public boolean areBothChildrenBlack() {
        if (left != null && left.isRed()) {
            return false;
        }
        if (right != null && right.isRed()) {
            return false;
        }
        return true;
    }
    public int count() {
      int count = 1;
      if (left != null) {
         count += left.count();
      }
      if (right != null) {
         count += right.count();
      }
      return count;
   }
    
   public RBTNode<K,V> getGrandparent() {
      if (parent == null) {
         return null;
      }
      return parent.parent;
   }
   
   public RBTNode<K,V> getPredecessor() {
      RBTNode<K,V> node = left;
      while (node.right != null) {
         node = node.right;
      }
      return node;
   }
   
   public RBTNode<K,V> getSibling() {
      if (parent != null) {
         if (this == parent.left) {
            return parent.right;
         }
         return parent.left;
      }
      return null;
   }
   
   public RBTNode<K,V> getUncle() {
      RBTNode<K,V> grandparent = getGrandparent();
      if (grandparent == null) {
         return null;
      }
      if (grandparent.left == parent) {
         return grandparent.right;
      }
      return grandparent.left;
   }
   
   public boolean isBlack() {
      return color == Color.BLACK;
   }
   
   public boolean isRed() {
      return color == Color.RED;
   }
   
   public boolean replaceChild(RBTNode<K,V> currentChild, RBTNode<K,V> newChild) {
      if (left == currentChild) {
         setLeft(newChild);
         return true;
      }
      else if (right == currentChild) {
         setRight(newChild);
         return true;
      }
      return false;
   }
   
   public void setLeft(RBTNode<K,V> newChild) {
      left = newChild;      
      
      if (left != null) {
         left.parent = this;
      }
   }
   
   public void setRight(RBTNode<K,V> newChild) {
      right = newChild;      
      
      if (right != null) {
         right.parent = this;
      }
   }

   public void setColor(Color c) {
        color = c;
   }
}