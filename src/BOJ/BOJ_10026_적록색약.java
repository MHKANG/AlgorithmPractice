package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10026_적록색약 {
	static int N;
	static char[][]matrix;
	static int[][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][]visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		matrix = new char[N][N];
		visited = new boolean[N][N];
		int n_cnt = 0;
		int cb_cnt = 0;
		for(int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			
			for(int j = 0; j < temp.length(); j++) {
				matrix[i][j] = temp.charAt(j);
			}
		}
		
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <N; j++) {
				if(!visited[i][j]) {
					normal(i,j, matrix[i][j]);
					n_cnt++;
				}
			}
		}
		visited = new boolean[N][N];
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <N; j++) {
				if(!visited[i][j]) {
					color_blindness(i,j, matrix[i][j]);
					cb_cnt++;
				}
			}
		}
		
		System.out.println(n_cnt +" " + cb_cnt);
		
	}
	
	public static void normal(int row, int col, char color) {
		Queue<dot>q = new LinkedList<>();
		
		q.add(new dot(row, col, color));
		
		while(!q.isEmpty()) {
			dot top = q.poll();
			
			if(visited[top.r][top.c]) {
				continue;
			}
			visited[top.r][top.c] = true;
			
			for(int i = 0; i < dirs.length; i++) {
				int nr = top.r + dirs[i][0];
				int nc = top.c + dirs[i][1];
				
				if(isIn(nr, nc) && !visited[nr][nc]&& matrix[nr][nc] == top.color ) {
					q.add(new dot(nr, nc, matrix[nr][nc]));
				}
			}
		}
	}
	
	public static void color_blindness(int row, int col, char color) {
		Queue<dot>q = new LinkedList<>();
		
		q.add(new dot(row, col, color));
		
		while(!q.isEmpty()) {
			dot top = q.poll();
			
			if(visited[top.r][top.c]) {
				continue;
			}
			visited[top.r][top.c] = true;
			
			for(int i = 0; i < dirs.length; i++) {
				int nr = top.r + dirs[i][0];
				int nc = top.c + dirs[i][1];
				
				if(isIn(nr, nc) && !visited[nr][nc]) {
					if(matrix[nr][nc] =='R' && top.color =='G')
						q.add(new dot(nr, nc, matrix[nr][nc]));
					else if(matrix[nr][nc] =='G' && top.color =='R')
						q.add(new dot(nr, nc, matrix[nr][nc]));
					else if(matrix[nr][nc] == top.color)
						q.add(new dot(nr, nc, matrix[nr][nc]));
				}
			}
		}
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	
	static class dot{
		int r;
		int c;
		char color;
		dot(int row, int col, char color){
			this.r = row;
			this.c = col;
			this.color = color;
		}
	}
}
