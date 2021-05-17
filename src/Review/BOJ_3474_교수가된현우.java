package Review;

import java.util.Scanner;

public class BOJ_3474_교수가된현우 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 StringBuilder sb = new StringBuilder();
		 int T = sc.nextInt();
		 
		 for(int i = 0; i < T; i++) {
			 long Num = sc.nextLong();
			 sb.append(count_five(Num)).append("\n");
		 }
		 System.out.print(sb);
	}

	
	public static int count_five(long N) {
		int count = 0;
		for(int i = 5; i <=N; i*=5) {
			count += N/i;
		}
		
		return count;
	}
}
