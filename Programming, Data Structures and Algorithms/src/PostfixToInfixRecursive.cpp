/*
 * PostfixToInfixRecursive.cpp
 *
 *  Created on: 07-Apr-2011
 *      Author: kempa
 */

/* Operands can consist of only single digit numbers.
 * No spaces allowed between tokens
 */
#include<iostream>
#include<string>
#include<vector>

using std::cout;
using std::endl;
using std::cerr;
using std::string;
using std::vector;

void convertFirstSubExpression(vector<string>&);

bool isOperator(char c)
{
	switch (c)
	{
	case '+':
	case '*':
	case '#':
		return true;
	default:
		return false;
	}
}

void setSecondOperandAndOperator(vector<string> &exp)
{
	vector<string>::iterator it = exp.begin();

	// Advance to the second token now. The first is an operand
	it++;

	// The crux of the recursive algorithm
	if (isOperator((*it)[0])) // Second token is an operator -- Trivial case
		return; // operand2 and operator are already the first two tokens in the expression
	else // second token is an operand. Need to process further
	{
		convertFirstSubExpression(exp);
		setSecondOperandAndOperator(exp);
	}
}

void convertFirstSubExpression(vector<string> &exp)
{
	// Extract and remove operand1 from exp
	string operand1 = exp[0];
	exp.erase(exp.begin());

	// To set operand2 and operator associated with operand1 as the first two tokens of exp
	setSecondOperandAndOperator(exp);

	// Extract and remove operand2 from exp
	string operand2 = exp[0];
	exp.erase(exp.begin());

	// Extract and remove the operator from exp
	string op = exp[0];
	exp.erase(exp.begin());

	// Append the converted subexpression at the helm of exp
	if (op != "#")
		exp.insert(exp.begin(),
				"(" + operand1 + " " + op + " " + operand2 + ")");
	else
		exp.insert(exp.begin(), operand2);
}

int main(int argc, char *argv[])
{
	vector<string> exp(argc + 2);

	/* Refer to PostfixEvaluationRecursive for comments */
	int i;
	exp[0] = "0";
	for (i = 1; i < argc; i++)
		exp[i] = argv[i];
	exp[i] = "#";

	convertFirstSubExpression(exp);

	for (i = 1; i < argc; i++)
		cout << argv[i];
	cout << " = " << exp[0] << endl;
	return 0;
}
