#include<stdio.h>

char *a; 
int i;
int main(int argc, char *argv[])
{
	int eval();
	if (argc <= 1)
	{
		printf("\nUsage: %s <prefix-expression>\nSeperate the operands and operators by spaces\n", argv[0]);
	return 1;	
	}
	a = argv[1];
	printf("%s = %d\n", a, eval());
	return 0;
}

int eval()
  { int x = 0;
    while (a[i] == ' ') i++;
    if (a[i] == '+')
      { i++; return eval() + eval(); }
    if (a[i] == '*')
      { i++; return eval() * eval(); }
    while ((a[i] >= '0') && (a[i] <= '9')) 
      x = 10*x + (a[i++]-'0'); 
    return x;
  }
