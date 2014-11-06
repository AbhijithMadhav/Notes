/*
 * PostfixToinfix.cpp
 *
 *  Created on: 07-Apr-2011
 *      Author: kempa
 */


#include <iostream>
#include <string>
#include <stack>
#include <sstream>

using std::cout;
using std::endl;
using std::stack;
using std::string;
using std::ostringstream;

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
	stack<string> operandStack;
	string exp(argv[1]);
	for (int i = 0; i < (int)exp.length(); i++)
	{
		if (isdigit(exp[i]))
		{
			int operand;

			// extract number
			for (operand = 0; isdigit(exp[i]); i++)
				operand = (operand * 10) + (exp[i] - '0');

			// convert to a string

			std::ostringstream oss;
			oss << operand;

			// push into stack
			operandStack.push(oss.str());
		}
		else if (isOperator(exp[i]))
		{
			string operand2 = operandStack.top();
			operandStack.pop();
			string operand1 = operandStack.top();
			operandStack.pop();

			std::ostringstream oss;
			oss << exp[i];
			operandStack.push("(" + operand1 + oss.str() + operand2 + ")");
		}
	}
	cout << exp << " = " << operandStack.top() << endl;
	return 0;
}
