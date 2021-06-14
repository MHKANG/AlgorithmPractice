package Algorithm;

public class 카데인알고리즘 {
	public static void main(String[] args) {
		int A[] = {3, 2, -6, 4, 0};
		
		int localMax = A[0];
		int globalMax = A[0];
		
		for(int i = 1; i < A.length; i++) {
			localMax = Math.max(A[i], localMax+A[i]); // 현재 i 위치에서 가장 큰 값을 찾음
			globalMax = Math.max(globalMax, localMax); // 현재 시작점 i위치에서 가장 큰 값을 global로 치환해준다.
		}
		System.out.println(globalMax);
	}
}
