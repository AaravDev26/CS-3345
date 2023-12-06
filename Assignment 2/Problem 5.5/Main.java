/*
Aarav Dev
Assignment 2
Problem 5.5
*/

public class Main
{
    // testing the hash table
	public static void main(String[] args) 
	{
		HashTable hashTable = new HashTable(10); // initializing hash table
		// inserting numbers into hash table
        hashTable.insert(1);
        hashTable.insert(2);
        hashTable.insert(3);
        hashTable.insert(43);
        hashTable.insert(22);
        hashTable.insert(19);
        hashTable.insert(6);
        hashTable.insert(15);
        hashTable.insert(110);
        hashTable.insert(49);
        hashTable.insert(69);
        System.out.println(hashTable.contains(1)); // true
        System.out.println(hashTable.contains(4)); // false 
        hashTable.remove(2); 
        System.out.println(hashTable.size()); // 10
        hashTable.print(); // prints out hash table
	}
}
