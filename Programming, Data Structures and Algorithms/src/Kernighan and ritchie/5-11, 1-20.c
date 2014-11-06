/* Exercise 5-11. Modify the program entab and detab (written as exercises in Chapter 1) to
accept a list of tab stops as arguments. Use the default tab settings if there are no arguments.
*/

/*
Exercise 1-20. Write a program detab that replaces tabs in the input with the proper number
of blanks to space to the next tab stop. Assume a fixed set of tab stops, say every n columns.
Should n be a variable or a symbolic parameter?
*/

#include <stdlib.h>
#include <stdio.h>

#define TAB_STOP 4 // A tab stop is every eighth character position in a page

int main(int argc, char *argv[])
{
	int detab(int), tab_stop;

	if (argc < 2)
		tab_stop = TAB_STOP;
	else
		tab_stop = atoi(*++argv);
	printf("Tab stop is every %d column\n", tab_stop);
	detab(tab_stop);
	return 0;
}
