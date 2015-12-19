package tree;

public class BinarySearchTree
{
	int[] array = {17, 6, 19, 3,16, 18, 20, 2, 4, 14, 13, 15};
	node root;
	node previous=null;
	node previousParent=null;
	private static class node{
		node left,right;
		int key;
		public node(node ls, node rs, int x){
			this.left=ls;
			this.right=rs;
			this.key=x;
		}
	}


    public BinarySearchTree()
    {
        root = null;
    }

    public void insert(int x)
    {
        root = insert(x, root);
    }
    
    private node insert(int x, node t)
    {
      if (t == null)
         t = new node(null,null,x);
      else if (x < t.key)
         t.left = insert(x, t.left);
      else if (x > t.key)
         t.right = insert(x, t.right);

      return t;
    }

	void inOrder(node root){
		if (root.left!=null)
			inOrder(root.left);
		System.out.printf("%d ",root.key);
		if (root.right!=null)
			 inOrder(root.right);
	}
	
	Boolean treeSearch(node x,int k){

		if (x==null){
			return false;
		}
		else if (k==x.key){
			return true;
		}
		else if (k<x.key){
			previous=x;
			return treeSearch(x.left,k);
		}
		else{
			previous=x;
			return treeSearch(x.right,k);
		}
	}
	
	node treeMax(node x){
		while (x.right!=null){
			previousParent=previous;
			previous=x;
			x=x.right;
		}
		return x;
	}
	
	node predecessor(node x){
		if (x.left!=null){
			previousParent=previous;
			previous=x;
			x=x.left;
			while (x.right!=null){
				previousParent=previous;
				previous=x;
				x=x.right;
			}
			return x;
		}else{
			while (previous!=null && previous.left==x){
				x=previous;
				previous=previousParent;
				
				//System.out.println(previous.left.key);
			}
			return previous;
		}
	}
	
	void partC(node root){
		System.out.println("node "+root.key+" predecessor is ");
		int output=predecessor(root).key;
		if (output>root.key)
			System.out.println("null");
		else{
			System.out.println(output);
		}
		if (root.left!=null)
			partC(root.left);
		if (root.right!=null)
			partC(root.right);
	}
		
    public static void main(String[] args)
    {
    	BinarySearchTree myList= new BinarySearchTree();
    	//part a

    	for (int i=0;i<myList.array.length;i++){
    		myList.insert(myList.array[i]);
    	}
    	myList.inOrder(myList.root);
    	System.out.println("\n");
    	
    	//part b
    	for (int i=1;i<=20;i++){
    		Boolean result = myList.treeSearch(myList.root,i);
    		if (result){
    			if (i==myList.root.key)
    				System.out.println(i+" found at parent null");
    			else{
    				System.out.println(i+" found at parent "+myList.previous.key);
    			}
    		}
    		else if (!result)
    			System.out.println(i+" is not found");
    	}

    	System.out.println();
    	myList.partC(myList.root);
    }
}