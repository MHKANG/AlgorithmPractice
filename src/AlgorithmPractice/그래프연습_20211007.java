package AlgorithmPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 그래프연습_20211007 {
	
	static int v;
	static List<Integer>[]graph;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		int M = sc.nextInt();
		int S = sc.nextInt();
		graph = new List[v+1];
		
		for(int i = 1; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i ++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			graph[s].add(e);
			graph[e].add(s);
		}
		dfs(S);
		bfs(S);
		
		
	}
	public static void dfs(int start) {
		boolean[] visited = new boolean[v+1];
		Stack<Integer> st = new Stack<>();
		List<Integer>path = new ArrayList<>();
		
		st.push(start);
		
		while(!st.isEmpty()) {
			Integer top = st.pop();
			
			if(visited[top]) {
				continue;
			}
			visited[top] = true;
			path.add(top);
			
			List<Integer>children = graph[top];
			for(int i = children.size()-1; i >=0 ; i--) {
				Integer child = children.get(i);
				if(!visited[child]) {
					st.push(child);
				}
					
			}
		}
		System.out.println("dfs 경로 : " + path);
	}
	public static void bfs(int start) {
		boolean[] visited = new boolean[v+1];
		Queue<Integer>que = new LinkedList<>();
		List<Integer>path = new ArrayList<>();
		
		que.offer(start);
		
		while(!que.isEmpty()) {
			Integer af = que.poll();
			
			if(visited[af])
				continue;
			visited[af] = true;
			path.add(af);
			
			List<Integer>children = graph[af];
			for(int i = 0; i < children.size(); i++) {
				Integer child = children.get(i);
				if(!visited[child])
					que.offer(child);
			}
		}
		System.out.println("bfs 경로 : " + path);
	}
}
