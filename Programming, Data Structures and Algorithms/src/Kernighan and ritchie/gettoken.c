#include <string.h>
#include <ctype.h>
#include "5-18,20.h"

int gettoken(void) /* return next token */
{
    int c, getch(void);
    void ungetch(int);
    char *p = token;
    while ((c = getch()) == ' ' || c == '\t')
        ;
    if (c == '(') {
	    while ((c = getch()) == ' ' || c == '\t')
		    ;
        if (c == ')') {
            strcpy(token, "()");
            return tokentype = PARENS;
        } else {
            ungetch(c);
            return tokentype = '(';
      }
  } else if (c == '[') {
      for (*p++ = c; (*p++ = getch()) != ']'; )
          ;
      *p = '\0';
      return tokentype = BRACKETS;
  } else if (isalpha(c)) {
      for (*p++ = c; isalnum(c = getch()); )
          *p++ = c;
      *p = '\0';
      ungetch(c);
      return tokentype = NAME;
  } else
  {
	  *p++ = c;
	  *p = '\0';
      return tokentype = c;
  }
}

