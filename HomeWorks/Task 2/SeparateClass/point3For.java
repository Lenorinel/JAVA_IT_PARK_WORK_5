import java.util.Scanner;
//вариант с for вместо while
class point3 {
	public static void main(String args[]) {
		System.out.println("Enter the number\n");
		
		Scanner scanner = new Scanner(System.in);
		
		int s = 0, n = scanner.nextInt() , x;
		if(n != 0 ) {
		for(x = n ; x != 0; x/=10) s+=x%10;
		
		//while(n != 0) {
			//s+=n % 10;
			//n /= 10;
		//}
			if(s < 0) {
				s *= (-1);
			System.out.println("Digits summ of number is: " + s);
			}
			
			else System.out.println("Digits summ of number is: " + s);
			
		}
		else System.out.println("please enter correct number");
	}
}
