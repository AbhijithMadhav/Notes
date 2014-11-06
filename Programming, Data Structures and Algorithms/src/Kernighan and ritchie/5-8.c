/* Exercise 5-8. There is no error checking in day_of_year or month_day. Remedy this defect. */

/* Exercise 5-9. Rewrite the routines day_of_year and month_day with pointers instead of
indexing. */

#include <stdio.h>

int main()
{
	int day_of_year(int year, int month, int day);
	printf("day_of_year: %d\n", day_of_year(2010, 2, 2));
	
	{
		int month_day(int, int, int*, int*);
		int month, day;
		if (month_day(2010, 100, &month, &day) > 0)
			printf("month_day: %d %d\n", month, day);
	}
	getchar();
	return 0;
}