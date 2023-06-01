import java.util.*;
import java.io.*;


public class Main
{
    public static int N;
    public static int[][] matrix;
    public static int resultValue;
    public static void main(String args[]) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine()); // 전체 사람 수
        matrix = new int[N][N];
        for(int r=0;r<N;r++){
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            for(int c=0;c<N;c++){
                matrix[r][c]=Integer.parseInt(st.nextToken());
            }
        }
        resultValue = Integer.MAX_VALUE;
        boolean[] startTeam = new boolean[N];
        dfs(0, 0, startTeam);
        System.out.println(resultValue);
    }
    public static void dfs(int cur, int startValue, boolean[] startTeam){
        if(cur== N/2){
            int startTeamValue = 0;
            int linkTeamValue = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    // 스타트 팀
                    if(startTeam[i] && startTeam[j]){
                        startTeamValue += matrix[i][j];
                    }
                    // 링크 팀
                    if(!startTeam[i] && !startTeam[j]){
                        linkTeamValue += matrix[i][j];
                    }
                }
            }
            resultValue = Math.min(resultValue, Math.abs(startTeamValue - linkTeamValue));
            return;
        }

        for(int n=startValue;n<N;n++){
            startTeam[n]=true;
            dfs(cur+1, n+1, startTeam);
            startTeam[n]=false;
        }
    }
}
