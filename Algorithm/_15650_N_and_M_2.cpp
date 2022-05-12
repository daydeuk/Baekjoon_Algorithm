#include<iostream>

using namespace std;

#define MAX 9
int N, M;
bool visited[MAX] = {};
int arr[MAX] = {};

void dfs(int count, int start)
{
	if (count == M)
	{
		for (int i = 0; i < M; i++)
		{
			cout << arr[i] << " ";
		}
		cout << '\n';
	}
	else {
		for (int j = start + 1; j <= N; j++)
		{
			if (!visited[j])
			{
				visited[j] = true;
				arr[count] = j;
				dfs(count + 1, j);
				visited[j] = false;
			}
		}
	}
}
int main()
{
	cin >> N >> M;
	dfs(0, 0);
	return 0;
}