package Programmers;

import java.util.Stack;

public class PRO_괄호변환 {
	
	public static void main(String[] args) {
		
		System.out.println(solution("()))((()"));
		
	}
	
	
	static String result = "";
    public static String solution(String p) {
        String answer = "";
        answer = divide(p);
        return answer;
    }
    public static String divide(String str){
        if(str.length() == 0){
            return "";
        }else if(checkRight(str)){
            return str;
        }else if(str.length()==2) {
        	String u = str.substring(0, 2);
            String v = "";
            
            if(checkRight(u)){
                result+= u;
                return divide(v);
            }else{
                divide(v);
                u = "";
                String temp="";
                
                return result+"("+temp+")"+divide(v);
                
            }
        }
        
        for(int i = 2; i < str.length(); i++){
        	
            String u = str.substring(0, i);
            String v = str.substring(i, str.length());
            
            if(checkRight(u)){
                result+= u;
                return divide(v);
            }else if(checkBalance(u)) {
            	divide(v);
	        	u = u.substring(1, u.length()-1);
	             
	            String temp = "";
	            for(int j = 0; j < u.length(); j++){
	                if(u.charAt(j) =='('){
	                    temp+=")";
	                }else{
	                    temp+="(";
	                }
	            }
	            return result+"("+temp+")"+divide(v);
            }  
        }
        return result;
        
    }
    public static boolean checkBalance(String str){
        int count1 = 0;
        int count2 = 0;
        boolean result = true;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)=='('){
                count1 ++;
            }else if(str.charAt(i)==')'){
                count2 ++;
            }
        }
        if(count1!=count2){
            result = false;
        }
        
        return result;
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
