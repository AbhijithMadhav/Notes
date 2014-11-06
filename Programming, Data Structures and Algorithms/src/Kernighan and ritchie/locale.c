#include<stdio.h>
#include<locale.h>
/* Windows specific header to deal with windows console idiosyncrasies */
/* Have let windows language extensions remain enabled for the same purpose */
#include<windows.h>


/*
 * Program to print different codepages to familiarise myself with character sets and locale
 */


void my_print(char *l_name)
{
	int i, j, c = 0;

	/* http://msdn.microsoft.com/en-us/library/aa272906(VS.60).aspx */
	/* http://msdn.microsoft.com/en-us/library/aa246449(VS.60).aspx */
	/* http://msdn.microsoft.com/en-us/goglobal/bb964653.aspx */
	printf("Current locale is: %s\n", setlocale (LC_ALL, l_name));
	printf("Euro character : %c\n", 0x80);
	for (i = 0; i < 16; ++i)
	{
		for (j = 0; j < 16; ++j)
		{
			printf("%c ", c);
			++c;
		}
		printf("\n");
	}
	printf("\n\n");
}

int main()
{
	/* 
	 * Need to set console so that it can print all the glyphs in a particular codepage 
	 * http://stackoverflow.com/questions/1969385/unable-to-print-euro-symbol-in-a-c-program
	 */

	/* http://msdn.microsoft.com/en-us/library/ms686013%28VS.85%29.aspx */
	/* http://msdn.microsoft.com/en-us/library/ms683169%28VS.85%29.aspx */
	printf("Current output code page: %d\n", GetConsoleOutputCP());
	printf("Current input code page: %d\n", GetConsoleCP());
	if (!SetConsoleOutputCP(858))
		printf("Failed\n");
	if (!SetConsoleCP(858))
		printf("Failed\n");
	printf("Current output code page: %d\n", GetConsoleOutputCP());
	printf("Current input code page: %d\n", GetConsoleOutputCP());
	
	my_print("");
	my_print(".28605");

		getchar();
	return 0;
}