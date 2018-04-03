import java.util.Random;
import java.util.Scanner;

class MainC {
	public static void main(String args[]) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter parametres of your array m*n");
				
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		
		int[][] a = new int[m][n]; 
		int min;
		
		System.out.println("Your massive is: ");
		
		for(int i = 0; i < a.length; i++)
			for(int j = 0; j < a[i].length; j++)
				a[i][j] = random.nextInt(20);
		for(int i[]: a) {
			for(int j: i)
				System.out.print(j + " ");
			System.out.println();
		}
			System.out.println();
		for(int i = 0; i < a.length; i++){
			min = a[i][0];
			for(int j = 0; j < a[i].length; j++) {
				if(a[i][j] < min) min = a[i][j];
			}
			System.out.println(" Mininmum of " + (i+1) + " row is: " + min);
			}
	}
}
				