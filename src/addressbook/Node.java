/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

/**
 *
 * @author el
 */
public class Node {
    
    private Node nextNode;
    private Node rightNode;
    private Node leftNode;
    
    private String key;
    private Person value;

    /**
     * El: Default Constructor for hash table
     * 
     * @param key
     * @param value 
     */
    Node(String key, Person value) {
        this.key = value.getFullName();
        this.value = value;
        this.nextNode = null;
    }    

    /**
     * EL: Default constructor for binary tree
     * 
     * @param value 
     */
    Node(Person value) {
        this.value = value;
        leftNode = null;
        rightNode = null;
    }

    /**
     * EL: Constructor for deletions in binary tree
     */
    Node() {
        value = null;
        leftNode = null;
        rightNode = null;
    }
    
    // EL: Getters and Setters
    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }    
    
    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Person getValue() {
        return value;
    }

    public void setValue(Person value) {
        this.value = value;
    }    

    public String getKey() {
        return key;
    }
 
    public void setKey(String key) {
        this.key = key;
    }    
   
    /**
     * Delete a value in binary tree
     * 
     * @param key
     * @param node
     * @return 
     */
    Boolean deleteValue(String key, Node node) {
        // EL: delete recursively
        if (key.compareTo(value.getFullName()) == 0) {
            // EL: node with no children
            if (leftNode != null && rightNode != null) {
                return rightNode.deleteValue(key, this);
    
            } else if (node.leftNode == this) {
                // EL: left node has exactly one child. Point to null to delete it
                node.leftNode = leftNode != null ? leftNode: rightNode;
                System.out.println("Deleted: " + value.getFirstName() + " " + value.getLastName() + ". Key:" + key);
                return true;
                
            } else if (node.rightNode == this) {
                // EL: left node has exactly one child. Point to null to delete it
                node.rightNode = leftNode != null ? leftNode : rightNode;
                System.out.println("Deleted: " + value.getFirstName() + " " + value.getLastName() + ". key:" + key);
                return true;
                
            }
        } else if (key.compareTo(value.getFullName()) < 0) {
            // EL: search left side
            if (leftNode != null) {
                return leftNode.deleteValue(key, this);
                
            } else {
                System.out.println("Not deleted, record not found. Key:" + key);
                return false;
                
            }
        } else {
            // EL: search right side
            if (rightNode != null) {
                return rightNode.deleteValue(key, this);
            } else {
                System.out.println("Not deleted, record not found. Key:" + key);
                return false;
                
            }
        }

        System.out.println("Not deleted, record not found. Key:" + key);
        return false;
    } 

}
