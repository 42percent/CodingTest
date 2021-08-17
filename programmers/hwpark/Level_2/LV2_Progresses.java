import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LV2_Progresses {
	/**
	 *  https://programmers.co.kr/learn/courses/30/lessons/42586
	 * @author H.W.PARK
	 * @return  
	 */
	public static int[] solution(int[] progresses, int[] speeds) {
		
        List<Integer> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
       
        for(int i=0; i < progresses.length; i++) {
        	int day=0;
        	while(progresses[i] < 100) {
        		progresses[i] += speeds[i];
        		day++;
        	}
        	temp.add(day);
        }
        int i=0;
        int cnt=1;
        while(true) {
        	if(temp.get(i) >= temp.get(i+1)) {
        		temp.remove(i+1);
        		cnt++;
        	}else {
        		i++;
        		list.add(cnt);
        		cnt=1;
        	}
        	if(temp.size() -1 == list.size()){
                list.add(cnt);
                break;
            }
        	
        }
        int[] answer = new int[list.size()];
        for(int a=0; a < list.size(); a++) {
        	answer[a] = list.get(a);
        }
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] progess = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		solution(progess,speeds);
	}
}
