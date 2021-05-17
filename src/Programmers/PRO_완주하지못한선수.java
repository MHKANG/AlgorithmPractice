package Programmers;

import java.util.Arrays;

public class PRO_완주하지못한선수 {
	public String solution(String[] participant, String[] completion) {
		 String answer = "";
	        
	        Arrays.sort(participant);
	        Arrays.sort(completion);
	        
	        boolean check = true;
	        for(int i = 0; i < completion.length; i++){
	            if(!participant[i].equals(completion[i])){
	                answer = participant[i];
	                check = false;
	                break;
	            }
	        }
	        if(check){
	            answer = participant[participant.length-1];
	        }
	       
	        
	        return answer;
	}
}
