package Codility.Lesson09;


//reference : https://github.com/Mickey0521/Codility/blob/master/MaxDoubleSliceSum.java
public class Cod_MaxDobuleSliceSum_other1 {
	public static void main(String[] args) {
		int[]A = {3, 2, 6, -1, 4, 5, -1, 2};
		int answer = -1;
		
		int[] left = new int[A.length];
		int[] right = new int[A.length];
		
		for(int i = 1; i < A.length; i++) {
			left[i] = Math.max(0, left[i-1]+A[i]);
		}
		
		for(int i = A.length-2; i >=0; i--) {
			right[i] = Math.max(0, right[i+1]+A[i]);
		}
		
		int max = 0;
		
		for(int i = 1; i < A.length-1; i++) {
			if(left[i-1] + right[i+1] > max) {
				max = left[i-1] + right[i+1];
			}
		}
		answer = max;
	}
}
