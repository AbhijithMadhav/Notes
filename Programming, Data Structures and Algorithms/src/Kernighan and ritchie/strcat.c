/* 
Exercise 5-3. Write a pointer version of the function strcat that we showed in Chapter 2:
strcat(s,t) copies the string t to the end of s.
*/

char* strcat(char *s, char *t)
{
	char *temp = s;
	while (*s)
		s++;
	while ((*s++ = *t++))
		;
	return temp;
}