/* Exercise 3-3. Write a function expand(s1,s2) that expands shorthand notations like a-z in
 * the string s1 into the equivalent complete list abc...xyz in s2. Allow for letters of either case 
 * and digits, and be prepared to handle cases like a-b-c and a-z0-9 and -a-z. Arrange that a
 * leading or trailing - is taken literally.
 */

#include<stdio.h>
#include<string.h>
#include<ctype.h>

#define FALSE 0
#define TRUE 1
#define MAX 1000

int expand(char s1[], char s2[]);

int main()
{
	char s1[] = "a--", s2[MAX];
	expand(s1, s2);
	printf("Expanded string is %s\n", s2);
	getchar();
}


int expand(char s1[], char s2[])
{
	int i, ch, j;
	for (i = 0, j = 0; i < strlen(s1) && j < MAX; ++i)
	{
		if (isalnum(s1[i]) && (i > 1) && (s1[i - 1] == '-') && isalnum(s1[i - 2]))
		{
			ch = s1[i - 2];
			while (ch != s1[i])
				s2[j++] = ++ch;
		}
		else if (s1[i] == '-')
		{
			if (i == 0 || i == strlen(s1) - 1)
				s2[j++] = s1[i];
			else if ((i < strlen(s1) - 2) && isalnum(s1[i - 1]) && isalnum(s1[i + 1]))
				;
			else
				s2[j++] = s1[i];
		}
		else
			s2[j++] = s1[i];
	}
	s2[j] = '\0';
	if (j == (MAX - 1))
		return FALSE;
	else
		return TRUE;
}