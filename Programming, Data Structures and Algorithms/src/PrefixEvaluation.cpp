/*
 * PrefixEvaluation.cpp
 *
 *  Created on: 01-Apr-2011
 *      Author: kempa
 */

#include<stdlib.h>
#include<ctype.h>
#include<string.h>
#include<stack>
#include<iostream>

// The below definitions are inserted into the stack instead of the ascii equivalents for '+' and '*', 43 and 45
// This is so because 43 & 45 are more likely to occur in a expression than INT_MIN and INT_MIN - 1
// Of course the program won't work properly in some cases if on of the operands id INT_MIN or INT_MIN - 1
#include<limits.h>
#define ADD INT_MIN
#define MUL (INT_MIN + 1)

bool isOperand(int s)
{
	switch (s)
	{
	case ADD:
		return false;
	case MUL:
		return false;
	default:
		return true;
	}
}

using std::stack;
using std::cout;
using std::endl;
int main(int argc, char *argv[])
{
	stack<int> save; // stack used in evalutaion

	char *exp = argv[1];
	int operand1 = 0, operand2 = 0, operand = 0;

	for (int i = 0; i < (int) strlen(exp); i++)
	{
		// Push operator into stack
		// operator is saved so that it can be accessed when both its operands are obtained down the line
		// 'if' is not necessary as switch has cases only for the recognised operators
		switch (exp[i])
		{
		case '+':
			save.push(ADD);
			continue;
		case '*':
			save.push(MUL);
			continue;
		}

		if (isdigit(exp[i]))
		{
			// extract the operand
			for (operand = 0; exp[i] != ' ' && i < (int) strlen(exp); i++)
				operand = 10 * operand + (exp[i] - '0');

			// if the top of the stack is a number, it is the first operand which was saved before
			//    and exp[i] is the second operand for the operator behind the number on the top of the stack
			if (!save.empty() && isOperand(save.top()))
			{
				operand2 = operand;
				// evaluate the expression as long as there are saved 'first operands' on the toop of the stack
				while (!save.empty() && isOperand(save.top()))
				{
					operand1 = save.top();
					save.pop();
					switch (save.top())
					{
					case ADD:
						operand2 = operand1 + operand2;
						break;
					case MUL:
						operand2 = operand1 * operand2;
						break;
					}
					save.pop();
				}
				// Once there are no operands on top of the stack, the above calculated
				//   result if the result of a sub-expression
				//   It forms the first operand for the operator behind it in the stack
				//   So save it
				save.push(operand2);
			}
			else if (save.empty())
			{
				cout << "incorrect prefix expression. "
						<< "No operator specified for operand " << exp[i - 1]
						<< endl;
				exit(1);
			}
			else // if the top of the stack is not an operand, exp[i] is the first operand of the operator preceding it. Save it
				save.push(operand);
		}

	}
	cout << argv[1] << " = " << save.top() << endl;
	save.pop();
	return 0;
}
