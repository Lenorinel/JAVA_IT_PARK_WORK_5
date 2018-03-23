import java.util.Scanner;

class point3 {
	public static void main(String args[]) {
		System.out.println("Enter the number\n");
		
		Scanner scanner = new Scanner(System.in);
		
		int s = 0, n = scanner.nextInt();
		if(n != 0 ) {
		while(n != 0) {
			s+=n % 10;
			n /= 10;
		}
			if(s < 0) {
				s *= (-1);
			System.out.println("Digits summ of number is: " + s);
			}
			
			else System.out.println("Digits summ of number is: " + s);
			
		}
		else System.out.println("please enter correct number");
	}
}
