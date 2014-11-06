#include "calc.h"
#include <string.h>
#include <ctype.h>

/* classifies the operand or operator
   returns NUMBER if number found(positive/negative, integer/float)
           returns the single character if the argument consists of a singlke character
           SIN if operator is 'sin'
           POW if operator is 'pow' 
           EXP if operator is 'exp'
		   -1 if any other string
 */

int classify_op(char *op)
{
	int isnumber(char* s);
	if (strlen(op) == 1)
	{
		switch(op[0])
		{
		case '+':
		case '-':
		case '*':
		case '/':
		case '%':
			return op[0];
			break;
		}
	}
	if (isnumber(op))
			return NUMBER;
	else if (strcmp(op, "sin") == 0)
		return SIN;
	else if (strcmp(op, "pow") == 0)
		return POW;
	else if (strcmp(op, "exp") == 0)
		return EXP;

	return INVALID_OPERATOR;
}