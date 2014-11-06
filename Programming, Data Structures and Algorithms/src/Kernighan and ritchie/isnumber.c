#include <ctype.h>
#include <string.h>

int isnumber(char *s)
{
	while (*s != '\0')
	{
		if (isdigit(*s))
			;
		else if (strlen(s) > 1)
		{
			if (*s == '.' && isdigit(*(s +1))) 
				;
			else if ((*s == '+' || *s == '-') && isdigit(*(s + 1)))
				;
		}
		else
			return 0;
		s++;
	}
	return 1;
}