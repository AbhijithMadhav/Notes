#define MAXVAL 100 /* maximum depth of val stack */
#include <stdio.h>
static int sp = 0; /* next free stack position */
static double val[MAXVAL]; /* value stack */

/* push: push f onto value stack */
void push(double f)
{
	if (sp < MAXVAL)
		val[sp++] = f;
	else
		printf("error: stack full, can't push %g\n", f);
}

/* pop: pop and return top value from stack */
double pop(void)
{
	if (sp > 0)
		return val[--sp];
	else 
	{
		printf("error: stack empty\n");
		return 0.0;
	}
}

void print_top(void)
{
	if (sp > 0)
		printf("Top of stack: %g\n", val[sp - 1]);
}

void duplicate(void)
{
	if (sp < MAXVAL && sp > 0)
		val[sp++] = val[sp - 1];
	else
		printf("error: stack full or empty, can't duplicate %g\n", val[sp-1]);
}

void swap(void)
{
	double temp;
	if (sp  > 1)
	{
		temp = val[sp-1];
		val[sp-1] = val[sp-2];
		val[sp-2] = temp;
	}
	else
		printf("error: stack does not have a minimum of 2 elements to swap");
}

void clear(void)
{
	sp = 0;
}