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

// This is a project skeleton file

import java.io.PrintStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Vector;

/**
 * This class is used for representing the inheritance tree during code
 * generation.
 */
class CgenClassTable extends SymbolTable
{

	/** All classes in the program, represented as CgenNode */
	private Vector<CgenNode> nds;

	/** This is the stream to which assembly instructions are output */
	private PrintStream str;
	
	/** Used to implement dynamic dispatch **/
	public Map<AbstractSymbol, LinkedList<MethodNode>> mTab;

	/** Used to lookup attributes dynamically**/
	public Map<AbstractSymbol, LinkedList<AttrNode>> aTab;
	
	/** Used to find the LUB of the type of the case expression from among its
	 * branches**/
	public Map<Integer, LinkedList<Integer>> caseTab;
	
	//private Environment env;

	/** Constructs a new class table and invokes the code generator */
	public CgenClassTable(Classes cls, PrintStream str)  
			
	{
		nds = new Vector<CgenNode>();

		this.str = str;

		//env = new Environment();
		
		mTab = new HashMap<AbstractSymbol, LinkedList<MethodNode>>();
		aTab = new HashMap<AbstractSymbol, LinkedList<AttrNode>>();
		caseTab = new HashMap<Integer, LinkedList<Integer>>();
		
		enterScope();
		if (Flags.cgen_debug)
			System.out.println("Building CgenClassTable");

		// Gather all classes in nds
		// Create name to Node mappings
		installBasicClasses();
		installClasses(cls);
		
		buildInheritanceTree();
		installMethodTab();
		installAttrTab();
		installCaseTab();
		code();

		exitScope();
	}

	// The following creates an inheritance graph from
	// a list of classes. The graph is implemented as
	// a tree of `CgenNode', and class names are placed
	// in the base class symbol table.
	/**
	 * Inserts a given node into a list of nodes
	 * @param nd
	 */
	private void installClass(CgenNode nd)
	{
		AbstractSymbol name = nd.getName();
		if (probe(name) != null)
			return;
		nds.addElement(nd);
		
		// The symbol table contains a name to node mapping.
		// node representation contains only name of the parent of a cool class
		// The symbol table helps obtain the node representation of this parent 
		// 	given its name
		addId(name, nd);
	}

	/**
	 * Creates data structures representing basic Cool classes (Object,
	 * IO, Int, Bool, String).
	 * */
	private void installBasicClasses()
	{
		// ?? Incomplete
		AbstractSymbol filename = AbstractTable.stringtable
				.addString("<basic class>");
	
		// A few special class names are installed in the lookup table
		// but not the class list. Thus, these classes exist, but are
		// not part of the inheritance hierarchy. 
		// No_class serves as the parent of Object and the other special classes.
		// SELF_TYPE is the self class; it cannot be redefined or inherited. 
		// prim_slot is a class known to the code generator.

		addId(TreeConstants.No_class, new CgenNode(new class_(0,
				TreeConstants.No_class, TreeConstants.No_class,
				new Features(0), filename), CgenNode.Basic, this));

		addId(TreeConstants.SELF_TYPE, new CgenNode(new class_(0,
				TreeConstants.SELF_TYPE, TreeConstants.No_class,
				new Features(0), filename), CgenNode.Basic, this));

		addId(TreeConstants.prim_slot, new CgenNode(new class_(0,
				TreeConstants.prim_slot, TreeConstants.No_class,
				new Features(0), filename), CgenNode.Basic, this));
				
		// The Object class has no parent class. Its methods are
		// cool_abort() : Object aborts the program
		// type_name() : Str returns a string representation
		// of class name
		// copy() : SELF_TYPE returns a copy of the object

		class_ Object_class = new class_(
				0,
				TreeConstants.Object_,
				TreeConstants.No_class,
				new Features(0)
						.appendElement(
								new method(0, TreeConstants.cool_abort,
										new Formals(0), TreeConstants.Object_,
										new no_expr(0)))
						.appendElement(
								new method(0, TreeConstants.type_name,
										new Formals(0), TreeConstants.Str,
										new no_expr(0)))
						.appendElement(
								new method(0, TreeConstants.copy,
										new Formals(0),
										TreeConstants.SELF_TYPE, new no_expr(0))),
				filename);

		installClass(new CgenNode(Object_class, CgenNode.Basic, this));

		// The IO class inherits from Object. Its methods are
		// out_string(Str) : SELF_TYPE writes a string to the output
		// out_int(Int) : SELF_TYPE "    an int    " "     "
		// in_string() : Str reads a string from the input
		// in_int() : Int "   an int     " "     "

		class_ IO_class = new class_(
				0,
				TreeConstants.IO,
				TreeConstants.Object_,
				new Features(0)
						.appendElement(
								new method(0, TreeConstants.out_string,
										new Formals(0)
												.appendElement(new formal(0,
														TreeConstants.arg,
														TreeConstants.Str)),
										TreeConstants.SELF_TYPE, new no_expr(0)))
						.appendElement(
								new method(0, TreeConstants.out_int,
										new Formals(0)
												.appendElement(new formal(0,
														TreeConstants.arg,
														TreeConstants.Int)),
										TreeConstants.SELF_TYPE, new no_expr(0)))
						.appendElement(
								new method(0, TreeConstants.in_string,
										new Formals(0), TreeConstants.Str,
										new no_expr(0)))
						.appendElement(
								new method(0, TreeConstants.in_int,
										new Formals(0), TreeConstants.Int,
										new no_expr(0))), filename);

		installClass(new CgenNode(IO_class, CgenNode.Basic, this));

		// The Int class has no methods and only a single attribute, the
		// "val" for the integer.

		class_ Int_class = new class_(0, TreeConstants.Int,
				TreeConstants.Object_, new Features(0).appendElement(new attr(
						0, TreeConstants.val, TreeConstants.prim_slot,
						new no_expr(0))), filename);

		installClass(new CgenNode(Int_class, CgenNode.Basic, this));

		// Bool also has only the "val" slot.
		class_ Bool_class = new class_(0, TreeConstants.Bool,
				TreeConstants.Object_, new Features(0).appendElement(new attr(
						0, TreeConstants.val, TreeConstants.prim_slot,
						new no_expr(0))), filename);

		installClass(new CgenNode(Bool_class, CgenNode.Basic, this));

		// The class Str has a number of slots and operations:
		// val the length of the string
		// str_field the string itself
		// length() : Int returns length of the string
		// concat(arg: Str) : Str performs string concatenation
		// substr(arg: Int, arg2: Int): Str substring selection

		class_ Str_class = new class_(
				0,
				TreeConstants.Str,
				TreeConstants.Object_,
				new Features(0)
						.appendElement(
								new attr(0, TreeConstants.val,
										TreeConstants.Int, new no_expr(0)))
						.appendElement(
								new attr(0, TreeConstants.str_field,
										TreeConstants.prim_slot, new no_expr(0)))
						.appendElement(
								new method(0, TreeConstants.length,
										new Formals(0), TreeConstants.Int,
										new no_expr(0)))
						.appendElement(
								new method(0, TreeConstants.concat,
										new Formals(0)
												.appendElement(new formal(0,
														TreeConstants.arg,
														TreeConstants.Str)),
										TreeConstants.Str, new no_expr(0)))
						.appendElement(
								new method(
										0,
										TreeConstants.substr,
										new Formals(0)
												.appendElement(
														new formal(
																0,
																TreeConstants.arg,
																TreeConstants.Int))
												.appendElement(
														new formal(
																0,
																TreeConstants.arg2,
																TreeConstants.Int)),
										TreeConstants.Str, new no_expr(0))),
				filename);

		installClass(new CgenNode(Str_class, CgenNode.Basic, this));
	}

	private void installClasses(Classes cs)
	{
		for (Enumeration e = cs.getElements(); e.hasMoreElements();)
		{
			installClass(new CgenNode((Class_) e.nextElement(),
					CgenNode.NotBasic, this));
		}
	}

	private void buildInheritanceTree()
	{
		for (Enumeration<CgenNode> e = nds.elements(); e.hasMoreElements();)
		{
			setRelations((CgenNode) e.nextElement());
		}
	}

	private void setRelations(CgenNode nd)
	{
		CgenNode parent = (CgenNode) probe(nd.getParent());
		nd.setParentNd(parent);
		parent.addChild(nd);
	}

	/** Gets the root of the inheritance tree */
	public CgenNode root()
	{
		return (CgenNode) probe(TreeConstants.Object_);
	}
	
	// The following methods emit code for constants and global
	// declarations.

	/**
	 * Construct the method table used to generate code for dynamic dispatch
	 * The method table, mTAb has a key per method. The value of a key is a
	 * list of MethodNode's with overridden methods not included. 
	 */
	private void installMethodTab()
	{	
		for (Enumeration<CgenNode> e = nds.elements(); e.hasMoreElements(); )
		{// For each class
			CgenNode nd = (CgenNode)e.nextElement();

			// For each ancestor of this class
			int methodOffset = 0;
			for (Iterator<CgenNode> i = nd.getAncestors(); i.hasNext();)
			{
				CgenNode p = i.next();
				for (Enumeration e1 = p.getFeatures().getElements(); e1
						.hasMoreElements();)
				{// An entry of each method
					method m;
					try
					{
						m = (method) e1.nextElement();
						if(!mTab.containsKey(m.name))
						{
							if (!nd.isOverridden(m.name, p))
							{
								LinkedList<MethodNode> l 
									= new LinkedList<MethodNode>();
								l.add(new MethodNode(methodOffset, m, nd));
								mTab.put(m.name, l);
							}
						}
						else
						{
							if (!nd.isOverridden(m.name, p))
								mTab.get(m.name).add
									(new MethodNode(methodOffset, m, nd));
						}
						methodOffset++;
					}
					catch (ClassCastException ex) // Attributes
					{
						// Attributes can be Features too.
						// Not interested in attributes here
						continue;
					}
				}
			}
		}
	}

	private void installAttrTab()
	{
		// For all the classes in the ancestor program
		for(Iterator<CgenNode> i = nds.iterator(); i.hasNext(); )
		{
			CgenNode nd = i.next();
			
			int offset = nd.getStartAttrOffset();
			for(Enumeration e = nd.getFeatures().getElements(); 
					e.hasMoreElements(); )
			{
				try
				{
					attr a = (attr)e.nextElement();
					if (!aTab.containsKey(a.name))
					{	
						LinkedList<AttrNode> lst = new LinkedList<AttrNode>();
						for (Iterator<CgenNode> k = nd.getSubtypes(); 
								k.hasNext(); ) // This includes nd itself
						{
							CgenNode ndSubType = k.next();
							lst.add(new AttrNode(offset, ndSubType.classTag, 
									ndSubType));
						}
						aTab.put(a.name, lst);
					}
					else
					{	
						LinkedList<AttrNode> lst = aTab.get(a.name);
						for (Iterator<CgenNode> k = nd.getSubtypes(); 
								k.hasNext(); ) // This includes nd itself
						{
							CgenNode ndSubType = k.next();
							lst.add(new AttrNode(offset, ndSubType.classTag, 
									ndSubType));
						}
					}
					offset++;
				}
				catch (ClassCastException ex)
				{
					
				}
			}
		}
		/*for (Iterator<AbstractSymbol> i = aTab.keySet().iterator();
				i.hasNext(); )
		{
			AbstractSymbol n = i.next();
			System.out.println(n.toString());
			for (Iterator<AttrNode> k = aTab.get(n).iterator(); k.hasNext(); )
			{
				AttrNode nd = k.next();
				System.out.println("\t" + nd.nd.name.toString() + " : " + nd.offset);
			}
			System.out.println();
		}*/
	}

	/**
	 * The caseTab contains mappings which give the ancestors of each class in 
	 * the child first order. This makes it easier to determine the LUB of a
	 * type.
	 * 
	 * The LUB of the type of the case-expression is determined by sequentially 
	 * comparing each ancestor in the corresponding list(child-first order) 
	 * with all the types of the branches. The first matched ancestor is the LUB
	 */
	private void installCaseTab()
	{
		// for all classes in the program
		for(Enumeration<CgenNode> e = nds.elements(); e.hasMoreElements(); )
		{
			CgenNode nd = e.nextElement();
			LinkedList<Integer> lst = new LinkedList<Integer>();
			for (Iterator<CgenNode> i = nd.getAncestors(); i.hasNext(); )
			{
				CgenNode t = i.next();
				// Ancestors are in parents-first order
				// Create a list in the child-first order
				lst.addFirst(t.classTag); 
			}
			caseTab.put(nd.classTag, lst);
		}
		
		/*for (Iterator<Entry<Integer, LinkedList<Integer>>> i 
				= caseTab.entrySet().iterator(); i.hasNext(); )
		{
			Entry<Integer, LinkedList<Integer>> e = i.next();
			System.out.println("\n" + e.getKey());
			for (Iterator<Integer> k = e.getValue().iterator(); k.hasNext(); )
			{
				System.out.print(k.next() + " ");
			}
		}*/

	}
	/**
	 * This method is the meat of the code generator.
	 */
	public void code()  
	{
		if (Flags.cgen_debug)
			System.out.println("coding global data");
		codeGlobalData();

		if (Flags.cgen_debug)
			System.out.println("choosing gc");
		codeSelectGc();

		if (Flags.cgen_debug)
			System.out.println("coding constants");
		codeConstants();

		str.println("# Begin - Class name table");
		str.println("# Class name table contains addresses of String objects"
				+ " representing all the classes in the program. These can be"
				+ " indexed using the classtag of objects");
		str.println("# Used by Object.type_name() to return name of the "
				+ "invoking object");
		codeClassNameTab();
		str.println("# End - Class name table\n");

		str.println("# Begin - Class Object table");
		str.println("# Contains pointers to prototype objects of all classes "
				+ "and to their initializers. These can be indexed using the "
				+ "classtag of objexts");
		str.println("# Used to create objects for the expression, "
				+ "new SELF_TYPE");
		codeObjTab();
		str.println("# End - Class Object table\n");

		str.println("# Begin - Dispatch tables");
		str.println("# Dispatch table of all classes");
		codeDispTab();
		str.println("# End - Dispatch tables\n");

		str.println("# Begin - Prototype objects");
		str.println("# Prototype objects for all classes. Used to create new "
				+ "objects for the respective classes");
		codePrototypeObjects();
		str.println("# End - Prototype objects");		
		
		if (Flags.cgen_debug)
			System.out.println("coding global text");
		codeGlobalText();

		str.println("# Begin - Object Initializers");
		codeObjInit();
		str.println("# End - Object Initializers");

		str.println("# Begin - Class Methods");
		codeClassMethods();
		str.println("# End - Class Methods");

	}
	/**
	 * Emits code to start the .data segment and to
	 * declare the global names.
	 * */
	private void codeGlobalData()
	{
		// The following global names must be defined first.

		str.print("\t.data\n" + CgenSupport.ALIGN);
		str.println(CgenSupport.GLOBAL + CgenSupport.CLASSNAMETAB);
		str.print(CgenSupport.GLOBAL);
		CgenSupport.emitProtObjRef(TreeConstants.Main, str);
		str.println("");
		str.print(CgenSupport.GLOBAL);
		CgenSupport.emitProtObjRef(TreeConstants.Int, str);
		str.println("");
		str.print(CgenSupport.GLOBAL);
		CgenSupport.emitProtObjRef(TreeConstants.Str, str);
		str.println("");
		str.print(CgenSupport.GLOBAL);
		BoolConst.falsebool.codeRef(str);
		str.println("");
		str.print(CgenSupport.GLOBAL);
		BoolConst.truebool.codeRef(str);
		str.println("");
		str.println(CgenSupport.GLOBAL + CgenSupport.INTTAG);
		str.println(CgenSupport.GLOBAL + CgenSupport.BOOLTAG);
		str.println(CgenSupport.GLOBAL + CgenSupport.STRINGTAG);

		// We also need to know the tag of the Int, String, and Bool classes
		// during code generation.
		// why??? Incomplete

		str.println(CgenSupport.INTTAG + CgenSupport.LABEL + CgenSupport.WORD
				+ ((CgenNode)probe(TreeConstants.Int)).classTag);
		str.println(CgenSupport.BOOLTAG + CgenSupport.LABEL + CgenSupport.WORD
				+ ((CgenNode)probe(TreeConstants.Bool)).classTag);
		str.println(CgenSupport.STRINGTAG + CgenSupport.LABEL+ CgenSupport.WORD
				+ ((CgenNode)probe(TreeConstants.Str)).classTag);
	}

	/** Generates GC choice constants (pointers to GC functions) */
	private void codeSelectGc()
	{
		str.println(CgenSupport.GLOBAL + "_MemMgr_INITIALIZER");
		str.println("_MemMgr_INITIALIZER:");
		str.println(CgenSupport.WORD
				+ CgenSupport.gcInitNames[Flags.cgen_Memmgr]);

		str.println(CgenSupport.GLOBAL + "_MemMgr_COLLECTOR");
		str.println("_MemMgr_COLLECTOR:");
		str.println(CgenSupport.WORD
				+ CgenSupport.gcCollectNames[Flags.cgen_Memmgr]);

		str.println(CgenSupport.GLOBAL + "_MemMgr_TEST");
		str.println("_MemMgr_TEST:");
		str.println(CgenSupport.WORD
				+ ((Flags.cgen_Memmgr_Test == Flags.GC_TEST) ? "1" : "0"));
	}

	/**
	 * Emits code to reserve space for and initialise all of the
	 * constants. Class names should have been added to the string
	 * table (in the supplied code, is is done during the construction
	 * of the inheritance graph), and code for emitting string constants
	 * as a side effect adds the string's length to the integer table.
	 * The constants are emmitted by running through the stringtable and
	 * inttable and producing code for each entry.
	 */
	private void codeConstants()
	{
		// Add constants that are required by the code generator.
		AbstractTable.stringtable.addString("");
		AbstractTable.inttable.addString("0");

		// The string table must first be codified as the sizes of the string
		// are then added to the int table which is then codified
		AbstractTable.stringtable.codeStringTable(
				((CgenNode)probe(TreeConstants.Str)).classTag, str);
		AbstractTable.inttable.codeStringTable(
				((CgenNode)probe(TreeConstants.Int)).classTag, str);

		codeBools(((CgenNode)probe(TreeConstants.Bool)).classTag);
		codeVoid();
	}

	/** Emits code definitions for boolean constants. */
	private void codeBools(int classtag)
	{
		BoolConst.falsebool.codeDef(classtag, str);
		BoolConst.truebool.codeDef(classtag, str);
	}

	/** Emits code definition for void */
	private void codeVoid()
	{
		// Add -1 eye catcher
		str.println(CgenSupport.WORD + "-1");
		str.println(CgenSupport.VOIDCONST_PREFIX + CgenSupport.LABEL
				+ CgenSupport.WORD + CgenSupport.VOID_CLASSTAG); // tag 
		str.println(CgenSupport.WORD 
				+ (CgenSupport.DEFAULT_OBJFIELDS - 1)); // size
	}

	/**
	 * Class name table 
	 * 
	 * A table, which at index (class tag) ∗ 4 contains a pointer
	 * to a 'String' object containing the name of the class associated 
	 */
	private void codeClassNameTab()
	{
		//The PQ sorts the nodes w.r.t the class tags.
		PriorityQueue<CgenNode> pq = new PriorityQueue<CgenNode>(nds);		

		// Generate the class-name table
		str.print(CgenSupport.CLASSNAMETAB + CgenSupport.LABEL);
		while (!pq.isEmpty())
			str.println(CgenSupport.WORD + CgenSupport.STRCONST_PREFIX
					+ AbstractTable.stringtable.lookup
						(pq.remove().name.toString()).index);

	}

	/**
	 * Class Object table
	 * 
	 * A table, which at index (class tag) ∗ 8 contains a pointer to the
	 * prototype object and at index (class tag) ∗ 8 + 4 contains a pointer to
	 * the initialization method for that class. 
	 *  
	 *  This is required so that objects can be created for the expression
	 *  'new SELF_TYPE'
	 */
	private void codeObjTab()
	{		
		//The PQ sorts the nodes w.r.t the class tags.
		PriorityQueue<CgenNode> pq = new PriorityQueue<CgenNode>(nds);		

		// Generate the object table
		str.print(CgenSupport.CLASSOBJTAB + CgenSupport.LABEL);
		while (!pq.isEmpty())
		{
			CgenNode nd = pq.remove();
			str.println(CgenSupport.WORD + nd.getName().toString()
					+ CgenSupport.PROTOBJ_SUFFIX);
			str.println(CgenSupport.WORD + nd.getName().toString()
					+ CgenSupport.CLASSINIT_SUFFIX);
		}
	}

	/**
	 * Index for dispatch tables of all classes
	 * Also construb the method table used to generate code for dynamic dispatch
	 */
	private void codeDispTab()
	{	
		for (Enumeration<CgenNode> e = nds.elements(); e.hasMoreElements(); )
		{// For each class
			CgenNode nd = (CgenNode)e.nextElement();
			
			str.print(nd.getName().toString() + CgenSupport.DISPTAB_SUFFIX
					+ CgenSupport.LABEL);
			
			// For each ancestor of this class
			for (Iterator<CgenNode> i = nd.getAncestors(); i.hasNext();)
			{
				CgenNode p = i.next();
				for (Enumeration e1 = p.getFeatures().getElements(); e1
						.hasMoreElements();)
				{// An entry of each method
					method m;
					try
					{
						m = (method) e1.nextElement();
					}
					catch (ClassCastException ex) // Attributes
					{
						// Attributes can be Features too.
						// Not interested in attributes here
						continue;
					}
					str.println(CgenSupport.WORD + p.getName().toString() + "."
							+ m.name);
				}
			}
		}
		
/*		for(Iterator<LinkedList<MethodNode>> i = mTab.values().iterator(); i.hasNext();)
		{
			LinkedList<MethodNode> l = i.next();
			for(Iterator<MethodNode> j = l.iterator(); j.hasNext();)
			{
				MethodNode mn = j.next();
				System.out.print(mn.nd.name + "." + mn.m.name + " ");
			}
			System.out.println();
			
		}
		*/
	}
	
	/**
	 * Prototype Objects - Prototype objects of all classes of the
	 * program. Used by Object.copy() to create new objects
	 * 
	 */
	private void codePrototypeObjects()
	{
		for (Enumeration<CgenNode> e = nds.elements(); e.hasMoreElements(); )
		{
			CgenNode nd = (CgenNode)e.nextElement();

			str.println(CgenSupport.WORD + "-1"); // Add -1 eye catcher
			str.print(nd.getName() + CgenSupport.PROTOBJ_SUFFIX
					+ CgenSupport.LABEL); // label
			str.println(CgenSupport.WORD + 
					((CgenNode)probe(nd.getName())).classTag); // tag

			if (nd.getName().equals(TreeConstants.Object_))
			{
				// Object size
				str.println(CgenSupport.WORD + (CgenSupport.DEFAULT_OBJFIELDS));
				str.println(CgenSupport.WORD + nd.getName().toString()
						+ CgenSupport.DISPTAB_SUFFIX); // dispatch table
			}
			else if (nd.getName().equals(TreeConstants.Str))
			{
				// object size
				str.println(CgenSupport.WORD
						+ (CgenSupport.DEFAULT_OBJFIELDS
								+ CgenSupport.STRING_SLOTS 
								+ (CgenSupport.STR_DEFAULT.length() + 4) / 4));
				str.println(CgenSupport.WORD + nd.getName().toString()
						+ CgenSupport.DISPTAB_SUFFIX); // dispatch table
				// length
				str.print(CgenSupport.WORD);
				((IntSymbol) (AbstractTable.inttable
						.lookup(CgenSupport.STR_DEFAULT.length())))
						.codeRef(str);
				str.println();

				// default string
				CgenSupport.emitStringConstant(CgenSupport.STR_DEFAULT, str);
			}
			else if (nd.getName().equals(TreeConstants.Int))
			{
				str.println(CgenSupport.WORD
						+ (CgenSupport.DEFAULT_OBJFIELDS 
								+ CgenSupport.INT_SLOTS));// object size
				str.println(CgenSupport.WORD + nd.getName().toString()
						+ CgenSupport.DISPTAB_SUFFIX); // dispatch table
				str.println(CgenSupport.WORD + CgenSupport.INT_DEFAULT);
			}
			else if (nd.getName().equals(TreeConstants.Bool))
			{
				str.println(CgenSupport.WORD
						+ (CgenSupport.DEFAULT_OBJFIELDS 
								+ CgenSupport.BOOL_SLOTS));// object size
				str.println(CgenSupport.WORD + nd.getName().toString()
						+ CgenSupport.DISPTAB_SUFFIX); // dispatch table
				str.println(CgenSupport.WORD + CgenSupport.BOOL_DEFAULT);
			}
			else if (nd.getName().equals(TreeConstants.IO))
			{
				str.println(CgenSupport.WORD 
						+ CgenSupport.DEFAULT_OBJFIELDS);// object size
				str.println(CgenSupport.WORD + nd.getName().toString()
						+ CgenSupport.DISPTAB_SUFFIX); // dispatch table
			}
			else 			// user class prototype object
			{
				str.println(CgenSupport.WORD
						+ (CgenSupport.DEFAULT_OBJFIELDS 
								+ nd.getAttributes().size())); // size
				str.println(CgenSupport.WORD + nd.getName().toString()
						+ CgenSupport.DISPTAB_SUFFIX); // dispatch table

				// Initialize all attributes from the
				// inheritance hierarchy in the parent first order.
				for(Iterator<attr> i = nd.getAttributes().iterator();
						i.hasNext(); )
				{
					attr a;
					try
					{
						
						a = i.next();
					}
					catch (ClassCastException ex)
					{
						continue;
					}
					str.println(CgenSupport.WORD 
							+ Utilities.getDefaultObjectAddress(a.type_decl));
				}
			}
		}
	}



	/**
	 * Emits code to start the .text segment and to
	 * declare the global names.
	 * */
	private void codeGlobalText()
	{
		str.println(CgenSupport.GLOBAL + CgenSupport.HEAP_START);
		str.print(CgenSupport.HEAP_START + CgenSupport.LABEL);
		str.println(CgenSupport.WORD + 0);
		str.println("\t.text");
		str.print(CgenSupport.GLOBAL);
		CgenSupport.emitInitRef(TreeConstants.Main, str);
		str.println("");
		str.print(CgenSupport.GLOBAL);
		CgenSupport.emitInitRef(TreeConstants.Int, str);
		str.println("");
		str.print(CgenSupport.GLOBAL);
		CgenSupport.emitInitRef(TreeConstants.Str, str);
		str.println("");
		str.print(CgenSupport.GLOBAL);
		CgenSupport.emitInitRef(TreeConstants.Bool, str);
		str.println("");
		str.print(CgenSupport.GLOBAL);
		CgenSupport.emitMethodRef(TreeConstants.Main, TreeConstants.main_meth,
				str);
		str.println("");
	}

	/**
	 * Initializers for objects of all classes
	 */
	void codeObjInit() 
	{
		for (Enumeration<CgenNode> e = nds.elements(); e.hasMoreElements(); )
		{
			CgenNode nd = e.nextElement();

			str.print(nd.getName().toString() + CgenSupport.CLASSINIT_SUFFIX
					+ CgenSupport.LABEL);
			// Incomplete : Cleaner implementation
			method m = new method(0, new IdSymbol("init", "init".length(), 0), 
					new Formals(0, null), TreeConstants.No_type, new no_expr(0));
			MethodNode mn = new MethodNode(0, m, nd);

			// Callee responsibility
			str.println("#Set up the FP");
			CgenSupport.emitMove(CgenSupport.FP, CgenSupport.SP, str);
			str.println();
			str.println("#Save return address");
			CgenSupport.emitPush(CgenSupport.RA, mn, str);
			str.println();

			// Need to call the init of the parent of the class of this object
			
			// Caller responsibility
			// 1. Save my FP
			CgenSupport.emitPush(CgenSupport.FP, mn, str);
			
			// Save self Object
			CgenSupport.emitPush(CgenSupport.ACC, mn, str);
			// Call the initializer of the parent
			if (!nd.getName().equals(TreeConstants.Object_))
				CgenSupport.emitJal(nd.getParentNd().getName().toString()
						+ CgenSupport.CLASSINIT_SUFFIX, str);
			// Restore the self Object
			CgenSupport.emitPop(CgenSupport.ACC, mn, str);

			// Caller responsibility
			// 1. Restore my FP
			CgenSupport.emitPop(CgenSupport.FP, mn, str);
			
			// Basic classes whose attributes cannot be initialized explicitly
			if (nd.getName().equals(TreeConstants.Int)
					|| nd.getName().equals(TreeConstants.Str)
					|| nd.getName().equals(TreeConstants.Bool))
			{
				CgenSupport.emitPop(CgenSupport.RA, mn, str);
				CgenSupport.emitReturn(str); // return
				continue;
			}
			
			// Initialize attributes of this object. The inherited attributes
			//  are initialised by the parent initializer
			int offset = nd.getStartAttrOffset();
			for (Enumeration e1 = nd.getFeatures().getElements();
					e1.hasMoreElements();)
			{
				try
				{
					attr a = (attr)e1.nextElement();

					// Save self Object
					CgenSupport.emitPush(CgenSupport.ACC, mn, str);
					
					if (a.init.getClass().toString().equals("class no_expr"))// Incomplete: hack	
					{
						// Restore the self Object
						CgenSupport.emitPop(CgenSupport.ACC, mn, str);

						CgenSupport.emitLoadAddress(CgenSupport.T1, 
								Utilities.getDefaultObjectAddress(a.type_decl), 
									str);
						CgenSupport.emitStore(CgenSupport.T1, offset, 
								CgenSupport.ACC, str);
						
					}
				else
					{
						a.init.code(mn, this, str); 
						CgenSupport.emitMove(CgenSupport.T1, CgenSupport.ACC, 
								str);

						// 	Restore the self Object
						CgenSupport.emitPop(CgenSupport.ACC, mn, str);
					
						// 	Set initializer
						CgenSupport.emitStore(CgenSupport.T1, offset, 
								CgenSupport.ACC, str);
					}
					offset++;
				}
				catch(ClassCastException ex)
				{
					;
				}
			}
			CgenSupport.emitPop(CgenSupport.RA, mn, str);
			CgenSupport.emitReturn(str); // return
		}
	}

	/**
	 * Generates code for all methods in the program
	 */
	private void codeClassMethods() 
	{
		for (Enumeration<CgenNode> e = nds.elements(); e.hasMoreElements(); )
		{
			CgenNode nd = e.nextElement();

			// Code for methods of basic classes are given as a part of the
			// runtime.
			if (nd.getName().equals(TreeConstants.Object_)
					|| nd.getName().equals(TreeConstants.IO)
					|| nd.getName().equals(TreeConstants.Int)
					|| nd.getName().equals(TreeConstants.Bool) 
					|| nd.getName().equals(TreeConstants.Str))
				continue;

			// Code for methods of user classes
			for (Enumeration e1 = nd.getFeatures().getElements(); 
					e1.hasMoreElements();)
			{
				try
				{
					method m = (method) e1.nextElement();
					enterScope();
					MethodNode mn = null;
					for (Iterator<MethodNode> i = mTab.get(m.name).iterator(); 
							i.hasNext(); )
					{
						mn = i.next();
						if (mn.nd.equals(nd))
							break;
					}
					codeMethod(mn, nd);
					if (Flags.cgen_debug)
						System.out.println("Finished " + m.name);
					exitScope();
				}
				catch (ClassCastException ex)
				{
					continue;
				}
			}
		}
	}

	/**
	 * Generates code for specified method
	 * 
	 * @param m The AbstractSymbol representing the method
	 * @param c The class_ object representing the method in which the method
	 *            is statically defined.
	 */
	private void codeMethod(MethodNode mn, CgenNode c) 
	{
		CgenSupport.emitMethodDef(c.getName(), mn.m.name, str);
		
		str.println("# Set FP");
		CgenSupport.emitMove(CgenSupport.FP, CgenSupport.SP, str);
		str.println();
		
		str.println("# Save return address");
		CgenSupport.emitPush(CgenSupport.RA, mn, str);
		str.println();

		// Add the addresses of the formal parameters, relative to the FP,
		// into the symbol table. Note that the arguments are in the caller
		// AR above the current AR's FP
		int offset = mn.m.formals.getLength();
		for (Enumeration e = mn.m.formals.getElements(); e.hasMoreElements(); 
				offset--)
			addId(((formal) (e.nextElement())).name, offset);

		int nItems = 0;
		if (mn.m !=null)
			nItems = mn.nItems;
		str.println("# Emit code for method body");
		mn.m.expr.code(mn, this, str);
		str.println();

		if (mn!=null)
			mn.nItems = nItems;
		str.println("# Get return address");
		CgenSupport.emitPop(CgenSupport.RA, mn, str);
		str.println();
		
		// callee responsibilities after method body execution
		if (mn.m.formals.getLength() > 0)
		{
			str.println("# Pop AR");
		//	CgenSupport.emitPopAR(m.formals.getLength(), m, str);
			// This in effect is popping entries in the caller activation record
			// and this has to be accounted for after the dispatch of a method
			CgenSupport.emitPopAR(mn.m.formals.getLength(), str);
			str.println();
		}
		
		str.println("# Return");
		CgenSupport.emitReturn(str);
		str.println();
	}
}