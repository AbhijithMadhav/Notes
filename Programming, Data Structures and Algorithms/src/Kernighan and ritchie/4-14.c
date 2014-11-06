/* Exercise 4-14. Define a macro swap(t,x,y) that interchanges two arguments of type t.
(Block structure will help.)*/
#include<stdio.h>
#define swap(t, x, y) {t temp; temp = x; x = y; y = temp;}

int main()
{
	int a = 10, b = 20;
	swap(int, a, b);
	printf("%d %d\n", a, b);
	getchar();
}