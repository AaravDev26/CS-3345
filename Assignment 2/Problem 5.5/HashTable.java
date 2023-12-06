public class HashTable // implements hash table with separate chaining
{

    private Node[] table; // Array of Nodes to hold heads of singly linked lists
    private int size; // Number of elements in hash table

    // Inner class to represent nodes in singly linked list
    private static class Node 
    {
        int key; // Key (integer value) stored in the node
        Node next; // Reference to the next node in the list

        Node(int key, Node next) 
        {
            this.key = key;
            this.next = next;
        }
    }

    public HashTable(int capacity) 
    {
        table = new Node[capacity]; // Initialize table with given capacity
        size = 0; // Initialize size to 0
    }

    public void insert(int key) 
    {
        int index = hash(key); // Compute index in table for given key
        Node head = table[index]; // Get head of list at computed index
        Node newNode = new Node(key, null); // Create new node to hold given key
        if (head == null) { // If list is empty, set new node as head
            table[index] = newNode;
        } else { // Otherwise, append new node to end of list
            while (head.next != null) {
                head = head.next;
            }
            head.next = newNode;
        }
        size++; // Increment size of hash table
    }

    public boolean contains(int key) 
    {
        int index = hash(key); // Compute index in table for given key
        Node head = table[index]; // Get head of list at computed index
        while (head != null) 
        { // Traverse list until end is reached
            if (head.key == key) 
            { // If node with given key is found, return true
                return true;
            }
            head = head.next; // Otherwise, move to next node in list
        }
        return false; // If end of list is reached and key is not found, return false
    }

    public void remove(int key) {
        int index = hash(key); // Compute index in table for given key
        Node head = table[index]; // Get head of list at computed index
        if (head == null) // If list is empty, return
        { 
            return;
        }
        if (head.key == key) // If head node has the given key, set the next node as head
        { 
            table[index] = head.next;
            size--; // Decrement size of hash table
            return;
        }
        Node prev = head; // Maintain reference to previous node in list
        Node curr = head.next; // Maintain reference to current node in list
        while (curr != null) // Traverse list until end is reached
        { 
            if (curr.key == key) // If node with given key is found, remove it from list
            { 
                prev.next = curr.next;
                size--; // Decrement size of hash table
                return;
            }
            prev = curr; // Otherwise, move to next node in list
            curr = curr.next;
        }
    }

    public int size() 
    {
        return size; // Return size of hash table
    }

    private int hash(int key) 
    {
        return key % table.length; // Compute index in table using hash function
    }
    
    public void print() // prints the hash table
    {
        for (int i = 0; i < table.length; i++) // looping through table
        {
            System.out.print("Index " + i + ": "); // index
            Node head = table[i];
            while (head != null) // printing out linked list
            {
                if (head.next != null)
                {
                    System.out.print(head.key + ", ");
                }
                else
                {
                    System.out.print(head.key);
                }
                head = head.next;
            }
            System.out.println();
        }
    }
}