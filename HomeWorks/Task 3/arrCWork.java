class arrCWork {
	public static void main(String args[]) {
		int[] a = {5,6,1,2,2};
		//int n =3;
		for(int i = 2; i < a.length - 1; i++) { //выполняем присваивание последующего эллемента с третьего эл-та и до предпоследнего
			a[i] = a[i+1];
		}
		a[a.length - 1] = 0; // последнему эл-ту массива присваиваем значение 0
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		
	}
}
			