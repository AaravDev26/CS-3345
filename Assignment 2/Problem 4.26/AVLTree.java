public class AVLTree 
{
    // AVL node inner class
    private class AVLNode 
    {
        int key, height;
        AVLNode left, right;

        AVLNode(int d) 
        {
            key = d;
            height = 1;
        }
    }

    AVLNode root; // root of tree

    // get height of a node
    int height(AVLNode node) 
    {
        if (node == null)
            return 0;
        return node.height;
    }

    // get balance factor of a node
    int getBalance(AVLNode node) 
    {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // rotate right at node x
    AVLNode rotateRight(AVLNode x) 
    {
        AVLNode y = x.left;
        AVLNode z = y.right;
        
        // perform rotation
        y.right = x;
        x.left = z;

        // update heights
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        // return new root
        return y;
    }

    // rotate left at node x
    AVLNode rotateLeft(AVLNode x)
    {
        AVLNode y = x.right;
        AVLNode z = y.left;

        // perform rotation
        y.left = x;
        x.right = z;

        // update heights
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        // return new root
        return y;
    }

    // double rotation: left-right
    AVLNode doubleRotateLR(AVLNode c) 
    {
        AVLNode a = c.left;
        AVLNode b = a.right;
        // rearranging references
        a.right = b.left;
        c.left = b.right;
        b.left = a;
        b.right = c;
        // Update heights
        a.height = Math.max(height(a.left), height(a.right) ) + 1;
        c.height = Math.max(height(c.left), height(c.right) ) + 1;
        b.height = Math.max(a.height, c.height ) + 1;
        return b;
    }

    // double rotation: right-left
    AVLNode doubleRotateRL(AVLNode a) 
    {
        AVLNode c = a.right;
        AVLNode b = c.left;
        // rearranging references
        a.right = b.left;
        c.left = b.right;
        b.left = a;
        b.right = c;
        // Update heights
        a.height = Math.max(height(a.left), height(a.right) ) + 1;
        c.height = Math.max(height(c.left), height(c.right) ) + 1;
        b.height = Math.max(a.height, c.height ) + 1;
        return b;
    }

    // insert a key into the AVL tree, needs helper funtion to execute properly
    void insert(int key) 
    {
        root = insert(root, key);
    }

    // recursive helper function to insert a key into the AVL tree
    AVLNode insert(AVLNode node, int key) 
    {
        if (node == null)
            return new AVLNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // key already exists
            return node;

        // update height of this node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // get balance factor of this node
        int balance = getBalance(node);

        // perform rotations if needed
        if (balance > 1 && key < node.left.key) // left-left case
            return rotateRight(node);
        else if (balance < -1 && key > node.right.key) // right-right case
            return rotateLeft(node);
        else if (balance > 1 && key > node.left.key) // left-right case
            return doubleRotateLR(node);
        else if (balance < -1 && key < node.right.key) // right-left case
            return doubleRotateRL(node);

        // no rotation needed
        return node;
    }

    // print the tree in inorder traversal, needs helper funtion to execute properly
    public void inorder() 
    {
        inorder(root);
    }

    // helper function to print the tree in inorder traversal
   void inorder(AVLNode node) 
   {
        if (node != null) 
        {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }
}