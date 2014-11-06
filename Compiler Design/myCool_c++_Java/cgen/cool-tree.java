// -*- mode: java -*- 
//
// file: cool-tree.m4
//
// This file defines the AST
//
//////////////////////////////////////////////////////////

import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.io.PrintStream;
import java.util.Vector;

/** Defines simple phylum Program */
abstract class Program extends TreeNode
{
	protected Program(int lineNumber)
	{
		super(lineNumber);
	}

	public abstract void dump_with_types(PrintStream out, int n);

	public abstract void semant();

	public abstract void cgen(PrintStream s);

}

/** Defines simple phylum Class_ */
abstract class Class_ extends TreeNode
{
	protected Class_(int lineNumber)
	{
		super(lineNumber);
	}

	public abstract void dump_with_types(PrintStream out, int n);

	public abstract AbstractSymbol getName();

	public abstract AbstractSymbol getParent();

	public abstract AbstractSymbol getFilename();

	public abstract Features getFeatures();

}

/**
 * Defines list phylum Classes
 * <p>
 * See <a href="ListNode.html">ListNode</a> for full documentation.
 */
class Classes extends ListNode
{
	public final static Class elementClass = Class_.class;

	/** Returns class of this lists's elements */
	public Class getElementClass()
	{
		return elementClass;
	}

	protected Classes(int lineNumber, Vector elements)
	{
		super(lineNumber, elements);
	}

	/** Creates an empty "Classes" list */
	public Classes(int lineNumber)
	{
		super(lineNumber);
	}

	/** Appends "Class_" element to this list */
	public Classes appendElement(TreeNode elem)
	{
		addElement(elem);
		return this;
	}

	public TreeNode copy()
	{
		return new Classes(lineNumber, copyElements());
	}
}

/** Defines simple phylum Feature */
abstract class Feature extends TreeNode
{
	protected Feature(int lineNumber)
	{
		super(lineNumber);
	}

	public abstract void dump_with_types(PrintStream out, int n);

}

/**
 * Defines list phylum Features
 * <p>
 * See <a href="ListNode.html">ListNode</a> for full documentation.
 */
class Features extends ListNode
{
	public final static Class elementClass = Feature.class;

	/** Returns class of this lists's elements */
	public Class getElementClass()
	{
		return elementClass;
	}

	protected Features(int lineNumber, Vector elements)
	{
		super(lineNumber, elements);
	}

	/** Creates an empty "Features" list */
	public Features(int lineNumber)
	{
		super(lineNumber);
	}

	/** Appends "Feature" element to this list */
	public Features appendElement(TreeNode elem)
	{
		addElement(elem);
		return this;
	}

	public TreeNode copy()
	{
		return new Features(lineNumber, copyElements());
	}
}

/** Defines simple phylum Formal */
abstract class Formal extends TreeNode
{
	protected Formal(int lineNumber)
	{
		super(lineNumber);
	}

	public abstract void dump_with_types(PrintStream out, int n);

}

/**
 * Defines list phylum Formals
 * <p>
 * See <a href="ListNode.html">ListNode</a> for full documentation.
 */
class Formals extends ListNode
{
	public final static Class elementClass = Formal.class;

	/** Returns class of this lists's elements */
	public Class getElementClass()
	{
		return elementClass;
	}

	protected Formals(int lineNumber, Vector elements)
	{
		super(lineNumber, elements);
	}

	/** Creates an empty "Formals" list */
	public Formals(int lineNumber)
	{
		super(lineNumber);
	}

	/** Appends "Formal" element to this list */
	public Formals appendElement(TreeNode elem)
	{
		addElement(elem);
		return this;
	}

	public TreeNode copy()
	{
		return new Formals(lineNumber, copyElements());
	}
}

/** Defines simple phylum Expression */
abstract class Expression extends TreeNode
{
	protected Expression(int lineNumber)
	{
		super(lineNumber);
	}

	private AbstractSymbol type = null;

	public AbstractSymbol get_type()
	{
		return type;
	}

	public Expression set_type(AbstractSymbol s)
	{
		type = s;
		return this;
	}

	public abstract void dump_with_types(PrintStream out, int n);

	public void dump_type(PrintStream out, int n)
	{
		if (type != null)
		{
			out.println(Utilities.pad(n) + ": " + type.getString());
		}
		else
		{
			out.println(Utilities.pad(n) + ": _no_type");
		}
	}

	/**
	 * 
	 * @param c Represents the class in which this expression lies
	 * @param m Represents the method in which this expression lies
	 * @param env
	 * @param s
	 */
	public abstract void code(MethodNode mn, CgenClassTable env, PrintStream s);

}

/**
 * Defines list phylum Expressions
 * <p>
 * See <a href="ListNode.html">ListNode</a> for full documentation.
 */
class Expressions extends ListNode
{
	public final static Class elementClass = Expression.class;

	/** Returns class of this lists's elements */
	public Class getElementClass()
	{
		return elementClass;
	}

	protected Expressions(int lineNumber, Vector elements)
	{
		super(lineNumber, elements);
	}

	/** Creates an empty "Expressions" list */
	public Expressions(int lineNumber)
	{
		super(lineNumber);
	}

	/** Appends "Expression" element to this list */
	public Expressions appendElement(TreeNode elem)
	{
		addElement(elem);
		return this;
	}

	public TreeNode copy()
	{
		return new Expressions(lineNumber, copyElements());
	}
}

/** Defines simple phylum Case */
abstract class Case extends TreeNode
{
	protected Case(int lineNumber)
	{
		super(lineNumber);
	}

	public abstract void dump_with_types(PrintStream out, int n);

}

/**
 * Defines list phylum Cases
 * <p>
 * See <a href="ListNode.html">ListNode</a> for full documentation.
 */
class Cases extends ListNode
{
	public final static Class elementClass = Case.class;

	/** Returns class of this lists's elements */
	public Class getElementClass()
	{
		return elementClass;
	}

	protected Cases(int lineNumber, Vector elements)
	{
		super(lineNumber, elements);
	}

	/** Creates an empty "Cases" list */
	public Cases(int lineNumber)
	{
		super(lineNumber);
	}

	/** Appends "Case" element to this list */
	public Cases appendElement(TreeNode elem)
	{
		addElement(elem);
		return this;
	}

	public TreeNode copy()
	{
		return new Cases(lineNumber, copyElements());
	}
}

/**
 * Defines AST constructor 'program'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class program extends Program
{
	public Classes classes;

	/**
	 * Creates "program" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for classes
	 */
	public program(int lineNumber, Classes a1)
	{
		super(lineNumber);
		classes = a1;
	}

	public TreeNode copy()
	{
		return new program(lineNumber, (Classes) classes.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "program\n");
		classes.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_program");
		for (Enumeration e = classes.getElements(); e.hasMoreElements();)
		{
			((Class_) e.nextElement()).dump_with_types(out, n + 1);
		}
	}

	/**
	 * This method is the entry point to the semantic checker. You will
	 * need to complete it in programming assignment 4.
	 * <p>
	 * Your checker should do the following two things:
	 * <ol>
	 * <li>Check that the program is semantically correct
	 * <li>Decorate the abstract syntax tree with type information by setting
	 * the type field in each Expression node. (see tree.h)
	 * </ol>
	 * <p>
	 * You are free to first do (1) and make sure you catch all semantic errors.
	 * Part (2) can be done in a second stage when you want to test the complete
	 * compiler.
	 */
	public void semant()
	{
		/* ClassTable constructor may do some semantic analysis */
		ClassTable classTable = new ClassTable(classes);

		/* some semantic analysis code may go here */

		if (classTable.errors())
		{
			System.err.println("Compilation halted due to static semantic "
					+ "errors.");
			System.exit(1);
		}
	}

	/**
	 * This method is the entry point to the code generator. All of the work
	 * of the code generator takes place within CgenClassTable constructor.
	 * 
	 * @param s the output stream
	 * @see CgenClassTable
	 * */
	public void cgen(PrintStream s)
	{
		// spim wants comments to start with '#'
		s.print("# start of generated code\n");

		CgenClassTable codegen_classtable = new CgenClassTable(classes, s);

		s.print("\n# end of generated code\n");
	}

}

/**
 * Defines AST constructor 'class_'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class class_ extends Class_
{
	public AbstractSymbol name;
	public AbstractSymbol parent;
	public Features features;
	public AbstractSymbol filename;

	/**
	 * Creates "class_" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for name
	 * @param a1 initial value for parent
	 * @param a2 initial value for features
	 * @param a3 initial value for filename
	 */
	public class_(int lineNumber, AbstractSymbol a1, AbstractSymbol a2,
			Features a3, AbstractSymbol a4)
	{
		super(lineNumber);
		name = a1;
		parent = a2;
		features = a3;
		filename = a4;
	}

	public TreeNode copy()
	{
		return new class_(lineNumber, copy_AbstractSymbol(name),
				copy_AbstractSymbol(parent), (Features) features.copy(),
				copy_AbstractSymbol(filename));
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "class_\n");
		dump_AbstractSymbol(out, n + 2, name);
		dump_AbstractSymbol(out, n + 2, parent);
		features.dump(out, n + 2);
		dump_AbstractSymbol(out, n + 2, filename);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_class");
		dump_AbstractSymbol(out, n + 2, name);
		dump_AbstractSymbol(out, n + 2, parent);
		out.print(Utilities.pad(n + 2) + "\"");
		Utilities.printEscapedString(out, filename.getString());
		out.println("\"\n" + Utilities.pad(n + 2) + "(");
		for (Enumeration e = features.getElements(); e.hasMoreElements();)
		{
			((Feature) e.nextElement()).dump_with_types(out, n + 2);
		}
		out.println(Utilities.pad(n + 2) + ")");
	}

	public AbstractSymbol getName()
	{
		return name;
	}

	public AbstractSymbol getParent()
	{
		return parent;
	}

	public AbstractSymbol getFilename()
	{
		return filename;
	}

	public Features getFeatures()
	{
		return features;
	}
}

/**
 * Defines AST constructor 'method'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class method extends Feature
{
	public AbstractSymbol name;
	public Formals formals;
	public AbstractSymbol return_type;
	public Expression expr;

	/**
	 * Creates "method" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for name
	 * @param a1 initial value for formals
	 * @param a2 initial value for return_type
	 * @param a3 initial value for expr
	 */
	public method(int lineNumber, AbstractSymbol a1, Formals a2,
			AbstractSymbol a3, Expression a4)
	{
		super(lineNumber);
		name = a1;
		formals = a2;
		return_type = a3;
		expr = a4;
	}

	public TreeNode copy()
	{
		return new method(lineNumber, copy_AbstractSymbol(name),
				(Formals) formals.copy(), copy_AbstractSymbol(return_type),
				(Expression) expr.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "method\n");
		dump_AbstractSymbol(out, n + 2, name);
		formals.dump(out, n + 2);
		dump_AbstractSymbol(out, n + 2, return_type);
		expr.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_method");
		dump_AbstractSymbol(out, n + 2, name);
		for (Enumeration e = formals.getElements(); e.hasMoreElements();)
		{
			((Formal) e.nextElement()).dump_with_types(out, n + 2);
		}
		dump_AbstractSymbol(out, n + 2, return_type);
		expr.dump_with_types(out, n + 2);
	}
}

/**
 * Defines AST constructor 'attr'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class attr extends Feature
{
	public AbstractSymbol name;
	public AbstractSymbol type_decl;
	public Expression init;

	/**
	 * Creates "attr" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for name
	 * @param a1 initial value for type_decl
	 * @param a2 initial value for init
	 */
	public attr(int lineNumber, AbstractSymbol a1, AbstractSymbol a2,
			Expression a3)
	{
		super(lineNumber);
		name = a1;
		type_decl = a2;
		init = a3;
	}

	public TreeNode copy()
	{
		return new attr(lineNumber, copy_AbstractSymbol(name),
				copy_AbstractSymbol(type_decl), (Expression) init.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "attr\n");
		dump_AbstractSymbol(out, n + 2, name);
		dump_AbstractSymbol(out, n + 2, type_decl);
		init.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_attr");
		dump_AbstractSymbol(out, n + 2, name);
		dump_AbstractSymbol(out, n + 2, type_decl);
		init.dump_with_types(out, n + 2);
	}

}

/**
 * Defines AST constructor 'formal'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class formal extends Formal
{
	public AbstractSymbol name;
	public AbstractSymbol type_decl;

	/**
	 * Creates "formal" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for name
	 * @param a1 initial value for type_decl
	 */
	public formal(int lineNumber, AbstractSymbol a1, AbstractSymbol a2)
	{
		super(lineNumber);
		name = a1;
		type_decl = a2;
	}

	public TreeNode copy()
	{
		return new formal(lineNumber, copy_AbstractSymbol(name),
				copy_AbstractSymbol(type_decl));
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "formal\n");
		dump_AbstractSymbol(out, n + 2, name);
		dump_AbstractSymbol(out, n + 2, type_decl);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_formal");
		dump_AbstractSymbol(out, n + 2, name);
		dump_AbstractSymbol(out, n + 2, type_decl);
	}

}

/**
 * Defines AST constructor 'branch'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class branch extends Case
{
	public AbstractSymbol name;
	public AbstractSymbol type_decl;
	public Expression expr;

	/**
	 * Creates "branch" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for name
	 * @param a1 initial value for type_decl
	 * @param a2 initial value for expr
	 */
	public branch(int lineNumber, AbstractSymbol a1, AbstractSymbol a2,
			Expression a3)
	{
		super(lineNumber);
		name = a1;
		type_decl = a2;
		expr = a3;
	}

	public TreeNode copy()
	{
		return new branch(lineNumber, copy_AbstractSymbol(name),
				copy_AbstractSymbol(type_decl), (Expression) expr.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "branch\n");
		dump_AbstractSymbol(out, n + 2, name);
		dump_AbstractSymbol(out, n + 2, type_decl);
		expr.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_branch");
		dump_AbstractSymbol(out, n + 2, name);
		dump_AbstractSymbol(out, n + 2, type_decl);
		expr.dump_with_types(out, n + 2);
	}

}

/**
 * Defines AST constructor 'assign'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class assign extends Expression
{
	protected AbstractSymbol name;
	protected Expression expr;

	/**
	 * Creates "assign" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for name
	 * @param a1 initial value for expr
	 */
	public assign(int lineNumber, AbstractSymbol a1, Expression a2)
	{
		super(lineNumber);
		name = a1;
		expr = a2;
	}

	public TreeNode copy()
	{
		return new assign(lineNumber, copy_AbstractSymbol(name),
				(Expression) expr.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "assign\n");
		dump_AbstractSymbol(out, n + 2, name);
		expr.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_assign");
		dump_AbstractSymbol(out, n + 2, name);
		expr.dump_with_types(out, n + 2);
		dump_type(out, n);
	}

	/**
	 * Generates code for the assign expression.
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		s.println("# Start - Assign expression");
		s.println();

		s.println("# Save self object");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Evaluate the RHS and get the reference in $a0");
		expr.code(mn, env, s);
		s.println();

		s.println("# Get the address of the identifier");
		if (env.lookup(name) != null)
		{
			s.println("# The identifier is a local variable. Store relative to $fp");
			CgenSupport.emitStore(CgenSupport.ACC, (Integer) env.lookup(name),
					CgenSupport.FP, s);

			s.println("# Discard stored self object");
			CgenSupport.emitPop(CgenSupport.T1, mn, s);
		}
		else
		{
			s.println("# The identifier is an object attribute");

			s.println("# Temporarily cache the result");
			CgenSupport.emitMove(CgenSupport.T1, CgenSupport.ACC, s);
			s.println();

			s.println("# Restore the self object");
			CgenSupport.emitPop(CgenSupport.ACC, mn, s);
			s.println();

			s.println("# Save the RHS");
			CgenSupport.emitPush(CgenSupport.T1, mn, s);

			s.println("# Class tag of invoking object");
			CgenSupport.emitPush(CgenSupport.ACC, mn, s);
			CgenSupport.emitFetchClassTag(CgenSupport.ACC, CgenSupport.ACC, s);

			int aLabel[] = new int[env.aTab.get(name).size()];
			int endLabel = CgenSupport.getLabel();
			int nLabel = 0;
			for (Iterator<AttrNode> i = env.aTab.get(name).iterator(); i
					.hasNext(); nLabel++)
			{
				AttrNode attrNd = i.next();
				aLabel[nLabel] = CgenSupport.getLabel();
				CgenSupport.emitLoadImm(CgenSupport.T1, attrNd.classTag, s);
				CgenSupport.emitBeq(CgenSupport.ACC, CgenSupport.T1,
						aLabel[nLabel], s);
			}

			int nItems = 0;

			nItems = mn.nItems;
			nLabel = 0;
			for (Iterator<AttrNode> i = env.aTab.get(name).iterator(); i
					.hasNext(); nLabel++)
			{

				mn.nItems = nItems;
				AttrNode attrNd = i.next();
				CgenSupport.emitLabelDef(aLabel[nLabel], s);
				CgenSupport.emitPop(CgenSupport.ACC, mn, s);
				CgenSupport.emitPop(CgenSupport.T1, mn, s);
				CgenSupport.emitStore(CgenSupport.T1, attrNd.offset,
						CgenSupport.ACC, s);
				CgenSupport.emitMove(CgenSupport.ACC, CgenSupport.T1, s);

				CgenSupport.emitBranch(endLabel, s);
			}
			CgenSupport.emitLabelDef(endLabel, s);

		}

		/*
		 * offsetAddress a = Utilities.getAddress(name, mn.nd, env);
		 * 
		 * s.println("# Store the result in the location of the variable");
		 * CgenSupport.emitStore(CgenSupport.T1, a.offset, a.reg, s);
		 * s.println();
		 * 
		 * s.println("# De-cache the result. It must be in $a0");
		 * CgenSupport.emitMove(CgenSupport.ACC, CgenSupport.T1, s);
		 */

		s.println("# End of assign expression");
		s.println();
	}
}

/**
 * Defines AST constructor 'static_dispatch'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class static_dispatch extends Expression
{
	public Expression expr;
	public AbstractSymbol type_name;
	public AbstractSymbol name;
	public Expressions actual;

	/**
	 * Creates "static_dispatch" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for expr
	 * @param a1 initial value for type_name
	 * @param a2 initial value for name
	 * @param a3 initial value for actual
	 */
	public static_dispatch(int lineNumber, Expression a1, AbstractSymbol a2,
			AbstractSymbol a3, Expressions a4)
	{
		super(lineNumber);
		expr = a1;
		type_name = a2;
		name = a3;
		actual = a4;
	}

	public TreeNode copy()
	{
		return new static_dispatch(lineNumber, (Expression) expr.copy(),
				copy_AbstractSymbol(type_name), copy_AbstractSymbol(name),
				(Expressions) actual.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "static_dispatch\n");
		expr.dump(out, n + 2);
		dump_AbstractSymbol(out, n + 2, type_name);
		dump_AbstractSymbol(out, n + 2, name);
		actual.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_static_dispatch");
		expr.dump_with_types(out, n + 2);
		dump_AbstractSymbol(out, n + 2, type_name);
		dump_AbstractSymbol(out, n + 2, name);
		out.println(Utilities.pad(n + 2) + "(");
		for (Enumeration e = actual.getElements(); e.hasMoreElements();)
		{
			((Expression) e.nextElement()).dump_with_types(out, n + 2);
		}
		out.println(Utilities.pad(n + 2) + ")");
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		int voidLabel = CgenSupport.getLabel();
		int endLabel = CgenSupport.getLabel();

		s.println("# Static Method dispatch\n");

		s.println("# Save FP");
		CgenSupport.emitPush(CgenSupport.FP, mn, s);
		s.println();

		for (Enumeration e = actual.getElements(); e.hasMoreElements();)
		{
			s.println("# Save self");
			CgenSupport.emitPush(CgenSupport.ACC, mn, s);
			s.println();

			Expression ex = (Expression) e.nextElement();
			s.println("# Evaluate actual argument and get it in in $a0");
			ex.code(mn, env, s);
			s.println();

			s.println("# Temporarily cache evaluated argument");
			CgenSupport.emitMove(CgenSupport.T1, CgenSupport.ACC, s);
			s.println();

			s.println("# Restore self");
			CgenSupport.emitPop(CgenSupport.ACC, mn, s);
			s.println();

			s.println("# Push argument in Stack");
			CgenSupport.emitPush(CgenSupport.T1, mn, s);
			s.println();
		}

		s.println("# Evaluate invoking object and Get it in $a0");
		expr.code(mn, env, s);
		s.println();

		int nItems = 0;

		{
			s.println("# Test if invoking object is void");
			CgenSupport.emitPush(CgenSupport.ACC, mn, s);
			CgenSupport.emitFetchClassTag(CgenSupport.ACC, CgenSupport.ACC, s);
			CgenSupport.emitLoadImm(CgenSupport.T1, CgenSupport.VOID_CLASSTAG,
					s);
			nItems = mn.nItems;
			CgenSupport.emitBeq(CgenSupport.ACC, CgenSupport.T1, voidLabel, s);
			CgenSupport.emitPop(CgenSupport.ACC, mn, s);
		}

		s.println("# Get reference to dispatch Table");
		CgenSupport.emitFetchDispTab(CgenSupport.T1, CgenSupport.ACC, s);

		CgenNode nd = (CgenNode) (env.lookup(type_name));
		MethodNode m1 = null;
		for (Iterator<MethodNode> i = env.mTab.get(name).iterator(); i.hasNext();)
		{
			m1 = i.next();
			if (m1.nd.equals(nd))
				break;
		}

		CgenSupport.emitLoad(CgenSupport.T1, m1.offset, CgenSupport.T1, s);
		s.println();

		s.println("# Dispatch");
		CgenSupport.emitJalr(CgenSupport.T1, s);
		s.println();

		// The arguments of this AR will be popped by the
		// callee
		mn.nItems -= actual.getLength();
		s.println("# Restore FP");
		CgenSupport.emitPop(CgenSupport.FP, mn, s);
		s.println();
		CgenSupport.emitBranch(endLabel, s);

		mn.nItems = nItems - actual.getLength();
		{
			CgenSupport.emitLabelDef(voidLabel, s);
			CgenSupport.emitPop(CgenSupport.ACC, mn, s);
			CgenSupport.emitLoadString(CgenSupport.ACC,
					(StringSymbol) AbstractTable.stringtable
							.lookup(mn.nd.filename.toString()), s);
			CgenSupport.emitLoadImm(CgenSupport.T1, 1, s);
			CgenSupport.emitJal("_dispatch_abort", s);
			CgenSupport.emitPop(CgenSupport.FP, mn, s);
		}

		CgenSupport.emitLabelDef(endLabel, s);
	}

}

/**
 * Defines AST constructor 'dispatch'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class dispatch extends Expression
{
	public Expression expr;
	public AbstractSymbol name;
	public Expressions actual;

	/**
	 * Creates "dispatch" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for expr
	 * @param a1 initial value for name
	 * @param a2 initial value for actual
	 */
	public dispatch(int lineNumber, Expression a1, AbstractSymbol a2,
			Expressions a3)
	{
		super(lineNumber);
		expr = a1;
		name = a2;
		actual = a3;
	}

	public TreeNode copy()
	{
		return new dispatch(lineNumber, (Expression) expr.copy(),
				copy_AbstractSymbol(name), (Expressions) actual.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "dispatch\n");
		expr.dump(out, n + 2);
		dump_AbstractSymbol(out, n + 2, name);
		actual.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_dispatch");
		expr.dump_with_types(out, n + 2);
		dump_AbstractSymbol(out, n + 2, name);
		out.println(Utilities.pad(n + 2) + "(");
		for (Enumeration e = actual.getElements(); e.hasMoreElements();)
		{
			((Expression) e.nextElement()).dump_with_types(out, n + 2);
		}
		out.println(Utilities.pad(n + 2) + ")");
		dump_type(out, n);
	}

	public CgenNode getNode(CgenNode root, AbstractSymbol name)
	{
		LinkedList<CgenNode> q = new LinkedList<CgenNode>();

		q.add(root);

		while (!q.isEmpty())
		{
			CgenNode nd = q.remove();
			if (nd.name.equals(name))
				return nd;
			for (Enumeration e = nd.getChildren(); e.hasMoreElements();)
				q.add((CgenNode) e.nextElement());
		}
		return null;
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		int notVoidLabel = CgenSupport.getLabel();
		int nItems = 0;

		s.println("# Method dispatch\n");

		s.println("# Save FP");
		CgenSupport.emitPush(CgenSupport.FP, mn, s);
		s.println();

		s.println("# Push Arguments");
		for (Enumeration e = actual.getElements(); e.hasMoreElements();)
		{
			s.println("# Save self");
			CgenSupport.emitPush(CgenSupport.ACC, mn, s);
			s.println();

			Expression ex = (Expression) e.nextElement();
			s.println("# Evaluate actual argument and get it in in $a0");
			ex.code(mn, env, s);
			s.println();

			s.println("# Temporarily cache evaluated argument");
			CgenSupport.emitMove(CgenSupport.T1, CgenSupport.ACC, s);
			s.println();

			s.println("# Restore self");
			CgenSupport.emitPop(CgenSupport.ACC, mn, s);
			s.println();

			s.println("# Push argument in Stack");
			CgenSupport.emitPush(CgenSupport.T1, mn, s);
			s.println();
		}

		s.println("# Evaluate invoking object and Get it in $a0");
		expr.code(mn, env, s);
		s.println();

		s.println("# Save it");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Need to check if the invoking object is void");
		s.println("# Fetch its classtag");
		CgenSupport.emitFetchClassTag(CgenSupport.ACC, CgenSupport.ACC, s);
		s.println("# Get the classtag of void");
		CgenSupport.emitLoadImm(CgenSupport.T1, CgenSupport.VOID_CLASSTAG, s);
		s.println("# The test. Is the invoking object not void?");
		s.println("# If yes, branch to label" + notVoidLabel);
		CgenSupport.emitBne(CgenSupport.ACC, CgenSupport.T1, notVoidLabel, s);
		s.println("# Else, invoking object is void.");

		s.println("# Void ");
		nItems = mn.nItems; // Incomplete : Causes infinite looping in GC
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);
		CgenSupport.emitLoadString(CgenSupport.ACC,
				(StringSymbol) AbstractTable.stringtable.lookup(mn.nd.filename
						.toString()), s);
		CgenSupport.emitLoadImm(CgenSupport.T1, 1, s);
		CgenSupport.emitJal("_dispatch_abort", s);
		CgenSupport.emitPop(CgenSupport.FP, mn, s);
		mn.nItems = nItems; // Incomplete: Causes infinite looping in GC

		s.println("# Not void");
		CgenSupport.emitLabelDef(notVoidLabel, s);
		s.println("# Restore the invoking object");
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);
		s.println();
		s.println("# Determine the dispatch based on the "
				+ "type of the self object");
		s.println();
		s.println("# Save the invoking object");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println("# Get the class tag of the invoking object");
		CgenSupport.emitFetchClassTag(CgenSupport.ACC, CgenSupport.ACC, s);
		Integer label[] = new Integer[env.mTab.get(name).size()];
		int k = 0;
		for (Iterator<MethodNode> i = env.mTab.get(name).iterator(); i
				.hasNext(); k++)
		{
			MethodNode m1 = i.next();
			s.println("# Class tag of " + m1.nd.name);
			CgenSupport.emitLoadImm(CgenSupport.T1, m1.nd.classTag, s);
			label[k] = CgenSupport.getLabel();
			CgenSupport.emitBeq(CgenSupport.ACC, CgenSupport.T1, label[k], s);
		}
		s.println();

		nItems = mn.nItems;
		int dispatchLabel = CgenSupport.getLabel();
		int j = 0;
		for (Iterator<MethodNode> i = env.mTab.get(name).iterator(); i
				.hasNext(); j++)
		{

			mn.nItems = nItems;
			MethodNode m1 = i.next();
			s.println("# Dispatch for " + m1.nd.name + "." + m1.m.name);
			CgenSupport.emitLabelDef(label[j], s);
			s.println("# Restore the invoking object");
			CgenSupport.emitPop(CgenSupport.ACC, mn, s);
			s.println("# Dispatch table of invoking object");
			CgenSupport.emitFetchDispTab(CgenSupport.T1, CgenSupport.ACC, s);
			s.println("# Address of dynamic dispatch");
			CgenSupport.emitLoad(CgenSupport.T1, m1.offset, CgenSupport.T1, s);
			CgenSupport.emitBranch(dispatchLabel, s);
		}
		CgenSupport.emitLabelDef(dispatchLabel, s);

		s.println("# Dispatch");
		CgenSupport.emitJalr(CgenSupport.T1, s);
		s.println();

		// The arguments of this AR will be popped by the
		// callee
		mn.nItems -= actual.getLength();
		s.println("# Restore FP");
		CgenSupport.emitPop(CgenSupport.FP, mn, s);
		s.println();
	}
}

/**
 * Defines AST constructor 'cond'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class cond extends Expression
{
	public Expression pred;
	public Expression then_exp;
	public Expression else_exp;

	/**
	 * Creates "cond" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for pred
	 * @param a1 initial value for then_exp
	 * @param a2 initial value for else_exp
	 */
	public cond(int lineNumber, Expression a1, Expression a2, Expression a3)
	{
		super(lineNumber);
		pred = a1;
		then_exp = a2;
		else_exp = a3;
	}

	public TreeNode copy()
	{
		return new cond(lineNumber, (Expression) pred.copy(),
				(Expression) then_exp.copy(), (Expression) else_exp.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "cond\n");
		pred.dump(out, n + 2);
		then_exp.dump(out, n + 2);
		else_exp.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_cond");
		pred.dump_with_types(out, n + 2);
		then_exp.dump_with_types(out, n + 2);
		else_exp.dump_with_types(out, n + 2);
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)
	{
		s.println("# If-then-else");
		s.println();

		int elseLabel = CgenSupport.getLabel();
		int endLabel = CgenSupport.getLabel();

		s.println("# Save self object before evaluating predicate. ");
		s.println("# Will need it to evaluate then-expression and else-expression");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Evaluate predicate and get reference in $a0");
		pred.code(mn, env, s);
		s.println();

		s.println("# Fetch the bool value of the object");
		CgenSupport.emitFetchBool(CgenSupport.ACC, CgenSupport.ACC, s);

		s.println("# Get reference to 'false' constant");
		CgenSupport.emitLoadAddress(CgenSupport.T1,
				CgenSupport.BOOLCONST_PREFIX + CgenSupport.BOOL_FALSE, s);
		CgenSupport.emitFetchBool(CgenSupport.T1, CgenSupport.T1, s);
		s.println();

		s.println("# The test. Did the predicate evaluate to 'false'?");
		s.println("# If it did jump to label" + elseLabel);
		CgenSupport.emitBeq(CgenSupport.ACC, CgenSupport.T1, elseLabel, s);
		s.println();

		// Save the number of items in the current AR
		// This is needed to restore the same while generating code for the else
		// branch
		int nItems = 0;

		nItems = mn.nItems;
		s.println("# If-Then Branch");
		s.println("# Retrieve self object before evaluating the then-expr");
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Evaluate the then-expr and get reference in $a0");
		then_exp.code(mn, env, s);
		s.println();

		s.println("# End of if-then. Branch to label" + endLabel);
		CgenSupport.emitBranch(endLabel, s);
		s.println();

		mn.nItems = nItems;
		s.println("# The else branch");
		CgenSupport.emitLabelDef(elseLabel, s);
		s.println();

		s.println("# Retrieve self object before evaluating the else-expr");
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Evaluate the else-expr and get reference in $a0");
		else_exp.code(mn, env, s);
		s.println();

		s.println("# End of if-then-else");
		CgenSupport.emitLabelDef(endLabel, s);
		s.println();
	}

}

/**
 * Defines AST constructor 'loop'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class loop extends Expression
{
	public Expression pred;
	public Expression body;

	/**
	 * Creates "loop" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for pred
	 * @param a1 initial value for body
	 */
	public loop(int lineNumber, Expression a1, Expression a2)
	{
		super(lineNumber);
		pred = a1;
		body = a2;
	}

	public TreeNode copy()
	{
		return new loop(lineNumber, (Expression) pred.copy(),
				(Expression) body.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "loop\n");
		pred.dump(out, n + 2);
		body.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_loop");
		pred.dump_with_types(out, n + 2);
		body.dump_with_types(out, n + 2);
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		s.println("# while loop");
		s.println();

		int endLabel = CgenSupport.getLabel();
		int loopLabel = CgenSupport.getLabel();

		s.println("# Save self object");
		s.println("# Will need it to evaluate the pred in the first iteration");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Loop");
		CgenSupport.emitLabelDef(loopLabel, s);
		s.println();

		s.println("# Retrieve self object before evaluating the predicate");
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Save self object before evaluating predicate.");
		s.println("# Will need it to evaluate the body of the loop");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Evaluate predicate and get reference in $a0");
		pred.code(mn, env, s);
		CgenSupport.emitFetchBool(CgenSupport.ACC, CgenSupport.ACC, s);
		s.println();

		s.println("# Get reference to 'false' constant");
		CgenSupport.emitLoadAddress(CgenSupport.T1,
				CgenSupport.BOOLCONST_PREFIX + CgenSupport.BOOL_FALSE, s);
		CgenSupport.emitFetchBool(CgenSupport.T1, CgenSupport.T1, s);
		s.println();

		s.println("# The test. Did the predicate evaluate to 'false'?");
		s.println("# If it did jump to label" + endLabel);
		CgenSupport.emitBeq(CgenSupport.ACC, CgenSupport.T1, endLabel, s);
		s.println();

		s.println("# Retrieve self object before evaluating the body");
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Save self object.");
		s.println("# Will need it to evaluate the pred in the next iteration");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Evaluate the body and get reference in $a0");
		body.code(mn, env, s);
		s.println();

		s.println("# Go back to label" + loopLabel
				+ " to check if predicate is false");
		CgenSupport.emitBranch(loopLabel, s);
		s.println();

		s.println("# End of loop.");
		CgenSupport.emitLabelDef(endLabel, s);

		s.println("# Retrieve self object to restore the SP");
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Set return value to void");
		CgenSupport.emitLoadAddress(CgenSupport.ACC,
				CgenSupport.VOIDCONST_PREFIX, s);
		s.println();
	}

}

/**
 * Defines AST constructor 'typcase'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class typcase extends Expression
{
	public Expression expr;
	public Cases cases;

	/**
	 * Creates "typcase" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for expr
	 * @param a1 initial value for cases
	 */
	public typcase(int lineNumber, Expression a1, Cases a2)
	{
		super(lineNumber);
		expr = a1;
		cases = a2;
	}

	public TreeNode copy()
	{
		return new typcase(lineNumber, (Expression) expr.copy(),
				(Cases) cases.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "typcase\n");
		expr.dump(out, n + 2);
		cases.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_typcase");
		expr.dump_with_types(out, n + 2);
		for (Enumeration e = cases.getElements(); e.hasMoreElements();)
		{
			((Case) e.nextElement()).dump_with_types(out, n + 2);
		}
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		int nItems = 0;
		int notVoidLabel = CgenSupport.getLabel();

		s.println("# Case expression");
		s.println();

		s.println("# Save self. Needed while evaluating the LUB branch");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Evaluate the case expression");
		expr.code(mn, env, s);

		s.println("# Need to check if the evaluated expression is void");
		s.println();

		s.println("# Save it");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println("# Fetch its classtag");
		CgenSupport.emitFetchClassTag(CgenSupport.ACC, CgenSupport.ACC, s);
		s.println("# Get the classtag of void");
		CgenSupport.emitLoadImm(CgenSupport.T1, CgenSupport.VOID_CLASSTAG, s);
		s.println("# The test. Is the evaluated expression not void?");
		s.println("# If yes, branch to label" + notVoidLabel);
		CgenSupport.emitBne(CgenSupport.ACC, CgenSupport.T1, notVoidLabel, s);
		s.println("# Else, evaluated expression is void.");
		CgenSupport.emitLoadString(CgenSupport.ACC,
				(StringSymbol) AbstractTable.stringtable.lookup(mn.nd.filename
						.toString()), s);
		CgenSupport.emitLoadImm(CgenSupport.T1, 1, s);
		CgenSupport.emitJal("_case_abort2", s);
		s.println();

		CgenSupport.emitLabelDef(notVoidLabel, s);

		s.println("# Restore the evaluated expression");
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);
		s.println("# Save the evaluated value.");
		s.println("# Will need to bind it to the identifier of one of the branches");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println("# Class tag of the case expression");
		CgenSupport.emitFetchClassTag(CgenSupport.ACC, CgenSupport.ACC, s);

		// Code to jump to a particular branch of execution based on the
		// dynamic type of the case-expression
		// Once this is generated, we can generate code to find out
		// which type among all case-branches is the LUB of the dynamic type.
		int typeLabel[] = new int[env.caseTab.size()];
		int n = 0;
		for (Iterator<Integer> i = env.caseTab.keySet().iterator(); i.hasNext(); n++)
		{
			int classTag = i.next();
			CgenSupport.emitLoadImm(CgenSupport.T1, classTag, s);
			typeLabel[n] = CgenSupport.getLabel();
			CgenSupport.emitBeq(CgenSupport.ACC, CgenSupport.T1, typeLabel[n],
					s);
		}
		// Incomplete
		// CgenSupport.emitAbort();

		// Code to get the LUB of the dynamic type of the case expression
		int branchLabel[] = new int[cases.getLength()];
		for (int i = 0; i < cases.getLength(); i++)
			branchLabel[i] = CgenSupport.getLabel();
		n = 0;
		for (Iterator<LinkedList<Integer>> i = env.caseTab.values().iterator(); i
				.hasNext(); n++)
		{
			CgenSupport.emitLabelDef(typeLabel[n], s);

			LinkedList<Integer> lst = i.next();

			for (Iterator<Integer> k = lst.iterator(); k.hasNext();)
			{
				int classTag = k.next();
				CgenSupport.emitLoadImm(CgenSupport.ACC, classTag, s);
				int m = 0;
				for (Enumeration e = cases.getElements(); e.hasMoreElements(); m++)
				{
					branch b = (branch) e.nextElement();
					CgenSupport.emitLoadImm(CgenSupport.T1,
							((CgenNode) env.lookup(b.type_decl)).classTag, s);
					CgenSupport.emitBeq(CgenSupport.ACC, CgenSupport.T1,
							branchLabel[m], s);
				}
			}
			nItems = mn.nItems;
			CgenSupport.emitPop(CgenSupport.ACC, mn, s);
			CgenSupport.emitPop(CgenSupport.ACC, mn, s);
			CgenSupport.emitJal("_case_abort", s);
			mn.nItems = nItems;
		}

		// Code for each branch of the case expression
		int endLabel = CgenSupport.getLabel();
		n = 0;
		if (mn != null)
			nItems = mn.nItems;
		for (Enumeration e = cases.getElements(); e.hasMoreElements(); n++)
		{
			branch b = (branch) e.nextElement();

			env.enterScope();

			if (mn != null)
				mn.nItems = nItems;
			CgenSupport.emitLabelDef(branchLabel[n], s);
			s.println("# Temporarily cache the evaluated variable");
			CgenSupport.emitPop(CgenSupport.T1, mn, s);

			s.println("# Restore self");
			CgenSupport.emitPop(CgenSupport.ACC, mn, s);

			s.println("# Save the case variable in the stack");
			CgenSupport.emitPush(CgenSupport.T1, mn, s);
			// The offset is negative as the location of local variables are
			// below
			// the FP
			env.addId(b.name, -(mn.nItems - 1));

			b.expr.code(mn, env, s);

			s.println("# Discard case variable");
			CgenSupport.emitPop(CgenSupport.T1, mn, s);
			env.exitScope();
			CgenSupport.emitBranch(endLabel, s);
		}

		CgenSupport.emitLabelDef(endLabel, s);
	}

}

/**
 * Defines AST constructor 'block'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class block extends Expression
{
	public Expressions body;

	/**
	 * Creates "block" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for body
	 */
	public block(int lineNumber, Expressions a1)
	{
		super(lineNumber);
		body = a1;
	}

	public TreeNode copy()
	{
		return new block(lineNumber, (Expressions) body.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "block\n");
		body.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_block");
		for (Enumeration e = body.getElements(); e.hasMoreElements();)
		{
			((Expression) e.nextElement()).dump_with_types(out, n + 2);
		}
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		s.println("# Start of block");
		s.println();

		int n = 0;
		for (Enumeration e = body.getElements(); e.hasMoreElements(); n++)
			e.nextElement();

		Enumeration e = body.getElements();
		for (; n > 1; n--)
		{
			s.println("# Save self object before evaluating this expression.");
			s.println("# Will need it to evaluate the subsequent expressions");
			CgenSupport.emitPush(CgenSupport.ACC, mn, s);
			s.println();

			s.println("# Evaluate the expression and "
					+ "get the reference in $a0");
			((Expression) (e.nextElement())).code(mn, env, s);
			s.println();

			s.println("# Retrieve self object before evaluating the next "
					+ "expression");
			CgenSupport.emitPop(CgenSupport.ACC, mn, s);
			s.println();
		}
		s.println("# Evaluate the last expression and "
				+ "get the reference in $a0");
		((Expression) (e.nextElement())).code(mn, env, s);
		s.println();

		s.println("# End of block");
		s.println();
	}
}

/**
 * Defines AST constructor 'let'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class let extends Expression
{
	public AbstractSymbol identifier;
	public AbstractSymbol type_decl;
	public Expression init;
	public Expression body;

	/**
	 * Creates "let" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for identifier
	 * @param a1 initial value for type_decl
	 * @param a2 initial value for init
	 * @param a3 initial value for body
	 */
	public let(int lineNumber, AbstractSymbol a1, AbstractSymbol a2,
			Expression a3, Expression a4)
	{
		super(lineNumber);
		identifier = a1;
		type_decl = a2;
		init = a3;
		body = a4;
	}

	public TreeNode copy()
	{
		return new let(lineNumber, copy_AbstractSymbol(identifier),
				copy_AbstractSymbol(type_decl), (Expression) init.copy(),
				(Expression) body.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "let\n");
		dump_AbstractSymbol(out, n + 2, identifier);
		dump_AbstractSymbol(out, n + 2, type_decl);
		init.dump(out, n + 2);
		body.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_let");
		dump_AbstractSymbol(out, n + 2, identifier);
		dump_AbstractSymbol(out, n + 2, type_decl);
		init.dump_with_types(out, n + 2);
		body.dump_with_types(out, n + 2);
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{

		s.println("# let expression");
		s.println();

		env.enterScope();

		s.println("# Save the self object before evaluating the "
				+ "initializer.");
		s.println("# Will need it while evaluating the body of the let");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println();

		// Hack. Incomplete
		if (init.getClass().toString().equals("class no_expr"))
		{
			s.println("# No Initializer. Get the reference to the default "
					+ "value in $a0 ");
			CgenSupport.emitLoadAddress(CgenSupport.ACC,
					Utilities.getDefaultObjectAddress(type_decl), s);
			s.println();
		}
		else
		{
			s.println("# Evaluate the initializer and get the reference in "
					+ "$a0");
			init.code(mn, env, s);
			s.println();
		}

		s.println("# Temporarily hold the let identifier");
		CgenSupport.emitMove(CgenSupport.T1, CgenSupport.ACC, s);
		s.println();

		s.println("# Restore the self object");
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Save the let variable in the stack");
		CgenSupport.emitPush(CgenSupport.T1, mn, s);
		// The offset is negative as the location of local variables are below
		// the FP
		env.addId(identifier, -(mn.nItems - 1));
		s.println();

		s.println("# Evaluate let-body and get the reference in $a0");
		body.code(mn, env, s);
		s.println();

		s.println("# Remove the let variable introduced");
		CgenSupport.emitPop(CgenSupport.T1, mn, s);
		env.exitScope();
		s.println();

		s.println("# let expression ends");
	}

}

/**
 * Defines AST constructor 'plus'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class plus extends Expression
{
	public Expression e1;
	public Expression e2;

	/**
	 * Creates "plus" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for e1
	 * @param a1 initial value for e2
	 */
	public plus(int lineNumber, Expression a1, Expression a2)
	{
		super(lineNumber);
		e1 = a1;
		e2 = a2;
	}

	public TreeNode copy()
	{
		return new plus(lineNumber, (Expression) e1.copy(),
				(Expression) e2.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "plus\n");
		e1.dump(out, n + 2);
		e2.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_plus");
		e1.dump_with_types(out, n + 2);
		e2.dump_with_types(out, n + 2);
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		s.println("# + expression");
		s.println();

		s.println("#Save reference to self object.");
		s.println("# Needed while evaluating the second operand");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);

		s.println("# evaluate the first operand and get reference in $a0");
		e1.code(mn, env, s);

		s.println("# Get the value of the first operand");
		CgenSupport.emitFetchInt(CgenSupport.T1, CgenSupport.ACC, s);

		s.println("# Restore the self object before evaluating the second operand");
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);

		s.println("# Save the value of the first operand in the stack");
		CgenSupport.emitPush(CgenSupport.T1, mn, s);

		s.println("# evaluate the second operand and get reference in $a0");
		e2.code(mn, env, s);

		s.println("# Get the value of the first operand");
		CgenSupport.emitFetchInt(CgenSupport.ACC, CgenSupport.ACC, s);

		s.println("# Restore the value of the first operand from the stack");
		CgenSupport.emitPop(CgenSupport.T1, mn, s);

		s.println("# Compute and then save result in stack");
		CgenSupport
				.emitAdd(CgenSupport.ACC, CgenSupport.T1, CgenSupport.ACC, s);
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);

		s.println("# Create new object to store the result");
		CgenSupport.emitCallObjectCopy(TreeConstants.Int, mn, s);

		s.println("# Store result in new object");
		CgenSupport.emitPop(CgenSupport.T1, mn, s);
		CgenSupport.emitStoreInt(CgenSupport.T1, CgenSupport.ACC, s);
	}
}

/**
 * Defines AST constructor 'sub'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class sub extends Expression
{
	public Expression e1;
	public Expression e2;

	/**
	 * Creates "sub" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for e1
	 * @param a1 initial value for e2
	 */
	public sub(int lineNumber, Expression a1, Expression a2)
	{
		super(lineNumber);
		e1 = a1;
		e2 = a2;
	}

	public TreeNode copy()
	{
		return new sub(lineNumber, (Expression) e1.copy(),
				(Expression) e2.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "sub\n");
		e1.dump(out, n + 2);
		e2.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_sub");
		e1.dump_with_types(out, n + 2);
		e2.dump_with_types(out, n + 2);
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		s.println("# - expression");
		s.println();

		s.println("#Save reference to self object.");
		s.println("# Needed while evaluating the second operand");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);

		s.println("# evaluate the first operand and get reference in $a0");
		e1.code(mn, env, s);

		s.println("# Get the value of the first operand");
		CgenSupport.emitFetchInt(CgenSupport.T1, CgenSupport.ACC, s);

		s.println("# Restore the self object before evaluating the second operand");
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);

		s.println("# Save the value of the first operand in the stack");
		CgenSupport.emitPush(CgenSupport.T1, mn, s);

		s.println("# evaluate the second operand and get reference in $a0");
		e2.code(mn, env, s);

		s.println("# Get the value of the first operand");
		CgenSupport.emitFetchInt(CgenSupport.ACC, CgenSupport.ACC, s);

		s.println("# Restore the value of the first operand from the stack");
		CgenSupport.emitPop(CgenSupport.T1, mn, s);

		s.println("# Compute and then save result in stack");
		CgenSupport
				.emitSub(CgenSupport.ACC, CgenSupport.T1, CgenSupport.ACC, s);
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);

		s.println("# Create new object to store the result");
		CgenSupport.emitCallObjectCopy(TreeConstants.Int, mn, s);

		s.println("# Store result in new object");
		CgenSupport.emitPop(CgenSupport.T1, mn, s);
		CgenSupport.emitStoreInt(CgenSupport.T1, CgenSupport.ACC, s);
	}

}

/**
 * Defines AST constructor 'mul'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class mul extends Expression
{
	public Expression e1;
	public Expression e2;

	/**
	 * Creates "mul" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for e1
	 * @param a1 initial value for e2
	 */
	public mul(int lineNumber, Expression a1, Expression a2)
	{
		super(lineNumber);
		e1 = a1;
		e2 = a2;
	}

	public TreeNode copy()
	{
		return new mul(lineNumber, (Expression) e1.copy(),
				(Expression) e2.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "mul\n");
		e1.dump(out, n + 2);
		e2.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_mul");
		e1.dump_with_types(out, n + 2);
		e2.dump_with_types(out, n + 2);
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		s.println("# * expression");
		s.println();

		s.println("#Save reference to self object.");
		s.println("# Needed while evaluating the second operand");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);

		s.println("# evaluate the first operand and get reference in $a0");
		e1.code(mn, env, s);

		s.println("# Get the value of the first operand");
		CgenSupport.emitFetchInt(CgenSupport.T1, CgenSupport.ACC, s);

		s.println("# Restore the self object before evaluating the second operand");
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);

		s.println("# Save the value of the first operand in the stack");
		CgenSupport.emitPush(CgenSupport.T1, mn, s);

		s.println("# evaluate the second operand and get reference in $a0");
		e2.code(mn, env, s);

		s.println("# Get the value of the first operand");
		CgenSupport.emitFetchInt(CgenSupport.ACC, CgenSupport.ACC, s);

		s.println("# Restore the value of the first operand from the stack");
		CgenSupport.emitPop(CgenSupport.T1, mn, s);

		s.println("# Compute and then save result in stack");
		CgenSupport
				.emitMul(CgenSupport.ACC, CgenSupport.T1, CgenSupport.ACC, s);
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);

		s.println("# Create new object to store the result");
		CgenSupport.emitCallObjectCopy(TreeConstants.Int, mn, s);

		s.println("# Store result in new object");
		CgenSupport.emitPop(CgenSupport.T1, mn, s);
		CgenSupport.emitStoreInt(CgenSupport.T1, CgenSupport.ACC, s);

	}

}

/**
 * Defines AST constructor 'divide'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class divide extends Expression
{
	public Expression e1;
	public Expression e2;

	/**
	 * Creates "divide" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for e1
	 * @param a1 initial value for e2
	 */
	public divide(int lineNumber, Expression a1, Expression a2)
	{
		super(lineNumber);
		e1 = a1;
		e2 = a2;
	}

	public TreeNode copy()
	{
		return new divide(lineNumber, (Expression) e1.copy(),
				(Expression) e2.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "divide\n");
		e1.dump(out, n + 2);
		e2.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_divide");
		e1.dump_with_types(out, n + 2);
		e2.dump_with_types(out, n + 2);
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		s.println("# / expression");
		s.println();

		s.println("#Save reference to self object.");
		s.println("# Needed while evaluating the second operand");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# evaluate the first operand and get reference in $a0");
		e1.code(mn, env, s);
		s.println();

		s.println("# Get the value of the first operand");
		CgenSupport.emitFetchInt(CgenSupport.T1, CgenSupport.ACC, s);
		s.println();

		s.println("# Restore the self object before evaluating the second operand");
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Save the value of the first operand in the stack");
		CgenSupport.emitPush(CgenSupport.T1, mn, s);
		s.println();

		s.println("# evaluate the second operand and get reference in $a0");
		e2.code(mn, env, s);
		s.println();

		s.println("# Get the value of the first operand");
		CgenSupport.emitFetchInt(CgenSupport.ACC, CgenSupport.ACC, s);
		s.println();

		s.println("# Restore the value of the first operand from the stack");
		CgenSupport.emitPop(CgenSupport.T1, mn, s);
		s.println();

		s.println("# Compute and then save result in stack");
		CgenSupport
				.emitDiv(CgenSupport.ACC, CgenSupport.T1, CgenSupport.ACC, s);
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Create new object to store the result");
		CgenSupport.emitCallObjectCopy(TreeConstants.Int, mn, s);
		s.println();

		s.println("# Store result in new object");
		CgenSupport.emitPop(CgenSupport.T1, mn, s);
		CgenSupport.emitStoreInt(CgenSupport.T1, CgenSupport.ACC, s);
		s.println();
	}
}

/**
 * Defines AST constructor 'neg'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class neg extends Expression
{
	public Expression e1;

	/**
	 * Creates "neg" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for e1
	 */
	public neg(int lineNumber, Expression a1)
	{
		super(lineNumber);
		e1 = a1;
	}

	public TreeNode copy()
	{
		return new neg(lineNumber, (Expression) e1.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "neg\n");
		e1.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_neg");
		e1.dump_with_types(out, n + 2);
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		s.println("# neg expression");
		s.println();

		s.println("# Evaluate the operand and get reference in $a0");
		e1.code(mn, env, s);
		s.println();

		s.println("# Negate the value and save it");
		CgenSupport.emitFetchInt(CgenSupport.ACC, CgenSupport.ACC, s);
		CgenSupport.emitNeg(CgenSupport.ACC, CgenSupport.ACC, s);
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println();

		s.println("#Create new integer object");
		CgenSupport.emitCallObjectCopy(TreeConstants.Int, mn, s);
		s.println();

		s.println("# Retrieve the negated value");
		CgenSupport.emitPop(CgenSupport.T1, mn, s);
		s.println();

		s.println("# Initialize the new object with it");
		CgenSupport.emitStoreInt(CgenSupport.T1, CgenSupport.ACC, s);
		s.println();

		s.println("# End of neg expression");
		s.println();
	}

}

/**
 * Defines AST constructor 'lt'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class lt extends Expression
{
	public Expression e1;
	public Expression e2;

	/**
	 * Creates "lt" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for e1
	 * @param a1 initial value for e2
	 */
	public lt(int lineNumber, Expression a1, Expression a2)
	{
		super(lineNumber);
		e1 = a1;
		e2 = a2;
	}

	public TreeNode copy()
	{
		return new lt(lineNumber, (Expression) e1.copy(),
				(Expression) e2.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "lt\n");
		e1.dump(out, n + 2);
		e2.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_lt");
		e1.dump_with_types(out, n + 2);
		e2.dump_with_types(out, n + 2);
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		s.println("# < expression");
		s.println("# ");
		int trueLabel = CgenSupport.getLabel();
		int endLabel = CgenSupport.getLabel();

		s.println("# Save self object. Needed during evaluation of the 2nd "
				+ "operand");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println();

		s.println("#Evaluate 1st operand and get reference in $a0");
		e1.code(mn, env, s);
		s.println();

		s.println("#Get value of 1st operand");
		CgenSupport.emitFetchInt(CgenSupport.T1, CgenSupport.ACC, s);
		s.println();

		s.println("# Restore self object before evaluation of the 2nd "
				+ "operand");
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);
		s.println();

		s.println("#Save the value of the 1st operand in the stack");
		CgenSupport.emitPush(CgenSupport.T1, mn, s);
		s.println();

		s.println("# Evaluate the 2nd operand and get reference in $a0");
		e2.code(mn, env, s);
		s.println("#");

		s.println("# Get the value of the 2nd operand");
		CgenSupport.emitFetchInt(CgenSupport.ACC, CgenSupport.ACC, s);
		s.println();

		s.println("# Restore the value of the first operand");
		CgenSupport.emitPop(CgenSupport.T1, mn, s);
		s.println();

		s.println("# The test. Branch to label" + trueLabel + " if true");
		CgenSupport.emitBlt(CgenSupport.T1, CgenSupport.ACC, trueLabel, s);
		s.println();

		/** False **/
		s.println("# False part");
		s.println("# Set return value to the boolean constant, false");
		CgenSupport.emitLoadAddress(CgenSupport.ACC,
				CgenSupport.BOOLCONST_PREFIX + CgenSupport.BOOL_FALSE, s);
		s.println();

		s.println("#Branch to the end, label" + endLabel);
		CgenSupport.emitBranch(endLabel, s);
		s.println("#");

		s.println("# True part");
		CgenSupport.emitLabelDef(trueLabel, s);
		s.println();

		s.println("# Set return value to the boolean constant, true");
		CgenSupport.emitLoadAddress(CgenSupport.ACC,
				CgenSupport.BOOLCONST_PREFIX + CgenSupport.BOOL_TRUE, s);
		s.println();

		s.println("# End of < expression");
		CgenSupport.emitLabelDef(endLabel, s);
		s.println();

	}
}

/**
 * Defines AST constructor 'eq'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class eq extends Expression
{
	public Expression e1;
	public Expression e2;

	/**
	 * Creates "eq" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for e1
	 * @param a1 initial value for e2
	 */
	public eq(int lineNumber, Expression a1, Expression a2)
	{
		super(lineNumber);
		e1 = a1;
		e2 = a2;
	}

	public TreeNode copy()
	{
		return new eq(lineNumber, (Expression) e1.copy(),
				(Expression) e2.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "eq\n");
		e1.dump(out, n + 2);
		e2.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_eq");
		e1.dump_with_types(out, n + 2);
		e2.dump_with_types(out, n + 2);
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		int trueLabel = CgenSupport.getLabel();
		int endLabel = CgenSupport.getLabel();

		s.println("# '=' expression");

		s.println("# Save self object before evaluating the LHS.");
		s.println("# Will need it while evaluating the RHS");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Evaluate the 1st operand and get reference in $a0");
		e1.code(mn, env, s);
		s.println();

		s.println("# Temporarily cache the 1st operand");
		CgenSupport.emitMove(CgenSupport.T1, CgenSupport.ACC, s);

		s.println("# Restore self object to evaluate the 2nd operand");
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Save the first operand");
		CgenSupport.emitPush(CgenSupport.T1, mn, s);
		s.println();

		s.println("# Evaluate the 2nd operand and get reference in $a0");
		e2.code(mn, env, s);
		s.println();

		s.println("# Move 2nd operand into $t2 to do the equality testing");
		CgenSupport.emitMove(CgenSupport.T2, CgenSupport.ACC, s);
		s.println();

		s.println("# Restore 1st operand into $t1 to do the equality testing");
		CgenSupport.emitPop(CgenSupport.T1, mn, s);
		s.println();
		s.println("# Are both operands the same object?. If yes go to label"
				+ trueLabel);
		CgenSupport.emitBeq(CgenSupport.T1, CgenSupport.T2, trueLabel, s);
		s.println();

		s.println("# equality test");
		CgenSupport.emitLoadAddress(CgenSupport.ACC,
				CgenSupport.BOOLCONST_PREFIX + CgenSupport.BOOL_TRUE, s);
		CgenSupport.emitLoadAddress(CgenSupport.A1,
				CgenSupport.BOOLCONST_PREFIX + CgenSupport.BOOL_FALSE, s);
		CgenSupport.emitJal("equality_test", s);
		CgenSupport.emitBranch(endLabel, s);

		s.println("# True Label. Return true");
		CgenSupport.emitLabelDef(trueLabel, s);
		CgenSupport.emitLoadAddress(CgenSupport.ACC,
				CgenSupport.BOOLCONST_PREFIX + CgenSupport.BOOL_TRUE, s);

		CgenSupport.emitLabelDef(endLabel, s);
	}

}

/**
 * Defines AST constructor 'leq'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class leq extends Expression
{
	public Expression e1;
	public Expression e2;

	/**
	 * Creates "leq" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for e1
	 * @param a1 initial value for e2
	 */
	public leq(int lineNumber, Expression a1, Expression a2)
	{
		super(lineNumber);
		e1 = a1;
		e2 = a2;
	}

	public TreeNode copy()
	{
		return new leq(lineNumber, (Expression) e1.copy(),
				(Expression) e2.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "leq\n");
		e1.dump(out, n + 2);
		e2.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_leq");
		e1.dump_with_types(out, n + 2);
		e2.dump_with_types(out, n + 2);
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		s.println("# <= expression");
		s.println("# ");
		int trueLabel = CgenSupport.getLabel();
		int endLabel = CgenSupport.getLabel();

		s.println("# Save self object. Needed during evaluation of the 2nd "
				+ "operand");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println();

		s.println("#Evaluate 1st operand and get reference in $a0");
		e1.code(mn, env, s);
		s.println();

		s.println("#Get value of 1st operand");
		CgenSupport.emitFetchInt(CgenSupport.T1, CgenSupport.ACC, s);
		s.println();

		s.println("# Restore self object before evaluation of the 2nd "
				+ "operand");
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);
		s.println();

		s.println("#Save the value of the 1st operand in the stack");
		CgenSupport.emitPush(CgenSupport.T1, mn, s);
		s.println();

		s.println("# Evaluate the 2nd operand and get reference in $a0");
		e2.code(mn, env, s);
		s.println("#");

		s.println("# Get the value of the 2nd operand");
		CgenSupport.emitFetchInt(CgenSupport.ACC, CgenSupport.ACC, s);
		s.println();

		s.println("# Restore the value of the first operand");
		CgenSupport.emitPop(CgenSupport.T1, mn, s);
		s.println();

		s.println("# The test. Branch to label" + trueLabel + " if true");
		CgenSupport.emitBleq(CgenSupport.T1, CgenSupport.ACC, trueLabel, s);
		s.println();

		/** False **/
		s.println("# False part");
		s.println("# Set return value to the boolean constant, false");
		CgenSupport.emitLoadAddress(CgenSupport.ACC,
				CgenSupport.BOOLCONST_PREFIX + CgenSupport.BOOL_FALSE, s);
		s.println();

		s.println("#Branch to the end, label" + endLabel);
		CgenSupport.emitBranch(endLabel, s);
		s.println("#");

		s.println("# True part");
		CgenSupport.emitLabelDef(trueLabel, s);
		s.println();

		s.println("# Set return value to the boolean constant, true");
		CgenSupport.emitLoadAddress(CgenSupport.ACC,
				CgenSupport.BOOLCONST_PREFIX + CgenSupport.BOOL_TRUE, s);
		s.println();

		s.println("# End of < expression");
		CgenSupport.emitLabelDef(endLabel, s);
		s.println();
	}

}

/**
 * Defines AST constructor 'comp'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class comp extends Expression
{
	public Expression e1;

	/**
	 * Creates "comp" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for e1
	 */
	public comp(int lineNumber, Expression a1)
	{
		super(lineNumber);
		e1 = a1;
	}

	public TreeNode copy()
	{
		return new comp(lineNumber, (Expression) e1.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "comp\n");
		e1.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_comp");
		e1.dump_with_types(out, n + 2);
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		s.println("# Complement expression");
		s.println();

		int endLabel = CgenSupport.getLabel();
		int returnFalseLabel = CgenSupport.getLabel();

		s.println("# Evaluate the operand");
		e1.code(mn, env, s);
		s.println();

		s.println("# Fetch the boolean value of the operand");
		CgenSupport.emitFetchBool(CgenSupport.T1, CgenSupport.ACC, s);
		s.println();

		s.println("# Save the operand");
		CgenSupport.emitPush(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Get the 'true' value");
		CgenSupport.emitLoadImm(CgenSupport.ACC, CgenSupport.BOOL_TRUE, s);
		s.println();

		int nItems = mn.nItems;
		s.println("# If operand is true, branch to label" + returnFalseLabel);
		CgenSupport.emitBeq(CgenSupport.T1, CgenSupport.ACC, returnFalseLabel,
				s);
		s.println();

		s.println("# Return true branch");
		s.println("# Restore operand");
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Return true");
		CgenSupport.emitLoadAddress(CgenSupport.ACC,
				CgenSupport.BOOLCONST_PREFIX + CgenSupport.BOOL_TRUE, s);
		CgenSupport.emitBranch(endLabel, s);
		s.println();

		mn.nItems = nItems;
		s.println("# Return False branch");
		CgenSupport.emitLabelDef(returnFalseLabel, s);
		s.println();

		s.println("# Restore operand");
		CgenSupport.emitPop(CgenSupport.ACC, mn, s);
		s.println();

		s.println("# Return False");
		CgenSupport.emitLoadAddress(CgenSupport.ACC,
				CgenSupport.BOOLCONST_PREFIX + CgenSupport.BOOL_TRUE, s);
		s.println();

		s.println("# End of complement expression");
		CgenSupport.emitLabelDef(endLabel, s);
		s.println();
	}
}

/**
 * Defines AST constructor 'int_const'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class int_const extends Expression
{
	public AbstractSymbol token;

	/**
	 * Creates "int_const" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for token
	 */
	public int_const(int lineNumber, AbstractSymbol a1)
	{
		super(lineNumber);
		token = a1;
	}

	public TreeNode copy()
	{
		return new int_const(lineNumber, copy_AbstractSymbol(token));
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "int_const\n");
		dump_AbstractSymbol(out, n + 2, token);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_int");
		dump_AbstractSymbol(out, n + 2, token);
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method method is provided
	 * to you as an example of code generation.
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		s.println("# Integer constant");
		CgenSupport
				.emitLoadInt(CgenSupport.ACC,
						(IntSymbol) AbstractTable.inttable.lookup(token
								.getString()), s);
		s.println();
	}

}

/**
 * Defines AST constructor 'bool_const'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class bool_const extends Expression
{
	public Boolean val;

	/**
	 * Creates "bool_const" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for val
	 */
	public bool_const(int lineNumber, Boolean a1)
	{
		super(lineNumber);
		val = a1;
	}

	public TreeNode copy()
	{
		return new bool_const(lineNumber, copy_Boolean(val));
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "bool_const\n");
		dump_Boolean(out, n + 2, val);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_bool");
		dump_Boolean(out, n + 2, val);
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method method is provided
	 * to you as an example of code generation.
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		s.println("# Boolean constant");
		CgenSupport.emitLoadBool(CgenSupport.ACC, new BoolConst(val), s);
		s.println();
	}
}

/**
 * Defines AST constructor 'string_const'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class string_const extends Expression
{
	public AbstractSymbol token;

	/**
	 * Creates "string_const" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for token
	 */
	public string_const(int lineNumber, AbstractSymbol a1)
	{
		super(lineNumber);
		token = a1;
	}

	public TreeNode copy()
	{
		return new string_const(lineNumber, copy_AbstractSymbol(token));
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "string_const\n");
		dump_AbstractSymbol(out, n + 2, token);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_string");
		out.print(Utilities.pad(n + 2) + "\"");
		Utilities.printEscapedString(out, token.getString());
		out.println("\"");
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method method is provided
	 * to you as an example of code generation.
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		s.println("# String constant");
		CgenSupport.emitLoadString(CgenSupport.ACC,
				(StringSymbol) AbstractTable.stringtable.lookup(token
						.getString()), s);
		s.println();
	}
}

/**
 * Defines AST constructor 'new_'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class new_ extends Expression
{
	public AbstractSymbol type_name;

	/**
	 * Creates "new_" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for type_name
	 */
	public new_(int lineNumber, AbstractSymbol a1)
	{
		super(lineNumber);
		type_name = a1;
	}

	public TreeNode copy()
	{
		return new new_(lineNumber, copy_AbstractSymbol(type_name));
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "new_\n");
		dump_AbstractSymbol(out, n + 2, type_name);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_new");
		dump_AbstractSymbol(out, n + 2, type_name);
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		s.println("# Expression 'new'");
		s.println();
		if (type_name.equals(TreeConstants.SELF_TYPE))
		{
			s.println("# Get the class tag of the invoking object");
			CgenSupport.emitFetchClassTag(CgenSupport.ACC, CgenSupport.ACC, s);
			s.println();

			s.println("# Get the address to the prototype object of self");
			s.println();
			s.println("# Offset in object table at which required prototype");
			s.println("# object is obtained");
			CgenSupport.emitSll(CgenSupport.ACC, CgenSupport.ACC, 3, s);

			s.println("# Base of the object table");
			CgenSupport.emitLoadAddress(CgenSupport.T1,
					CgenSupport.CLASSOBJTAB, s);

			s.println("# Address of the required prototype object");
			CgenSupport.emitAdd(CgenSupport.ACC, CgenSupport.T1,
					CgenSupport.ACC, s);

			s.println("# Save address. Will need it to calculate the");
			s.println("# reference to the init method");
			CgenSupport.emitPush(CgenSupport.ACC, mn, s);

			s.println("# Create new object");
			CgenSupport.emitPush(CgenSupport.FP, mn, s);
			CgenSupport.emitLoad(CgenSupport.ACC, 0, CgenSupport.ACC, s); // How??
																			// Incomplete
			CgenSupport.emitJal("Object.copy", s);
			CgenSupport.emitPop(CgenSupport.FP, mn, s);

			s.println("# Restore address of prototype object");
			CgenSupport.emitPop(CgenSupport.T1, mn, s);
			s.println("# Address of init method");
			// CgenSupport.emitAddiu(CgenSupport.T1, CgenSupport.T1, 4, s);
			CgenSupport.emitLoad(CgenSupport.T1, 1, CgenSupport.T1, s); // How??
																		// Incomplete

			CgenSupport.emitPush(CgenSupport.FP, mn, s);
			CgenSupport.emitJalr(CgenSupport.T1, s);
			CgenSupport.emitPop(CgenSupport.FP, mn, s);
		}
		else
		{
			s.println("# Create new object of type " + type_name);
			CgenSupport.emitCallObjectCopy(type_name, mn, s);
			s.println();
			// Attributes are initialized to default values or according to
			// their initializers by init call as this is a copy
			// of a prototype object
		}
		s.println("# End - Expression 'new'");
		s.println();
	}
}

/**
 * Defines AST constructor 'isvoid'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class isvoid extends Expression
{
	public Expression e1;

	/**
	 * Creates "isvoid" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for e1
	 */
	public isvoid(int lineNumber, Expression a1)
	{
		super(lineNumber);
		e1 = a1;
	}

	public TreeNode copy()
	{
		return new isvoid(lineNumber, (Expression) e1.copy());
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "isvoid\n");
		e1.dump(out, n + 2);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_isvoid");
		e1.dump_with_types(out, n + 2);
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		s.println("# isvoid expression");
		s.println();

		int falseLabel = CgenSupport.getLabel();
		int endLabel = CgenSupport.getLabel();

		s.println("# Evaluate the operand and get reference in $a0");
		e1.code(mn, env, s);
		s.println();

		s.println("# Get the class tag of the object");
		CgenSupport.emitFetchClassTag(CgenSupport.ACC, CgenSupport.ACC, s);
		s.println();

		s.println(" #isvoid?? Branch to the 'false' branch if not void, label"
				+ falseLabel);
		CgenSupport.emitBgti(CgenSupport.ACC, CgenSupport.VOID_CLASSTAG,
				falseLabel, s);
		s.println();

		s.println("# True branch");
		s.println("# Return value is true");
		CgenSupport.emitLoadBool(CgenSupport.ACC, new BoolConst(true), s);
		CgenSupport.emitBranch(endLabel, s);
		s.println();

		s.println("# False branch");
		CgenSupport.emitLabelDef(falseLabel, s);

		s.println("# Return value is true");
		CgenSupport.emitLoadBool(CgenSupport.ACC, new BoolConst(false), s);
		s.println();

		s.println("# End of isvoid expression");
		CgenSupport.emitLabelDef(endLabel, s);
		CgenSupport.emitStoreBool(CgenSupport.T1, CgenSupport.ACC, s);
		s.println();
	}
}

/**
 * Defines AST constructor 'no_expr'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class no_expr extends Expression
{
	/**
	 * Creates "no_expr" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 */
	public no_expr(int lineNumber)
	{
		super(lineNumber);
	}

	public TreeNode copy()
	{
		return new no_expr(lineNumber);
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "no_expr\n");
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_no_expr");
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression. This method is to be completed
	 * in programming assignment 5. (You may add or remove parameters as
	 * you wish.)
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
	}
}

/**
 * Defines AST constructor 'object'.
 * <p>
 * See <a href="TreeNode.html">TreeNode</a> for full documentation.
 */
class object extends Expression
{
	public AbstractSymbol name;

	/**
	 * Creates "object" AST node.
	 * 
	 * @param lineNumber the line in the source file from which this node came.
	 * @param a0 initial value for name
	 */
	public object(int lineNumber, AbstractSymbol a1)
	{
		super(lineNumber);
		name = a1;
	}

	public TreeNode copy()
	{
		return new object(lineNumber, copy_AbstractSymbol(name));
	}

	public void dump(PrintStream out, int n)
	{
		out.print(Utilities.pad(n) + "object\n");
		dump_AbstractSymbol(out, n + 2, name);
	}

	public void dump_with_types(PrintStream out, int n)
	{
		dump_line(out, n);
		out.println(Utilities.pad(n) + "_object");
		dump_AbstractSymbol(out, n + 2, name);
		dump_type(out, n);
	}

	/**
	 * Generates code for this expression.
	 * 
	 * @param s the output stream
	 * */
	public void code(MethodNode mn, CgenClassTable env, PrintStream s)

	{
		s.println("# Expression - Object");
		s.println();
		if (name.toString().equals(TreeConstants.self.toString()))
		{
			s.println("# Invoking object is self");
		}
		else
		{
			if (env.lookup(name) != null)
			{
				s.println("# Identifier is local");
				CgenSupport.emitLoad(CgenSupport.ACC,
						(Integer) env.lookup(name), CgenSupport.FP, s);
			}
			else
			{// attribute
				s.println("# Identifier is an attribute");

				s.println("# Class tag of invoking object");
				CgenSupport.emitPush(CgenSupport.ACC, mn, s);
				CgenSupport.emitFetchClassTag(CgenSupport.ACC, CgenSupport.ACC,
						s);

				int aLabel[] = new int[env.aTab.get(name).size()];
				int endLabel = CgenSupport.getLabel();
				int nLabel = 0;
				for (Iterator<AttrNode> i = env.aTab.get(name).iterator(); i
						.hasNext(); nLabel++)
				{
					AttrNode attrNd = i.next();
					aLabel[nLabel] = CgenSupport.getLabel();
					CgenSupport.emitLoadImm(CgenSupport.T1, attrNd.classTag, s);
					CgenSupport.emitBeq(CgenSupport.ACC, CgenSupport.T1,
							aLabel[nLabel], s);
				}
				int nItems = 0;
				nItems = mn.nItems;
				nLabel = 0;
				for (Iterator<AttrNode> i = env.aTab.get(name).iterator(); i
						.hasNext(); nLabel++)
				{

					mn.nItems = nItems;
					AttrNode attrNd = i.next();
					CgenSupport.emitLabelDef(aLabel[nLabel], s);
					CgenSupport.emitPop(CgenSupport.ACC, mn, s);
					CgenSupport.emitLoad(CgenSupport.ACC, attrNd.offset,
							CgenSupport.ACC, s);
					CgenSupport.emitBranch(endLabel, s);
				}
				CgenSupport.emitLabelDef(endLabel, s);
			}
		}
		s.println("# End - Expression - Object");
		s.println();
	}
}
