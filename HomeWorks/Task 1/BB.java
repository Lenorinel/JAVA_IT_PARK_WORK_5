class BB {
	public static void main(String args[]) {
			int i=11;
			String s = "", z = "";
			s += (i%2);
			i/=2;
			s += (i%2);
			z += s + i;
			String reverse = new StringBuffer(s).reverse().toString();
			System.out.println(i + " " + s);
			System.out.println(z);
	}
}