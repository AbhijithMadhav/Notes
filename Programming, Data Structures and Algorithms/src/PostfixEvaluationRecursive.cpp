/*
 * PostfixEvaluationRecursive.cpp
 *
 *  Created on: 02-Apr-2011
 *      Author: kempa
 */

/* Operands and operators must be delimited by spaces or tabs
 */

#include<iostream>
#include<string>
#include<sstream>
#include<boost/tokenizer.hpp>

using std::cout;
using std::endl;

using std::cerr;
using std::string;
using std::stringstream;
typedef boost::tokenizer<boost::char_separator<char> > tokenizer;

void evalFirstSubExpression(string&);

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

void removeSpaces(string &exp)
{
	int n;
	for (n = 0; isspace(exp[n]); n++)
		;
	exp.erase(0, n);
}

template<typename T>
string NumberToString(T Number)
{
	stringstream ss;
	ss << Number;
	return ss.str();
}

template <typename T>
T StringToNumber(const string &Text)//Text not by const reference so that the function can be used with a
{ //character array as argument
	stringstream ss(Text);
	T result;
	return ss >> result ? result : 0;
}

/*
 * Sets operand2 and operator as the first two tokens of exp
 * Ex:
 *    operand1 before-expression	after-expression
 *		2    	3+46+*#		        3+46+*#
 *    	5		46+*#		        10*#
 *    	0		23+46+*#		    50#
 *    	0		546+*#				50#
 *      5 		10*#				10*#
 */
void setSecondOperandAndOperator(string &exp)
{
	tokenizer token(exp);
	tokenizer::iterator it = token.begin();

	if (!isdigit((*it)[0]))
	{
		cerr
				<< "setSecondOperatorAndOperand: expected an operand at the start of the string, "
				<< exp << endl;
		exit(1);
	}

	// Advance to the second token now that the first is an operand
	it++;
	if (it == token.end())
	{
		cerr << "setSecondOperatorAndOperand: Detected premature end of expression. Was expecting an operator" << endl;
		exit(1);
	}

	// The crux of the recursive algorithm
	if (isOperator((*it)[0])) // Second token is an operator -- Trivial case
		return; // operand2 and operator are already the first two tokens in the expression
	else if (isdigit((*it)[0])) // second token is an operand. Need to process further
	{
		evalFirstSubExpression(exp);
		setSecondOperandAndOperator(exp);
	}
	else
	{
		cerr << "setSecondOperatorAndOperand: unimplemented operator, "
				<< (*it)[0] << endl;
		exit(1);
	}
}

/*
 * Evaluates the sub-expression of 'exp'
 * The sub-expression is identified as that whose first operand is the first token of exp
 * The result then replaces the sub-expression in 'exp'.
 *
 */
void evalFirstSubExpression(string &exp)
{
	int result;

	// Extract and remove operand1 from exp
	int operand1;
	{
		tokenizer::iterator it = (new tokenizer (exp))->begin();
		operand1 = StringToNumber<int>(*it);
		exp.erase(0, it->length()); // delete the operand
		removeSpaces(exp); // delete the spaces
	}

	// To set operand2 and operator associated with operand1 as the first two tokens of exp
	setSecondOperandAndOperator(exp);

	// Extract and remove operand2 from exp
	int operand2;
	{
		tokenizer::iterator it = (new tokenizer (exp))->begin();
		operand2 = StringToNumber<int>(*it);
		exp.erase(0, it->length());
		removeSpaces(exp);
	}

	// Extract and remove the operator from exp
	char op = exp[0];
	exp.erase(0, 1);
	removeSpaces(exp);

	// Evaluate
	switch (op)
	{
	case '+':
		result = operand1 + operand2;
		break;
	case '*':
		result = operand1 * operand2;
		break;
	case '#': // end of expression is reached. Refer to comments in main()
		result = operand2;
		break;
	default:
		cerr << "evalFirstSubExpression: unimplemented operator, " << op << endl;
		exit(1);
	}

	// Append the result at the helm of exp
	exp.insert(0, NumberToString(result) + " ");
}

int main(int argc, char *( argv[]))
{
	/* evalFirstSubExpression() evaluates only the sub-expression in exp whose first operand
	 * is the first token of 'exp'. This works for post-fix expressions whose
	 * first operands is a simple operand and not a sub-expression
	 * i.e. evaluates "5 2 3 + *" to 25
	 *
	 * For cases where the first operand is a subexpression evalFirstSubExpression()
	 * evaluates 'exp' only partially
	 * i.e evaluates "5 4 + 2 *" to "9 2 *"
	 * So,
	 *  . Make '0' as the first operand of every user specified postfix expression
	 *  . Making '#' as the corresponding operator, where
	 *  	. a '#' b = b
	 *  . Hence a postfix expression with a sub-expression as the first operand,
	 *  	say exp = "2 3 + 4 5 + *", can be evaluated by invoking evalFirstSubExpression(exp) with
	 *  	exp = "0 2 3 + 4 5 + * #"
	 */

	string exp("0 " + string(argv[1]) + " #");
	evalFirstSubExpression(exp);
	cout << argv[1] << " = " << exp << endl;
	return 0;
}
