package Codility.Lesson6;

import java.util.Arrays;

public class Cod_NumberOfDiscIntersection_other1 {
	//"refernece : https://github.com/Mickey0521/Codility/blob/master/NumberOfDiscIntersections.java
	// 문제 자체가 이해가 안되서 답을 찾아 보았다.
	public static void main(String[] args) {
		int[] A = {1, 5, 2, 1, 4, 0};
		long[] lower = new long[A.length];
		long[] upper = new long[A.length];
		
		for(int i = 0; i < A.length; i++) {
			lower[i] = i - (long)A[i]; // lower = center - A[i] 제일 왼쪽 시작 지점
			upper[i] = i + (long)A[i]; // upper = center + A[i] 제일 오른쪽 끝 영역
		}
		
		Arrays.sort(upper);
		Arrays.sort(lower);
		
		int answer = 0;
		int j = 0; // lower point
		
		for(int i = 0; i < A.length; i++) {
			while(j < A.length && upper[i] >= lower[j]) {
				answer = answer + j; // add j intersections;
				answer = answer - i; // minus "i" 중복 셈을 방지
				j++;
			}
		}
		
		if(answer > 10000000)
			answer = -1;
	}
}
