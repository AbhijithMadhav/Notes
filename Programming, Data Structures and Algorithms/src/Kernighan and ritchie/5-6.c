/*
Exercise 5-6. Rewrite appropriate programs from earlier chapters and exercises with pointers
instead of array indexing. Good possibilities include getline (Chapters 1 and 4), atoi, itoa,
and their variants (Chapters 2, 3, and 4), reverse (Chapter 3), and strindex and getop
(Chapter 4).
*/
#include <stdio.h>
#define MAX 1000
int main()
{
	int atoi(char*);
	void itoa(int, char*), itoaw(char*, int, int), recursive_itoa(char*, int);

	printf("atoi : %d %d %d\n\n", atoi("123"), atoi("-123"), atoi(" "));

	/*
	{
		char s[MAX];
		printf("Enter a line\n");
		printf("Length of line : %d\n\n", getline(s, MAX));
	}
*/

	{
	char s[MAX];
	itoa(-123, s);
	printf("itoa : %s \n", s);
	}
	
	{
	char s[MAX];
	itoaw(s, 123, 10);
	printf("itoaw : %s \n", s);
	}

	{
		char* strindex(char*, char*);
		printf("strindex : %c\n", *(strindex("this is the end", "end")));
	}

	{
		char s[MAX];
		int getop(char* s);
		printf("Enter a number or a operator\n");
		getop(s);
		printf("getop : %s\n", s);
	}

	getchar();
	getchar();
	return 0;
}
