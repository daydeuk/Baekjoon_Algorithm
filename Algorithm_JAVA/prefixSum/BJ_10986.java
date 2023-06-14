import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // input
        long resultCount = 0; // 결과 값을 저장할 변수
        // N,M 입력
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] matrix = new int[N+1]; // 입력값을 저장할 배열
        long[] sumMatrix = new long[N+1]; // 구간 합을 저장할 배열
        long[] modMatrix = new long[M]; // 나머지의 개수를 저장할 배열

        st = new StringTokenizer(in.readLine(), " ");
        for(int n=1;n<=N;n++){
            matrix[n] = Integer.parseInt(st.nextToken());
            sumMatrix[n] = sumMatrix[n-1] + (long)matrix[n];
            int modValue = (int)(sumMatrix[n] % M);
            if(modValue == 0){
                resultCount++;
            }
            modMatrix[modValue]++;
        }
        for(int i=0;i<M;i++){
            if(modMatrix[i]>1){
                resultCount += (modMatrix[i] * (modMatrix[i]-1) / 2); // nCr 공식
            }
        }
        System.out.println(resultCount);
    }
}
