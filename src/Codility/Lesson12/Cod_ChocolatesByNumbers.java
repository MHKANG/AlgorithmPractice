package Codility.Lesson12;

public class Cod_ChocolatesByNumbers {
	public static void main(String[] args) {
		int M = 4;
		int N = 10;
		
		int answer = (int)N/GCD(M, N);
		
		System.out.println(answer);
	}
	
	public static int GCD(int N, int M) {
		if(M == 0)
			return N;
		return GCD(M, N%M);
	}
}
