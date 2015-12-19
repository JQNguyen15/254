import java.util.*;
public class mergesort {

	static int array1[];
	static int counter=0;
	
	public static void main(String[] args){
		
		for (int i=5000;i<=100000;i+=5000){
			array1=new int[i];
			array1=randomArray(array1);
			array1=mergeSort(array1);
			System.out.println("Number of comparisons for n= "+i+" "+counter+" comparisons");
			resetCounter();
		}

		resetCounter();
	}
	
	static public int[] mergeSort(int a[]){
		if (a.length<=1)
			return a;
		
		int[] a1=new int[a.length/2];
		int[] a2=new int[a.length-a1.length];
		System.arraycopy(a,0,a1,0,a1.length);
		System.arraycopy(a,a1.length,a2,0,a2.length);
		a1=mergeSort(a1);
		a2=mergeSort(a2);
		a=merge(a,a1,a2);
		
		return a;
	}
	
	static public int[] merge(int a[],int a1[],int a2[]){
		int i=0,j=0,k=0;
		while (i<a1.length && j<a2.length){
			if (a1[i]<a2[j]){
				a[k]=a1[i];
				i++;
			
			}else{
				a[k]=a2[j];
				j++;
			}
			k++;
			counter++;
		}
		
		for (int m=i;m<a1.length;m++){
			a[k]=a1[m];
			k++;
		}
		for (int m=j;m<a2.length;m++){
			a[k]=a2[m];
			k++;
		}
		return a;
	}
	
	static public void resetCounter(){
		counter=0;
	}
	
	static public int[] randomArray(int a[]){
		Random rand=new Random();
		for (int i=0;i<a.length;i++){
			a[i]=rand.nextInt(a.length-1)+1;
		}
		return a;
	}
}
