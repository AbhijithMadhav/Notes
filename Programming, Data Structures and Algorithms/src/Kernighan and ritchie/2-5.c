/* Exercise 2-5. Write the function any(s1,s2), which returns the first location in a string s1
 * where any character from the string s2 occurs, or -1 if s1 contains no characters from s2.
 *(The standard library function strpbrk does the same job but returns a pointer to the
 * location.)
 */

# include <stdio.h>
# include <string.h>

# define MAX_LEN 100

int any(char s1[], char s2[])
{
	int i, pos = strlen(s1);
	for ( i = 0; i < strlen(s2); ++i)
	{
		int j;
		for ( j = 0; j < strlen(s1); ++j)
			if ( s1[j] == s2[i] && j < pos)
				pos = j;
	}
	if (pos == strlen(s1))
		return -1;
	else
		return(pos + 1);
}

int main()
{
	char s1[MAX_LEN], s2[MAX_LEN];
	int x;
	printf("Enter the two strings\n");
//	scanf("%s %s", s1, s2);
//	printf("Postion is first string where the first occurance of a character from the second"
//		   "string occurs : %d\n", any(s1, s2));
//	getch();
	x = 0xffffffff;
	x = x & ~0127;
	printf("%x\n",x );
	getch();
	return 0;
}