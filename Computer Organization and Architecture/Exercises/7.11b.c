#define N 1000
#define M 10000
int main()
{
/*	int i, a[N];
	for ( i = 0; i < N; ++i)
		a[i] *= 2;
*/
int i, j, a[M][N];

for (i = 0; i < N; i++)
for (j = 0; j < M; j++)
a[j][i] *= 2;

return 0;
}
