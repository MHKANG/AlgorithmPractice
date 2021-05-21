package Programmers;

import java.util.ArrayList;
import java.util.List;

public class PRO_기능개발 {
	 public int[] solution(int[] progresses, int[] speeds) {
	        
	        
	        List<Work> list = new ArrayList<>();
	        List<Integer> result = new ArrayList<>();
	        for(int i = 0; i < progresses.length; i++){
	            Work temp = new Work(progresses[i], speeds[i]);
	            list.add(temp);
	        }
	        
	        while(!list.isEmpty()){
	            int r_count = 0;
	            for(int i = 0; i < list.size(); i++){
	                list.get(i).progress += list.get(i).speed;
	            }
	            
	            for(int i = 0; i < list.size(); i++){
	                
	                if(i == 0 && list.get(i).progress >=100){
	                    r_count++;
	                    list.remove(i);
	                    i--;
	                }else if(r_count > 0 && list.get(i).progress <100){
	                    break;
	                }else if(r_count > 0 && list.get(i).progress >=100){
	                    r_count++;
	                    list.remove(i);
	                    i--;
	                }
	                
	                
	            }
	            if(r_count >0){
	                result.add(r_count);
	            }
	        }
	        
	        int[] answer = new int[result.size()];
	        
	        for(int i = 0; i < answer.length; i++){
	            answer[i] = result.get(i);
	        }
	       
	        
	        return answer;
	        
	    
	    }
	    
	    
	    static class Work{
	        int progress;
	        int speed;
	        
	        public Work(int p, int s){
	            this.progress = p;
	            this.speed = s;
	        }
	    }
}
