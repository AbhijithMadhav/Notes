#include <stdio.h>
#include <stdlib.h> /* for atof() */
#include <math.h>  /* for sin, pow */
#include "calc.h"

/* reverse Polish calculator */
int main(int argc, char *argv[])
{
	double op2;
	int classify_op(char*);

	/*int argc = 4;
	char *b[] = {"abc", "2", "3", "+"}, **argv = b;*/
	if (argc < 2)
	{
		printf("Usage\n");
		return -1;
	}
	while (--argc > 0 )
	{
		switch (classify_op(*++argv)) {
			case NUMBER:
				push(atof(*argv));
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
			default:
				printf("error: unknown command %s\n", *argv);
				break;
		}
	}
	printf("\t%.8g\n", pop());
	getchar();
	return 0;
}