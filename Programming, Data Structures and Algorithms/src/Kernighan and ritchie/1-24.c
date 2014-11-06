/*
 * 1-24.c
 *
 *  Created on: Oct 3, 2009
 *      Author: Abhijith
 */

#include<stdio.h>
#define MAX 10000
#define TRUE 1
#define FALSE 0

#define ERR_PARENTHESIS 2
#define ERR_BRACKETS 3
#define ERR_BRACES 4

	/* Stack */
int top = -1;
int stack[MAX];

int push(char c);
int pop();

/*
 * Exercise 1-24. Write a program to check a C program
 * for rudimentary syntax errors like unmatched
 * parentheses, brackets and braces. Don't forget
 * about quotes, both single and double, escape
 * sequences, and comments. (This program is hard if
 * you do it in full generality.)
 */
int main()
{
	int inComment = FALSE;
	int inSQuotes = FALSE;
	int inDQuotes = FALSE;
	int c = EOF, pc = EOF, nc = EOF, ppc = EOF;


	while ((c = getchar()) != EOF)
	{
		if (c == '"' && !inDQuotes && !inSQuotes && !inComment && pc != '\\')
			inDQuotes = TRUE;
		else if (c == '"' && inDQuotes && !inSQuotes && !inComment && pc != '\\')
			inDQuotes = FALSE;
		else if (c == '\'' && !inSQuotes && !inDQuotes && !inComment && pc != '\\')
			inSQuotes = TRUE;
		else if (c == '\'' && inSQuotes && !inDQuotes && !inComment && pc != '\\')
			inSQuotes = FALSE;
		else if ( c == '/' && nc == '*' && !inDQuotes && !inSQuotes && !inComment)
			inComment = TRUE;
		else if ( pc == '/' && ppc == '*' && !inDQuotes && !inSQuotes && inComment)
			inComment = FALSE;
		else if ( c == '(' && !inDQuotes && !inSQuotes && !inComment && pc != '\\')
			push('(');
		else if ( c == ')' && !inDQuotes && !inSQuotes && !inComment && pc != '\\')
		{
			if (pop() != '(')
			{
				printf("Matching '(' not found\n");
				return(ERR_PARENTHESIS);
			}
		}
		else if ( c == '[' && !inDQuotes && !inSQuotes && !inComment && pc != '\\')
			push('[');
		else if ( c == ']' && !inDQuotes && !inSQuotes && !inComment && pc != '\\')
		{
			if (pop() != '[')
			{
				printf("Matching ']' not found\n");
				return(ERR_BRACKETS);
			}
		}
		else if ( c == '{' && !inDQuotes && !inSQuotes && !inComment && pc != '\\')
			push('{');
		else if ( c == '}' && !inDQuotes && !inSQuotes && !inComment && pc != '\\')
		{
			if (pop() != '{')
			{
				printf("Matching '{' not found\n");
				return(ERR_BRACES);
			}
		}
	}
    return 0;
}

int push(char c)
{
	if ( top != MAX - 1)
	{
		stack[++top] = c;
		return 0;
	}
	else
	{
		printf("Stack Overflow\n");
		return 1;
	}
}

int pop()
{
	if ( top == -1 )
	{
			printf("Stack Underflow\n");
			return -1;
	}
	else
		return stack[top--];

}
