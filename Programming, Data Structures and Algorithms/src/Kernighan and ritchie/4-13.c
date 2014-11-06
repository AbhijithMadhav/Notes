int main()
{
	char s[100] = "asda";
	void reverse(char s[], int l, int r);
	reverse(s, 0, strlen(s) - 1);
	printf("%s\n", s);
	getchar();
}

void reverse(char s[], int l, int r)
{
	if (l < r - 1)
		reverse(s, l + 1, r - 1);
	
	if (l < r)
	{
		char temp;
		temp = s[l];
		s[l] = s[r];
		s[r] = temp;
	}
}