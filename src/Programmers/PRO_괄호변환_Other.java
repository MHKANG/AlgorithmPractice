package Programmers;

import java.util.Stack;

// Reference : https://velog.io/@zayson/프로그래머스-Java-괄호-변환
// StringBuilder를 사용하면 좀 더 편하게 문제를 해결 할 수 있었다.
public class PRO_괄호변환_Other {

	public static String solution(String p) {
		if(p.length()==0) {
			return "";
		}
		
		StringBuilder answer = new StringBuilder();
		StringBuilder sb = new StringBuilder(p);
		StringBuilder u = new StringBuilder();
		StringBuilder v = new StringBuilder();
		
		int o = 0;
		int c = 0;
		// 이부분 처리가 잘못되어서 다른 테스트 문을 통과 못한 것으로 보임
		// 균형잡힌 괄호문인 것을 판단하는 순간 바로 변환 과정을 들어가야 된다.
		for(int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i)=='(') {
				o++;
			}else if(sb.charAt(i)==')') {
				c++;
			}
			if(o == c) {
				u.append(sb.subSequence(0, i+1));
				v.append(sb.substring(i+1));
				break;
			}
		}
		if(checkRight(u.toString())) {
			return u.append(solution(v.toString())).toString();
		}
		answer.append("(").append(solution(v.toString())).append(")");
		u.deleteCharAt(0);
		u.deleteCharAt(u.length()-1);
		String temp = u.toString();
		StringBuilder temp2 = new StringBuilder();
		for(char ch : temp.toCharArray()) {
			if(ch=='(') {
				temp2.append(")");
			}else if(ch==')') {
				temp2.append("(");
			}
		}
		answer.append(temp2.toString());
		return answer.toString();
		
	}
	
	public static boolean checkRight(String str){
        boolean result = true;
        Stack<Character>st = new Stack<>();
        for(int i = 0; i <str.length(); i++){
            if(st.isEmpty()) {
            	st.push(str.charAt(i));
            }else if(str.charAt(i) == ')' && st.peek()=='(') {
            	st.pop();
            }else {
            	st.push(str.charAt(i));
            }
        }
        if(!st.empty())
        	result = false;
        
        return result;
    }
	
}
