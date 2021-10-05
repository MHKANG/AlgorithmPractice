package AlgorithmPractice;

import java.util.Arrays;
import java.util.Scanner;

public class 순열_20211006 {
	
	static int[] result;
	static int N, R;
	static int[] input;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		result = new int[R];
		permutation(0, new boolean[N]);
		
		
		
	}
	
	public static void permutation(int cnt, boolean[] visited) {
		if(cnt==R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i = 0; i <N; i ++) {
			if(visited[i])
				continue;
			visited[i] = true;
			result[cnt] = input[i];
			permutation(cnt+1, visited);
			visited[i] = false;
		}
	}
	// 중복 순열
	public static void permutation2(int cnt) {
		if(cnt==R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		for(int i = 0; i <N; i ++) {
			
			result[cnt] = input[i];
			permutation2(cnt+1);
			
		}
	}
}
