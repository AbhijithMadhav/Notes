/* Exercise 4-4. Add the commands to print the top elements of the stack without popping, to
duplicate it, and to swap the top two elements. Add a command to clear the stack.
*/

#include <stdio.h>

#include "calc.h"

int main()
{
	push(0.0);
	duplicate();
	push(1.23);
	print_top();
	duplicate();
	clear();
	print_top();
	duplicate();
	pop();
	getchar();
}
