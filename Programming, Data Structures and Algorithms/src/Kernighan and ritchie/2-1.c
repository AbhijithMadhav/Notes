#include<stdio.h>
#include<limits.h>
#include<float.h>
#include<math.h>
/*
 * Exercise 2-1. Write a program to determine the ranges of char, short, int,
 * and long variables, both signed and unsigned, by printing appropriate values
 * from standard headers and by direct computation. Harder if you compute them:
 * determine the ranges of the various floating-point types.
 */

int main()
{
	printf("Boundary values of char\n");

	/* Calculating max and min for integer data types
	 * n = number of bytes occupied by the data type
	 * min = - 2 ^ (n - 1) for signed, 0 for unsigned
	 * max = + (2 ^ (n - 1)) - 1
	 * Signed min and unsigned max is obtained by shifting 1 in lsb to msb, unsigned min is 0
	 * Signed max is obtained by shifting 1 is lsb to msb and then inverting all bits
	 * The obtained value must be cast to the appropriate type to ensure that only the relevent bits 
	 * for that type are interpreted
	 */
	printf("Range of signed char(From limits.h) : %d to %d\n", SCHAR_MIN, SCHAR_MAX);
	printf("Range of signed char(Computed values) : %d to %d\n", (signed char)(1 << ((sizeof(signed 
		char) * 8) - 1)), (signed char)~(1 << (sizeof(signed char) * 8) - 1));	

	printf("Range of unsigned char(From limits.h) : %u to %u\n", 0, UCHAR_MAX);
	printf("Range of unsigned char(Computed values) : %u to %u\n", 0, (unsigned char)~0);	

	printf("\nBoundary values of int\n");
	printf("Range of int(From limits.h) : %d to %d\n", INT_MIN, INT_MAX);
	printf("Range of int(Computed values) : %d to %d\n", (int)(1 << ((sizeof(int) * 8) - 1)), 
		(int)~(1 << (sizeof(int) * 8) - 1));	

	printf("Range of unsigned int(From limits.h) : %u to %u\n", 0, UINT_MAX);
	printf("Range of unsigned int(Computed values) : %u to %u\n", 0, (unsigned int)~0);	

	printf("Range of short(From limits.h) : %d to %d\n", SHRT_MIN, SHRT_MAX);
	printf("Range of short(Computed values) : %d to %d\n", (short)(1 << ((sizeof(short) * 8) - 1)), 
		(short)~(1 << (sizeof(short) * 8) - 1));	

	printf("Range of unsigned short(From limits.h) : %u to %u\n", 0, USHRT_MAX);
	printf("Range of unsigned short(Computed values) : %u to %u\n", 0, (unsigned short)~0);	

	printf("Range of long(From limits.h) : %d to %d\n", LONG_MIN, LONG_MAX);
	printf("Range of long(Computed values) : %d to %d\n", (long)(1 << ((sizeof(long) * 8) - 1)), 
		(long)~(1 << (sizeof(long) * 8) - 1));	

	printf("Range of unsigned long(From limits.h): %u to %u\n", 0, ULONG_MAX);
	printf("Range of unsigned long(Computed values) : %u to %u\n", 0, (unsigned long)~0);	

	printf("\nBoundary values of floating point numbers\n");
	/* Calculating max and min for floating point numbers
	 * emin = minimum value of the exponent field after adjustment with the excess
	 * emax = maximum value of the exponent field after adjustment with the excess
	 * m = number of bits for the mantissa field
	 * f = maximum value of the fractional part of the precision
	 *   = (2 ^ -1) + (2 ^ -2) + ... + ( 2 ^ (m-1))
	 *
	 * Minimum value = - 2 ^ (emin - m + 2)
	 * Maximum value = + 2 ^ (emax - 1) * (1 + f)
	 *
	 *
	 */
	printf("Positive range of float(From float.h): %e to %e\n", FLT_MIN,
			FLT_MAX);

	printf("Positive range of double(From float.h): %e to %e\n", DBL_MIN,
			DBL_MAX);

	printf("Positive range of long double(From float.h): %Le to %Le\n",
			LDBL_MIN, LDBL_MAX);
	getchar();
	return 0;
}
