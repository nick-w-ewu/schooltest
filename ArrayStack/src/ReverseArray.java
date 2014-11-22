
public class ReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		//use a stack to reverse the array a
		ArrayStack<Integer> stk = new ArrayStack<Integer>();
		
		for( int i = 0; i < a.length; i ++) {
			stk.push(a[i]);
		}
		//stk.status("", null);
		System.out.println("Information in stack is: " + stk.toString());
		System.out.println("Now reverse the array:");
		while( !stk.isEmpty() ) {
			System.out.print(stk.pop() + ",");
		}
		System.out.println();
	}
}
