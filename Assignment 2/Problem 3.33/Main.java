/*
Aarav Dev
Assignment 2
Problem 3.33
*/

public class Main
{
	public static void main(String[] args) 
	{
		CircularArrayQueue<Integer> queue = new CircularArrayQueue<>(5); // queue with size 5 initialized

        // adding elements to the queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        // print the queue
        System.out.print("Queue contents: ");
        queue.printQueue();

        // remove some elements from the queue
        System.out.println("Removed element: " + queue.dequeue());
        System.out.println("Removed element: " + queue.dequeue());

        // print the queue again
        System.out.print("Queue contents: ");
        queue.printQueue();

        // add another element to the queue
        queue.enqueue(60);

        // print the queue again
        System.out.print("Queue contents: ");
        queue.printQueue();
	}
}
