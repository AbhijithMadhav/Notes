/*
 * PrefixEvaluationRecursive.cpp
 *
 *  Created on: 01-Apr-2011
 *      Author: kempa
 */
#include<string.h>
#include<iostream>

using std::cout;
using std::endl;

char *a;
int i;

int eval()
{
	int x = 0;
	while (a[i] == ' ')
		i++;
	if (a[i] == '+')
	{
		i++;
		return eval() + eval();
	}
	if (a[i] == '*')
	{
		i++;
		return eval() * eval();
	}
	while ((a[i] >= '0') && (a[i] <= '9'))
		x = 10 * x + (a[i++] - '0');
	return x;
}

int main(int argc, char *argv[])
{
	a = new char[strlen(argv[1]) + 1];
	strcpy(a, argv[1]);
	i = 0;
	cout << argv[1] << " = " << eval() << endl;
	return 0;
}

