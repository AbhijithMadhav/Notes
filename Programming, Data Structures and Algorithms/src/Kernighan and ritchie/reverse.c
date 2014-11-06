#define MAX 1000
#include <string.h>
/* reverse: reverse string s in place */
char* reverse(char* s)
{
	char *r = s, *l = s;
	while (*r)
		r++;
	r--;
	{
		char c;
		for ( ; l < r; l++, --r)
		{
			c = *l;
			*l = *r;
			*r = c;
		}
	}
	return s;
}