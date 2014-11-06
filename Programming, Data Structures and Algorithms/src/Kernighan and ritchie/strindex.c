#include <stddef.h>

/* strindex: return index of t in s, -1 if none */
char* strindex(char *s, char *t)
{
	char *stemp, *ttemp;
	
	while (*s++ != '\0') {
		for (stemp = s, ttemp = t; *ttemp !='\0' && *stemp == *ttemp; stemp++, ttemp++)
			;
		if (ttemp > t && *ttemp == '\0')
			return s;
	}
	return NULL;
}