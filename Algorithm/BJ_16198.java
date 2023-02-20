import java.io.*;
import java.util.*;

/**
 * 신대득
 * BJ_16198 에너지 모으기
 */
public class BJ_16198 {
    static int maxValue=0;
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(in.readLine()); // N 입력
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        List<Integer> weightList= new ArrayList<>();
        for(int n=0;n<N;n++) {
            weightList.add(Integer.parseInt(st.nextToken()));
        }
        // 걍 모든 경우 보자..
        findAnswer(weightList,0);
        System.out.printf("%d", maxValue);
    }

    public static void findAnswer(List<Integer> curList, int sum){
        // 기저조건
        if(curList.size()==2){
            maxValue=Math.max(maxValue,sum);
            return;
        }

        // 리스트 복사
        List<Integer> myList=new ArrayList<>();
        for(int i=0;i<curList.size();i++){
            myList.add(curList.get(i));
        }

        // 다음 재귀 출발
        for(int i=1;i<myList.size()-1;i++){
            int X=myList.get(i);
            int X1=myList.get(i-1);
            int X2=myList.get(i+1);
            int curSum= X1*X2 +sum;
            myList.remove(i);
            findAnswer(myList,curSum);
            myList.add(i, X);
        }
    }
}
