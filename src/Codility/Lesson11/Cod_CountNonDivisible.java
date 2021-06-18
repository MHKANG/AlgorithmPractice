package Codility.Lesson11;

import java.util.Arrays;

// Task 55 Correctness 100 Performance 0

public class Cod_CountNonDivisible {
	public static void main(String[] args) {
		int[]A = {3, 1, 2, 3, 6};
		int[]answer = new int [A.length];
		for(int i = 0; i < A.length; i++){
            int c_divisors = 0;

            for(int j = 0; j < i; j++){
                if(A[i]%A[j] != 0){
                    c_divisors++;
                }
            }
            for(int j = i+1; j < A.length; j++){
                if(A[i]%A[j] != 0){
                    c_divisors++;
                }
            }
            answer[i] = c_divisors;
        }
		System.out.println(Arrays.toString(answer));
	}
}
