/*
 * InfixToPostfixRecursive.cpp
 *
 *  Created on: 06-Apr-2011
 *      Author: kempa
 */

#include<iostream>
#include<string>

using std::string;
using std::cout;
using std::endl;

string exp;
int i;

bool isOperator(int token)
{
	switch (token)
	{
	case '+':
	case '*':
		return true;
	default:
		return false;
	}
}

void convert()
{
	if (i < (signed)exp.size())
	{
		if (exp[i] == ')')
			return;
		else if (isOperator(exp[i]))
		{
			switch (exp[i])
			{
			case '*':
			case '+':
				int op = exp[i++];
				convert();
				cout << " " << (char) op;
				i++;
				convert();
				return;
			}
		}
		else if (isdigit(exp[i]))
		{
			int num;
			for (num = 0; isdigit(exp[i]) && i < (int) exp.size(); i++)
				num = (10 * num) + (exp[i] - '0');
			cout << " " << num;
			convert();
		}
		else
		{
			i++;
			convert();
		}
	}
}

int main(int argc, char *argv[])
{
	exp += argv[1];
	cout << argv[1] << " = ";
	i = 0;
	convert();
	cout << endl;
	return 0;
}
