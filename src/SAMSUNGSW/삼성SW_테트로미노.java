package SAMSUNGSW;

import java.util.Scanner;

public class 삼성SW_테트로미노 {
	
	static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
	static int Max = 0;
	static int N, M;
	static int[][]map;
	static boolean[][]visited;
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				makeTetro(i, j, 0, 0);
				makeMiddle(i, j);
			}
		}
		
		System.out.println(Max);
		
	}
	
	public static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
	
	public static void makeTetro(int r, int c, int depth, int sum) {
		
		if(depth==4) {
			Max = Math.max(Max, sum);
			return;
		}
		
		
		for(int i = 0; i < dirs.length; i++) {
			int nr = r + dirs[i][0];
			int nc = c + dirs[i][1];
			
			if(isIn(nr, nc) && !visited[nr][nc]) {
				visited[nr][nc] = true;
				makeTetro(nr, nc, depth+1, sum+map[nr][nc]);
				visited[nr][nc] = false;
			}
		}
		
	}
	// 'ㅗ' 모양을 dfs로 구현할 수 없기에 따로 만들어 준다. 
	public static void makeMiddle(int r, int c) {
		int wing = 4; // 가운데를 중심으로 상하 좌우 날개
		int min = Integer.MAX_VALUE;
		int sum = map[r][c];
		
		for(int i = 0; i < dirs.length; i++) {
			int nr = r + dirs[i][0];
			int nc = c + dirs[i][1];
			
			if(wing<=2)
				return;
			
			if(!isIn(nr,nc)) {
				wing--;
				continue;
			}
			min = Math.min(min, map[nr][nc]);
			sum = sum + map[nr][nc];
		}
		//만약에 모든 날개가 존재한다면 날개 중 가장 작은 값을 빼면 ㅗ 형태의 모양이 나온다.
		if(wing == 4) {
			sum = sum-min;
		}
		Max = Math.max(Max, sum);
	}
	
}
