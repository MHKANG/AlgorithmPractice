package Codility.Lesson4;

public class Cod_PermCheck {
	// Task : 100% , Correctness : 100% , Performance : 100%
	public static void main(String[] args) {
		int A[] = {4, 1, 3, 2};
		
		int N = A.length;
        int answer = 1;
        boolean[] check = new boolean[N+1];

        for(int i = 0; i < A.length; i++){
            if(A[i] <= N){
                check[A[i]] = true;
            }
        }

        for(int i = 1; i < check.length; i++){
            if(!check[i]){
                answer = 0;
                break;
            }
        }
        System.out.println(answer);
	}
}
