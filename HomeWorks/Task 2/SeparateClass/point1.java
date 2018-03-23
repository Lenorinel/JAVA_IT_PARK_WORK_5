//Вывести все четные числа в заданном диапазоне (Show in range) // пользователь вводит два числа a и b
import java.util.Scanner;

class point1 {
	public static void main(String args[]) {
		System.out.println("please enter lower and upper limits for your range\n");
		
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int i, sum = 0;
			if(a < b) { 
			System.out.println("even numbers in you range is:\n");
				for(i = a; i <= b; i++) 
							if(i != 0 && i%2==0) System.out.print(i + " ");
			}
			else { 
			System.out.println("even numbers in you range is:\n");
				for(i = a; i >= b; i--)
							if(i != 0 && i % 2 == 0) System.out.print(i + " ");
			}
	}
}
							
		