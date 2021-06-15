package Codility.Lesson03;

public class Cod_TapeEquilibriumElem_other1 {
	// Time Complexity : O(N)
	// reference : https://cchoimin.tistory.com/entry/Codility-TapeEquilibrium-100%EC%A0%90
	public static void main(String[] args) {
		
		
		int[]A = {3, 1,2, 4, 3};
		
		// code convention for find min value;
		// not use list;
		int min = Integer.MAX_VALUE;
		
		int left = 0;
		int right = 0;
		int sum = 0;
		
		for(int i : A){
			sum += i;
		}
		
		for(int j = 1; j < A.length; j++) {
			left += A[j-1];
			right = sum -left;
			min = Math.min(min, Math.abs(left-right));
		}
		
		System.out.println(min);
	}
}
