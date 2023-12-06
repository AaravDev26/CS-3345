/*
Aarav Dev
Assignment 2
Problem 4.34
*/

public class Main
{
    // testing BST generateRandomBST method
	public static void main(String[] args) 
	{
	    int N = 10; // number of nodes, contain keys with value 1 through N
		BST tree = new BST();
		BST.generateRandomBST(N);
		BST.inorder(); // should print numbers in ascending order
		BST.preorder(); // should print numbers in a different order nearly every time
	}
}
