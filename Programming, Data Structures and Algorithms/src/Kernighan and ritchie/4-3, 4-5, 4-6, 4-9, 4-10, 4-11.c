/*
Given the basic framework, it's straightforward to extend the calculator. Add the
modulus (%) operator and provisions for negative numbers.
*/

/*
Exercise 4-5. Add access to library functions like sin, exp, and pow. See <math.h> in
Appendix B, Section 4.
*/

/* 
Exercise 4-6. Add commands for handling variables. (It's easy to provide twenty-six variables
with single-letter names.) Add a variable for the most recently printed value.
*/

/* Exercise 4-9. Our getch and ungetch do not handle a pushed-back EOF correctly. Decide
what their properties ought to be if an EOF is pushed back, then implement your design.*/

/*
Exercise 4-10. An alternate organization uses getline to read an entire input line; this makes
getch and ungetch unnecessary. Revise the calculator to use this approach.
*/

/*
Exercise 4-11. Modify getop so that it doesn't need to use ungetch. Hint: use an internal
static variable.
*/

#include <stdio.h>
#include <stdlib.h> /* for atof() */
#include <math.h>  /* for sin, pow */
#include "calc.h"

#define MAXOP 100 /* max size of operand or operator */



/* reverse Polish calculator */
int main()
{
	int type, i;
	double op2;
	char s[MAXOP];
	double var_val[52];
	char var_name;

	for (i = 0; i < 52; ++i)
		var_val[i] = 0.0;

	while ((type = getop(s)) != EOF) 
	{
		switch (type) {
			case NUMBER:
				push(atof(s));
				break;
			case '+':
				push(pop() + pop());
				break;
			case '*':
				push(pop() * pop());
				break;
			case '-':
				op2 = pop();
				push(pop() - op2);
				break;
			case '/':
				op2 = pop();
				if (op2 != 0.0)
					push(pop() / op2);
				else
					printf("error: zero divisor\n");
				break;
			case '%':
				op2 = pop();
				if (op2 != 0)
					push((int)pop() % (int)op2);
				else
					printf("error: zero divisor\n");
				break;
			case SIN:
				push(sin(pop()));
				break;
			case EXP:
				push(exp(pop()));
				break;
			case POW:
				op2 = pop();
				push(pow(pop(), (int)op2));
				break;
			case IDENTIFIER:
				var_name = s[0];
				push(var_val[var_name - 'A']);
				break;
			case '=':
				var_val[var_name - 'A'] = pop();
				pop();
				break;
			case '<':
			case '\n':
				printf("\t%.8g\n", pop());
				break;
			default:
				printf("error: unknown command %s\n", s);
				break;
		}
	}
	return 0;
}