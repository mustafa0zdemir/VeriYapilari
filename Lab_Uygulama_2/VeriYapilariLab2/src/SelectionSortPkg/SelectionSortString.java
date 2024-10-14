package SelectionSortPkg;
public class SelectionSortString {
	static void secmeliSiralamaString(String[] str){
		int n = str.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (str[j].compareTo(str[minIndex])<0) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
            	//swap
            	  String temp = str[minIndex];
                  str[minIndex] = str[i];
                  str[i] = temp;
            }
          
        }
		
	}

	
	public static void main(String[] args) {
		  String[] str = {"kadir", "ayşe", "zeynep", "mehmet"};

	        secmeliSiralamaString(str);

	        for (int i = 0; i < str.length; i++) {
	            System.out.println(str[i]);
	        }
	    }
		
	}


