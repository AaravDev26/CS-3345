import java.util.EmptyStackException; // needed to throw exception if pop or peek is called when stack is empty 

class ListStack implements BKStack // class uses the BKStack interface, implements stack as a linked list
{
    private class Node // node class within ListStack class used for linked list implementation
    {
        double value; // value which node holds
        Node next; // points to next node

        public Node(double value) // default node constructor
        {
            this.value = value;
        }
    }

    private Node head; // head of linked list (same as top of stack)
    private int size; // size of linked list

    public ListStack() // default ListStack constructor
    {
        head = null; // sets head as null to begin
        size = 0; // initial size is zero
    }

    @Override // overriding base class method
    public void push(double value) // pushes value onto stack
    {
        Node newNode = new Node(value); // makes new node with parameter as its value
        newNode.next = head; // sets current head as the node after the created node
        head = newNode; // sets created node as head to push it to the top of the stack
        size++; // increasing the size variable by 1 when pushing onto stack
    }

    @Override // overriding base class method
    public double pop() throws EmptyStackException // returns value at top of stack and removes that value 
    {
        // throws exception if stack is empty
        if (isEmpty()) 
        {
            throw new EmptyStackException();
        }
        double value = head.value; // holds value in a temporary variable
        head = head.next; // removes value at top
        size--; // decreasing the size variable by 1 when popping off stack
        return value; // returns value at top which was stored in a temporary variable
    }

    @Override // overriding base class method
    public double peek() throws EmptyStackException // returns value at top of stack
    {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return head.value; // returns head of linked list (same as top of stack)
    }

    @Override // overriding base class method
    public boolean isEmpty()  // checks if stack is empty
    {
        return head == null; // checks by seeing if head is null
    }

    public int count() // Returns the number of elements in the stack
    {
        return size; // returns size variable
    }
    
}
