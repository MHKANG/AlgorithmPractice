package Review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11403_경로찾기 {
	private static int[][] matrix;
	private static int[][] result;
	private static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		matrix = new int[N][N];
		result = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i <N; i++) {
			check(i);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void check(int v) {
		Queue<Integer>q = new LinkedList<>();
		boolean visited[] = new boolean[N];
		q.add(v);
		
		while(!q.isEmpty()) {
			int front = q.poll();
			for(int i = 0; i < N; i++) {
				if(matrix[front][i]==1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					result[v][i] = 1;
				}
			}
		}
	}
}
