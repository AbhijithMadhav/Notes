/*
 * Exercise 2-4. Write an alternative version of squeeze(s1,s2) that deletes each character in 
 * s1 that matches any character in the string s2.
*/

# include <stdio.h>
# include <string.h>

# define MAX_LEN 100

char* squeeze(char s1[], char s2[])
{
	int i;
	for ( i = 0; i < strlen(s2) ; ++i)
	{
		int j, k;
		for ( j = 0, k = 0; j < strlen(s1) ; ++j)
		{
			if ( s1[j] != s2[i] )
				s1[k++] = s1[j];
		}
		s1[k] = NULL;
	}
	return s1;
}

int main()
{
	char s1[MAX_LEN], s2[MAX_LEN];
	printf("Enter the 2 strings\n");
	scanf("%s %s", s1, s2);
	printf("First string, after deleting characters found in the second string, is now : %s\n", squeeze(s1, s2));
	getch();
	return 0;
}
