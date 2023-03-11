import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

/**
 * 신대득
 * BJ_2447 별 찍기 - 10
 */
public class BJ_2447 {
    static char[][] matrix;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(in.readLine());
        matrix= new char[N+1][N+1];
        int k=0;
        int n=N;
        while(n>1){
            n/=3;
            k++;
        }
        for(int r=1;r<=N;r++){
            for(int c=1;c<=N;c++){
                matrix[r][c]='*';
            }
        }
        findAnswer(N,N, N);
        for(int r=1;r<=N;r++){
            for(int c=1;c<=N;c++){
                System.out.printf("%c", matrix[r][c]);
            }
            System.out.println();
        }
    }

    public static void findAnswer(int startN, int startR, int startC) {
        // 초과막기
        if(startN==0){
            return;
        }
//        int start=N/3;
        for(int r=startR/3+1; r<= (startR/3) + startN/3 ;r++){
            for(int c= (startC/3)+1;c<= (startC/3) + startN/3 ;c++){
                matrix[r][c]=' ';
            }
        }
        /*
        for(int r=startR+1;r<=startR+startN;r++){
            for (int c = startC + 1; c <=startC+startN; c++) {
                matrix[r][c] = ' ';
            }
        }
         */
        findAnswer(startN/3, startR/3, startC/3);
        findAnswer(startN/3, startR/3, startC/3+startN);
        findAnswer(startN/3, startR/3, startC/3+2*startN);

        findAnswer(startN/3, startR+startN/3, startC/3);
        findAnswer(startN/3, startR+startN/3, startC/3+startN*2);

        findAnswer(startN/3, startR/3+startN*2, startC/3);
        findAnswer(startN/3, startR/3+startN*2, startC/3+startN);
        findAnswer(startN/3, startR/3+startN*2, startC/3+startN*2);

        /*
        findAnswer(startN/3, startR/3, startC/3);
        findAnswer(startN/3, startR/3, startC/3+startN);
        findAnswer(startN/3, startR/3, startC/3+2*startN);
        findAnswer(startN/3, startR+startN, startC/3);
        //findAnswer(startN/3, startR/3+startN, startC/3+startN);
        findAnswer(startN/3, startR/3+startN, startC/3+startN*2);

        findAnswer(startN/3, startR/3+startN*2, startC/3);
        findAnswer(startN/3, startR/3+startN*2, startC/3+startN);
        findAnswer(startN/3, startR/3+startN*2, startC/3+startN*2);
         */
//        findAnswer(startR/3, startC);
    }
}
