package Codility.Lesson6;

import java.util.Arrays;

public class Cod_MaxProductOfThree {
	public static void main(String[] args) {
		int[]A = {-3, 1, 2, -2, 5, 6};
		int answer = Integer.MIN_VALUE;

        Arrays.sort(A);

        int posMax = A[A.length-1] * A[A.length-2] * A[A.length-3];
        int negMax = A[0]*A[1]*A[A.length-1];
        answer = Math.max(answer,posMax);
        answer = Math.max(answer,negMax);
        
        System.out.println(answer);
	}
}
