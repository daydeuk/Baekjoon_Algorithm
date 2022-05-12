#include<iostream>
#include<vector>
#include<numeric>
using namespace std;
int N;

bool find_producer(int p)
{
	vector<int> v_disassemble;
	int temp_index = p;
	while (1)
	{
		if (temp_index == 0)
		{
			break;
		}
		v_disassemble.push_back(temp_index % 10);
		temp_index = temp_index / 10;
	}
	int sum = 0;
	sum = accumulate(v_disassemble.begin(), v_disassemble.end(), 0);
	sum += p;

	if (sum == N)
	{
		return true;
	}
	return false;
}

int main()
{
	cin >> N;
	int result = 0;
	for (int i = 0; i < N; i++)
	{
		if (find_producer(i))
		{
			result = i;
			break;
		}
	}
	cout << result;
	return 0;
}