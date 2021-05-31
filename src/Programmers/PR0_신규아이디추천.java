package Programmers;

public class PR0_신규아이디추천 {
	public static void main(String[] args) {
		String answer;
		String input = "abcdefghijklmn.p";
		answer = step7(step6(step5(step4(step3(step2(step1(input)))))));
		System.out.println(answer);
	}
	// 대문자 범위 65 ~ 90
	// 소문자 범위 97 ~ 122
	 // 소문자 대문자로 변경
	public static String step1(String input) {
		String result;
		char[]arr;
		arr = input.toCharArray();
		for(int i = 0; i <input.length(); i++) {
			if(65 <=arr[i] && arr[i] <= 90) {
				arr[i] = (char)(arr[i]+32);
			}
		}
		
		result = String.valueOf(arr);
		return result;
	}
	public static String step2(String input) {
		StringBuilder result = new StringBuilder();
		char[] input_arr = input.toCharArray();
		for(char c : input_arr) {
			if((c >= 'a' && c<='z') || (c>='0' && c<='9') || c == '-' || c=='_' || c=='.' ) {
				result.append(c);
			}
		}
		
		
		return String.valueOf(result);
	}
	public static String step3(String input) {
		String result;
		result = input.replace("..", ".");
		while(result.contains("..")) {
			result = result.replace("..", ".");
		}
		
		return result;
	}
	public static String step4(String input) {
		String result = input;
		if(input.length()>0) {
			if(input.charAt(0) == '.') {
				result = result.substring(1, input.length());
			}
		}
		if (result.length() > 0) {
            if (result.charAt(result.length() - 1) == '.') {
                result = result.substring(0, result.length() - 1);
            }
        }
		return result;
	}
	public static String step5(String input) {
		String result = input;
		if(result.equals("")) {
			result= "a";
		}
		return result;
	}
	public static String step6(String input) {
		String result = input;
		if(result.length()>=16) {
			result = result.substring(0, 15);
			if(result.charAt(result.length()-1) == '.') {
				result = result.substring(0, result.length()-1);
			}
		}
		return result;
	}
	public static String step7(String input) {
		StringBuilder result = new StringBuilder(input);
		
		if(input.length()<=2) {
			char last = result.charAt(result.length()-1);
			
			while(result.length()<3) {
				result.append(last);
			}
		}
		
		return String.valueOf(result);
	}
}
