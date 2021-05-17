package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {
	private static int[][]matrix;
	private static int[][]result;
	private static int N;
	private static Queue<Integer>q = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		result = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {
			bfs(i);
 		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	
	}
	private static void bfs(int v) {
		Queue<Integer>q = new LinkedList<>();
		boolean visited[] = new boolean[N];
		q.add(v);
		
		while(!q.isEmpty()) {
			int front = q.poll();
			for(int i = 0; i < N; i++) {
				if(matrix[front][i] ==1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					result[v][i] = 1;
				}
			}
		}
	}
}
