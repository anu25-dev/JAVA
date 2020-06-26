public class Node { 
    Node root; 
  
    static class Node { 
        int data; 
        Node left, right; 
        Node(int data) 
        { 
            this.data = data; 
            this.left = null; 
            this.right = null; 
        } 
    } 
  
public Node insertLevelOrder(int[] arr, Node root, 
                                                int i) 
    { 
        
        if (i < arr.length) { 
            Node temp = new Node(arr[i]); 
            root = temp; 
  
         
            root.left = insertLevelOrder(arr, root.left, 
                                             2 * i + 1); 
  
            root.right = insertLevelOrder(arr, root.right, 
                                               2 * i + 2); 
        } 
        return root; 
    } 
  
    
    public void inOrder(Node root) 
    { 
        if (root != null) { 
            inOrder(root.left); 
            System.out.print(root.data + " "); 
            inOrder(root.right); 
        } 
    } 
  class BinaryTree 
{ 

	Node root; 

	public BinaryTree() 
	{ 
		root = null; 
	} 

	
	void printLevelOrder() 
	{ 
		int h = height(root); 
		int i; 
		for (i=1; i<=h; i++) 
			printGivenLevel(root, i); 
	} 

	
	int height(Node root) 
	{ 
		if (root == null) 
		return 0; 
		else
		{ 
			
			int lheight = height(root.left); 
			int rheight = height(root.right); 
			
			
			if (lheight > rheight) 
				return(lheight+1); 
			else return(rheight+1); 
		} 
	} 


	void printGivenLevel (Node root ,int level) 
	{ 
		if (root == null) 
			return; 
		if (level == 1) 
			System.out.print(root.data + " "); 
		else if (level > 1) 
		{ 
			printGivenLevel(root.left, level-1); 
			printGivenLevel(root.right, level-1); 
		} 
	} 
	
	
	public static void main(String args[]) 
	{ 
	    Tree t2 = new Tree(); 
        int arr[] = { 1, 2, 3, 4, 5, 6}; 
        t2.root = t2.insertLevelOrder(arr, t2.root, 0); 
        t2.inOrder(t2.root); 
	    BinaryTree tree = new BinaryTree(); 
	    tree.root= new Node(1); 
	    tree.root.left= new Node(2); 
	    tree.root.right= new Node(3); 
	    tree.root.left.left= new Node(4); 
	    tree.root.left.right= new Node(5); 
		
	System.out.println("Level order traversal of binary tree is "); 
	tree.printLevelOrder(); 
	} 
} }
