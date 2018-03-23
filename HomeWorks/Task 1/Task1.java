import java.util.Scanner;

class Task1 {
	public static void main(String args[]) {
		
		System.out.println("Please enter the number between 0 and 250");
		
		Scanner scanner = new Scanner(System.in);
		int t,num = scanner.nextInt();
				
		if(num>=0&&num<=255) f(num);
				
		else System.out.println("NOPE!You entering wrong number");
		}
	

		public static void f(int num) {
			if(num >= 2) 
				f(num/2);
				
				System.out.print((num%2));
				}
}