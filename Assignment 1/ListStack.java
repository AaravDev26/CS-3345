import java.util.EmptyStackException; // needed to throw exception if pop or peek is called when stack is empty
import java.util.Iterator; // needed to implement iterator

class ListStack implements BKStack, Iterable<Double> // class uses the BKStack interface, implements stack as a linked list, also implements iterable to make class iterable
{
    private class Node // node class within ListStack class used for linked list implementation
    {
        double value; // value which node holds
        Node next; // points to next node

        public Node(double d) // default node constructor
        {
            this.value = d;
        }
    }

    private Node head; // head of linked list (same as top of array)

    public ListStack() // default ListStack constructor
    {
        head = null; // sets head as null to begin
    }

    @Override // overriding base class method
    public void push(double value) // pushes value onto stack
    {
        Node newNode = new Node(value); // makes new node with parameter as its value
        newNode.next = head; // sets current head as the node after the created node
        head = newNode; // sets created node as head to push it to the top of the stack
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

    public Iterator<Double> iterator() // used for iteration over list
    {
        return new ListStackIterator();
    }

    private class ListStackIterator implements Iterator<Double> // uses iterator with double, as stack holds doubles
    {
        private Node current = head; // current node, initially set to head to start at front of linked list

        public boolean hasNext() // checks to see if current node has a next node
         {
            return current != null; // checks if current node is null
        }

        public Double next() // goes to next node and returns current value
        {
            if (!hasNext()) // if there is no next node, exception is thrown
            {
                throw new EmptyStackException(); // throws exception
            }
            double item = current.value; // holds current value 
            current = current.next; // goes to next node
            return item; // returns value
        }
    }

    public int count() // method to count number of elements in stack
    {
        int ans = 0; // temporary variable to hold number of elements
        for(double d: this) // using enhanced for loop to iterate over the stack, able to use enhanced for loop because the class is iterable
        {
            ans++; // incrementing count variable by 1
        } 
        return ans; // returning answer
    }
}
