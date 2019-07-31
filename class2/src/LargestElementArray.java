import java.util.Scanner;

public class LargestElementArray {

	public static int[] takeinput(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = s.nextInt();
		int[] arr = new int[size];
		for(int i=0; i< size; i++){
			System.out.println("enter "+i+" term");
			arr[i] = s.nextInt();
		}
		return arr;

	}

	public static void printarray(int[] arr){
		for(int i=0; i<arr.length ; i++){
			System.out.print(arr[i]);
		}
	}

	public static int largestelement(int[] arr){

		int max=arr[0];
		for(int i = 0; i<arr.length; i++){
			if (arr[i]>max){
				max = arr[i];
			}
		}
		return max;
	}

	public static int linearsearch(int arr[]){

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the element to be searched");
		int x = s.nextInt();

		for(int i = 0;i < arr.length; i++){
			if (arr[i]==x){
				return i;
			}

		}
		return -1;
	}

	public static int[] reversearray(int a[]){
		int x;
		int n = a.length;
		for(int i=0; i<n/2; i++){
			x=a[i];
			a[i]=a[n-i-1];
			a[n-i-1]=x;				
		}
		return a;
	}

	public static void selectionsort(int arr[]){
		for(int i = 0; i< arr.length-1; i++){
			int min = arr[i];
			int pos=i;
			for(int j=i+1;j<arr.length;j++){
				if (min>arr[j]){
					pos=j;
					min=arr[j];
			    }
				
			}
			
				int temp=arr[i];
				arr[i]=arr[pos];
				arr[pos]=temp;
			
		

		}
	}



	public static void main(String[] args) {

		//System.out.println("the largest element in the array is "+largestelement(takeinput()));

		/*	int x = linearsearch(takeinput());
		if(x!=-1){
			System.out.println("the position of the term you searche is "+x);
		}
		else{
			System.out.println("the element is not in the array");
		}        */

		/*	int[] arr=takeinput();
		int[] reversed=reversearray(arr);
		System.out.println("the reversed array is");
		printarray(reversed);      */

		int[] arr = takeinput();
		selectionsort(arr);
		printarray(arr);

	}

}
