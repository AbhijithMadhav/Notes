int a[10], *p = a, i;

void foo()
{
	for ( i = 0; i < 10; ++i)
		a[i] = i;

	for ( p = a; p < &a[9]; ++p)
		*p = i;
}
