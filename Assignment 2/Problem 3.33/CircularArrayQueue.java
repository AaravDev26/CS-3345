import java.util.NoSuchElementException;

public class CircularArrayQueue<T> 
{
    private int front; // index of the front of the queue
    private int rear; // index of the rear of the queue
    private int size; // current size of the queue
    private int capacity; // maximum capacity of the queue
    private T[] arr; // circular array for storing elements

    // constructor
    public CircularArrayQueue(int capacity) 
    {
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
    }

    // method to add an element to the rear of the queue
    public void enqueue(T element) 
    {
        if (size == capacity) 
        {
            throw new IllegalStateException("Queue is full"); // throws exception if queue is full
        }
        arr[rear] = element;
        rear = (rear + 1) % capacity; // update rear index in circular manner
        size++; // updates size variable
    }

    // method to remove and return the front element of the queue
    public T dequeue() 
    {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty"); // throws exception if queue is empty
        }
        T element = arr[front];
        arr[front] = null;
        front = (front + 1) % capacity; // update front index in circular manner
        size--; // updates size variable
        return element;
    }

    // method to return the front element of the queue without removing it
    public T peek() 
    {
        if (size == 0)
        {
            throw new NoSuchElementException("Queue is empty"); // throws exception if queue is empty
        }
        return arr[front];
    }

    // method to check if the queue is empty
    public boolean isEmpty() 
    {
        return size == 0;
    }

    // method to check if the queue is full
    public boolean isFull() 
    {
        return size == capacity;
    }

    // method to return the current size of the queue
    public int size() 
    {
        return size;
    }

    // method to print the elements of the queue
    public void printQueue() 
    {
        for (int i = 0; i < size; i++)  // looping through queue
        {
            int index = (front + i) % capacity; // calculate index in circular manner
            System.out.print(arr[index] + " ");
        }
        System.out.println(); // goes to next line
    }
}