import java.util.*;
import java.io.*;


public class Main
{
    public static int N;
    public static int resultValue;
    public static void main(String args[]) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        int[] check = new int[N];
        resultValue = 0;
        dfs(0, check);
        System.out.println(resultValue);
    }
    
    public static void dfs(int cur, int[] check){
        if(cur==N){
            resultValue++;
            return;
        }
        for(int value=0;value<N;value++){
            if(check(cur, value, check)){
                check[cur]=value;
                dfs(cur+1, check);
            }
        }
    }

    public static boolean check(int cur, int value, int[] check){
        for(int i=0;i<cur;i++){
            if(check[i]==value){
                return false;
            }
            if((cur-i) == Math.abs(value-check[i])){
                return false;
            }
        }        
        return true;
    }
}
