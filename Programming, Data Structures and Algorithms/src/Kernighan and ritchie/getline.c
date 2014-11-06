#include<stdio.h>

/* getline: read a line into s, return length */
int getline(char* s,int lim)
{
	int c;
	char *temp = s;
	while (--lim > 0 && (c = getchar())!= EOF && c!='\n')
		*s++ = (char)c;
	if (c == '\n')
		*s++ = (char)c;
	*s = '\0';
	return (s - temp);
}
