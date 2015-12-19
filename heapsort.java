
public class heapsort {
	static int[] a = {16, 11, 9, 10, 5, 6, 8, 1, 2, 4};
	static int[] a2={12, 10, 20, 19, 8, 7, 15};
	static int[] a3={12, 10, 20, 19, 8, 7, 15};
	static public Boolean DEBUG = false;
	public static void main(String[] args) {
		heapify(a,0,9);
		System.out.printf("for heapify(0,9): ");	
		for (int i=0;i<a.length;i++)
			System.out.printf("%d ",a[i]);
		
		buildHeap(a2);
		System.out.print("\nfor buildheap: ");
		for (int i=0;i<a2.length;i++)
			System.out.printf("%d ",a2[i]);
		
		heapSort(a3);
		System.out.print("\nfor heapsort: ");
		for (int i=0;i<a3.length;i++)
			System.out.printf("%d ",a3[i]);
	}
	
	static void heapSort(int[] a){
		buildHeap(a);
		for (int i=a.length-1;i>=1;i--){
			int temp=a[0];
			a[0]=a[i];
			a[i]=temp;
			heapify(a,0,i-1);
		}
	}

	static void buildHeap(int a[]){
		for (int i=(a.length/2)-1;i>=0;i--){
			if (DEBUG) System.out.println("i is "+i);
			heapify(a,i,a.length-1);
		}
	}
	
	static void heapify(int a[],int i,int j){
		//i and j are index for the range
		int k=-1;							//keeps track of index of bigger children node
		if (i*2+1>j)
			return;
		//for nodes with 2 children
		if (bigger(a[i*2+1],a[i*2+2]))
			k=i*2+1;
		else
			k=i*2+2;
		//for a node with just 1 chid
		if (i*2+2>j && i*2+1==j){
			k=i*2+1;
		}
		
		if (DEBUG){
			System.out.println("k is equal to "+k);
			System.out.println("a[i] = "+a[i]);
			System.out.println("a[k] = "+a[k]);
		}
		
		if (a[i]<a[k] && k!=-1){
			if (DEBUG) System.out.println("swapping");
			int temp=a[i];
			a[i]=a[k];
			a[k]=temp;
		}
		heapify(a,k,j);
	}
	
	static Boolean bigger(int a,int b){
		if (a>b)
			return true;
		else
			return false;
	}
}
