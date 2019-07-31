import java.util.Scanner;

public class ArrayAssignment {

	public static int[] takeinput(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = s.nextInt();
		int[] arr = new int[size];
		for(int i=0; i< size; i++){
			System.out.println("enter "+i+" term");
			arr[i] = s.nextInt();
		}
		s.close();
		return arr;

	}

	public static void printarray(int[] arr){
		for(int i=0; i<arr.length ; i++){
			System.out.print(arr[i]);
		}
	}

	public static int[] dectobinary(int dec){
		int x =dec;
		int i=0;
		while(x!=0){
			x=x/2;
			i++;
		}
		int n=i;
		int[] a = new int[n];

		while(dec>0){
			i=0;
			x =dec ;

			for(x=dec;x>0;i++){
				x=x/2;
			}

			dec = (int) (dec%Math.pow(2, (i-1)));
			a[n-i]=1;

		}
		return a;
	}


	public static void reverse(int[] arr){
		for(int i = 0; i < arr.length/2; i++){			
			int x=arr[i];
			arr[i]=arr[arr.length-i-1];
			arr[arr.length-i-1]=x;
		}				
	}


	public static int sumofposint(int[] arr){
		int sum=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>0){
				sum += arr[i];
			}
		}
		return sum;
	}


	public static int sumofnegint(int[] arr){
		int sum=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]<0){
				sum += arr[i];
			}
		}
		return sum;
	}


	public static int[] intersection(int[] arr1, int[] arr2){
		int k=0;	
		int n;
		if (arr1.length>arr2.length){
			n = arr1.length;
		}
		else{
			n = arr2.length;
		}
		int[] a = new int[n];
		for(int i=0; i<arr1.length; i++){

			for(int j=0; j < arr2.length; j++){
				if(arr1[i] == arr2[j]){
					a[k]=arr1[i];
					k++;
				}
			}
		}
		int[] intersection = new int[k];
		for(int i=0; i<k; i++){
			intersection[i] = a[i];
		}
		return intersection;		
	}


	public static void pairsumx(int arr[], int x){
		boolean flag = true;
		for(int i = 0; i < arr.length-1; i++){
			for(int j = i+1; j < arr.length; j++){
				if (arr[i]+arr[j]==x){
					System.out.println(arr[i]+" "+arr[j]);
					flag = false;
				}
			}
		}
		if (flag){
			System.out.println("Sorry no such pair exists");
		}
	}


	public static void triplesumx(int arr[], int x){
		boolean flag = true;
		for(int i = 0; i < arr.length-2; i++){
			for(int j = i+1; j < arr.length-1; j++){
				for(int k = j+1; k < arr.length; k++){
					if (arr[i]+arr[j]+arr[k]==x){
						System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
						flag = false;
					}
				}
			}
		}
		if (flag){
			System.out.println("Sorry no such pair exists");
		}
	}


	public static int[] arraysum(int[] a, int[] b){
		int aa=0,bb=0;
		for(int i=0; i<a.length; i++){
			aa += a[i]*Math.pow(10, a.length-i-1);
		}
		for(int i=0; i<b.length; i++){
			bb += b[i]*Math.pow(10, b.length-i-1);
		}
		int ss=aa+bb;
		int x = ss, n;
		for(n=0; x != 0; n++){
			x=x/10;
		}
		int sum[] = new int[n];
		for(int i = 0; i < n; i++){
			sum[n-i-1]=ss%10;
			ss=ss/10;
		}
		return sum;
	}


	public static int duplicateterm(int[] arr)
	{
		int x = -1;
		for(int i = 0; i < arr.length-1; i++)
		{
			for(int j = i+1; j < arr.length; j++)
			{
				if (arr[i]==arr[j])
				{
					x = arr[i];					
				}
			}
		}
		return x;
	}


	public static int rotationcheck(int[] arr)
	{
		for(int i = 0; i < arr.length -1; i++)
		{
			if (arr[i] > arr[i+1])
			{
				return (i+1);
			}
		}
		return -1;
	}



	public static void sort012(int[] arr)
	{
		int nextzero = 0;
		int nexttwo = arr.length - 1;
		int i = 0;
		int temp;
		while(i <= nexttwo)
		{
			if(arr[i] == 0)
			{
				temp = arr[i];
				arr[i] = arr[nextzero];
				arr[nextzero] = temp;
				nextzero++;
				i++;
			}
			else if (arr[i] == 2)
			{
				temp = arr[i];
				arr[i] = arr[nexttwo];
				arr[nexttwo] = temp;
				nexttwo--;
			}
			else i++;
		}
		
	}



	public static void main(String[] args) {



		/*		//	DecToBinary
		Scanner s = new Scanner(System.in);
		System.out.println("enter the decimal no");
		int dec = s.nextInt();
		System.out.println("the number in binary is ");
		printarray(dectobinary(dec));    
		s.close();                                           
		 */


		/*	//	Reverse an array
		int arr[] = takeinput();
		reverse(arr);
		System.out.println("The reversed array is ");
		printarray(arr);
		 */		


		/*		//	Sum of +ve & -ve elements in an array separately
		int arr[] = takeinput();
		System.out.println("the sum of positive integers is "+sumofposint(arr)+" and the sum of negative integers is "+sumofnegint(arr));       
		 */


		/*		//	Intersection of arrays
		int arr1[] = takeinput(), arr2[] = takeinput();
		System.out.println("the intersection of arrays is");
		printarray(intersection(arr1,arr2));                 
		 */


		/*		//	pairs with sum x
		Scanner s = new Scanner(System.in);
		System.out.println("enter a number");
		int x = s.nextInt();
		int arr[] = takeinput();
		System.out.println("the pairs whose sum is "+x+" are");
		pairsumx(arr,x);
		s.close();
		 */


		/*	//	three nos. with sum x
		Scanner s = new Scanner(System.in);
		System.out.println("enter a number");
		int x = s.nextInt();
		int arr[] = takeinput();
		System.out.println("the pair of three nos. whose sum is "+x+" are");
		triplesumx(arr,x);
		s.close();
		 */	


		/*	//	Sum of arrays
		int a[] = takeinput(), b[] = takeinput();
		int sum[] = arraysum(a,b);
		System.out.println("the sum array is ");
		printarray(sum);
		 */		


		/*	//	duplicate term
		int duplicateterm = duplicateterm(takeinput());
		System.out.println("the term which is repeated twice is "+duplicateterm);
		 */		

		/*	//	Rotated sorted array
		int x = rotationcheck(takeinput());
		System.out.println("the sorted array is rotated by "+x);
		 */		

		
		int arr[] = {1,0,2,1,0,2};
		sort012(arr);
		printarray(arr);
	}

}
