package Codility.Lesson9;

public class Cod_MaxSliceSum_other {
	// Task 30 Correctness 37 Performance 20
	public static void main(String[] args) {
		int A[] = {-2, 1};
		
		int answer = 0;
        if(A.length==1){
            answer = A[0];
        }
        int localSum = A[0];
        answer = A[0];
        
        for(int i = 1; i < A.length; i ++) {
        	localSum = Math.max(A[i], localSum + A[i]);
        	answer = Math.max(answer, localSum);
        }
        
        System.out.println(answer);
		
	}
}
