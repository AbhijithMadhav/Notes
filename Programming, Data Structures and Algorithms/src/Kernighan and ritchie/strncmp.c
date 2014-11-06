int strncmp(char *s, char *t, int n)
{
	while (n--)
		if (*s++ != *t++)
			return *(s-1) - *(t-1);
	return 0;
}