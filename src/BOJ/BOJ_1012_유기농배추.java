package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;;

public class BOJ_1012_유기농배추 {
	private static int M, N, K;
	private static int[][]map;
	private static int[][]dirs = {{1,0}, {-1,0}, {0,1},{0,-1}};
	private static boolean visited[][];
	private static List<Integer>answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M]; 
			answer = new ArrayList<>();
			for(int i = 0; i <K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1 && !visited[i][j])
						dfs(i, j);
				}
			}
			System.out.println(answer.size());
		}
		
	}
	public static void printMap() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void dfs(int r, int c) {
		Stack<dot>s = new Stack<>();
		s.add(new dot(r,c));
		List<dot>path = new ArrayList<>();
		
		while(!s.isEmpty()) {
			dot top = s.pop();
			
			if(visited[top.r][top.c])
				continue;
			visited[top.r][top.c] = true;
			path.add(top);
			for(int i = 0; i < dirs.length; i++) {
				int nr = top.r + dirs[i][0];
				int nc = top.c + dirs[i][1];
				
				if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc]==1) {
					s.add(new dot(nr, nc));
				}
			}
		}
		answer.add(path.size());
		
	}
	public static boolean isIn(int nr, int nc) {
		return(nr>=0 && nr<N && nc>=0 && nc<M);
	}
	static class dot{
		int r;
		int c;
		public dot(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "dot [r=" + r + ", c=" + c + "]";
		}
		
	}
}
