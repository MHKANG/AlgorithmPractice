package AlgorithmPractice;

import java.util.Arrays;
import java.util.Scanner;

public class 조합_20211006 {
	
	static int N, R;
	static int[] input;
	static int[] result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		result = new int[R];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		combination(0, 0);
	}
	
	public static void combination(int cnt, int cur) {
		if(cnt == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i = cur; i <N; i++) {
			result[cnt] = input[i];
			combination(cnt+1, i+1);
		}
	}
	//중복 조합
	public static void combination2(int cnt, int cur){
		if(cnt == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i = 0; i <N; i++) {
			result[cnt] = input[i];
			combination(cnt+1, i);
		}
	}
}
