#include<iostream>

using namespace std;

#define MAX 9

int N, M;
int arr[MAX] = { 0, };
bool visited[MAX] = { 0, };

void dfs(int count)
{
	if (count == M)
	{
		for (int i = 0; i < M; i++)
		{
			cout << arr[i] << " ";
		}
		//cout << endl;
		cout << '\n';
		return;
	}
	else
	{
		for (int j = 1; j <= N; j++)
		{
			if (!visited[j])
			{
				visited[j] = true;
				arr[count] = j;
				dfs(count + 1);
				visited[j] = false;
			}
		}
	}
}
int main()
{
	cin >> N >> M;
	dfs(0);
	return 0;
}