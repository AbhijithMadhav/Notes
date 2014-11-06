/*
 *  The scanner definition for COOL.
 */

import java_cup.runtime.Symbol;
import java.util.Random;
%%

%{
/*  Stuff enclosed in %{ %} is copied verbatim to the lexer class
 *  definition. All the extra variables/functions used in the
 *  lexer actions goes here.  
*/

    // Max size of string constants
    static int MAX_STR_CONST = 1024;

    // For assembling string constants
    StringBuilder string_buf = new StringBuilder();
    // A StringBuilder is chosen instead of a StringBuffer as this is a single
    // threaded process

    private int curr_lineno = 1;
    int get_curr_lineno() {
	return curr_lineno;
    }

    private AbstractSymbol filename;

    void set_filename(String fname) {
	filename = AbstractTable.stringtable.addString(fname);
    }

    AbstractSymbol curr_filename() {
	return filename;
    }

    private int nested = 0;
    private static boolean str_err;

	/* 
	 * Converts input string to a cool string by converting escape sequences
     * to the actual character representations
	 */
	StringBuilder toCoolString(StringBuilder sb) throws 
        NullInCoolStringException, 
        EscapedNullInCoolStringException
	{
	    for (int i = 0; i < sb.length(); i++)
	    {
	        // null character
	        if (sb.charAt(i) == 0)
            {
                str_err = true;
	            throw new NullInCoolStringException();
            }
	
            // escape character
	        if (sb.charAt(i) == '\\')
	            if (i == sb.length() - 1)
                    sb.deleteCharAt(i);
	            else
	            {
                    sb.deleteCharAt(i); // remove the '/'
	                if (sb.charAt(i) == 'b')
                    {
                        sb.deleteCharAt(i);
                        sb.insert(i, '\b');
                    }
	                else if (sb.charAt(i) == 't')
                    {
                        sb.deleteCharAt(i);
                        sb.insert(i, '\t');
                    }
	                else if (sb.charAt(i) == 'n')
                    {
                        sb.deleteCharAt(i);
                        sb.insert(i, '\n');
                    }
	                else if (sb.charAt(i) == 'f')
                    {
                        sb.deleteCharAt(i);
                        sb.insert(i, '\f');
                    }
	                else if (sb.charAt(i) == 0)
                    {
                        str_err = true;
	                    throw new EscapedNullInCoolStringException();
                    }
	            }
	    } // end of for
        return sb;
	}
	
    private int count(String str)
    {
        int num = 0;
        for(int i = 0; i < str.length(); i++)
            if (str.charAt(i) == '\n')
                num++;
        return num;
    }

    private Symbol appendToCoolString(String str)
    {
        try { 
            string_buf.append(toCoolString(new StringBuilder(str)));
        }
        catch(NullInCoolStringException e)  { 
                return new Symbol(TokenConstants.ERROR,
                    "String contains null character");
        }
        catch(EscapedNullInCoolStringException e) {
                return new Symbol(TokenConstants.ERROR,
                    "String contains an escaped null character");
        }
        return null;
    }
    
    class NullInCoolStringException extends Exception {}
    class EscapedNullInCoolStringException extends Exception {}
%}

%init{

/*  Stuff enclosed in %init{ %init} is copied verbatim to the lexer
 *  class constructor, all the extra initialization you want to do should
 *  go here.  Don't remove or modify anything that was there initially. */

    // empty for now
%init}

%eofval{

/*  Stuff enclosed in %eofval{ %eofval} specifies java code that is
 *  executed when end-of-file is reached.  If you use multiple lexical
 *  states and want to do something special if an EOF is encountered in
 *  one of those states, place your code in the switch statement.
 *  Ultimately, you should return the EOF symbol, or your lexer won't
 *  work.  */

    switch(yy_lexical_state) {
    case STRING:
        yybegin(YYINITIAL);
        if (!str_err)
            return new Symbol(TokenConstants.ERROR, 
                "EOF in string constant");
    case COMMENT:        
        yybegin(YYINITIAL);
        if (!str_err)
            return new Symbol(TokenConstants.ERROR,
                "EOF in comment");
    }
    return new Symbol(TokenConstants.EOF);
%eofval}

%class CoolLexer
%cup

DARROW    =      =>
ASSIGN    =      <-
LE        =      <=
a         =      [aA]
b         =     [bB]
c         =     [cC]
d         =     [Dd]
e         =     [Ee]
f         =     [Ff]
g         =     [Gg]
h         =     [Hh]
i         =     [Ii]
j         =     [Jj]
k         =     [Kk]
l         =     [Ll]
m         =     [Mm]
n         =     [Nn]
o         =     [Oo]
p         =     [Pp]
q         =     [Qq]
r         =     [Rr]
s         =     [Ss]
t         =     [Tt]
u         =     [Uu]
v         =     [Vv]
w         =     [Ww]
x         =     [Xx]
y         =     [Yy]
z         =     [Zz]

QUOTE     =     \"
NEWLINE   =     \n
SLASH     =     \\
ESC_SEQ   =     {SLASH}.|{SLASH}{NEWLINE}

%state COMMENT
%state STRING

%%
<YYINITIAL>\(\*         { yybegin(COMMENT);  }
<COMMENT>[^*(\n]+       {/* Ignore anything that is not a '*' or a '(' or a '\n'*/}
<COMMENT>\*[^)]         {/* Ignore a '*' not followed by a ')'*/}
<COMMENT>\([^*]         {/* Ignore a '(' not followed by a '*' */}
<COMMENT>\n             { ++curr_lineno; }
<COMMENT>\(\*           { nested++; }
<COMMENT>[*]+\)         {
                        if (nested == 0) 
                            yybegin(YYINITIAL);
                        else
                            nested--; 
                        }
<YYINITIAL>\*\)         { return new Symbol(TokenConstants.ERROR, "Unmatched *)"); }
<YYINITIAL>"--"[^\n]*   {;}


<YYINITIAL>{DARROW} { return new Symbol(TokenConstants.DARROW); }
<YYINITIAL>{ASSIGN} { return new Symbol(TokenConstants.ASSIGN); }
<YYINITIAL>{LE}     { return new Symbol(TokenConstants.LE); }


<YYINITIAL>~    { return new Symbol(TokenConstants.NEG); }
<YYINITIAL>\+   { return new Symbol(TokenConstants.PLUS); }
<YYINITIAL>\-   { return new Symbol(TokenConstants.MINUS); }
<YYINITIAL>\*   { return new Symbol(TokenConstants.MULT); }
<YYINITIAL>\/   { return new Symbol(TokenConstants.DIV); }
<YYINITIAL>\<   { return new Symbol(TokenConstants.LT); }
<YYINITIAL>\{   { return new Symbol(TokenConstants.LBRACE); }
<YYINITIAL>\}   { return new Symbol(TokenConstants.RBRACE); }
<YYINITIAL>\(   { return new Symbol(TokenConstants.LPAREN); }
<YYINITIAL>\)   { return new Symbol(TokenConstants.RPAREN); }
<YYINITIAL>:    { return new Symbol(TokenConstants.COLON); }
<YYINITIAL>;    { return new Symbol(TokenConstants.SEMI); }
<YYINITIAL>,    { return new Symbol(TokenConstants.COMMA); }
<YYINITIAL>=    { return new Symbol(TokenConstants.EQ); }
<YYINITIAL>\.   { return new Symbol(TokenConstants.DOT); }
<YYINITIAL>@    { return new Symbol(TokenConstants.AT); }


<YYINITIAL>{c}{l}{a}{s}{s}     { return new Symbol(TokenConstants.CLASS); }
<YYINITIAL>{e}{l}{s}{e}        { return new Symbol(TokenConstants.ELSE); }
<YYINITIAL>{f}{i}              { return new Symbol(TokenConstants.FI); }
<YYINITIAL>{i}{f}              { return new Symbol(TokenConstants.IF); }
<YYINITIAL>{i}{n}              { return new Symbol(TokenConstants.IN); }
<YYINITIAL>{i}{n}{h}{e}{r}{i}{t}{s}    { return new Symbol(TokenConstants.INHERITS); }
<YYINITIAL>{l}{e}{t}           { return new Symbol(TokenConstants.LET); }
<YYINITIAL>{l}{o}{o}{p}        { return new Symbol(TokenConstants.LOOP); }
<YYINITIAL>{p}{o}{o}{l}        { return new Symbol(TokenConstants.POOL); }
<YYINITIAL>{t}{h}{e}{n}        { return new Symbol(TokenConstants.THEN); }
<YYINITIAL>{w}{h}{i}{l}{e}     { return new Symbol(TokenConstants.WHILE); }
<YYINITIAL>{c}{a}{s}{e}        { return new Symbol(TokenConstants.CASE); }
<YYINITIAL>{e}{s}{a}{c}        { return new Symbol(TokenConstants.ESAC); }
<YYINITIAL>{o}{f}              { return new Symbol(TokenConstants.OF); }
<YYINITIAL>{n}{e}{w}           { return new Symbol(TokenConstants.NEW); }
<YYINITIAL>{i}{s}{v}{o}{i}{d}  { return new Symbol(TokenConstants.ISVOID); }
<YYINITIAL>{n}{o}{t}           { return new Symbol(TokenConstants.NOT); }
<YYINITIAL>t{r}{u}{e}          { return new Symbol(TokenConstants.BOOL_CONST, true); } 
<YYINITIAL>f{a}{l}{s}{e}       { return new Symbol(TokenConstants.BOOL_CONST, false); } 


<YYINITIAL>{QUOTE}                  { 
                                    yybegin(STRING);
                                    string_buf.delete(0, string_buf.length());
                                    str_err = false;
                                    }
<STRING>[^{QUOTE}{NEWLINE}{SLASH}]* { 
                                    curr_lineno += count(yytext());
                                    Symbol s = appendToCoolString(yytext());
                                    if (s != null)
                                        return s;
                                    }
<STRING>{ESC_SEQ}                   { 
                                    if (yytext().charAt(yytext().length() - 1) == '\n')
                                        curr_lineno++; 
                                    Symbol s = appendToCoolString(yytext());
                                    if (s != null)
                                        return s;
                                    }
<STRING>{NEWLINE}                   { 
                                    ++curr_lineno;
                                    yybegin(YYINITIAL);
                                    if (!str_err)
                                        return new Symbol(TokenConstants.ERROR, 
                                            "Unterminated string constant");
                                    }
<STRING>{QUOTE}                     {
	                                if (string_buf.length() > MAX_STR_CONST)
                                    {
                                        str_err = true;
                                        yybegin(YYINITIAL);
                                        return new Symbol(TokenConstants.ERROR,
                                             "String constant too long");
                                    }
                                    yybegin(YYINITIAL);
                                    if (!str_err)
                                        return new Symbol(TokenConstants.STR_CONST, 
                                            new StringSymbol(string_buf.toString(), string_buf.length(),
                                                new Random().nextInt()));
                                    }


<YYINITIAL>[0-9]+   { return new Symbol(TokenConstants.INT_CONST,
                                          new IntSymbol(yytext(), yytext().length(),
                                              new Random().nextInt()));}


<YYINITIAL>[A-Z][a-zA-Z_0-9]*   { return new Symbol(TokenConstants.TYPEID, 
                                                        new IdSymbol(yytext(), yytext().length(), 
                                                                        new Random().nextInt())); }
<YYINITIAL>[a-z][a-zA-Z_0-9]*   { return new Symbol(TokenConstants.OBJECTID, 
                                                        new IdSymbol(yytext(), yytext().length(), 
                                                                        new Random().nextInt()));}

<YYINITIAL>\n   {++curr_lineno;}

<YYINITIAL>[ \t\f\r\013]+ {;}


<YYINITIAL>.    { return new Symbol(TokenConstants.ERROR, yytext().charAt(0)); }
