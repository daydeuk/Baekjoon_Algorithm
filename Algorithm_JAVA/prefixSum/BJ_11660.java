import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //input
        
        // N, M 입력
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 입력값을 받을 배열 선언
        int[][] matrix = new int[N][N];
        for(int r=0;r<N;r++){
            st = new StringTokenizer(in.readLine(), " ");
            for(int c=0;c<N;c++){
                matrix[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 구간 합을 저장할 배열 선언
        int[][] sumMatrix = new int[N+1][N+1];
        for(int r=0;r<N;r++){
            // 구간 합 계산
            for(int c=0;c<N;c++){
                sumMatrix[r+1][c+1] = sumMatrix[r][c+1] + sumMatrix[r+1][c] - sumMatrix[r][c]
                + matrix[r][c];
            }
        }

        // 부분 합 계산
        for(int m=0;m<M;m++){
            st = new StringTokenizer(in.readLine(), " ");
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int answer = sumMatrix[y2+1][x2+1] - sumMatrix[y2+1][x1] - sumMatrix[y1][x2+1] + sumMatrix[y1][x1];
            System.out.println(answer);
        }
    }
}
