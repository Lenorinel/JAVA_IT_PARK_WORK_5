import java.util.Scanner;
class MainB {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(" Please enter the size of your array m x n ");
	
		
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		
		int[][] a = new int[m][n];
		int k = 1;
		
		System.out.println(" Your massive snake looks like:  ");
		System.out.println();
		for(int i = 0; i < a.length; i++)
				if( i == 0 || i%2 == 0) {
		
				for(int j = 0; j < a[i].length; j++){
					a[i][j] = k;
					k++;
				}
				}
				else for(int j = a[i].length - 1; j >= 0; j--) {
					a[i][j] = k;
					k++;
				}
				for (int z = 0; z < a.length; z++) {
                    for (int t = 0; t < a[z].length; t++) {
            	        System.out.print(a[z][t] + "\t");
                    }
					System.out.println();
				}

	}
}
				