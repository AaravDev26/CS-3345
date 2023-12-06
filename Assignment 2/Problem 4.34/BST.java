import java.util.Collections; // used to randomize the BST
import java.util.ArrayList; // import the ArrayList class

public class BST 
{
    private static Node root; // reference to root node
    
    // inner node class for encapsulating the nodes of the tree
    private static class Node 
    {
        int key;
        Node left, right;
        
        public Node(int item) 
        {
            key = item;
            left = right = null;
        }
    }
    
    // default constructor
    public BST() 
    {
        root = null;
    }
    
    // generates a random BST with n nodes with key values 1 through n
    public static void generateRandomBST(int n)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // getting values 1 through n
        for (int i = 1; i <= n; i++)
        {
            list.add(i);
        }
        Collections.shuffle(list); // randomizing order of numbers
        // inserting values into BST
        for (int i = 0; i < n; i++)
        {
            insert(list.get(i));
        }
    }
    
    // Insert a new node with the given key into the tree
    public static void insert(int key) 
    {
        root = insertNode(root, key);
    }
    
    // Recursive helper method for inserting a new node into the tree
    private static Node insertNode(Node root, int key) 
    {
        // If the root is null, create a new node with the given key and return it
        if (root == null) 
        {
            root = new Node(key);
            return root;
        }
        
        // If the key is less than the root's key, insert it into the left subtree
        if (key < root.key)
            root.left = insertNode(root.left, key);
        // If the key is greater than the root's key, insert it into the right subtree
        else if (key > root.key)
            root.right = insertNode(root.right, key);
        
        return root;
    }
    
    // prints contents of inorder traversal on the tree
    public static void inorder()
    {
        System.out.print("Inorder traversal: ");
        inorder(root);
        System.out.println();
    }
    
    // recursive helper method for the inorder traversal
    private static void inorder(Node n)
    {
        if (n != null)
        {
            inorder(n.left);
            System.out.print(n.key + " ");
            inorder(n.right);
        }
    }
    
    // prints contents of preorder traversal on the tree
    public static void preorder()
    {
        System.out.print("Preorder traversal: ");
        preorder(root);
        System.out.println();
    }
    
    // recursive helper method for the preorder traversal
    private static void preorder(Node n)
    {
        if (n != null)
        {
            System.out.print(n.key + " ");
            preorder(n.left);
            preorder(n.right);
        }
    }
    
}