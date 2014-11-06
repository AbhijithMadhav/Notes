/*
Copyright (c) 2000 The Regents of the University of California.
All rights reserved.

Permission to use, copy, modify, and distribute this software for any
purpose, without fee, and without written agreement is hereby granted,
provided that the above copyright notice and the following two
paragraphs appear in all copies of this software.

IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR
DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES ARISING OUT
OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF THE UNIVERSITY OF
CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY
AND FITNESS FOR A PARTICULAR PURPOSE.  THE SOFTWARE PROVIDED HEREUNDER IS
ON AN "AS IS" BASIS, AND THE UNIVERSITY OF CALIFORNIA HAS NO OBLIGATION TO
PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
*/

import java.io.PrintStream;
import java.util.Enumeration;

import java_cup.runtime.Symbol;

class Utilities {
    // change this to true to enable table checking
    private static final boolean checkTables = false;

    // sm: fixed an off-by-one error here; code assumed there were 80 spaces, but
    // in fact only 79 spaces were there; I've made it 80 now
    //                                         1         2         3         4         5         6         7
    //                               01234567890123456789012345678901234567890123456789012345678901234567890123456789
    private static String padding = "                                                                                "; // 80 spaces for padding
    
    /** Prints error message and exits 
     *
     * @param msg the error message
     * */
    public static void fatalError(String msg) {
	(new Throwable(msg)).printStackTrace();
	System.exit(1);
    }

    /** Prints an appropritely escaped string
     * 
     * @param str the output stream
     * @param s the string to print
     * */
    public static void printEscapedString(PrintStream str, String s) {
	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    switch (c) {
	    case '\\': str.print("\\\\"); break;
	    case '\"': str.print("\\\""); break;
	    case '\n': str.print("\\n"); break;
	    case '\t': str.print("\\t"); break;
	    case '\b': str.print("\\b"); break;
	    case '\f': str.print("\\f"); break;
	    default:
		if (c >= 0x20 && c <= 0x7f) {
		    str.print(c);
		} else {
		    String octal = Integer.toOctalString(c);
		    str.print('\\');
		    switch (octal.length()) {
		    case 1:
			str.print('0');
		    case 2:
			str.print('0');
		    default:
			str.print(octal);
		    }
		}
	    }
	}
    }

    /** Returns a string representation for a token
     *
     * @param s the token
     * @return the string representation
     * */
    public static String tokenToString(Symbol s) {
	switch (s.sym) {
	case TokenConstants.CLASS:      return("CLASS");
	case TokenConstants.ELSE:       return("ELSE");
	case TokenConstants.FI:         return("FI");
	case TokenConstants.IF:         return("IF");
	case TokenConstants.IN:         return("IN");
	case TokenConstants.INHERITS:   return("INHERITS");
	case TokenConstants.LET:        return("LET");  
	case TokenConstants.LOOP:       return("LOOP"); 
	case TokenConstants.POOL:       return("POOL"); 
	case TokenConstants.THEN:       return("THEN"); 
	case TokenConstants.WHILE:      return("WHILE"); 
	case TokenConstants.ASSIGN:     return("ASSIGN");
	case TokenConstants.CASE:       return("CASE");  
	case TokenConstants.ESAC:       return("ESAC");  
	case TokenConstants.OF:         return("OF");    
	case TokenConstants.DARROW:     return("DARROW");
	case TokenConstants.NEW:        return("NEW");   
	case TokenConstants.STR_CONST:  return("STR_CONST");
	case TokenConstants.INT_CONST:  return("INT_CONST");
	case TokenConstants.BOOL_CONST: return("BOOL_CONST");
	case TokenConstants.TYPEID:     return("TYPEID"); 
	case TokenConstants.OBJECTID:   return("OBJECTID");
	case TokenConstants.ERROR:      return("ERROR"); 
	case TokenConstants.error:      return("ERROR"); 
	case TokenConstants.LE:         return("LE");    
	case TokenConstants.NOT:        return("NOT");   
	case TokenConstants.ISVOID:     return("ISVOID");
	case TokenConstants.PLUS:       return("'+'");
	case TokenConstants.DIV:        return("'/'");
	case TokenConstants.MINUS:      return("'-'");
	case TokenConstants.MULT:       return("'*'");
	case TokenConstants.EQ:         return("'='");
	case TokenConstants.LT:         return("'<'");
	case TokenConstants.DOT:        return("'.'");
	case TokenConstants.NEG:        return("'~'");
	case TokenConstants.COMMA:      return("','");
	case TokenConstants.SEMI:       return("';'");
	case TokenConstants.COLON:      return("':'");
	case TokenConstants.LPAREN:     return("'('");
	case TokenConstants.RPAREN:     return("')'");
	case TokenConstants.AT:         return("'@'");
	case TokenConstants.LBRACE:     return("'{'");
	case TokenConstants.RBRACE:     return("'}'");
	case TokenConstants.EOF:        return("EOF");
	default:                        return("<Invalid Token: " + s.sym + ">");
	}
    }

    /** Prints a token to stderr
     *
     * @param s the token
     * */
    public static void printToken(Symbol s) {
	System.err.print(tokenToString(s));

	String val = null;

	switch (s.sym) {
	case TokenConstants.BOOL_CONST:
	    System.err.print(" = " + s.value);
	    break;
	case TokenConstants.INT_CONST:
	    val = ((AbstractSymbol)s.value).getString();
	    System.err.print(" = " + val);
	    if (checkTables) {
		AbstractTable.inttable.lookup(val);
	    }
	    break;
	case TokenConstants.TYPEID:
	case TokenConstants.OBJECTID:
	    val = ((AbstractSymbol)s.value).getString();
	    System.err.print(" = " + val);
	    if (checkTables) {
		AbstractTable.idtable.lookup(val);
	    }
	    break;
	case TokenConstants.STR_CONST: 
	    val = ((AbstractSymbol)s.value).getString();
	    System.err.print(" = \"");
	    printEscapedString(System.err, val);
	    System.err.print("\"");
	    if (checkTables) {
		AbstractTable.stringtable.lookup(val);
	    }
	    break;
	case TokenConstants.ERROR:
	    System.err.print(" = \"");
	    printEscapedString(System.err, s.value.toString());
	    System.err.print("\"");
	    break;
	}
	System.err.println("");
    }

    /** Dumps a token to the specified stream
     *
     * @param s the token
     * @param str the stream
     * */
    public static void dumpToken(PrintStream str, int lineno, Symbol s) {
	str.print("#" + lineno + " " + tokenToString(s));

	String val = null;

	switch (s.sym) {
	case TokenConstants.BOOL_CONST:
	    str.print(" " + s.value);
	    break;
	case TokenConstants.INT_CONST:
	    val = ((AbstractSymbol)s.value).getString();
	    str.print(" " + val);
	    if (checkTables) {
		AbstractTable.inttable.lookup(val);
	    }
	    break;
	case TokenConstants.TYPEID:
	case TokenConstants.OBJECTID:
	    val = ((AbstractSymbol)s.value).getString();
	    str.print(" " + val);
	    if (checkTables) {
		AbstractTable.idtable.lookup(val);
	    }
	    break;
	case TokenConstants.STR_CONST: 
	    val = ((AbstractSymbol)s.value).getString();
	    str.print(" \"");
	    printEscapedString(str, val);
	    str.print("\"");
	    if (checkTables) {
		AbstractTable.stringtable.lookup(val);
	    }
	    break;
	case TokenConstants.ERROR:
	    str.print(" \"");
	    printEscapedString(str, s.value.toString());
	    str.print("\"");
	    break;
	}

	str.println("");
    }

    /** Returns the specified amount of space padding 
     *
     * @param n the amount of padding
     * */
    public static String pad(int n) {
	if (n > 80) return padding;
	if (n < 0) return "";
	return padding.substring(0, n);
    }
    
    public static String getDefaultObjectAddress(AbstractSymbol type)
    {
    	String defaultAddress;
		if (type.equals(TreeConstants.Int))
			defaultAddress = CgenSupport.INTCONST_PREFIX
					+ AbstractTable.inttable
							.lookup(CgenSupport.INT_DEFAULT).index;
		else if (type.equals(TreeConstants.Str))
			defaultAddress = CgenSupport.STRCONST_PREFIX
					+ AbstractTable.stringtable
							.lookup(CgenSupport.STR_DEFAULT).index;
		else if (type.equals(TreeConstants.Bool))
			defaultAddress = CgenSupport.BOOLCONST_PREFIX 
					+ CgenSupport.BOOL_FALSE;
		else
			defaultAddress = CgenSupport.VOIDCONST_PREFIX;
		
//		System.out.println(type.toString() + " : " + defaultAddress);
		return defaultAddress;
    }
    
    /**
     * Returns the address of variables which are either 
     * 1. Object attributes or 
     * 2. Parameters of class methods or
     * 3. Variables introduced by the let expression
     *  
     * Address of an object attribute is the sum of the address of the invoking 
     * object(present in $a0) and the offset of attribute in the class of the 
     * invoking object.
     * The class of the invoking object must be either the class in which the
     * attribute is defined or one of its subclass. The offset of the attribute
     * in a class and in any of its subclass is the same and thus the class in 
     * which the attribute is originally defined, c, can be used to calculate
     * the offset.  
     *  
     * In the later two cases,
     * Address of an identifier is the sum of the address of the frame pointer of
     * that particular activation and an offset, given by the position of the
     * parameter in the parameter list.
     *  
     * @param name Variable whose address is to be found.
     * @param c The class in which the name is defined.
     * @param env Symbol table containing offsets of formal parameters.
     * @return A <register, offset> tuple. The 'offset' specifies the number of
     * 			words.
     */
    // Incomplete - c is the class in which the name is found. c should be the self object
    public static offsetAddress getAddress(AbstractSymbol name, CgenNode c,
    		SymbolTable env)
    {
		int offset = 0;
		if (env.lookup(name) != null)
		{
			// Cases 2 and 3
			offset = (Integer)(env.lookup(name));
			
			// The offset is negative if it is a local variable
			// The offset is positive the name is a function parameter
			return new offsetAddress(offset, CgenSupport.FP);
		}
		else
		{
			// Case 1
			offset = CgenSupport.DEFAULT_OBJFIELDS;
			for (Enumeration e = c.getFeatures().getElements(); 
					e.hasMoreElements(); offset++)
			{
				try{
					attr a = (attr)e.nextElement();
					if (a.name.equals(name))
						return new offsetAddress(offset, CgenSupport.ACC);
				}
				catch (ClassCastException ex)
				{
					
				}
			}
			//throw new AddressNotFoundException("");
			return null;
		}
    }
}

class offsetAddress
{
	int offset;
	String reg;

	public offsetAddress(int offset, String reg)
	{
		this.offset = offset;
		this.reg = reg;
	}
}

class MethodNode
{
	method m;
	int offset; // offset of this method in an objects dispatch table
	int nItems;
	CgenNode nd;
	
	public MethodNode(int offset, method m, CgenNode nd)
	{
		nItems = 0;
		this.m = m;
		this.offset = offset;
		this.nd = nd;
	}
}

class AR
{
	int nItems;
	method m;
	public AR(method m)
	{
		this.m = m;
		this.nItems = 0;
	}
}

class AttrNode
{
	int offset;
	int classTag;
	CgenNode nd; // Incomplete: Remove this
	
	public AttrNode(int offset, int classTag, CgenNode nd)
	{
		this.offset = offset;
		this.classTag = classTag;
		this.nd = nd;
	}
}