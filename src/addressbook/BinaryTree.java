/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

/**
 *
 * @author EL
 */
public class BinaryTree {

    private Node root;
    private Node leftNode;
    private Node rightNode;
    
    private Person person;
    private String key;

   /**
     * Insert node to the binary tree
     * 
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param phoneNumber 
     */
    public void insertNode(String firstName, String lastName, String emailAddress, String phoneNumber) {
         
        person = new Person(firstName, lastName, emailAddress, phoneNumber);
        key = person.getFullName();
         
        // EL: There is not a root in the Binary tree, add it
        if (root == null) {
            System.out.println("Added " + person.getFirstName() + " " + person.getLastName() + ". Email: " + person.getEmailAddress() + " (as root)");
            root = new Node(person.getFullName(), person);
        } else {
            // EL: add a value under the root
            addValue(root, key, person);
            System.out.println("Added " + person.getFirstName() + " " + person.getLastName() + ". Email: " + person.getEmailAddress());
        }
         
    }

    /**
     * Look up node in the binary tree
     * 
     * @param firstName
     * @param lastName
     * @return 
     */
    Person lookupNode(String firstName, String lastName) {   
         
        key = findKey(firstName, lastName);
        person = null;
         
        if(root != null) {
            // EL: search left and right paths if binary tree has values
            person = getValue(root, key);       
        }
         
        if(person == null) {
            // EL: nothing found messsage and the key used
            System.out.println("Nothing found. Key:" + key);
        } else {
            // EL: person found message
            System.out.format("Found %s %s.\n", person.getFirstName(), person.getLastName());
        }
         
        return person;
         
    }        

    /**
     * Delete a node from binary tree
     * 
     * @param firstName
     * @param lastName
     * @return 
     */
    Boolean deleteNode(String firstName, String lastName) {
         
        // EL: key to compare and delete
        key = findKey(firstName, lastName);
 
        if (root == null) {
            // EL: tree is empty, return null
            return false;
        } else {
            // EL: TODO. If the root is the element to delete
            if (root.getValue().getFullName().compareTo(key) == 0) {
                return false;
            } else {
                // EL: delete value that matches key
                return root.deleteValue(key, null);
            }
        }
    }

    /**
     * Add values to binary tree
     * 
     * @param node
     * @param key
     * @param value 
     */
    private void addValue(Node node, String key, Person value) {
        
        // EL: find right and left nodes
        leftNode = node.getLeftNode();
        rightNode = node.getRightNode();
 
        if (key.equals(node.getKey())) {
            // EL: If 'key' equals the node, update it
            node.setValue(value);
        } else if (key.compareTo(node.getKey()) < 0) {
            // EL: if key is less than node, add it to left node
            if(leftNode == null) {
                leftNode = new Node(key, value);
                node.setLeftNode(leftNode);
            } else {
                addValue(leftNode, key, value);
            }
        } else if (key.compareTo(node.getKey()) > 0) {
            if(rightNode == null) {
                rightNode = new Node(key, value);
                node.setRightNode(rightNode);
            } else {
                addValue(rightNode, key, value);  
            }
        } else {
            System.out.println("No node added");
        }
         
    }
     
    /**
     * Get value from binary tree
     * 
     * @param node
     * @param key
     * @return 
     */
    private Person getValue(Node node, String key) {
         
        // EL: find right and left nodes
        leftNode = node.getLeftNode();
        rightNode = node.getRightNode();
         
        if (key.equals(node.getKey())) {
            // EL: If 'key' equals the node, value found
            person = node.getValue();
        } else if (key.compareTo(node.getKey()) < 0) {
            // EL: if key is less than node, search the left path
            if (leftNode != null) {
                person = this.getValue(leftNode, key);
            }
        } else if (key.compareTo(node.getKey()) > 0) {
            if (rightNode != null) {
                person = this.getValue(rightNode, key);
            }
        }
         
        return person;
         
    }        
    
    /**
     * EL: Key for insertions, deletions and look-ups
     * 
     * EL: For all insertions, deletions, and look­ups, the suggestion is to 
     * apply an upper case function to convert all letters in both the first 
     * and last name to upper case and concatenate to form a single name string.
     * 
     * @param firstName
     * @param lastName
     * @return 
     */
    private String findKey(String firstName, String lastName) {
        key = firstName.toUpperCase() + lastName.toUpperCase();
        return key;
    }
    
    // EL: Based on code from:
    // http://www.baeldung.com/java-binary-tree
    // http://www.algolist.net/Data_structures/Binary_search_tree
    
}
