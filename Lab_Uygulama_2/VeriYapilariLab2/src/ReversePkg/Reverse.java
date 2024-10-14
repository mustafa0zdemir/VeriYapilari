package ReversePkg;

public class Reverse {
	
	
	static void reverse(char s[],int index) {
		if(index <0) {
			return;
		}
		System.out.println(s[index]);
		reverse(s,index-1);
		
		
	}

	public static void main(String[] args) {
		char[] karakter = {'b','u',' ','b','i','r',' ','t','e','s','t'};
		reverse(karakter,karakter.length-1);

	}

}
