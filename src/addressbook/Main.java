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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // EL: Test Cases with the binary tree
        BinaryTree binaryTree = new BinaryTree();

        System.out.println("===== Binary tree nodes =====");
        binaryTree.insertNode("Bob", "Smith", "bsmith@somewhere.com", "555-235-1111");
        binaryTree.insertNode("Jane", "Williams", "jw@something.com", "555-235-1112");
        binaryTree.insertNode("Mohammed", "al-Salam", "mas@someplace.com", "555-235-1113");
        binaryTree.insertNode("Pat", "Jones", "pjones@homesweethome.com", "555-235-1114");
        binaryTree.insertNode("Billy", "Kidd", "billy_the_kid@nowhere.com", "555-235-1115");
        binaryTree.insertNode("H.", "Houdini", "houdini@noplace.com", "555-235-1116");
        binaryTree.insertNode("Jack", "Jones", "jjones@hill.com", "555-235-1117");
        binaryTree.insertNode("Jill", "Jones", "jillj@hill.com", "555-235-1118");
        binaryTree.insertNode("John", "Doe", "jdoe@somedomain.com", "555-235-1119");
        binaryTree.insertNode("Jane", "Doe", "jdoe@somedomain.com", "555-235-1120");

        binaryTree.lookupNode("Pat", "Jones");
        binaryTree.lookupNode("Billy", "Kidd");
        
        binaryTree.deleteNode("John", "Doe");

        binaryTree.insertNode("Test", "Case", "Test_Case@testcase.com", "555-235-1121");
        binaryTree.insertNode("Nadezhda", "Kanachekhovskaya", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru", "555-235-1122"); 
        binaryTree.insertNode("Jo", "Wu", "wu@h.com", "555-235-1123");
        binaryTree.insertNode("Millard", "Fillmore", "millard@theactualwhitehouse.us", "555-235-1124");
        binaryTree.insertNode("Bob", "vanDyke", "vandyke@nodomain.com", "555-235-1125");
        binaryTree.insertNode("Upside", "Down", "upsidedown@rightsideup.com", "555-235-1126");
        
        binaryTree.lookupNode("Jack", "Jones");
        binaryTree.lookupNode("Nadezhda", "Kanachekhovskaya");

        binaryTree.deleteNode("Jill", "Jones");
        binaryTree.deleteNode("John", "Doe");
        
        binaryTree.lookupNode("Jill", "Jones");
        binaryTree.lookupNode("John", "Doe");
        
        // EL: Test Cases with the hash table
        HashTable hashTable = new HashTable();
        
        System.out.println();
        System.out.println("===== Hash table nodes =====");
        hashTable.insertNode("Bob", "Smith", "bsmith@somewhere.com", "555-235-1111");
        hashTable.insertNode("Jane", "Williams", "jw@something.com", "555-235-1112");
        hashTable.insertNode("Mohammed", "al-Salam", "mas@someplace.com", "555-235-1113");
        hashTable.insertNode("Pat", "Jones", "pjones@homesweethome.com", "555-235-1114");
        hashTable.insertNode("Billy", "Kidd", "billy_the_kid@nowhere.com", "555-235-1115");
        hashTable.insertNode("H.", "Houdini", "houdini@noplace.com", "555-235-1116");
        hashTable.insertNode("Jack", "Jones", "jjones@hill.com", "555-235-1117");
        hashTable.insertNode("Jill", "Jones", "jillj@hill.com", "555-235-1118");
        hashTable.insertNode("John", "Doe", "jdoe@somedomain.com", "555-235-1119");
        hashTable.insertNode("Jane", "Doe", "jdoe@somedomain.com", "555-235-1120");

        hashTable.lookupNode("Pat", "Jones");
        hashTable.lookupNode("Billy", "Kidd");

        hashTable.deleteNode("John", "Doe");

        hashTable.insertNode("Test", "Case", "Test_Case@testcase.com", "555-235-1121");
        hashTable.insertNode("Nadezhda", "Kanachekhovskaya", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru", "555-235-1122"); 
        hashTable.insertNode("Jo", "Wu", "wu@h.com", "555-235-1123");
        hashTable.insertNode("Millard", "Fillmore", "millard@theactualwhitehouse.us", "555-235-1124");
        hashTable.insertNode("Bob", "vanDyke", "vandyke@nodomain.com", "555-235-1125");
        hashTable.insertNode("Upside", "Down", "upsidedown@rightsideup.com", "555-235-1126");

        hashTable.lookupNode("Jack", "Jones");
        hashTable.lookupNode("Nadezhda", "Kanachekhovskaya");

        hashTable.deleteNode("Jill", "Jones");     
        hashTable.deleteNode("John", "Doe");
   
        hashTable.lookupNode("Jill", "Jones");
        hashTable.lookupNode("John", "Doe"); 
        
    }

}
