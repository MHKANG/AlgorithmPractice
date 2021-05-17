package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i <N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if(order.equals("push")) {
				int input = Integer.parseInt(st.nextToken());
				stack.push(input);
			}else if(order.equals("pop")) {
				if(stack.size()==0) {
					sb.append("-1").append("\n");
				}else {
					sb.append(Integer.toString(stack.pop())).append("\n");
				}
			}else if(order.equals("size")) {
					sb.append(Integer.toString(stack.size())).append("\n");
			}else if(order.equals("empty")) {
				if(stack.empty()) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
			}else if(order.equals("top")) {
				if(stack.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(Integer.toString(stack.peek())).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
