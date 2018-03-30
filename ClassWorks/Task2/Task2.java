import java.util.Scanner;

class Task2 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int a[] = {5,6,1,2,2}, i;
		
		System.out.println("Please enter the number of postion you want to delete");
		
		int n = scanner.nextInt();
		for(i=n; i < a.length; i++) {
			a[i] = a [i+1];
			System.out.print(a[i] + " ");
		}
	}
}