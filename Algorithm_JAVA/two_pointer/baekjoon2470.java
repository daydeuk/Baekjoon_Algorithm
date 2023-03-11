package two_pointer;

import java.io.*;
import java.util.*;

/**
 * 신대득
 * 백준 2470 두용액
 */
public class baekjoon2470 {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        long[] input= new long[N];
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for(int n=0;n<N;n++){
            input[n]=Long.parseLong(st.nextToken());
        }
        Arrays.sort(input);
        int start=0;
        int end=N-1;
        long minValue=2000000000;
        int resultStart=-1;
        int resultEnd=-1;

        while(true){
            if(start==end){
                break;
            }
            long curValue=Math.abs(input[start]+input[end]);
            if(curValue< minValue){
                minValue=curValue;
                resultStart=start;
                resultEnd=end;
                if(minValue==0){
                    break;
                }
            }else{
                if(Math.abs(input[start]) < Math.abs(input[end])){
                    end--;
                } else{
                    start++;
                }
                // curValue가 양수인지 음수인지에 의해서 end--, start++ 가능
            }
        }
        System.out.printf("%d %d", input[resultStart], input[resultEnd]);

    }
}
