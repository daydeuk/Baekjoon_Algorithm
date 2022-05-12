#include<iostream>
#include<vector>
using namespace std;

int N, M;

int main()
{
	cin >> N >> M;
	vector<int>v_card;
	for (int input_case = 1; input_case <= N; input_case++)
	{
		int input_card = 0;
		cin >> input_card;
		v_card.push_back(input_card);
	}
	int result = 0;
	for (int c1 = 0; c1 < N - 2; c1++)
	{
		for (int c2 = c1+1; c2 < N - 1; c2++)
		{
			for (int c3 = c2+1; c3 < N; c3++)
			{
				int sum = v_card[c1] + v_card[c2] + v_card[c3];
				if (sum > M)
				{
					continue;
				}
				if (sum > result)
				{
					result = sum;
				}
			}
		}
	}
	cout << result;
	return 0;
}