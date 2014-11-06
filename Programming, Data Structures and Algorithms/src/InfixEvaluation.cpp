/*
 * InfixEvaluation.cpp
 *
 *  Created on: 25-Mar-2011
 *      Author: kempa
 */

#include<string.h>
#include<stdlib.h>
#include<iostream>
#include"STACK.cxx"

using std::cout;
using std::endl;
/* Evaluates infix expressions.
 * Assumes expression is surrounded sufficiently by parenthesis
 * Usage: InfixEvaluation <infix expression>
 */
int main(int argc, char *argv[])
{
	STACK<int> save(argc);
	char *exp = argv[1];
	for (int i = 0; i < (int) strlen(exp); i++)
	{
		if (exp[i] == '*' || exp[i] == '+')
		{
			//			cout << "Pushing operator, " << exp[i] << endl ;
			save.push(exp[i]);
			save.print();
		}
		else if (exp[i] >= '0' && exp[i] <= '9')
		{
			int num = 0;
			for (; exp[i] != ' ' && i < (int) strlen(exp); i++)
				num = 10 * num + (exp[i] - '0');
			save.push(num);
			save.print();
		}
		else if (exp[i] == ')')
		{ /* order of popping in important */
			int op2 = save.pop(); //save.print();
			int op = save.pop(); //save.print();
			int op1 = save.pop();
			save.print();
			switch (op)
			{
			case '+':
				save.push(op1 + op2);
				save.print();
				break;
			case '*':
				save.push(op1 * op2);
				save.print();
				break;
			default:
				cout << "Error: Invalid operand(ASCII code), " << op << " "
						<< op1 << " " << op2 << endl;
				return 1;
			}
		}
	}
	cout << "Assuming infix expression is properly qualified with parenthesis"
			<< endl;
	for (int i = 0; i < (int) strlen(exp); i++)
		cout << exp[i];
	cout << " = " << save.pop() << endl;
	save.print();
	return 0;
}
