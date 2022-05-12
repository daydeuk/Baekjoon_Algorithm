#include <iostream>
using namespace std;
#define MAX 15
int N;
int result_count;
int visited[MAX] = {};
int arr[MAX] = {};

bool check(int check_number)
{
	for (int i = 0; i < check_number; i++)
	{
		if (arr[i] == arr[check_number] || abs(arr[check_number] - arr[i]) == check_number - i)return false;
	}
	return true;
}

void dfs(int count)
{
	if (count == N)
	{
		result_count++;
		return;
	}
	else {
		for (int i = 0; i < N; i++)
		{
			arr[count] = i;
			if (check(count))
			{
				dfs(count + 1);
			}
		}
	}
}
int main()
{
	cin >> N;
	dfs(0);
	//0은 array를 뜻함.
	if (result_count > 0)
	{
		cout << result_count;
	}
	return 0;
}