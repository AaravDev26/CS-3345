public class LinkedList 
{
    private Node head; // reference to the head node
    
    // inner class for the nodes of the linked list
    private class Node 
    {
        int data;
        Node next;
        
        Node(int data) // node constructor
        {
            this.data = data;
            this.next = null;
        }
    }
    
    // constructor for creating an empty linked list with a head node
    public LinkedList() 
    {
        head = new Node(-1); // "dummy" head, not used to store actual data, used to simplify methods which deal with the beginning of the list
    }
    
    // method to return the size of the linked list
    public int size() 
    {
        int count = 0;
        Node cur = head.next; // setting current node to head (head variable is a dummy node, which is why it is set to head.next)
        while (cur != null) // traversing the list
        {
            count++; // incrementing count by 1
            cur = cur.next; // going to next node
        }
        return count;
    }
    
    // method to print the linked list
    public void printList() 
    {
        Node cur = head.next; // setting current node to head (head variable is a dummy node, which is why it is set to head.next)
        while (cur != null) 
        {
            System.out.print(cur.data + " "); // prints data with a space in between
            cur = cur.next; // going to next node
        }
        System.out.println(); // next line
    }
    
    // method to test if a value x is contained in the linked list
    public boolean contains(int x) 
    {
        Node cur = head.next; // setting current node to head (head variable is a dummy node, which is why it is set to head.next)
        while (cur != null) 
        {
            if (cur.data == x) 
            {
                return true;
            }
            cur = cur.next; // going to next node
        }
        return false;
    }
    
    // method to add a value x if it is not already contained in the linked list
    public void add(int x) 
    {
        Node cur = head.next; // setting current node to head (head variable is a dummy node, which is why it is set to head.next)
        Node prev = head;
        while (cur != null) 
        {
            if (cur.data == x) 
            {
                return; // value already exists in the list
            }
            prev = cur;
            cur = cur.next;
        }
        // value does not exist in the list, so add it at the end
        Node newNode = new Node(x);
        prev.next = newNode;
    }
    
    // method to remove a value x if it is contained in the linked list
    public void remove(int x) 
    {
        Node cur = head.next; // setting current node to head (head variable is a dummy node, which is why it is set to head.next)
        Node prev = head; // previous node
        while (cur != null) 
        {
            if (cur.data == x) {
                prev.next = cur.next; // remove the node by updating the previous node's next reference
                return;
            }
            prev = cur;
            cur = cur.next; // going to next node
        }
    }
}