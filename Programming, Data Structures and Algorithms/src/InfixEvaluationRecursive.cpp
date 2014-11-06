/*
 * InfixEvalutionRecursive.cpp
 *
 *  Created on: 26-Mar-2011
 *      Author: kempa
 */

/* Evaluates infix expressions.
 * Assumes expression is surrounded sufficiently by parenthesis
 * Usage: InfixEvaluationRecursive <infix expression>
 */


#include<string.h>
#include<stdlib.h>
#include<iostream>

using std::cout;
using std::endl;

int eval(char*, int, int);
void show_error_location(char*, int);

int main(int argc, char *argv[])
{
	cout << argv[1] << " = " << eval(argv[1], 0, strlen(argv[1]) - 1) << endl;
	return 0;
}

int eval(char *exp, int s, int e)
{
	int i = s; // used to iterate over the infix expression
	int op; // used to hold the operator of the infix expression
	int operand1 = 0, operand2 = 0; // used to hold the values of operands

	while (isspace(exp[i])) // skip spaces
		i++;

	if (exp[i] != '(')
	{
		cout << "Expression not parenthesised properly. ";
		cout << "Expected '(', got " << exp[i] << " instead at position, " << i
				+ 1 << endl;
		show_error_location(exp, i);
		exit(1);
	}
	i++; // skip parenthesis

	while (isspace(exp[i])) // skip spaces
		i++;

	// deal with first operand of the infix expression
	if (exp[i] == '(') // if first operand is a subexpression
	{
		int s1 = i;
		i++;
		for (int p_count = 1; p_count; i++)
		{ // find the end of the subexpression
			if (exp[i] == ')')
				p_count--;
			else if (exp[i] == '(')
				p_count++;
		}
		int e1 = i - 1;
		operand1 = eval(exp, s1, e1);
	}
	else if (isdigit(exp[i])) // if the first operand is a number
	{
		for (; isdigit(exp[i]); i++) // collect the operand
			operand1 = 10 * operand1 + (exp[i] - '0');
	}
	else
	{
		cout << "Evaluating first operand. Found neither a sub-expression nor an operand at position "
				<< i << ". Character found is" << exp[i] << endl;
		show_error_location(exp, i);
		exit(1);
	}
	//cout << "operand 1 = " << operand1 << endl;

	while (isspace(exp[i])) // skip spaces
		i++;

	// Deal with the operator
	op = exp[i++];
	//cout << "operator = " << op << endl;

	while (isspace(exp[i])) // skip spaces
		i++;

	// deal with second operand of the infix expression
	if (exp[i] == '(') // if second operand is a subexpression
	{
		int s2 = i;
		i++;
		for (int p_count = 1; p_count; i++)
		{ // find the end of the subexpression
			if (exp[i] == ')')
				p_count--;
			else if (exp[i] == '(')
				p_count++;
		}
		int e2 = i - 1;
		operand2 = eval(exp, s2, e2);
	}
	else if (isdigit(exp[i])) // if the second operand is just an operand
	{
		for (; isdigit(exp[i]) && i <= e; i++) // collect the operand
			operand2 = 10 * operand2 + (exp[i] - '0');
	}
	else
	{
		cout << "Evaluating second operand. Found neither a sub-expression nor an operand at position "
				<< i << ". Found character, " << exp[i] << endl;
		show_error_location(exp, i);
		exit(1);
	}
	//cout << "operand 2 = " << operand2 << endl;

	switch(op)
	{
	case '+':
		return (operand1 + operand2);
		break;
	case '*':
		return (operand1 * operand2);
		break;
	default:
		cout << "Unimplemented operator, " << op << endl;
		exit(1);
	}
}


void show_error_location(char* exp, int pos)
{
	cout << exp << endl;
	for (int i = 1; i <= pos; i++)
		cout << " ";
	cout << "^" << endl;
}


/*
#include<string.h>
#include<stdlib.h>
#include<iostream>
#include<string>

using std::cout;
using std::endl;

void show_error_location(char*, int);

class Infix
{
	string* exp;
public:
	Infix(string s)
	{
		exp = new string(s);
	}
	int find_matching_parenthesis(int i)
	{
		int begin = i;
		i++;
		for (int p_count = 1; p_count; i++) // find the end of the subexpression
		{
			if (exp.at(i) == ')')
				p_count--;
			else if (exp.at(i) == '(')
				p_count++;
		}
		return i;
	}
};
int main(int argc, char *argv[])
{
	cout << argv[1] << " = " << eval(*(new infix(*(new string(argv[1]))))) << endl;
	return 0;
}

int eval(Infix infix)
{
	string exp = infix.getexp();
	int i = exp.find_first_not_of(' '); // used to iterate over the infix expression

	// the expression must begin with a '('
	if (exp[i] != '(')
	{
		cout << "Expression not parenthesised properly. ";
		cout << "Expected '(', got " << exp[i] << " instead at position, " << i
				+ 1 << endl;
		show_error_location(exp, i);
		exit(1);
	}

	i = exp.find_first_not_of(' ', i + 1); // skip spaces after the opening parenthesis

	int op; // used to hold the operator of the infix expression
	int operand1 = 0, operand2 = 0; // used to hold the values of operands

	// deal with first operand of the infix expression
	if (exp[i] == '(') // if first operand is a subexpression
	{

		try {
			operand1 = eval(find_matching_parenthesis(i));
		}
		catch(out_of_range) {
			cout << "Not properly parentesised\n";
			exit(1);
		}
		while (p_count)
		{

		}
		int begin = i;
		i++;
		for (int p_count = 1; p_count; i++) // find the end of the subexpression
		{
			if (exp[i] == ')')
				p_count--;
			else if (exp[i] == '(')
				p_count++;
		}
		int end = i - 1;
		operand1 = eval(exp.substr(s, end - begin));
	}
	else if (isdigit(exp[i])) // if the first operand is a number
	{
		for (; isdigit(exp[i]); i++) // collect the operand
			operand1 = 10 * operand1 + (exp[i] - '0');
	}
	else
	{
		cout << "Evaluating first operand. Found neither a sub-expression nor an operand at position "
				<< i << ". Character found is" << exp[i] << endl;
		show_error_location(exp, i);
		exit(1);
	}
	//cout << "operand 1 = " << operand1 << endl;

	i = exp.find_first_not_of(' ', i); // skip spaces after first operand

	// Deal with the operator
	op = exp[i++];
	//cout << "operator = " << op << endl;

	i = exp.find_first_not_of(' ', i + 1); // skip spaces after the operator, before the second operand

	// deal with second operand of the infix expression
	if (exp[i] == '(') // if second operand is a subexpression
	{
		int s2 = i;
		i++;
		for (int p_count = 1; p_count; i++)
		{ // find the end of the subexpression
			if (exp[i] == ')')
				p_count--;
			else if (exp[i] == '(')
				p_count++;
		}
		int e2 = i - 1;
		operand2 = eval(exp, s2, e2);
	}
	else if (isdigit(exp[i])) // if the second operand is just an operand
	{
		for (; isdigit(exp[i]) && i <= e; i++) // collect the operand
			operand2 = 10 * operand2 + (exp[i] - '0');
	}
	else
	{
		cout << "Evaluating second operand. Found neither a sub-expression nor an operand at position "
				<< i << ". Found character, " << exp[i] << endl;
		show_error_location(exp, i);
		exit(1);
	}
	//cout << "operand 2 = " << operand2 << endl;

	switch(op)
	{
	case '+':
		return (operand1 + operand2);
		break;
	case '*':
		return (operand1 * operand2);
		break;
	default:
		cout << "Unimplemented operator, " << op << endl;
		exit(1);
	}
}


void show_error_location(char* exp, int pos)
{
	cout << exp << endl;
	for (int i = 1; i <= pos; i++)
		cout << " ";
	cout << "^" << endl;
}
*/
