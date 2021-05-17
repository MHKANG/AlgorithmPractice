package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PRO_모의고사 {
	public int[] solution(int[] answers) {
        int[] answer;
        
        List<Integer> list = new ArrayList();
        
        int[] num1 = new int [10000];
        int[] num2 = new int [10000];
        int[] num3 = new int [10000];
        
        int[] count = {0, 0 ,0};
        
        for(int i = 0; i < 10000; i++){
            if(i%5 == 0){
                num1[i] = 1;
            }
            if(i%5== 1){
                num1[i] = 2;
            }
            if(i%5== 2){
                num1[i] = 3;
            }
            if(i%5== 3){
                num1[i] = 4;
            }
            if(i%5== 4){
                num1[i] = 5;
            }
            
            if(i%8== 0){
                num2[i] = 2;
            }
            if(i%8== 1){
                num2[i] = 1;
            }
            if(i%8== 2){
                num2[i] = 2;
            }
            if(i%8== 3){
                num2[i] = 3;
            }
            if(i%8== 4){
                num2[i] = 2;
            }
            if(i%8== 5){
                num2[i] = 4;
            }
            if(i%8== 6){
                num2[i] = 2;
            }
            if(i%8== 7){
                num2[i] = 5;
            }
            
            if(i%10==0){
                num3[i] = 3;
            }
            if(i%10==1){
                num3[i] = 3;
            }
            if(i%10==2){
                num3[i] = 1;
            }
            if(i%10==3){
                num3[i] = 1;
            }
            if(i%10==4){
                num3[i] = 2;
            }
            if(i%10==5){
                num3[i] = 2;
            }
            if(i%10==6){
                num3[i] = 4;
            }
            if(i%10==7){
                num3[i] = 4;
            }
            if(i%10==8){
                num3[i] = 5;
            }
            if(i%10==9){
                num3[i] = 5;
            }
        }
        
        for(int i = 0; i < answers.length; i++){
            if(num1[i] == answers[i])
                count[0]++;
            if(num2[i] == answers[i])
                count[1]++;
            if(num3[i] == answers[i])
                count[2]++;
        }
        
        int[] countCopy = count.clone();
        Arrays.sort(countCopy);
        int max = countCopy[2];
        
        for(int i = 0; i < 3; i++){
            if(count[i] == max){
                list.add(i+1);
            }
        }
        
        answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
        
    }
}
