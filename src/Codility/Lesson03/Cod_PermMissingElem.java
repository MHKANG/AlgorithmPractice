package Codility.Lesson03;

public class Cod_PermMissingElem {
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 5};
		
		int answer = -1;
		
		boolean[]check = new boolean[A.length+2];
		
		for(int i = 0; i < A.length; i++) {
			check[A[i]] = true;
		}
		
		for(int i = 1; i < check.length; i++) {
			if(!check[i]) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}
}
