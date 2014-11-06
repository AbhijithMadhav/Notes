#include <stdio.h>

void foo();
void boo();
void call(int, int (*)());

int main()
{
	int a = 0;
	call(1, (int (*)())(a ? boo : foo));
	return 0;
}

void call(int a, int (*funcptr)())
{
	(*funcptr)();
}

void foo()
{
	printf("In foo\n");
}

void boo()
{
	printf("In boo\n");
}
