package Programmers;

import java.util.*;

public class PRO_메뉴리뉴얼 {
	static HashMap<String, Integer>map;
    static int tempCount = 0;
    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String>pq = new PriorityQueue<String>();
        for(int i = 0; i < course.length; i++) {
        	map = new HashMap<String, Integer>();
        	tempCount = 0;
        	for(int j = 0; j < orders.length; j ++) {
        		combi(0, 0, course[i], "", orders[j]);
        	}
        	for(String s : map.keySet()) {
        		if(map.get(s)==tempCount && tempCount>1) {
        			pq.offer(s);
        		}
        	}
        }
        String[] answer = new String[pq.size()];
        int num = 0;
        while(!pq.isEmpty()) {
        	answer[num++] = pq.poll();
        }
        
        return answer;
    }
    
    public static void combi(int cnt, int cur,int menuCount , String result, String order){
        if(cnt == menuCount){
        	char[] c = result.toCharArray();
        	Arrays.sort(c);
        	String str = "";
        	for(int i= 0; i < c.length; i ++) {
        		str+=c[i];
        	}
        	map.put(str, map.getOrDefault(str, 0)+1);
        	tempCount = Math.max(tempCount, map.get(str));
        	return;
        }
        for(int i = cur; i < order.length(); i ++) {
        	char now = order.charAt(i);
        	combi(cnt+1,i+1, menuCount, result+now, order);
        	
        	
        }
    }
}
