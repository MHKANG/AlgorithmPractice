package Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_2468_안전영역 {
	static int N;
	static int[][] map;
	static int max = Integer.MIN_VALUE;
	static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		int max_v = 0;
		int min_v = 100;
		
		for(int i = 0; i < N; i++) {
			for(int j =0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(max_v < map[i][j]) {
					max_v = map[i][j];
				}
				if(min_v > map[i][j]) {
					min_v = map[i][j];
				}
			}
		}
		
		for(int k = min_v-1; k <= max_v; k++) {
			List<Integer> ary = new ArrayList<>(); 
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j]> k) {
						ary.add(dfs(i, j, k, visited));
					}
				}
			}
//			System.out.println("높이 : "+ k +"영역 개수 :" + ary.size());
			max = Math.max(ary.size(), max);
		}
		
		System.out.println(max);
		
	}
	
	
	static int dfs(int s_row, int s_col, int high, boolean[][] visited) {
		
		Stack<node>st = new Stack<>();
		st.push(new node(s_row, s_col, map[s_row][s_col]));
		int area_size = 0;
		while(!st.isEmpty()) {
			node temp = st.pop();
//			System.out.println(temp.toString());
			if(visited[temp.getRow()][temp.getCol()]) {
				continue;
			}
			visited[temp.getRow()][temp.getCol()] = true;
			
			for(int i = 0; i < dirs.length; i++) {
				int nr = temp.row + dirs[i][0];
				int nc = temp.col + dirs[i][1];
				
				if(isIn(nr, nc) && map[nr][nc]>high && !visited[nr][nc]) {
					st.push(new node(nr, nc, map[nr][nc]));
					area_size++;
				}
			}
		}
//		System.out.println(area_size);
		return area_size;
	}
	
	// 영역안에 있는지 체크
	static boolean isIn(int r, int c) {
		return (r>=0 && r<N && c>=0 && c< N);
	}
	
	static class node{
		int row;
		int col;
		int val;
		@Override
		public String toString() {
			return "node [row=" + row + ", col=" + col + ", val=" + val + "]";
		}
		public node(int row, int col, int val) {
			super();
			this.row = row;
			this.col = col;
			this.val = val;
		}
		public node() {
			
		}
		public node(int row, int col) {
			this.row = row;
			this.col = col;
		}
		public int getRow() {
			return row;
		}
		public void setRow(int row) {
			this.row = row;
		}
		public int getCol() {
			return col;
		}
		public void setCol(int col) {
			this.col = col;
		}
		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		
		
	}
	
}
