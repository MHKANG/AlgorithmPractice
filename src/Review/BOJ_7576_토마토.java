package Review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576_토마토 {
	static int N, M;
	static int[][]map;
	static boolean[][]visited;
	static int[][]dirs = {{1,0}, {-1,0},{0,1},{0,-1}};
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		ans = 0;
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		spread();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <M; j++) {
				ans = Math.max(ans, map[i][j]);
			}
		}
		//printMap();
		ans = ans-1;
		if(!check_spread()) {
			ans = -1;
		}
		System.out.println(ans);
	}
	
	static void printMap() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] +" ");
			}
			System.out.println();
		}
	}
	
	static void spread() {
		
		Queue<dot>que = new LinkedList();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					que.offer(new dot(i, j));
				}
			}
		}
		
		
		while(!que.isEmpty()) {
			dot temp = que.poll();
			
			if(visited[temp.getR()][temp.getC()]) {
				continue;
			}
			
			visited[temp.getR()][temp.getC()] = true;
			
			for(int i = 0; i < dirs.length; i++) {
				int nr = temp.getR()+dirs[i][0];
				int nc = temp.getC()+dirs[i][1];
				
				if(isIn(nr, nc) && map[nr][nc]!=-1 && map[nr][nc] == 0) {
				
					map[nr][nc] = map[temp.getR()][temp.getC()]+1;
					que.offer(new dot(nr, nc));		
				}
			}
		}
	}
	
	static boolean check_spread() {
		boolean check = true;
		
		loop:
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					check =false;
					break loop;
				}
			}
		}
		
		return check;
	}
	
	
	static boolean isIn(int r, int c) {
		return (r>=0 && r<N && c>=0 && c<M); 
	}
	
	static class dot{
		int r;
		int c;
		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}
		public int getC() {
			return c;
		}
		public void setC(int c) {
			this.c = c;
		}
		public dot(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public dot() {}
	}
}
