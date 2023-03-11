package two_pointer;

import java.io.*;
import java.util.*;

/**
 * 신대득
 * 백준 3273 두수의 합
 * 투포인터 활용 문제
 */
public class baekjoon3273 {
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
        Arrays.sort(input);
        int start=0; int end=N-1; int count=0;
        while(true){
            if(start==end){
                break;
            }
            int sum=input[start]+input[end];
            if(sum==x){
                count++;
                start++;
            } else if(sum<x){
                start++;
            } else if(sum>x){
                end--;
            }
        }
        System.out.printf("%d", count);

    }

}
