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

    private void bstRemove(K key) {
      RBTNode<K,V> node = search(key);
      bstRemoveNode(node);
   }

   private void bstRemoveNode(RBTNode<K,V> node) {
      if (node == null) {
         return;
      }

      // Case 1: Internal node with 2 children
      if (node.left != null && node.right != null) {
         RBTNode<K,V> successorNode = node.right;
         while (successorNode.left != null) {
            successorNode = successorNode.left;
         }

         K successorKey = successorNode.key;
         V successorValue = successorNode.value;
         bstRemoveNode(successorNode);

         node.key = successorKey;
         node.value = successorValue;
      }
      
      else if (node == root) {
         if (node.left != null) {
            root = node.left;
         }
         else {
            root = node.right;
         }
        
         if (root != null) {
            root.parent = null;
         }
      }
      
      else if (node.left != null) {
         node.parent.replaceChild(node, node.left);
      }

      // Case 4: Internal with right child OR leaf
      else {
         node.parent.replaceChild(node, node.right);
      }
   }
   
   public boolean isNullOrBlack(RBTNode<K,V> node) {
      if (node == null) {
         return true;
      }
      return node.isBlack();
   }
   
   public boolean isNotNullAndRed(RBTNode<K,V> node) {
      if (node == null) {
         return false;
      }
      return node.isRed();
   }

   private void prepareForRemoval(RBTNode<K,V> node) {
      if (tryCase1(node)) {
         return;
      }

      RBTNode<K,V> sibling = node.getSibling();
      if (tryCase2(node, sibling)) {
         sibling = node.getSibling();
      }
      if (tryCase3(node, sibling)) {
         return;
      }
      if (tryCase4(node, sibling)) {
         return;
      }
      if (tryCase5(node, sibling)) {
         sibling = node.getSibling();
      }
      if (tryCase6(node, sibling)) {
         sibling = node.getSibling();
      }

      sibling.setColor(node.parent.color);
      node.parent.setColor(RBTNode.Color.BLACK);
      if (node == node.parent.left) {
         sibling.right.setColor(RBTNode.Color.BLACK);
         rotateLeft(node.parent);
      }
      else {
         sibling.left.setColor(RBTNode.Color.BLACK);
         rotateRight(node.parent);
      }
   }
   
   public boolean removeKey(K key) {
      RBTNode<K,V> node = search(key);
      if (node != null) {
         removeNode(node);
         return true;
      }
      return false;
   }

   private void removeNode(RBTNode<K,V> node) {
      if (node.left != null && node.right != null) {
         RBTNode<K,V> predecessorNode = node.getPredecessor();
         K predecessorKey = predecessorNode.key;
         V predecessorValue = predecessorNode.value;
         removeNode(predecessorNode);
         node.key = predecessorKey;
         node.value = predecessorValue;
         return;
      }

      if (node.isBlack()) {
         prepareForRemoval(node);
      }
      bstRemove(node.key);

      if (root != null && root.isRed()) {
         root.setColor(RBTNode.Color.BLACK);
      }
   }
   
   public RBTNode<K,V> search(K desiredKey) {
      RBTNode<K,V> currentNode = root;
      while (currentNode != null) {
         // Return the node if the key matches
         if (currentNode.key.equals(desiredKey)) {
            return currentNode;
         } else if (desiredKey.compareTo(currentNode.key) < 0) {
            currentNode = currentNode.left;
         } else {
            currentNode = currentNode.right;
         }
      }
      
      return null;
   }

   private boolean tryCase1(RBTNode<K,V> node) {
        if (node.isRed() || node.parent == null) {
            return true;
        }
        return false;
   }
   
   private boolean tryCase2(RBTNode<K,V> node, RBTNode<K,V> sibling) {
        if (sibling.isRed()) {
            node.parent.setColor(RBTNode.Color.RED); 
            sibling.setColor(RBTNode.Color.BLACK);
            if (node == node.parent.left) {
                rotateLeft(node.parent);
            }
            else {
                rotateRight(node.parent);
            }
            return true;
        }
        return false;
   }
   
   private boolean tryCase3(RBTNode<K,V> node, RBTNode<K,V> sibling) {
        if (node.parent.isBlack() && sibling.areBothChildrenBlack()) {
            sibling.setColor(RBTNode.Color.RED);
            prepareForRemoval(node.parent);
            return true;
        }
        return false; 
   }
   
   private boolean tryCase4(RBTNode<K,V> node, RBTNode<K,V> sibling) {
        if (node.parent.isRed() && sibling.areBothChildrenBlack()) {
            node.parent.setColor(RBTNode.Color.BLACK);
            sibling.setColor(RBTNode.Color.RED);
            return true;
        }
        return false;
   }
   
   private boolean tryCase5(RBTNode<K,V> node, RBTNode<K,V> sibling) {
        if (isNotNullAndRed(sibling.left)) {
            if (isNullOrBlack(sibling.right)) {
                if (node == node.parent.left) {
                    sibling.setColor(RBTNode.Color.RED);
                    sibling.left.setColor(RBTNode.Color.BLACK);
                    rotateRight(sibling);
                    return true;
                }
            }
        }
        return false; 
   }
   
   private boolean tryCase6(RBTNode<K,V> node, RBTNode<K,V> sibling) {
        if (isNullOrBlack(sibling.left)) {
            if (isNotNullAndRed(sibling.right)) {
                if (node == node.parent.right) {
                    sibling.setColor(RBTNode.Color.RED);
                    sibling.right.setColor(RBTNode.Color.BLACK);
                    rotateLeft(sibling);
                    return true;
                }
            }
        }
        return false; 
   }
}


