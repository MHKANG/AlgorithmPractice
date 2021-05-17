package BOJ;

import java.util.Scanner;
import java.util.Arrays;

public class BOJ_6603_로또 {
	public static void main(String[] args) {
		int K;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			K = sc.nextInt();
			if(K== 0) {
				break;
			}
			
			int[] ary = new int[K];
			for(int i = 0; i < K; i++) {
				ary[i] = sc.nextInt();
			}
			int[] result = new int[6];
			System.out.println();
			combination(ary, 0, 0,result);
		}
		
	}
	public static void combination(int[] ary, int cnt, int cur, int[] result) {
		
		if(cnt==6) {
			Arrays.sort(result);
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i = cur; i < ary.length; i++) {
				result[cnt] = ary[i];
				combination(ary, cnt+1, i+1,result);
		}
		
	}
}
