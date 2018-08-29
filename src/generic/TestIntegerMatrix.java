package generic;

public class TestIntegerMatrix {
	public static void main(String[] args) {
		// Create Integer array m1, m2
		Integer[][] m1 = new Integer[][] {
			{1, 2, 3}, 
			{4, 5, 6}, 
			{1, 1, 1}
		};
		Integer[][] m2 = new Integer[][] {
			{1, 1, 1},
			{2, 2, 2},
			{0, 0, 0}
		};
		
		// Create an instance of IntegerMatrix 
		IntegerMatrix integerMatrix = new IntegerMatrix();
		
		System.out.println("\nm1 + m2 is ");
		GenericMatrix.printResult(
				m1, m2, integerMatrix.addMatrix(m1, m2), '+');
		
		
		
	}
}
