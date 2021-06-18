package Codility.Lesson11;

import java.util.Arrays;

// Task 100 Correctness 100 Performance 100

public class Cod_CountNonDivisible2 {
	public static void main(String[] args) {
		int[]A = {1,1,1,1,1,1,1,1,1,1};
		int[]answer = new int [A.length];
		int[]countNum = new int[2*A.length+1];
		int countOne = 0;
		boolean[] prime = new boolean[2*A.length+2];
		
		prime[0] = prime[1] = true;
		
		for(int i =2; i*i <=2*A.length+1; i++) {
			
			if(!prime[i]) {
				
				for(int j=i*i; j<=2*A.length+1; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		for(int i = 0; i < A.length; i++) {
			if(A[i]==1) {
				countOne++;
			}
			countNum[A[i]]++;
			
			
		}
		for(int i = 0; i < A.length; i++) {
			if(!prime[A[i]]) {
				answer[i] = A.length - (countOne + countNum[A[i]]);
			}else {
				answer[i] = A.length;
				for(int j = 1; j*j <= A[i]; j++) {
					if(j*j >A[i]) {
						break;
					}
					if(A[i]%j == 0) {
						int div = A[i]/j;
						if(A[i] == 1 || j*j == A[i]) {
							answer[i] -= countNum[j];
						}else {
							answer[i] -= countNum[j] + countNum[div];
						}
					}
				}
				
			}
		}
		
		System.out.println(Arrays.toString(answer));
		
	}
	
	
}
