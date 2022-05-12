#include<iostream>
using namespace std;

#define MAX 8;
int arr[8] = {};
//visited ¾È½áµµ µÊ
int N, M;

void dfs(int count)
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
		for (int j = 1; j <= N; j++)
		{
			arr[count] = j;
			dfs(count + 1);
		}
	}
}
int main()
{
	cin >> N >> M;
	dfs(0);
	return 0;
}