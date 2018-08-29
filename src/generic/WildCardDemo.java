package generic;

public class WildCardDemo {
	public static void main(String[] args) {
		GenericStack<Integer> intStack = new GenericStack<Integer>();
		intStack.push(1);
		intStack.push(2);
		intStack.push(-2);
		
		print(intStack);
	}
	
	public static <T> void print(GenericStack<T> stack) {
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}
}

