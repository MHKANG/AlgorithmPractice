package Codility.Lesson5;

public class Cod_CountDiv {
	// Task : 100 Correctness : 100 Performance : 100
	public static void main(String[] args) {
		int A = 11;
		int B = 345;
		int K = 17;
		int answer = 0;
		
		
		if(A == 0)
			answer = B/ K +1;
		else
			answer = B /K - (A-1)/ K;
		// A-1인 이유는 A이전에 나오는 K의 배수 만큼 빼야 하기 때문 만약 A가 K의 배수면 1이 더해지기 때문이다.

        System.out.println(answer);
	}
}
