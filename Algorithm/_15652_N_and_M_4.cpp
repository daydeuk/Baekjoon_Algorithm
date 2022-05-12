#include<iostream>
using namespace std;
#define MAX 9
int N, M;
int arr[MAX] = {};

void dfs(int count,int start)
{
	if (count == M)
	{
		for (int i = 0; i < M; i++)
		{
			cout<<arr[i]<<" ";
		}
		cout << '\n';
	}
	else {
		for (int j = start; j <= N; j++)
		{
			arr[count] = j;
			dfs(count + 1, j);
		}
	}
}

int main()
{	
	cin >> N >> M;
	dfs(0,1);
	return 0;
}