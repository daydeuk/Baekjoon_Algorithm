package two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 신대득
 * 백준 3273 두수의 합
 * 투포인터 활용 문제
 * 구간 합을 구해버렸음.. (실수)
 */
public class baekjoon3273_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        // n^2 의 시간 => 10,000,000,000
        int[] input = new int[N];
        for(int n=0;n<N;n++){
            input[n]=Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(in.readLine());

        int start=0; int end=0; int count=0;
        int sum=input[end];
        while(true){
            // 탈출조건
            if(start>=N || end>=N){
                break;
            }
            // 반복문
            if(sum==x){ // 결과값을 찾으면
                count++;
                sum-=(input[start++]);
                //end++;
                if(start>=N){
                    break;
                }
                //sum+=input[end];
            } else if(sum<x){ // x보다 작으면 end를 늘려야함
                System.out.println("sum<x인경우 : start는 뭐냐면 "+start);
                System.out.println("sum<x인경우 : end는 뭐냐면 "+end);
                System.out.println("sum = "+ sum);
                System.out.println();
                end++;
                if(end>=N){
                    break;
                }
                sum+=input[end];
            } else if(sum>x){ // x보다 크면 start를 늘려야함
                System.out.println("sum>x인경우 : start는 뭐냐면 "+start);
                System.out.println("sum>x인경우 : end는 뭐냐면 "+end);
                System.out.println("sum = "+ sum);
                System.out.println();
                sum-=input[start++];
                if(start>=N){
                    break;
                }
            }
        }
        System.out.printf("%d", count);
    }

}
