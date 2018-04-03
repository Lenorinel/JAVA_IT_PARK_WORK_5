import java.util.Scanner;

class Prog {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Vvedite kolichestvo elementov massiva");
		int s = scanner.nextInt();
		int a[] = new int[s];
		int b[] = new int[a.length];
		System.out.println("Vvedite " + s + " elementov massiva");
		for(int t=0; t < s; t++)
			a[t] = scanner.nextInt();
		//добавить ввод с клавы с принтом сообщения
		
		for( int x = 0; x<a.length -1; x++) { //				2 7 8[3]
			for(int n = x+1; n < a.length; n++) { //7 8 2    /8, 0 / 0
 				if(a[x] == a[n]) {
				if(a[x] == a[s-1]) b[s-1]++;
				b[n]++;
				b[x]++;
				
				}
				
				}
		}
		//for(int z: b) System.out.print(z + " ");
		System.out.println();
		for( int y = 0; y < b.length; y++)
			if(b[y] > 0) a[y] = 0;
	
	for(int z: a) System.out.print(z + " ");
		}
	}