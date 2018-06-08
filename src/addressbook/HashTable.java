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
public class HashTable {

    // EL: Hash table data structure and initial size
    private final static int TABLE_SIZE = 13;
    private final Node[] table;
    private Person person;
    private String key;
    
    // EL: Initialize hash table
    HashTable() {
        table = new Node[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }
    
    /**
     * Hash Method
     * 
     * @param key
     * @return 
     */
    public int hashMethod(String key) {
        int hash = key.hashCode() % TABLE_SIZE;
        return hash < 0 ? hash + TABLE_SIZE : hash;
    }
    
    // EL: Source: 
    // https://stackoverflow.com/questions/9335169/understanding-strange-java-hash-function
    
    /**
     * * REFERENCE: JAVA SOURCE CODE *
     * 
     * Applies a supplemental hash function to a given hashCode, which defends
     * against poor quality hash functions. This is critical because HashMap
     * uses power-of-two length hash tables, that otherwise encounter collisions
     * for hashCodes that do not differ in lower bits. Note: Null keys always
     * map to hash 0, thus index 0.
     */
    private int getSupplementalHash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
        
    /**
     * Insert a node into the hash table
     * 
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param phoneNumber 
     */
    public void insertNode(String firstName, String lastName, String emailAddress, String phoneNumber) {
        
        // EL: Person object to add to hash table
        person = new Person(firstName, lastName, emailAddress, phoneNumber);
        
        // EL:  Hash bucket
        int personHash = hashMethod(person.getFullName());
        int hash = getSupplementalHash(personHash);
        
        // EL: node value to insert or update
        final Node node = new Node(person.getFullName(), person);
        
        if(table[hash] == null) {
            // EL: add and entry to the hash table
            table[hash] = node;
            System.out.println("Added " + person.getFirstName() + " " + person.getLastName()+ ". Email: " + person.getEmailAddress());
        } else {
            // EL: If there is already an entry at current hash
            // position, add entry to the hash table.
            Node temp = table[hash];
            while(temp.getNextNode() != null) {
                temp = temp.getNextNode();
            }
            temp.setNextNode(node);
            System.out.println("Added " + person.getFirstName() + " " + person.getLastName()+ ". Email: " + person.getEmailAddress());
        }
        
    }

    /**
     * EL: For all insertions, deletions, and look­ups, the suggestion is to 
     * apply an upper case function to convert all letters in both the first 
     * and last name to upper case and concatenate to form a single name string.
     * 
     * @param firstName
     * @param lastName
     * @return 
     */
    public String findKey(String firstName, String lastName) {
        key = firstName.toUpperCase() + lastName.toUpperCase();
        return key;
    }
        
    /**
     * Look up node in the hash table
     * 
     * @param firstName
     * @param lastName
     * @return 
     */
    Person lookupNode(String firstName, String lastName) {
        
        // EL: Match bucket with key
        key = findKey(firstName, lastName);
        
        // EL:  Hash bucket
        int personHash = hashMethod(key);
        int hash = getSupplementalHash(personHash);
        
        if (table[hash] == null) {
            return null;
        } else {
            Node tempNode = table[hash];
            
            // EL: find hash bucket
            while ((tempNode != null) && ((tempNode.getValue().getFullName()).hashCode() != key.hashCode())) {
                tempNode = tempNode.getNextNode();
            }
            if (tempNode == null) {
                // EL: if node is empty, then nothign found
                System.out.println("Nothing found. Key:" + key);
                return null;
            } else {
                System.out.println("Found: " + tempNode.getValue().getFirstName() + " " + tempNode.getValue().getLastName());
                return tempNode.getValue();
            }
        }

    }
    
    /**
     * Delete a node from the hash table
     * 
     * @param firstName
     * @param lastName 
     */
    public void deleteNode(String firstName, String lastName) {
        
        // EL: Match bucket with key and delete it
        key = findKey(firstName, lastName);
         
        int personHash = hashMethod(key);
        int hash = getSupplementalHash(personHash);
         
        if(table[hash] != null) {
             
            Node deleteNode = null;
            Node temp = table[hash];
             
            // EL: Check the entry hash table match
            // for the given 'key' and delete it by pointing it to null
            while( !temp.getKey().equals(key) && temp.getNextNode() != null ) {
                deleteNode = temp;
                temp = temp.getNextNode();            
            }
             
            // EL: If'key' is found, delete it
            if ( temp.getKey().equals(key) ) {
                if (deleteNode == null) {
                    table[hash] = temp.getNextNode();
                } else {
                   deleteNode.setNextNode(temp.getNextNode()); 
                   System.out.println("Deleted: " + temp.getValue().getFirstName() + " " + temp.getValue().getLastName());
                }
            } else {
                System.out.println("Not deleted, record not found. Key:" + key);
            }
             
        } 

    }
    
    // EL: Based on code from:
    // https://github.com/ntallapa12/java_algos/blob/master/src/main/java/com/forum/java/algos/TMHashMap.java
    // http://www.algolist.net/Data_structures/Hash_table/Simple_example

}
