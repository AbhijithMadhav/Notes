/* Write the function strindex(s,t) which returns the position of the rightmost
occurrence of t in s, or -1 if there is none.
*/
#include<stdio.h>
int strrindex(char s[], char t[]);

int main()
{
	char s[] = "  123 asjkdfgas 123kajsdah123 kjsadfpasdh123";
	char t[] = "123";
	printf("Last occurance of substring \"%s\" in \"%s\" is at position: %d", s, t, strrindex(s, t));
	getchar();
}

int strrindex(char s[], char t[])
{
	int i, j, k;
	int rightmost = -1;
	for (i = 0; s[i] != '\0'; ++i)
	{
		for (j = i, k = 0; s[j] != '\0' && t[k] != '\0' && s[j] == t[k]; ++j, ++k)
			;
		if ( (k > 0) && (t[k] == '\0'))
			rightmost = i;
	}
	return rightmost;
}



