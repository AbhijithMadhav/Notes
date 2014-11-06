/*
 * PostfixEvaluation.cpp
 *
 *  Created on: 02-Apr-2011
 *      Author: kempa
 */

#include <iostream>
#include <string>
#include <stack>
#include <cstdlib>

using std::cout;
using std::endl;
using std::stack;
using std::string;

bool isOperator(char c)
{
	switch(c)
	{
	case '+':
	case '*':
		return true;
	default:return false;
	}
}

int main(int argc, char *argv[])
{
	string exp(argv[1]);
	stack<int> save;

	for (int i = 0; i < (signed)exp.length(); i++)
	{
		if (isOperator(exp[i]))
		{
			int operand1 = save.top();
			save.pop();
			int operand2 = save.top();
			save.pop();
			switch (exp[i])
			{
			case '+':
				save.push(operand1 + operand2);
				continue;
			case '*':
				save.push(operand1 * operand2);
				continue;
			}
		}
		else if (isdigit(exp[i]))
		{
			int operand;
			for (operand = 0; isdigit(exp[i]); i++)
				operand = (operand * 10) + (exp[i] - '0');
			save.push(operand);
		}
	}
	cout << exp << " = " << save.top() << endl;
	save.pop();
	return 0;
}
