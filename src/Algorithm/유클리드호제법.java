package Algorithm;

public class 유클리드호제법 {
	public static void main(String[] args) {
		int N = 10;
		int M = 5;
		
		System.out.println(GCD2(N, M));
	}
	
	public static int GCD1(int N, int M) {
		if(M == 0)
			return N;
		return GCD1(M, N%M);
	}
	
	public static int GCD2(int N, int M) {
		if(N==M)
			return N;
		if(N>M)
			return GCD2(N-M, M);
		else
			return GCD2(N, M-N);
	}
}
