import java.util.Scanner;

class Task2 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
			while (true) {
				System.out.println("\tMENU:");
				System.out.println("1.Show all even numbers in selected range" + "\n2.Show SUM of entering numbers");
				System.out.println("3.Show SUM of digits entering number" + "\n4.Exit");
				int cmnd = scanner.nextInt();
					
					switch (cmnd) {
						
						case 1: { 		// Вывод четных чисел из заданного интервала
							
							System.out.println("\nPlease enter lower and upper limits for your range\n");
							
							int a = scanner.nextInt();
							int b = scanner.nextInt();
							int i;
								if(a < b) { 
								System.out.println("\nEven numbers in you range is:\n");
									for(i = a; i <= b; i++) 
										if(i != 0 && i%2==0) System.out.print(i + " ");
									
								}
								else { 
									System.out.println("\nEven numbers in you range is:\n");
									for(i = a; i >= b; i--)
										if(i != 0 && i % 2 == 0) System.out.print(i + " ");
									
									}
							
							System.out.println();
							
							break;
						}		
						
						case 2: {		// Рассчет суммы введенных чисел
						
						System.out.println("\nEnter a digit of numbers you want to summ\n");
						
						int n = scanner.nextInt();
						int t = 1, s = 0;
	
							if(n != 0) {
			
								System.out.println("\nPlease enter " + n + " numbers\n");
			
								while(t <= n) {
								int a = scanner.nextInt();
								s += a;
								t++;
								}
								System.out.println("\nSumm of entering numbers is: " + s);
							}
							else System.out.println("\n0 it's not good idea");
							
							System.out.println();
							
							break;
						}
						
						case 3: {  		//Рассчет суммы цифр введенного числа
						
							System.out.println("\nEnter the number\n");
						
							int s = 0, n = scanner.nextInt();
							
							if(n != 0 ) {
								while(n != 0) {
							
									s+=n % 10;
									n /= 10;
								}
							
							if(s < 0) {
								s *= (-1);
								System.out.println("\nDigits summ of number is: " + s);
								
							}
			
							else System.out.println("\nDigits summ of number is: " + s);
								 			
							}
							else System.out.println("\nplease enter correct number");
							
							System.out.println();
							
							break;
						}
						
						default: {
								
								System.out.println("\nThank you for using this program! Bye!");
								System.exit(0);
								break;
						}
					}
			}
	}
}
						
											
