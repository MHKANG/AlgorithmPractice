package AlgorithmPractice;

import java.util.Arrays;
import java.util.Scanner;

public class 순열_20210914 {
	static int N, R;
	static int[] numbers;
	static int[] result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		numbers = new int[N];
		result = new int[R];
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		permutation(0, new boolean[N]);
	}
	
	public static void permutation(int cnt, boolean[]visited) {
		
		if(cnt == R) {
			System.out.println(Arrays.toString(result));
			return ;
		}
		for(int i = 0; i < numbers.length; i++) {
			if(visited[i])
				continue;
			result[cnt]= numbers[i];
			visited[i] = true;
			permutation(cnt+1, visited);
			visited[i] = false;
			
		}
	}
	// 중복 순열
	public static void permutation2(int cnt) {
		
		if(cnt == R) {
			System.out.println(Arrays.toString(result));
			return ;
		}
		for(int i = 0; i < numbers.length; i++) {
			
			result[cnt]= numbers[i];
		
			permutation2(cnt+1);
			
			
		}
	}
}
