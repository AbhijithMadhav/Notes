#include<stdio.h>

/* 
 * Compile the below with "Default char unsigned" option turned of and on
 * Properties -> Configuration properties -> C/C++ -> Language -> Default char unsigned
 */


int main()
{
	unsigned char uc = 127;
	signed char sc = 127;
	char pc = 127;

	uc = uc + 5;
	sc = sc + 5;
	pc = pc + 5;

	printf("unsigned char: %c %d\nsigned char: %c %d\nplain char: %c %d\n", uc, uc, sc, sc, pc, pc);

	getchar();
	return 0;
}