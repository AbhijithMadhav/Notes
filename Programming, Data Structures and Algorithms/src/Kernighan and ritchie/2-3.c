/*
 * 2-3.c
 *
 *  Created on: Dec 6, 2009
 *      Author: Abhijith
 */

#include<stdio.h>
#include<string.h>
#include<math.h>

#define MAX_LEN 10

long htoi(char []);

/*
 * Write a function htoi(s), which converts a string of hexadecimal digits
 * (including an optional 0x or 0X) into its equivalent integer value. The
 * allowable digits are 0 through 9, a through f, and A through F.
 */
int main()
{
	char hex[MAX_LEN];
	printf("\nHexadecimal number(Max 8 digits) : ");
	scanf("%s", hex);
	putchar('\n');
	if (hex[0] == '0' && (hex[1] == 'x' || hex[1] == 'X'))
	{
		if (strlen(hex) > ((sizeof(long) * 2) + 2))
		{
			printf("Enter a maximum of 8 digits only\n");
			getch();
			return 1;
		}
	}
	else if (strlen(hex) > sizeof(long) * 2 )
	{
			printf("Enter a maximum of 8 digits only\n");
			getch();
			return 1;
	}
	printf("Decimal equivalent : %d\n", htoi(hex));
	getch();
    return 0;
}

long htoi(char hex[])
{
	int num;
	long decimal = 0;
	int i;
	for(i = strlen(hex) - 1 ; i >= 0 ; --i)
	{
		switch(hex[i])
		{
		case 'x':
		case 'X':
			if ( i == 1 )
				continue;
			else
			{
				printf("Invalid hexadecimal numeral '%c' at position %d\n", hex[i], strlen(hex) - 1 -i);
				continue;
			}
			break;
		case '0':
			if ( (strlen(hex) > 1) && (hex[1] == 'x' || hex[1] == 'X'))
				continue;
			else
				num = hex[i] - '0';
		case 'A':
		case 'a':
			num = 10;
			break;
		case 'B':
		case 'b':
			num = 11;
			break;
		case 'C':
		case 'c':
			num = 12;
			break;
		case 'D':
		case 'd':
			num = 13;
			break;
		case 'E':
		case 'e':
			num = 14;
			break;
		case 'F':
		case 'f':
			num = 15;
			break;
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			num = hex[i] - '0';
			break;
		default:
			printf("Invalid hexadecimal numeral '%c' at position %d\n", hex[i], strlen(hex) - 1 -i);
			num = 0;
			break;
		}
		decimal += num * (long)pow(16, strlen(hex) - 1 - i);
	}
	return(decimal);
}