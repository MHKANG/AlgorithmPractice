package SAMSUNGSW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 삼성SW_연구소 {
	static int[][]map;
	static int[][]wall;
	static int[][]dir = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
	static int N, M;
	static int safeArea;
	static ArrayList<dot> virusList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		
		map = new int[N][M];
		
		safeArea = 0;
		virusList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] ==2)
					virusList.add(new dot(i, j));
			}
		}
		
		
		wall = copyMap(map);
		
		
		makeWall(0);
		
		System.out.println(safeArea);
		
		
	}
	
	
	public static int[][] copyMap(int[][] original) {
			
		
		int[][] copy = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copy[i][j] = original[i][j];
			}
		}
		
		
		
		return copy;
	}
	
	public static void makeWall(int depth) {
		if(depth==3) {
			spread();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(wall[i][j] == 0) {
					wall[i][j] = 1;
					makeWall(depth+1);
					wall[i][j] = 0;
				}
			}
		}
	}
	
	public static boolean isIn(int row, int col) {
		return row>=0 && row<N && col>=0 && col<M;
	}
	
	public static int countSafe(int[][]ary) {
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <M; j++) {
				if(ary[i][j] == 0)
					count++;
			}
		}
		return count;
	}
	
	
	public static void spread() {
		
		int[][]copy = copyMap(wall);
		
		Queue<dot>q = new LinkedList<>();
		
		for(int i = 0; i < virusList.size(); i++) {
			q.offer(new dot(virusList.get(i).row, virusList.get(i).col));
		}
		
		while(!q.isEmpty()) {
			dot front = q.poll();
			
			for(int d = 0; d<dir.length; d++) {
				int nr = front.row + dir[d][0];
				int nc = front.col + dir[d][1];
				
				if(isIn(nr, nc) && copy[nr][nc] == 0) {
					copy[nr][nc] = 2;
					q.offer(new dot(nr, nc));
				}
				
			}
			
		}
		int count = countSafe(copy);
		safeArea = Math.max(safeArea, count);
		
	}
	
	static class dot{
		int row;
		int col;
		
		public dot(int r, int c){
			row = r;
			col = c;
		}
	}
	
}
