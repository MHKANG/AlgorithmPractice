package BOJ;

import java.util.Scanner;

public class BOJ_10819_차이를최대로 {
	
	static int N;
	static int[] input;
	static int max;
	static int[] result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		max = Integer.MIN_VALUE;
		N = sc.nextInt();
		input = new int[N];
		result = new int[N];
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		permutation(0, new boolean[N]);
		System.out.println(max);
	}
	
	public static int calResult(int[]ary) {
		int sum = 0;
		for(int i = 0; i <ary.length-1; i++) {
			sum += Math.abs(ary[i+1]-ary[i]);
		}
		
		return sum;
	}
	
	public static void permutation(int cnt, boolean[] visited) {
		if(cnt == N) {
			int sum = calResult(result);
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < input.length; i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			result[cnt] = input[i];
			permutation(cnt+1, visited);
			visited[i] = false;
		}
	}
}
