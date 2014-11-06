#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAXTOKEN   100

int dcl(void);
int dirdcl(void);
int gettoken(void);
char tokentype;            /* type of last token */
char token[MAXTOKEN];     /* last token string */
char name[MAXTOKEN];      /* identifier name */
char datatype[MAXTOKEN];  /* data type = char, int, etc. */
char out[1000];

int main() /* convert declaration to words */
{
	int success;
    printf("Enter the declaration\n");
    while (gettoken() != EOF) {    /* 1st token on line */
    strcpy(datatype, token); /* is the datatype */
    out[0] = '\0';
    success = dcl();        /* parse rest of line */
    if (tokentype != '\n')
    {
        printf("syntax error\n");
        while (gettoken() != '\n')
	    ;
	continue;
    }
    if (success)
	    printf("%s: %s %s\n", name, out, datatype);
    }
    return 0;
}



