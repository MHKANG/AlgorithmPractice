package BOJ;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_2407_조합 {
	
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		
		BigInteger num1 = BigInteger.ONE;
		BigInteger num2 = BigInteger.ONE;
		
		for(int i = 0; i < m; i++) {
			num1 = num1.multiply(new BigInteger(String.valueOf(n-i)));
			num2 = num2.multiply(new BigInteger(String.valueOf(i+1)));
		}
		
		System.out.println(num1.divide(num2));
		
		
		//System.out.println(combi(n,m));
		
	}
	
	
	// 시간 초과 재귀
	public static int combi (int n , int r) {
		if(n== r || r == 0 ) {
			return 1;
		}else {
			return combi(n-1, r-1) + combi(n-1, r);
		}
	}
	
	
}
