package Codility.Lesson2;

import java.util.Arrays;
//Correctness : 100% , Task Score = 100% Performance : 100% 
public class Cod_CyclicRotation {
	public static void main(String[] args) {
		int []A = {3, 8, 9, 7, 6};
		int K = 3;
		
		if(A.length!= 0) {
		
			while(K>0) {
				int[] temp = A.clone();
				int lastnum = A[A.length-1];
				for(int i = 0; i < temp.length-1; i++) {
					A[i+1] = temp[i];
				}
				A[0] = lastnum;
				K--;
				System.out.println(Arrays.toString(A));
			}
		}
		
	}
}
