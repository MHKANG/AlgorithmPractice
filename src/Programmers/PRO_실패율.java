package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PRO_실패율 {
	public static void main(String[] args) {
		int N = 4;
		int[] stages = {3,3,3,3,3};
		int[] answer = new int[N];
        
        int[] count = new int[N+1];
        List<FailRate> rateList = new ArrayList<>();
        for(int i = 0; i < stages.length; i++){
            if(stages[i] != N+1)
                count[stages[i]]++;
        }
        int challange = stages.length;
        
        System.out.println(Arrays.toString(count));
       
        for(int i = 1; i <count.length; i++){
            float r = 0;
            
            if(challange != 0) {
            	r = (float)count[i]/challange;
            	challange = challange - count[i];
            }
            
            System.out.println(r);
            rateList.add(new FailRate(i, r));
        }
        Collections.sort(rateList);
        for(int i = 0; i < answer.length; i++){
            answer[i] = rateList.get(i).Snum;
            System.out.print(answer[i] +" ");
        }
       
	}
	static class FailRate implements Comparable<FailRate>{
        int Snum;
        float Rate;
        
        public FailRate(int num, float rate){
            this.Snum = num;
            this.Rate = rate;
        }
        
        @Override
        public int compareTo(FailRate fr){
            if(this.Rate <fr.Rate){
                return 1;
            }
            else if(this.Rate == fr.Rate){
                if(this.Snum > fr.Snum){
                    return 1;
                }
            }
            return -1;
        }
    }
}
