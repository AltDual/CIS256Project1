public class AVLMap<K extends Comparable<K>,V> extends BSTMap<K,V> {
    public AVLNode<K,V> root;
    public AVLMap() {
        super();
    }

    private void rotateLeft(AVLNode<K,V> node) {
        AVLNode<K,V> parent = node.parent;
        AVLNode<K,V> rightChild = node.right;
        AVLNode<K,V> rightLeftChild = rightChild.left;
        
        node.right = rightLeftChild;
        rightChild.left = node;
        if (parent != null) {
            parent.replaceChild(node, rightChild);
        } else {
            root = rightChild;
            root.parent = null;
        }
    }

    private void rotateRight(AVLNode<K,V> node) {
        AVLNode<K,V> parent = node.parent;
        AVLNode<K,V> leftChild = node.left;
        AVLNode<K,V> leftRightChild = leftChild.right;
        
        node.left = leftRightChild;
        leftChild.right = node;
        if (parent != null) {
            parent.replaceChild(node, leftChild);
        } else {
            root = leftChild;
            root.parent = null;
        }
    }
    
    private void rebalance(AVLNode<K,V> node) {
        node.updateHeight();

        if (node.getBalance() == -2) {
            if (node.right.getBalance() == 1) {
                rotateRight(node.right);
            }

            rotateLeft(node);
        }
        else if (node.getBalance() == 2) {
            if (node.right.getBalance() == -1) {
                rotateLeft(node.left);
            }

            rotateRight(node);
        }
    }

    public void put(K key, V value) {
        AVLNode<K, V> node = new AVLNode<K, V>(key, value);
        if (root == null) {
            root = node;
        } else {
            AVLNode<K, V> current = root;
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
        node = node.parent;
        while (node != null) {
            rebalance(node);
            node = node.parent;
        }
    }
    
    private boolean removeNode(AVLNode<K,V> nodeToRemove) {
        if (nodeToRemove == null) {
            return false;
        }
            
        AVLNode<K,V> parent = nodeToRemove.parent;
            
        if (nodeToRemove.left != null && nodeToRemove.right != null) {
            AVLNode<K,V> successorNode = nodeToRemove.right;
            while (successorNode.left != null) {
                successorNode = successorNode.left;
            }
                
            nodeToRemove.key = successorNode.key;
            nodeToRemove.value = successorNode.value; 
            removeNode(successorNode);
                
            return true;
        }
        
        else if (nodeToRemove == root) {
            if (nodeToRemove.left != null) {
                root = nodeToRemove.left;
            }
            else {
                root = nodeToRemove.right;
            }

            if (root != null) {
                root.parent = null;
            }
            
            return true;
        }
        
        else if (nodeToRemove.left != null) {
            parent.replaceChild(nodeToRemove, nodeToRemove.left);
        }
            
        else {
            parent.replaceChild(nodeToRemove, nodeToRemove.right);
        }
                
        AVLNode<K,V> nodeToRebalance = parent;
        while (nodeToRebalance != null) {
            rebalance(nodeToRebalance);         
            nodeToRebalance = nodeToRebalance.parent;
        }
        
        return true;
    }

    public boolean removeKey(K key) {
        AVLNode<K,V> node = get(key);
        if (node == null) {
            return false;
        }
        return removeNode(node);
    }

    public AVLNode<K,V> get(K key) {
        AVLNode<K, V> current = root;
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
}

