
public class DecToBin {
	
	public static String toBinary(int nbit, int n) {
		if( n < 0 ) {
			System.out.println("Please input positive number!");
			return null;
		}
		String res = "";
		int c = 0;
		ArrayStack<Integer> stk = new ArrayStack<Integer>();
		int quot = n, remainder;
		while( quot > 0 ) {
			remainder = quot % 2;
			stk.push(remainder);
			quot = quot / 2;
			c ++;
		}
		while( c < nbit ) {
			stk.push(0);
			c ++;
		}
		while( !stk.isEmpty() ) {
			res += stk.pop();
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {11, 105, 96, 255, 16, 23};
		int len = 8;
		for( int d: a) {
			String binary = toBinary(len, d);
			System.out.println("Binary for decimal number  " + d + " is " + binary);
		}
	}

}
