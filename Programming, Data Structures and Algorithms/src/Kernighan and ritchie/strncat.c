char* strncat(char* s, char* t, int n)
{
	char *temp = s;
	while (*s)
		++s;
	while (*t && n--)
		*s++ = *t++;

	*s = '\0';
	return temp;
}

