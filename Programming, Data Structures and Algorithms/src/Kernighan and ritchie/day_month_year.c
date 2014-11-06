#include <stdio.h>
static char daytab[2][13] = {
	{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
	{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
};
/* day_of_year: set day of year from month & day
returns -1 if 'year' is out of range
-2 if 'month' is out of range
-3 if 'day' is out of range
The day of the year if successful
*/
int day_of_year(int year, int month, int day)
{
	int i, leap;

	if (year < 0)
	{
		printf("'year' value out of range : %d\n", year);
		return -1;
	}
	leap = year%4 == 0 && year%100 != 0 || year%400 == 0;

	if (month < 1 || month > 12)
	{
		printf("'month' value out of range : %d\n", month);
		return -2;
	}
	if (day < 0 || day > *(*(daytab + leap) + month))
	{
		printf("'day' value out of range : %d\n", day);
		return -3;
	}

	for (i = 1; i < month; i++)
		day += *(*(daytab + leap) + i);
	return day;
}

/* month_day: set month, day from day of year
returns 1 if successful
-1 if 'year' is out of range
-2 if yearday is out of range
*/
int month_day(int year, int yearday, int *pmonth, int *pday)
{
	int i, leap;

	if (year < 0)
	{
		printf("'year' value out of range : %d\n", year);
		return -1;
	}
	leap = year%4 == 0 && year%100 != 0 || year%400 == 0;

	if (yearday < 1)
	{
		printf("'yearday' value out of range : %d\n", yearday);
		return -2;
	}
	for (i = 1; i < 12 && yearday > *(*(daytab + leap) + i); i++)
		yearday -= *(*(daytab + leap) + i);

	if (i == 12 && yearday > *(*(daytab + leap) + 12))
	{
		printf("'yearday' value out of range : %d\n", yearday);
		return -2;
	}

	*pmonth = i;
	*pday = yearday;
	return 1;
}