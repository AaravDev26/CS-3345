import java.util.EmptyStackException; // needed to throw exception if pop or peek is called when stack is empty 

class ArrayStack implements BKStack // class uses the BKStack interface, implements stack as an array
{
    private final int INITIAL_CAPACITY = 10; // initial capacity of stack
    private double[] arr; // array which will act as stack
    private int top; // index of the top of the stack
    private int size; // holds the number of items in the stack

    public ArrayStack() // default constructor
    {
        arr = new double[INITIAL_CAPACITY]; // initializes stack with the initial amount of space
        top = -1; // sets top as negative 1 since stack starts empty
        size = 0;
    }

    @Override // overriding base class method
    public void push(double value) // pushes value onto stack
    {
        // resizes stack if stack is full
        if (top == arr.length - 1) // checking if stack is full
        {
            resizeArray(); // resizes stack to double to current size
        }
        arr[++top] = value; // increments index of top and updates it to value in parameter
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
        size--; // decreases size variable by 1 when popping off stack
        return arr[top--]; // decrements index of top and returns value
    }

    @Override // overriding base class method
    public double peek() throws EmptyStackException // returns value at top of stack
    {
        // throws exception if stack is empty
        if (isEmpty()) 
        {
            throw new EmptyStackException();
        }
        return arr[top]; // returns value
    }

    @Override // overriding base class method
    public boolean isEmpty() // checks if stack is empty
    {
        return top == -1; //  checks by seeing if the top variable is negative one, as initialized
    }
    
    public int count() // Returns the number of elements in the stack
    {
        return size; // returns size variable
    }

    private void resizeArray() // method to resize array if it fills up
    {
        double[] newArr = new double[arr.length * 2]; // makes new array which is double the size of the previous one
        // copying over values into new array
        for (int i = 0; i < arr.length; i++) 
        {
            newArr[i] = arr[i];
        }
        arr = newArr; // setting array to the new array
    }
}
