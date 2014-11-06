#include <iostream>
#include <string.h>
#include "array_stack.cpp"

/* infix to postfix */

/* usage: ./a.out "<infix expression>" */
int main(int argc, char *argv[])
{
	char *a = argv[1];
	int N = strlen(a);
	STACK < char >ops(N);
	for (int i = 0; i < N; i++)
	{
		if (a[i] == ')')
			std::cout << ops.pop() << " ";
		if ((a[i] == '+') || (a[i] == '*') || (a[i] == '-')
		    || (a[i] == '/'))
			ops.push(a[i]);

		if ((a[i] >= '0') && (a[i] <= '9'))
		{
			while ((a[i] >= '0') && (a[i] <= '9'))
			{
				std::cout << a[i];
				++i;
			}
			std::cout << " ";
			--i;
		}
	}
	std::cout << std::endl;
}
