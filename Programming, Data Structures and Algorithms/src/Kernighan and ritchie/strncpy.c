char* strncpy(char *s, char *t, int n)
{
	char *temp = s;
	while (n--)
	{
		if (!(*t))
			*s++ = '\0';
		else
			*s++ = *t++;
	}
	*s = '\0';
return temp;
}