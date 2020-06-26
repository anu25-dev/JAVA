//question 1-traverse leaves right to left//
 
public class Tree { 
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
  
static class Node  
{  
    int data;  
    Node left, right;  
};  
  

static Node newNode(int data)  
{  
    Node temp = new Node();  
    temp.data = data;  
    temp.left = temp.right = null;  
    return temp;  
}  
  

static void traverseLeaves(Node root)  
{  

    if (root == null)  
        return;  
  
    
    if (root.left == null && root.right == null)  
    {  
        System.out.print( root.data +" ");  
        return;  
    }  
  
   
    if (root.right != null)  
        traverseLeaves(root.right);  
  
     
    if (root.left != null)  
        traverseLeaves(root.left);  
}  
  

public static void main(String args[]) 
{  
      Tree t2 = new Tree(); 
        int arr[] = { 1, 2, 3, 4, 6, 7, 8, 10, 13, 14 }; 
        t2.root = t2.insertLevelOrder(arr, t2.root, 0); 
        t2.inOrder(t2.root); 
        Node root = newNode(1);  
        root.left = newNode(2);  
        root.right = newNode(3);  
        root.left.left = newNode(4);  
        root.left.right = newNode(5);  
        root.right.left = newNode(6);  
        root.right.right = newNode(7);  
        root.left.left.left = newNode(8);  
        root.right.right.left = newNode(9);  
        root.left.left.left.right = newNode(10);  
  
    traverseLeaves(root);  
}  
}  
 
