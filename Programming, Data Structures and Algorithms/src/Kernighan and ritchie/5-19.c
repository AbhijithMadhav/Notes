#include <stdio.h>
#include <string.h>
#include <ctype.h>

#include "5-18,20.h"

#define MAXTOKEN   100

int gettoken(void);
int tokentype;            /* type of last token */
char token[MAXTOKEN];     /* last token string */
char name[MAXTOKEN];      /* identifier name */
char datatype[MAXTOKEN];  /* data type = char, int, etc. */
char out[1000];

/* undcl: convert word descriptions to declarations */
int main()
{
    int type, p_type;
    char temp[MAXTOKEN];
    while (gettoken() != EOF) {
        strcpy(out, token);
	p_type = tokentype;
        while ((type = gettoken()) != '\n')
	{
            if (type == PARENS || type == BRACKETS)
                strcat(out, token);
            else if (type == '*') {
		    if (p_type == NAME)
		    {
			    sprintf(temp, "(*%s)", out);
			    strcpy(out, temp);
		    }
		    else
		    { 
			    sprintf(temp, "*%s", out);
			    strcpy(out, temp);
		    }
            } else if (type == NAME) {
                sprintf(temp, "%s %s", token, out);
                strcpy(out, temp);
            } else
                printf("invalid input at %s\n", token);
	    p_type = type;
	}
	    printf("%s\n", out);
    }
    return 0;
}
