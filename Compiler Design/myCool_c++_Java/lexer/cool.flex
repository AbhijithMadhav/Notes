/*
 *  The scanner definition for COOL.
 */

%{
#include <cool-parse.h>

/* The cool parser assumes 'cool_' identifiers. So ensure that the default
 *  versions are replaced cool-lex.cc with the 'cool_' versions
 */
#define yylval cool_yylval
#define yylex  cool_yylex

/* Max size of string constants */
#define MAX_STR_CONST 1025

extern FILE *fin; /* we read from this file */

/* define YY_INPUT so we read from the FILE fin:
 * This change makes it possible to use this scanner in
 * the Cool compiler.
 */
#undef YY_INPUT
#define YY_INPUT(buf,result,max_size) \
	if ( (result = fread( (char*)buf, sizeof(char), max_size, fin)) < 0) \
		YY_FATAL_ERROR( "read() in flex scanner failed");

char string_buf[MAX_STR_CONST]; /* to assemble string constants */

extern int curr_lineno;
extern int verbose_flag;

extern YYSTYPE cool_yylval;

#define _STR_CONST 0
#define _NULL_IN_STRING 1
#define _TOO_LONG_STRING 2
#define _ESCAPED_NULL_IN_STRING 3

int toCoolString(char*&, int&);
int count(char*, int);
int nested = 0;
int str_len;
char *string;
char invalid_char;
int status;
%}

/*
 * Names for regular expressions
 */
DARROW          =>
ASSIGN          <-
LE              <=
a   		    [aA]
b	        	[bB]
c       		[cC]
d       		[Dd]
e       		[Ee]
f       		[Ff]
g       		[Gg]
h       		[Hh]
i       		[Ii]
j       		[Jj]
k       		[Kk]
l       		[Ll]
m	        	[Mm]
n	        	[Nn]
o       		[Oo]
p       		[Pp]
q       		[Qq]
r       		[Rr]
s       		[Ss]
t       		[Tt]
u       		[Uu]
v       		[Vv]
w       		[Ww]
x       		[Xx]
y       		[Yy]
z       		[Zz]

 /*
  * Start conditions
  */
%x COMMENT
%x STRING
%x STRING_ERROR
%%

 /*
  *  Nested comments
  */
\(\*                    { BEGIN COMMENT;  }
<COMMENT>[^*(\n]+       /* Ignore anything that is not a '*' or a '(' or a '\n'*/
<COMMENT>\*[^)]         /* Ignore a '*' not followed by a ')'*/
<COMMENT>\([^*]         /* Ignore a '(' not followed by a '*' */
<COMMENT>\n             { ++curr_lineno; }
<COMMENT>\(\*           { nested++; }
<COMMENT>[*]+\)         {
                            if (nested == 0) 
                                BEGIN INITIAL;
                            else
                                nested--;
                        }
<COMMENT><<EOF>>        {
                            BEGIN INITIAL;
                            cool_yylval.error_msg = "EOF in comment";
                            return ERROR;
                        }
\*\)                    {
                            cool_yylval.error_msg = "Unmatched *)";
                            return ERROR;
                        }
 /*
  *  Line comments
  */
"--"[^\n]*              ;

 /*
  *  The multiple-character operators.
  */
{DARROW}    		        { return DARROW; }
{ASSIGN}                    { return ASSIGN; }
{LE}                        { return LE; }

 /*
  * Single character operators
  */
~                           { return '~'; }
\+                          { return '+'; }
\-                          { return '-'; }
\*                          { return '*'; }
\/                          { return '/'; }
\<                          { return '<'; }
\{				            { return '{'; }
\}				            { return '}'; }
\(				            { return '('; }
\)				            { return ')'; }
:				            { return ':'; }
;                           { return ';'; }
,                           { return ','; }
=                           { return '='; }
\.                          { return '.'; }
@                           { return '@'; }

 /* 
  * Keywords are case-insensitive except for the values true and false,
  * which must begin with a lower-case letter.
  */
{c}{l}{a}{s}{s}     		{ return CLASS; }
{e}{l}{s}{e}		        { return ELSE; }
{f}{i}      				{ return FI; }
{i}{f}		        		{ return IF; }
{i}{n}				        { return IN; }
{i}{n}{h}{e}{r}{i}{t}{s}	{ return INHERITS; }
{l}{e}{t}           		{ return LET; }
{l}{o}{o}{p}		        { return LOOP; }
{p}{o}{o}{l}	        	{ return POOL; }
{t}{h}{e}{n}		        { return THEN; }
{w}{h}{i}{l}{e}		        { return WHILE; }
{c}{a}{s}{e}	        	{ return CASE; }
{e}{s}{a}{c}	        	{ return ESAC; }
{o}{f}			            { return OF; }
{n}{e}{w}	        		{ return NEW; }
{i}{s}{v}{o}{i}{d}	        { return ISVOID; }
{n}{o}{t}		            { return NOT; }
t{r}{u}{e}			        {
            					cool_yylval.boolean = true;
			            		return BOOL_CONST;
            				} 
f{a}{l}{s}{e}	    		{
				            	cool_yylval.boolean = false;
            					return BOOL_CONST;
			            	} 


 /*
  *  String constants (C syntax)
  *  Escape sequence \c is accepted for all characters c. Except for 
  *  \n \t \b \f, the result is c.
  *
  */
\"\"                            {
            					    cool_yylval.symbol = new Entry("", 0, rand());
                                    return STR_CONST;
                                }
\"                              { BEGIN STRING;}
<STRING>([^\\"\n]|\\.|\\\n)*    { /* Match everything until 
                                        an unescaped '"' or 
                                        an unespaced '\n'*/ 

                                    str_len = yyleng;
                                    string = (char*)malloc(yyleng);
                                    memcpy(string, yytext, yyleng);
                                    status = toCoolString(string, str_len);
                                    curr_lineno += count(yytext, yyleng);
                                    if (status != _STR_CONST)
                                    {
                                        if (status == _NULL_IN_STRING)
                                            cool_yylval.error_msg = "String contains null character";
                                        else if (status == _TOO_LONG_STRING)
                                            cool_yylval.error_msg = "String constant too long";
                                        else // _ESCAPED_NULL_IN_STRING
                                            cool_yylval.error_msg = "String contains an escaped null character";
                                        return ERROR;
                                    }
                                }
<STRING>\n                      { //An unescaped newline
                                  // If an error is already found in the string 
                                        // use this as a demarcator to resume lexing
                                  // else 
                                        // Flag this condition as an unterminated string

                                    ++curr_lineno;
                                    BEGIN INITIAL;
                                    if (status == _STR_CONST)
                                    {
                                        cool_yylval.error_msg = "Unterminated string constant";
                                        return ERROR;
                                    }
                                }
<STRING>\"                      {
                                    BEGIN INITIAL;
                                    if (status == _STR_CONST)
                                    {
            					        cool_yylval.symbol = new Entry(string, str_len, rand());
                                        return STR_CONST;
                                    }
                                }
<STRING><<EOF>>                 {
                                    BEGIN INITIAL;
                                    cool_yylval.error_msg = "EOF in string constant";
                                    return ERROR;
                                }

 /*
  * Integer constants
  */
[0-9]+      {
                cool_yylval.symbol = new Entry(yytext, yyleng, rand());
            	return INT_CONST;
			 }

 /*
  * Identifiers
  */
[A-Z][a-zA-Z_0-9]*		{
            			cool_yylval.symbol = new Entry(yytext, yyleng, rand());
			           	return TYPEID;
            		}
[a-z][a-zA-Z_0-9]*     {
				       	cool_yylval.symbol = new Entry(yytext, yyleng, rand());
            			return OBJECTID;
			        }

 /*
  * Count lines
  */
\n      ++curr_lineno;

 /*
  * White Space
  */
[ \t\f\r\v]+        ;

 /*
  * Undefined characters
  */
.       {
            invalid_char = yytext[0];
            cool_yylval.error_msg = &invalid_char;
            return ERROR;
         }
%%

/* 
 * Converts string pointed by str to a cool string
 *  1. Reports any nulls(returns ERROR)
 *  2. Converts escape character representation to the actual character(returns STR_CONST)
 */
int toCoolString(char *&str, int &n)
{
    // deal with escape sequences if any
    // also detect null characters
    for (int i = 0; i < n; i++)
    {
        // null character
        if (str[i] == 0)
                return _NULL_IN_STRING;

        // '\' is the last character of the string
        if (str[i] == '\\' && i == n - 1)
            n--;
        else if (str[i] == '\\' && i < n - 1)
        {
   		    if (str[i+1] == 'b')
       		    str[i] = 8;
            else if (str[i+1] == 't')
        	    str[i] = 9;
            else if (str[i+1] == 'n')
	    	    str[i] = 10;
            else if (str[i+1] == 'f')
			     str[i]= 12;
            else if (str[i + 1] == 0)
                return _ESCAPED_NULL_IN_STRING;
            else
                str[i] = str[i+1];

            // adjust string by moving all characters one place left 
    	    for ( int j = i+1; j < n - 1; j++)
              	str[j] = str[j+1];
            n--;
        }
    } // end of for
    if (n > 1024)
        return _TOO_LONG_STRING;
    return _STR_CONST;
}

int count(char *string, int len)
{
    int num = 0;
    for(int i = 0; i < len; i++)
        if (string[i] == '\n')
            num++;
    return num;
}
