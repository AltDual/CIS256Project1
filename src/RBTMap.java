public class RBTMap<K extends Comparable<K>,V> extends BSTMap<K,V> {
    private RBTNode<K,V> root;
   
    public RBTMap() {
        root = null;
    }
    
    public void put(K key, V value) {
        RBTNode<K,V> newNode = new RBTNode<K,V>(key, value, null, true);
        insertNode(newNode);
    }
    
    private void insertNode(RBTNode<K,V> node) {
        if (root == null) {
            root = node;
        }
        else {
            RBTNode<K,V> currentNode = root;
            while (currentNode != null) {
                if (currentNode.key.equals(node.key)) {
                    currentNode.value = node.value;
                    return;
                } else if (node.key.compareTo(currentNode.key) < 0) {
                    if (currentNode.left == null) {
                        currentNode.setLeft(node);
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.setRight(node);
                        break;
                    }
                    else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }
        
        node.setColor(RBTNode.Color.RED);
        insertionBalance(node);
    }
    
    private void insertionBalance(RBTNode<K,V> node) {
        if (node.parent == null) {
            node.setColor(RBTNode.Color.BLACK);
            return;
        }
            
        if (node.parent.isBlack()) {
            return;
        }
        
        RBTNode<K,V> parent = node.parent;
        RBTNode<K,V> grandparent = node.getGrandparent();
        RBTNode<K,V> uncle = node.getUncle();
            
        if (uncle != null && uncle.isRed()) {
            parent.setColor(RBTNode.Color.BLACK);
            uncle.setColor(RBTNode.Color.BLACK);
            grandparent.setColor(RBTNode.Color.RED);
            insertionBalance(grandparent);
            return;
        }

        if (node == parent.right && parent == grandparent.left) {
            rotateLeft(parent);
            node = parent;
            parent = node.parent;
        } else if (node == parent.left && parent == grandparent.right) {
            rotateRight(parent);
            node = parent;
            parent = node.parent;
        }

        parent.setColor(RBTNode.Color.BLACK);
        grandparent.setColor(RBTNode.Color.RED);
                    
        if (node == parent.left) {
            rotateRight(grandparent);
        }
        else {
            rotateLeft(grandparent);
        }
    }
    
    private void rotateLeft(RBTNode<K,V> node) {
        RBTNode<K,V> rightLeftChild = node.right.left;
            
        if (node.parent != null) {
            node.parent.replaceChild(node, node.right);
        } else {
            root = node.right;
            root.parent = null;
        }

        node.right.setLeft(node);
            
        node.setRight(rightLeftChild);
    }
    
    private void rotateRight(RBTNode<K,V> node) {
        RBTNode<K,V> leftRightChild = node.left.right;
            
        if (node.parent != null) {
            node.parent.replaceChild(node, node.left);
        } else { 
            root = node.left;
            root.parent = null;
        }
        node.left.setRight(node);
            
        node.setLeft(leftRightChild);
    }
}

