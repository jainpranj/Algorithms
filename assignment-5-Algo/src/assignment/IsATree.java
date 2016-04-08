package assignment;

public class IsATree {
	Node root = null;
	StringBuilder sb = new StringBuilder();

	public class Node {
		private Node root;
		private Node left;
		private Node right;
		private int key;

public Node(int key){
	this.key=key;
}
	}


	public void put(int value) {
		root = put(root, value);
	}

	public Node put(Node x, int value) {

		if (x == null) {
			
			x = new Node(value);
			return x;

		}

		if (compareTo(x.key, value) == 1) {
		//	sb.append("(" + x.key);
		//	System.out.print(sb);
			x.right = put(x.left, value);
			//sb.append(")");
		} else if (compareTo(x.key, value) == -1) {
		//	sb.append("(" + x.key);
		//	System.out.print(sb);
			x.left = put(x.right, value);
		//	sb.append(")");
		} else {
			x.key = value;
		}
		return x;

	}

	public int compareTo(int x, int y) {
		if (x > y) {
			return 1;
		} else if (x < y) {
			return -1;
		}
		return 0;

	}
    public void printPostorder(Node node)
    {
    	//StringBuilder sb=new StringBuilder();
        if (node == null)
            return;
 
        // first recur on left subtree
        printPostorder(node.left);
 
        // then recur on right subtree
        printPostorder(node.right);
 
        // now deal with the node
       // System.out.print(node.key + " ");
        sb.append(node.key);
       // return sb;
    }
    
    void printPreorder(Node node)
    {
        if (node == null)
            return;
 
        /* first print data of node */
       // System.out.print(node.key + " ");
        sb.append(node.key);
 
        /* then recur on left sutree */
        printPreorder(node.left);
 
        /* now recur on right subtree */
        printPreorder(node.right);
    }

	public static void main(String[] args) {
		IsATree aTree = new IsATree();
		// Node root=null;
		aTree.put('A');
		aTree.put('B');
		aTree.put('C');
		aTree.put('G');
		aTree.put('F');
		aTree.put('H');
		aTree.put('D');
		aTree.put('E');
		//System.out.println(aTree.sb);
		System.out.println(aTree);
	}
}
