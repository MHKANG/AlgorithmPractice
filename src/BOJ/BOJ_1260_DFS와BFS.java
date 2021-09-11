package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_1260_DFS와BFS {
	static int N, M;
	static List<Integer>[] graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int start = sc.nextInt();
		graph = new List[N+1];
		for(int i = 0; i <N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i <M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			graph[s].add(e);
			graph[e].add(s);
		}
		for(int i = 0; i < graph.length; i++) {
			Collections.sort(graph[i]);
		}
		
		dfs(start);
		System.out.println();
		bfs(start);
		
	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		List<Integer> l = new ArrayList<>();
		boolean[] visited = new boolean[N+1];
		
		q.offer(start);
		
		while(!q.isEmpty()) {
			int top = q.poll();
			
			if(visited[top])
				continue;
			visited[top] = true;
			l.add(top);
			List<Integer> children = graph[top];
			for(int i = 0; i < children.size(); i++) {
				int child = children.get(i);
				if(!visited[child]) {
					
					q.offer(child);
				}
			}
		}
		
		for(int i = 0; i <l.size(); i++) {
			System.out.print(l.get(i) +" ");
		}
	}
	public static void dfs(int start) {
		Stack<Integer> s = new Stack<>();
		List<Integer> l = new ArrayList<>();
		boolean[] visited = new boolean[N+1];
		
		s.push(start);
		while(!s.isEmpty()) {
			int top = s.pop();
	
			if(visited[top])
				continue;
			visited[top] = true;
			l.add(top);
			List<Integer> children = graph[top];
			for(int i = children.size()-1; i >=0; i--) {
				int child = children.get(i);
				if(!visited[child]) {
					s.push(child);
				}
			}
		}
		
		for(int i = 0; i <l.size(); i++) {
			System.out.print(l.get(i) +" ");
		}
	}
}
