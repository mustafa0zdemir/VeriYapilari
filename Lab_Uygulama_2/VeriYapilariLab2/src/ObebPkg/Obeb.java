package ObebPkg;

public class Obeb {

	
	
	public static int obeb(int a, int b) {
		if(b==0) {
			return a;
		}
		return obeb(a,a%b);
	}
	public static void main(String[] args) {
		
		System.out.println(obeb(12,3));

	}

}
