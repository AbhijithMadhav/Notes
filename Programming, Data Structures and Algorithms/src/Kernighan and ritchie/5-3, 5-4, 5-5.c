/*
Exercise 5-3. Write a pointer version of the function strcat that we showed in Chapter 2:
strcat(s,t) copies the string t to the end of s.
*/

/* Exercise 5-4. Write the function strend(s,t), which returns 1 if the string t occurs at the
end of the string s, and zero otherwise.
*/

/*
Exercise 5-5. Write versions of the library functions strncpy, strncat, and strncmp, which
operate on at most the first n characters of their argument strings. For example,
strncpy(s,t,n) copies at most n characters of t to s. Full descriptions are in Appendix B.
*/

#include <stdio.h>

int main()
{
	char s[100] = "end", *t = "aend";

	int strncmp(char *s, char *t, int n);
	char* strncat(char *s, char *t, int n);
	char* strncpy(char *s, char *t, int n);
	int strend(char* s, char* t);
	char *strcat(char* s, char* t);

	printf("%s - %s = %d\n", s, t, strncmp(s, t, 3));
	/*
	printf("strncat: %s\n", strncat(s, t, 3));
	

	printf("strncpy: %s\n", strncpy(s, t, 3));
	
	if (strend(s, t))
		printf("\"%s\" found at the end of \"%s\"\n", t, s);
	else
		printf("\"%s\" not found at the end of \"%s\"\n", t, s);

	printf("Concatenated string: %s\n", strcat(s, t));
	*/
	getchar();
}