import java.util.Scanner;
//выводит сумму введенных чисел
class point2 {
	public static void main(String args[]) {
		System.out.println("Enter a digit of numbers you want to summ\n");
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int t = 1, s = 0;
	
		if(n != 0) {
			
			System.out.println("Please enter " + n + " numbers\n");
			
		while(t <= n) {
			int a = scanner.nextInt();
			s += a;
			t++;
		  }
		  System.out.println("Summ of entering numbers is: " + s);
		}
		else System.out.println("\n0 it's not good idea");
		 
	}
}