import java.util.Scanner;
// Вторая попытка Task 1
class Try2 {
public static void main(String args[]) {
	System.out.println("vvedite chislo ot 0 do 255 vkluchitelno");
	
	Scanner scanner = new Scanner(System.in);
	int n = scanner.nextInt(), x = n;
	String s = "";
	
	if(n>=0&&n<=255) {
		if(n>=2) {
			s += (n%2);
			n /= 2;
			if(n>=2) {
				s += (n%2);
				n /= 2;
				if(n>=2) {
					s += (n%2);
					n /= 2;
					if(n>=2) {
						s += (n%2);
						n /= 2;
						if(n>=2) {
							s += (n%2);
							n /= 2;
							if(n>=2) {
								s += (n%2);
								n /= 2;
								if(n>=2) {
									s += (n%2);
									n /= 2;
								
								}
							}
						}
					}
				}
			}
		}
		s += (n%2);
		String reverse = new StringBuffer(s).reverse().toString();
		System.out.println(" Chislo " + x + " v dvoichnoi systeme ravno " + reverse);
	}
	else System.out.println("neverniy vvod");
  }
}