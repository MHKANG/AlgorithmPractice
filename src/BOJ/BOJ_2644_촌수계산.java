package BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2644_촌수계산 {
	static int N, start, end, M;
	static List<Integer>[] rel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		start = sc.nextInt();
		end = sc.nextInt();
		M = sc.nextInt();
		rel = new List[N+1];
		for(int i = 1; i <=N; i++) {
			rel[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			rel[s].add(e);
			rel[e].add(s);
		}
		System.out.println(bfs(start, end));
	}
	
	public static int bfs(int start, int end) {
		Queue<vertex> q= new LinkedList<>();
		boolean[]visited = new boolean[N+1];
		q.offer(new vertex(start, 0));
		int depth = 0;
		List<vertex>path = new ArrayList<>();
		while(!q.isEmpty()) {
			vertex top = q.poll();
			
			if(visited[top.idx])
				continue;
			
			visited[top.idx] = true;
			path.add(top);
			depth = top.depth;
			List<Integer>children = rel[top.idx];
			for(int i = 0; i < children.size(); i++) {
				int child = children.get(i);
				if(!visited[child]) {
					if(child == end) {
						return depth+1;
					}
					q.offer(new vertex(child, depth+1));
				}
			}
		}
		return -1;
	}
	
	static class vertex {
		int idx;
		int depth;
		
		public vertex(int idx, int depth) {
			this.idx = idx;
			this.depth = depth;
		}
	}
}
