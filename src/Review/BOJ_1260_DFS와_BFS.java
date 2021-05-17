package Review;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1260_DFS와_BFS {
	
	static List<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		graph = new List[N+1];
		
		for(int i = 0; i < graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		int s, e;
		for(int i =0; i < M; i++) {
			s = sc.nextInt();
			e = sc.nextInt();
			graph[s].add(e);
			graph[e].add(s);
		}
		for(int i = 0; i < graph.length; i++) {
			Collections.sort(graph[i]);
		}
		dfs(V,N);
		System.out.println();
		bfs(V, N);
		
	}
	public static void dfs(int V, int N) {
		visited = new boolean[N+1];
		Stack<Integer>stack = new Stack<>();
		List<Integer>path = new ArrayList<>();
		
		stack.push(V);
		
		while(!stack.isEmpty()) {
			
			Integer top = stack.pop();
			
			if(visited[top]) {
				continue;
			}
			
			visited[top] = true;
			path.add(top);
			
			List<Integer>children = graph[top];
			for(int i = children.size()-1; i >=0 ; i--) {
				Integer child = children.get(i);
				if(!visited[child]) {
					stack.push(child);
				}
			}
		}
		
		for(int i = 0; i < path.size(); i++) {
			System.out.print(path.get(i)+" ");
		}
	}
	public static void bfs(int V, int N) {
		visited = new boolean[N+1];
		List<Integer>path = new ArrayList<>();
		Queue<Integer>que = new LinkedList<>();
		
		que.offer(V);
		
		while(!que.isEmpty()) {
			Integer front = que.poll();
		
			if(visited[front]) {
				continue;
			}
			visited[front] = true;
			path.add(front);
			
			List<Integer>children = graph[front];
			
			for(int i = 0; i < children.size(); i++) {
				Integer child = children.get(i);
				if(!visited[child]) {
					que.offer(child);
				}
			}
		}
		
		for(int i = 0; i < path.size(); i++) {
			System.out.print(path.get(i)+" ");
		}
		
		
	}
}
