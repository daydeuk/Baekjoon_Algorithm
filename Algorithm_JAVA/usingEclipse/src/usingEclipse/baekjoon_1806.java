package usingEclipse;

import java.io.*;
import java.util.*;

/**
 * 
 * @author 신대득
 * 백준 1806번 : 부분합 문제
 */

public class baekjoon_1806 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// N, S 입력
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] input = new int[N];
		// 수열 입력
		st = new StringTokenizer(in.readLine(), " ");
		for (int n = 0; n < N; n++) {
			input[n] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;

		int minLength=Integer.MAX_VALUE;
		long sum = 0;
		sum+=input[end];
		while (true) {
			if (start >= N) {
				break;
			}
			if (end>=N) {
				end=N-1;
			}
			if(start>end) {
				end=start;
			}
			// 이 부분이 없어야한다!!!!!!!!!!!!
			// 이 부분의 시간이 없어져야 투포인트의 이유!!!!!!!!!!!
			/*
			for (int cur = start; cur <= end; cur++) {
				sum += (long)input[cur];
			}
			*/
			if(sum>=S) {
				int length=end-start+1;
				minLength=Math.min(minLength, length);
				sum-=input[start];
				start++;
			} 
			if(sum<S) {
				// end가 끝까지 갔는데도 sum이 더 작으면 끝내야함.
				if(end==N-1) {
					break;
				}else if(end<N-1){
					end++;
					sum+=input[end];
				}
			}
		}
		if(minLength== Integer.MAX_VALUE) {
			System.out.print(0);
		}else {
			System.out.printf("%d", minLength);
		}
	}
}
