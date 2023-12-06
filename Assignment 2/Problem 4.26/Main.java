/*
Aarav Dev
Assignment 2
Problem 4.26
*/

public class Main
{
    // testing AVLTree class
	public static void main(String[] args) 
	{
		AVLTree tree = new AVLTree(); // initializing tree

        // insert keys into the tree
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);
    
        // print the tree, inorder traversal should print from least to greatest if AVLTree class is correct
        System.out.println("Inorder traversal of the constructed AVL tree:");
        tree.inorder();
	}
}
