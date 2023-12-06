/*
Aarav Dev
Assignment 2
Problem 3.11
*/

public class Main
{
	public static void main(String[] args) // tests LinkedList class functions
	{
		LinkedList list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2); // is not added because 2 is already in list
        
        System.out.println("List size: " + list.size()); // output: List size: 3
        
        System.out.print("List contents: ");
        list.printList(); // output: List contents: 1 2 3
        
        System.out.println("Contains 2? " + list.contains(2)); // output: Contains 2? true
        System.out.println("Contains 4? " + list.contains(4)); // output: Contains 4? false
        
        list.add(4);
        System.out.print("List contents after adding 4: ");
        list.printList(); // output: List contents after adding 4: 1 2 3 4
        
        list.remove(3);
        System.out.print("List contents after removing 3: ");
        list.printList(); // output: List contents after removing 3: 1 2 4
	}
}
