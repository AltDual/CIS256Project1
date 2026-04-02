public class AVLNode<K extends Comparable<K>,V> extends BSTMapNode<K,V> {
    public int height;
    public AVLNode<K,V> left;
    public AVLNode<K,V> right;
    public AVLNode<K,V> parent;
    public AVLNode(K key, V value){
        super(key, value);
        height = 0;
    }
    
    public AVLNode(K nodeKey, V nodeValue, AVLNode<K, V> leftChild, AVLNode<K, V> rightChild, AVLNode<K, V> nodeParent) {
        super(nodeKey, nodeValue, leftChild, rightChild, nodeParent);
        height = 0;
    }

    public boolean replaceChild(AVLNode<K,V> currentChild, AVLNode<K,V> newChild) {
        if (left == currentChild) {
            left = newChild;
            return true;
        }
        else if (right == currentChild) {
            right = newChild;
            return true;
        }
        
        return false;
    }

    public int getBalance() {
        int leftHeight = -1;
        if (left != null) {
            leftHeight = left.height;
        }
                
        int rightHeight = -1;
        if (right != null) {
            rightHeight = right.height;
        }
                
        return leftHeight - rightHeight; 
    }

    public void updateHeight() {
        int leftHeight = -1;
        if (left != null) {
            leftHeight = left.height;
        }
                
        int rightHeight = -1;
        if (right != null) {
            rightHeight = right.height;
        }

        height = ((leftHeight > rightHeight) ? leftHeight : rightHeight) + 1;
    }
}
