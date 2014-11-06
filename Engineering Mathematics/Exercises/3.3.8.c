#include<stdio.h>

char *s[] = { "a", "b", "c", "d", "e", "FUN"} ;// "f", "g", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", 'z", "0", "1",
int main()
{
	int i, j, l, k;
	for (i = 0; i <= 4; ++i)
	{
		for (j = 0 ; j <= 5; ++j)
			for (l = 0 ; l <= 5; ++l)
		
				for (k = 0 ; k <= 5; ++k)
				{
						printf("%s %s %s %s\n", s[i], s[j], s[l], s[k]);
				}
	}
	return 0;
}
						
