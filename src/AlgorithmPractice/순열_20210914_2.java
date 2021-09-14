package AlgorithmPractice;

import java.util.Arrays;
import java.util.Scanner;

public class 순열_20210914_2 {
	static int N, R;
	static int[] input, result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		result = new int[R];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		permutation2(0, new boolean[N]);
		
	}
	
	public static void permutation(int cnt, boolean[] visited) {
		if(cnt == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for(int i = 0; i < input.length; i++) {
			if(visited[i])
				continue;
			result[cnt] = input[i];
			visited[i] = true;
			permutation(cnt+1, visited);
			visited[i] = false;
		}
	}
	public static void permutation2(int cnt, boolean[] visited) {
		if(cnt == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for(int i = 0; i < input.length; i++) {
			
			result[cnt] = input[i];
			permutation2(cnt+1, visited);
			
		}
	}
}
