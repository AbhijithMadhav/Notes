/*
 * InfixToPostfix.cpp
 *
 *  Created on: 06-Apr-2011
 *      Author: kempa
 */

#include<iostream>
#include<stack>
#include<string>

using std::stack;
using std::string;
using std::cout;
using std::endl;

int main(int argc, char *argv[])
{
	stack<int> save;
	string exp(argv[1]);
	cout << argv[1] << " = ";
	for(int i = 0; i < (int)exp.size(); i++)
	{
		int num;
		if (isdigit(exp[i]))
		{
			for(num = 0; isdigit(exp[i]) && i < (int)exp.size(); i++)
				num = (10 * num) + (exp[i] - '0');
			cout << " " << num;
			continue;
		}

		switch(exp[i])
		{
		case '(':
			break;
		case '+':
		case '*':
			save.push(exp[i]);
			break;
		case ')':
			cout << " " << (char)save.top();
			save.pop();
			break;
		}
	}
	cout << endl;
	return 0;
}
