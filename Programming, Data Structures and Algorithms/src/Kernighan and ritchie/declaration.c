#include <string.h>
#include <stdio.h>
#include "5-18,20.h"

int dirdcl(void);
int gettoken(void);

/* dcl: parse a declarator */
int dcl(void)
{
    int ns, temp;
    for (ns = 0; gettoken() == '*'; ) /* count *'s */
         ns++;
    temp = dirdcl();
    while (ns-- > 0)
         strcat(out, " pointer to");
    return temp;
}

/* dirdcl: parse a direct declarator */
int dirdcl(void)
{
    int type;
    if (tokentype == '(') {          /* ( dcl ) */
        dcl();
         if (tokentype != ')')
	 {
             printf("error: missing )\n");
	     return 0;
	 }
    } else if (tokentype == NAME) /* variable name */
         strcpy(name, token);
    else
    {
         printf("error: expected name or (dcl)\n");
	 return 0;
    }
    while ((type=gettoken()) == PARENS || type == BRACKETS)
  if (type == PARENS)
      strcat(out, " function returning");
  else {
      strcat(out, " array");
      strcat(out, token);
      strcat(out, " of");
  }
    return 1;
}

