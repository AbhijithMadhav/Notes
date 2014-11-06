// -*- mode: java -*- 
//
// file: cool-tree.m4
//
// This file defines the AST
//
//////////////////////////////////////////////////////////

import java.util.Enumeration;
import java.io.PrintStream;
import java.util.Vector;


/** Defines simple phylum Program */
abstract class Program extends TreeNode {
    protected Program(int lineNumber) {
        super(lineNumber);
    }
    public abstract void dump_with_types(PrintStream out, int n);
    public abstract void semant() throws PossibleNullDereferenceException, UnresolvableSelfTypeException;
    public abstract void validate(SymbolTable o, ClassTable ct) throws PossibleNullDereferenceException, UnresolvableSelfTypeException;
}


/** Defines simple phylum Class_ */
abstract class Class_ extends TreeNode {
    protected Class_(int lineNumber) {
        super(lineNumber);
    }
    public abstract void dump_with_types(PrintStream out, int n);
    public abstract void validate(SymbolTable o, ClassTable ct) throws PossibleNullDereferenceException, UnresolvableSelfTypeException;
}


/** Defines list phylum Classes
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Classes extends ListNode {
    public final static Class elementClass = Class_.class;
    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }
    protected Classes(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }
    /** Creates an empty "Classes" list */
    public Classes(int lineNumber) {
        super(lineNumber);
    }
    /** Appends "Class_" element to this list */
    public Classes appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }
    public TreeNode copy() {
        return new Classes(lineNumber, copyElements());
    }
}


/** Defines simple phylum Feature */
abstract class Feature extends TreeNode {
    protected Feature(int lineNumber) {
        super(lineNumber);
    }
    public abstract void dump_with_types(PrintStream out, int n);
    public abstract void validate(SymbolTable o, class_c c, ClassTable ct) throws PossibleNullDereferenceException, UnresolvableSelfTypeException;
}


/** Defines list phylum Features
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Features extends ListNode {
    public final static Class elementClass = Feature.class;
    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }
    protected Features(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }
    /** Creates an empty "Features" list */
    public Features(int lineNumber) {
        super(lineNumber);
    }
    /** Appends "Feature" element to this list */
    public Features appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }
    public TreeNode copy() {
        return new Features(lineNumber, copyElements());
    }
}


/** Defines simple phylum Formal */
abstract class Formal extends TreeNode {
    protected Formal(int lineNumber) {
        super(lineNumber);
    }
    public abstract void dump_with_types(PrintStream out, int n);
    public abstract void validate(SymbolTable o, method m, class_c c, ClassTable ct) throws UnresolvableSelfTypeException ;
}


/** Defines list phylum Formals
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Formals extends ListNode {
    public final static Class elementClass = Formal.class;
    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }
    protected Formals(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }
    /** Creates an empty "Formals" list */
    public Formals(int lineNumber) {
        super(lineNumber);
    }
    /** Appends "Formal" element to this list */
    public Formals appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }
    public TreeNode copy() {
        return new Formals(lineNumber, copyElements());
    }
}


/** Defines simple phylum Expression */
abstract class Expression extends TreeNode {
    protected Expression(int lineNumber) {
        super(lineNumber);
    }
    private AbstractSymbol type = null;                                 
    public AbstractSymbol get_type() throws PossibleNullDereferenceException { 
        if (type == null) 
            throw new PossibleNullDereferenceException("Internal Error: get_type : Attempting to retrieve type before it is set.");
        return type;
    }           
    public Expression set_type(AbstractSymbol s) { type = s; return this; } 
    public abstract void dump_with_types(PrintStream out, int n);
    public void dump_type(PrintStream out, int n) {
        if (type != null)
            { out.println(Utilities.pad(n) + ": " + type.getString()); }
        else
            { out.println(Utilities.pad(n) + ": _no_type"); }
    }
    public abstract void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct) throws PossibleNullDereferenceException, UnresolvableSelfTypeException ;
}


/** Defines list phylum Expressions
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Expressions extends ListNode {
    public final static Class elementClass = Expression.class;
    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }
    protected Expressions(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }
    /** Creates an empty "Expressions" list */
    public Expressions(int lineNumber) {
        super(lineNumber);
    }
    /** Appends "Expression" element to this list */
    public Expressions appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }
    public TreeNode copy() {
        return new Expressions(lineNumber, copyElements());
    }
}


/** Defines simple phylum Case */
abstract class Case extends TreeNode {
    protected Case(int lineNumber) {
        super(lineNumber);
    }
    public abstract void dump_with_types(PrintStream out, int n);
    public abstract void validate(SymbolTable o, method m, class_c c, ClassTable ct) throws PossibleNullDereferenceException, UnresolvableSelfTypeException ;
}


/** Defines list phylum Cases
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Cases extends ListNode {
    public final static Class elementClass = Case.class;
    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }
    protected Cases(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }
    /** Creates an empty "Cases" list */
    public Cases(int lineNumber) {
        super(lineNumber);
    }
    /** Appends "Case" element to this list */
    public Cases appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }
    public TreeNode copy() {
        return new Cases(lineNumber, copyElements());
    }
}


/** Defines AST constructor 'programc'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class programc extends Program {
    protected Classes classes;

    /** Creates "programc" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for classes
      */
    public programc(int lineNumber, Classes a1) {
        super(lineNumber);
        classes = a1;
    }
    public TreeNode copy() {
        return new programc(lineNumber, (Classes)classes.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "programc\n");
        classes.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_program");
        for (Enumeration e = classes.getElements(); e.hasMoreElements(); ) {
            // sm: changed 'n + 1' to 'n + 2' to match changes elsewhere
	    ((Class_)e.nextElement()).dump_with_types(out, n + 2);
        }
    }

        /** This method is the entry point to the semantic checker.
	<p>
        Your checker should do the following two things:
	<ol>
	<li>Check that the program is semantically correct
	<li>Decorate the abstract syntax tree with type information
        by setting the type field in each Expression node.
        (see tree.h)
	</ol>
	<p>
	You are free to first do (1) and make sure you catch all semantic
    	errors. Part (2) can be done in a second stage when you want
	to test the complete compiler.
    */
    public void semant() throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
		// ClassTable contains the inheritance relationship info and thus is a part of the class environment
		ClassTable ct = new ClassTable(classes);
		if (ct.errors()) {
		    System.err.println("Compilation halted due to static semantic errors.");
		    System.exit(1);
		}
	
		/* some semantic analysis code may go here */
	    SymbolTable o = new SymbolTable();
	    validate(o, ct);
		if (ct.errors()) {
		    System.err.println("Compilation halted due to static semantic errors.");
		    System.exit(1);
		}
    }

    public void validate(SymbolTable o, ClassTable ct) throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        o.enterScope(); // program scope start
        
        // Validate each class of the program
        for (Enumeration e = classes.getElements(); e.hasMoreElements(); )
    	    ((Class_)e.nextElement()).validate(o, ct);

        o.exitScope(); // program scope end
    }
}


/** Defines AST constructor 'class_c'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class class_c extends Class_ {
    protected AbstractSymbol name;
    protected AbstractSymbol parent;
    protected Features features;
    protected AbstractSymbol filename;
    /** Creates "class_c" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for name
      * @param a2 initial value for parent
      * @param a3 initial value for features
      * @param a4 initial value for filename
      */
    public class_c(int lineNumber, AbstractSymbol a1, AbstractSymbol a2, Features a3, AbstractSymbol a4) {
        super(lineNumber);
        name = a1;
        parent = a2;
        features = a3;
        filename = a4;
    }
    public TreeNode copy() {
        return new class_c(lineNumber, copy_AbstractSymbol(name), copy_AbstractSymbol(parent), (Features)features.copy(), copy_AbstractSymbol(filename));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "class_c\n");
        dump_AbstractSymbol(out, n+2, name);
        dump_AbstractSymbol(out, n+2, parent);
        features.dump(out, n+2);
        dump_AbstractSymbol(out, n+2, filename);
    }

    
    public AbstractSymbol getFilename() { return filename; }
    public AbstractSymbol getName()     { return name; }
    public AbstractSymbol getParent()   { return parent; }
    public Features getFeatures() { return features; }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_class");
        dump_AbstractSymbol(out, n + 2, name);
        dump_AbstractSymbol(out, n + 2, parent);
        out.print(Utilities.pad(n + 2) + "\"");
        Utilities.printEscapedString(out, filename.getString());
        out.println("\"\n" + Utilities.pad(n + 2) + "(");
        for (Enumeration e = features.getElements(); e.hasMoreElements();) {
	    ((Feature)e.nextElement()).dump_with_types(out, n + 2);
        }
        out.println(Utilities.pad(n + 2) + ")");
    }

    public void validate(SymbolTable o, ClassTable ct) throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        // Validate each feature of the class
        // A feature is either a method or attribute definition
        for (Enumeration e = features.getElements(); e.hasMoreElements();)
    	    ((Feature)e.nextElement()).validate(o, this, ct);
    }

    public boolean containsAttr(AbstractSymbol name, ClassTable ct) throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        // look in class env
        for (AbstractSymbol supertype : ct.supertypes(getName())) 
            for (Enumeration e = ct.get_class_c(supertype).getFeatures().getElements(); e.hasMoreElements(); )
                try { 
                    if (((attr)e.nextElement()).getName().equals(name))
                        return true;
                } catch(ClassCastException ex) {
                     continue;
                     // if e.nextElement() turns out to be a method, there are no name to compare. so ignore
                }
        return false;
    }

        // look in class env
    public attr getAttr(AbstractSymbol name, ClassTable ct) throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        for (AbstractSymbol supertype : ct.supertypes(getName())) 
            for (Enumeration e = ct.get_class_c(supertype).getFeatures().getElements(); e.hasMoreElements(); )
                try { 
                    attr a = (attr)e.nextElement();
                    if (a.getName().equals(name))
                        return a;
                } catch(ClassCastException ex) {
                     continue;
                     // if e.nextElement() turns out to be a method, there are no name to compare. so ignore
                }
        throw new PossibleNullDereferenceException("Internal Error : getAttr : No attribute called " + name + ". Use containsAttr() first");
    }

    public boolean containsMethod(AbstractSymbol name, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException  {
        for (AbstractSymbol supertype : ct.supertypes(getName())) 
	        for (Enumeration e = ct.get_class_c(supertype).getFeatures().getElements(); e.hasMoreElements(); )
	            try { 
	                if (((method)e.nextElement()).getName().equals(name))
	                    return true;
	            } catch(ClassCastException ex) {
	                 continue;
	                 // if e.nextElement() turns out to be a attribute, there are no name to compare. so ignore
	            }
	    return false;
    }

    public method getMethod(AbstractSymbol name, ClassTable ct) throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
         // A redefnition overrides a method in an ancestor.
         // Thus check for the method in this class first
        for (Enumeration e = features.getElements(); e.hasMoreElements(); )
            try {
	                method m = (method)e.nextElement();
	                if (m.getName().equals(name))
	                    return m;
	            } catch(ClassCastException ex) {
	                 continue;
	                 // if e.nextElement() turns out to be a attribute, there are no name to compare. so ignore
	            }

        // Now check in all the supertypes
        for (AbstractSymbol supertype : ct.supertypes(getName()))
	        for (Enumeration e = ct.get_class_c(supertype).getFeatures().getElements(); e.hasMoreElements(); )
	            try { 
	                method m = (method)e.nextElement();
	                if (m.getName().equals(name))
	                    return m;
	            } catch(ClassCastException ex) {
	                 continue;
	                 // if e.nextElement() turns out to be an attribute , there are no name to compare. so ignore
	            }
        throw new PossibleNullDereferenceException("Internal Error : getMethod : No attribute called " + name + ". Use containsMethod() first");
    }


}


/** Defines AST constructor 'method'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class method extends Feature {
    protected AbstractSymbol name;
    protected Formals formals;
    protected AbstractSymbol return_type;
    protected Expression expr;
    /** Creates "method" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for name
      * @param a2 initial value for formals
      * @param a3 initial value for return_type
      * @param a4 initial value for expr
      */
    public method(int lineNumber, AbstractSymbol a1, Formals a2, AbstractSymbol a3, Expression a4) {
        super(lineNumber);
        name = a1;
        formals = a2;
        return_type = a3;
        expr = a4;
    }
    public TreeNode copy() {
        return new method(lineNumber, copy_AbstractSymbol(name), (Formals)formals.copy(), copy_AbstractSymbol(return_type), (Expression)expr.copy());
    }

    public AbstractSymbol getName() { return name; }
    public Formals getFormals() { return formals; }
    public AbstractSymbol getReturnType() { return return_type; }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "method\n");
        dump_AbstractSymbol(out, n+2, name);
        formals.dump(out, n+2);
        dump_AbstractSymbol(out, n+2, return_type);
        expr.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_method");
        dump_AbstractSymbol(out, n + 2, name);
        for (Enumeration e = formals.getElements(); e.hasMoreElements();) {
	    ((Formal)e.nextElement()).dump_with_types(out, n + 2);
        }
        dump_AbstractSymbol(out, n + 2, return_type);
	expr.dump_with_types(out, n + 2);
    }

    public void validate(SymbolTable o, class_c c, ClassTable ct) throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        // is this a redefined method? If so, check on the number and type of parameters
        if (!isOriginalMethod(c, ct)) {
            Enumeration eOriginal = getOriginalMethod(c, ct).getFormals().getElements();
            Enumeration eRedefined = formals.getElements();
            while ( eOriginal.hasMoreElements() && eRedefined.hasMoreElements()) {
                formalc fOriginal = (formalc)eOriginal.nextElement();
                formalc fRedefined = (formalc)eRedefined.nextElement();
                if (!fOriginal.getTypeDecl().equals(fRedefined.getTypeDecl()))
                    ct.semantError(c).println("In redefined method " + name + ", parameter type " + fRedefined.getTypeDecl() + " is different from original type " + fOriginal.getTypeDecl());
            }
            if (eOriginal.hasMoreElements() || eRedefined.hasMoreElements())
                ct.semantError(c).println("Incompatible number of formal parameters in redefined method " + name + ".");
        }

        // Validate each formal parameter
        Vector<AbstractSymbol> lst = new Vector<AbstractSymbol>();
        for (Enumeration e = formals.getElements(); e.hasMoreElements();) {
            formalc f = (formalc)e.nextElement();
            if (f.getName().equals(TreeConstants.self)) 
                ct.semantError(c).println("'self' cannot be the name of a formal parameter.");
            if (lst.contains(f.getName()))
                ct.semantError(c).println("Formal parameter " + f.getName() + " is multiply defined.");
            else
                lst.add(f.getName());
	        f.validate(o, this, c, ct);
        }

        // Is return type of method defined
        // getResolvedType for <name>(...) : SELF_TYPE
        if (!ct.isDefined(Util.getResolvedType(return_type, c))) {
            ct.semantError(c).println("Return type " + return_type + " not defined.");
            return;
        }
        // Validate the body of the method only if the return type is defined as the type of the body needs to be a subtype of the return type
        expr.validateAndSetType(o, this, c, ct);

        // Check if the return type is compatible with the inferred type
        if (return_type.equals(TreeConstants.SELF_TYPE)) {
            if (expr.get_type().equals(TreeConstants.SELF_TYPE))
                return; // compatible
            else // T <= SELF_TYPE(c) is false
                ct.semantError(c).println("Inferred return type " + expr.get_type() + " of method " + name + " does not conform to declared return type " + return_type +".");
        }
        else { 
            if (!ct.supertypes(Util.getResolvedType(expr.get_type(), c)).contains(return_type))
                ct.semantError(c).println("Inferred return type " + expr.get_type() + " of method " + name + " does not conform to declared return type " + return_type +".");
        }
    }

    // look for name in in method env
    public boolean containsFormal(AbstractSymbol name) {
        for (Enumeration e = formals.getElements(); e.hasMoreElements(); ) 
      	    if (((formalc)e.nextElement()).getName().equals(name)) 
                return true;
        return false;
    }

    // look for name in in method env
    public formalc getFormal(AbstractSymbol name) {
        for (Enumeration e = formals.getElements(); e.hasMoreElements(); ) {
            formalc f = (formalc)e.nextElement();
      	    if (f.getName().equals(name)) 
                return f;
        }
        return null;
    }

    // Is this method original, and not one which is redifined and thus overridding its namesake in a supertype?
    public boolean isOriginalMethod(class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        for (AbstractSymbol supertype : ct.supertypes(c.getName())) {
            if (supertype.equals(c.getName()))
                continue;
	        for (Enumeration e = ct.get_class_c(supertype).getFeatures().getElements(); e.hasMoreElements(); )
	            try { 
	                if (((method)e.nextElement()).getName().equals(name))
	                    return false;
	            } catch(ClassCastException ex) {
	                 continue;
	                 // if e.nextElement() turns out to be a attribute, there are no name to compare. so ignore
	            }
        }
	    return true;
    }

    // Get the original method that this one is overridding
    public method getOriginalMethod(class_c c, ClassTable ct) throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        for (AbstractSymbol supertype : ct.supertypes(c.getName())) {
            if (supertype.equals(c.getName()))
                continue;
	        for (Enumeration<method> e = ct.get_class_c(supertype).getFeatures().getElements(); e.hasMoreElements(); )
	            try { 
                    method m = e.nextElement();
	                if (m.getName().equals(name))
	                    return m;
	            } catch(ClassCastException ex) {
	                 continue;
	                 // if e.nextElement() turns out to be a attribute, there are no name to compare. so ignore
	            }
        }
        throw new PossibleNullDereferenceException("Internal Error : getOriginalMethod : Trying to get the original method when this one is the one. Use isOriginalMethod() before.");
    }
}


/** Defines AST constructor 'attr'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class attr extends Feature {
    protected AbstractSymbol name;
    protected AbstractSymbol type_decl;
    protected Expression init;
    private method dummy;
    /** Creates "attr" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for name
      * @param a2 initial value for type_decl
      * @param a3 initial value for init
      */
    public attr(int lineNumber, AbstractSymbol a1, AbstractSymbol a2, Expression a3) {
        super(lineNumber);
        name = a1;
        type_decl = a2;
        init = a3;
        dummy = new method(lineNumber, TreeConstants.dummyMethodForAttr, new Formals(lineNumber), TreeConstants.Object_, new no_expr(lineNumber));
    }
    public TreeNode copy() {
        return new attr(lineNumber, copy_AbstractSymbol(name), copy_AbstractSymbol(type_decl), (Expression)init.copy());
    }

    public AbstractSymbol getName() { return name; }
    public AbstractSymbol getTypeDecl() { return type_decl; } 

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "attr\n");
        dump_AbstractSymbol(out, n+2, name);
        dump_AbstractSymbol(out, n+2, type_decl);
        init.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_attr");
        dump_AbstractSymbol(out, n + 2, name);
        dump_AbstractSymbol(out, n + 2, type_decl);
	init.dump_with_types(out, n + 2);
    }

    public void validate(SymbolTable o, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        // an attribute cannot be named 'self'
        if (name.equals(TreeConstants.self))
            ct.semantError(c).println("'self' cannot be the name of an attribute.");

        // is attr type is known?
        // getResolvedType for '<name> : SELF_TYPE'
        if (!ct.isDefined(Util.getResolvedType(type_decl, c)))
            ct.semantError(c).println("Type " + type_decl + " of attribute " + name + " not defined.");

        // Should not override attributes of supertypes
        for (AbstractSymbol cName : ct.supertypes(c.getName()))
            if (!cName.equals(c.getName()) && ct.get_class_c(cName).containsAttr(name, ct))
                ct.semantError(c).println("Attribute " + name + " is an attribute of an inherited class.");

        // validate the initializer
        init.validateAndSetType(o, dummy, c, ct);
    }
}


/** Defines AST constructor 'formalc'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class formalc extends Formal {
    protected AbstractSymbol name;
    protected AbstractSymbol type_decl;
    /** Creates "formalc" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for name
      * @param a2 initial value for type_decl
      */
    public formalc(int lineNumber, AbstractSymbol a1, AbstractSymbol a2) {
        super(lineNumber);
        name = a1;
        type_decl = a2;
    }
    public TreeNode copy() {
        return new formalc(lineNumber, copy_AbstractSymbol(name), copy_AbstractSymbol(type_decl));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "formalc\n");
        dump_AbstractSymbol(out, n+2, name);
        dump_AbstractSymbol(out, n+2, type_decl);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_formal");
        dump_AbstractSymbol(out, n + 2, name);
        dump_AbstractSymbol(out, n + 2, type_decl);
    }

    public AbstractSymbol getName() {
        return name;
    }

    public AbstractSymbol getTypeDecl() {
        return type_decl;
    }

    public void validate(SymbolTable o, method m, class_c c, ClassTable ct) throws UnresolvableSelfTypeException{
        // formal parameter cannot be self type
        if (type_decl.equals(TreeConstants.SELF_TYPE)) {
            ct.semantError(c).println("Formal parameter " + type_decl + " cannot have type SELF_TYPE.");
            return;
        }

        // Is formal type is a known type
        if (!ct.isDefined(type_decl)) {
            ct.semantError(c).println("Type " + type_decl + " of formal parameter " + name + " not defined.");
            return;
        }
    }
}


/** Defines AST constructor 'branch'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class branch extends Case {
    protected AbstractSymbol name;
    protected AbstractSymbol type_decl;
    protected Expression expr;
    /** Creates "branch" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for name
      * @param a2 initial value for type_decl
      * @param a3 initial value for expr
      */
    public branch(int lineNumber, AbstractSymbol a1, AbstractSymbol a2, Expression a3) {
        super(lineNumber);
        name = a1;
        type_decl = a2;
        expr = a3;
    }
    public TreeNode copy() {
        return new branch(lineNumber, copy_AbstractSymbol(name), copy_AbstractSymbol(type_decl), (Expression)expr.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "branch\n");
        dump_AbstractSymbol(out, n+2, name);
        dump_AbstractSymbol(out, n+2, type_decl);
        expr.dump(out, n+2);
    }

    public AbstractSymbol getTypeDecl() { return type_decl; } 
    public Expression getExpr() { return expr; }
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_branch");
        dump_AbstractSymbol(out, n + 2, name);
        dump_AbstractSymbol(out, n + 2, type_decl);
	expr.dump_with_types(out, n + 2);
    }

    public void validate(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        o.enterScope(); // Branch scope start

        if (type_decl.equals(TreeConstants.SELF_TYPE)) 
            ct.semantError(c).println("Identifier " + name + " declared with type SELF_TYPE in case branch.");
        // is branch type is a known type
        else if (!ct.isDefined(type_decl)) 
           ct.semantError(c).println("Type " + type_decl + " of branch " + name + " not defined.");

        // Introduce the branch identifier into the symbol table
        o.addId(name, new TypeAndInit(type_decl, new no_expr(lineNumber)));

        // Validate the branch expression
        expr.validateAndSetType(o, m, c, ct);

        o.exitScope(); // Branch scope ends
    }
}


/** Defines AST constructor 'assign'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class assign extends Expression {
    protected AbstractSymbol name;
    protected Expression expr;
    /** Creates "assign" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for name
      * @param a2 initial value for expr
      */
    public assign(int lineNumber, AbstractSymbol a1, Expression a2) {
        super(lineNumber);
        name = a1;
        expr = a2;
    }
    public TreeNode copy() {
        return new assign(lineNumber, copy_AbstractSymbol(name), (Expression)expr.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "assign\n");
        dump_AbstractSymbol(out, n+2, name);
        expr.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_assign");
        dump_AbstractSymbol(out, n + 2, name);
	expr.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct) throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        // Set the default type of expression in case of error
        set_type(TreeConstants.Object_);

        if (name.equals(TreeConstants.self)) {
            ct.semantError(c).println("Cannot assign to 'self'");
            return;
        }
         // Is the name bound to a declaration?
        if (o.lookup(name) == null && !m.containsFormal(name) && !c.containsAttr(name, ct))
            ct.semantError(c).println("Assignment to undeclared variable " + name + ".");

        // Validate the intializer
        expr.validateAndSetType(o, m, c, ct);


        // Check if the LHS is compatible with the RHS
        AbstractSymbol tName = Util.typeLookup(name, o, m, c, ct);
        if (!ct.supertypes(Util.getResolvedType(expr.get_type(), c)).contains(tName)) {
        // getResolvedType for '<name> <- self'
            ct.semantError(c).println("Type " + expr.get_type() + " of assigned expression does not conform to declared type " +  tName + " of identifier " + name + ".");
            return;
        }
 
        // set type of expression
        set_type(expr.get_type());
    }
}


/** Defines AST constructor 'static_dispatch'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class static_dispatch extends Expression {
    protected Expression expr;
    protected AbstractSymbol type_name;
    protected AbstractSymbol name;
    protected Expressions actual;
    /** Creates "static_dispatch" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for expr
      * @param a2 initial value for type_name
      * @param a3 initial value for name
      * @param a4 initial value for actual
      */
    public static_dispatch(int lineNumber, Expression a1, AbstractSymbol a2, AbstractSymbol a3, Expressions a4) {
        super(lineNumber);
        expr = a1;
        type_name = a2;
        name = a3;
        actual = a4;
    }
    public TreeNode copy() {
        return new static_dispatch(lineNumber, (Expression)expr.copy(), copy_AbstractSymbol(type_name), copy_AbstractSymbol(name), (Expressions)actual.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "static_dispatch\n");
        expr.dump(out, n+2);
        dump_AbstractSymbol(out, n+2, type_name);
        dump_AbstractSymbol(out, n+2, name);
        actual.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_static_dispatch");
	expr.dump_with_types(out, n + 2);
        dump_AbstractSymbol(out, n + 2, type_name);
        dump_AbstractSymbol(out, n + 2, name);
        out.println(Utilities.pad(n + 2) + "(");
        for (Enumeration e = actual.getElements(); e.hasMoreElements();) {
	    ((Expression)e.nextElement()).dump_with_types(out, n + 2);
        }
        out.println(Utilities.pad(n + 2) + ")");
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        // Validate the invoking expression
        expr.validateAndSetType(o, m, c, ct);

        // Set default type of dispatch in case of an error
        set_type(TreeConstants.Object_);

        // Validate the actual arguments
        for (Enumeration e = actual.getElements(); e.hasMoreElements();)
            ((Expression)e.nextElement()).validateAndSetType(o, m, c, ct);

        // Type Checking
        
        // Get types of actual arguments
        Vector<AbstractSymbol> tActual = new Vector<AbstractSymbol>();
        for (Enumeration e = actual.getElements(); e.hasMoreElements();)
            tActual.add(Util.getResolvedType(((Expression)e.nextElement()).get_type(), c));
            // getResolvedType for <expr>@<type_name>.<name>(..., self, ...)

        // Get type of invoking expression 
        AbstractSymbol tExpr = expr.get_type();

        // static type qualifier cannot be SELF
        if (type_name.equals(TreeConstants.SELF_TYPE)) {
            ct.semantError(c).println("Static dispatch to SELF_TYPE.");
            return;
        }

        // is the invoking expression a descendent of the static type qualifier?
        if (!ct.supertypes(Util.getResolvedType(expr.get_type(), c)).contains(type_name)) {
        // getResolvedType for self@<type_name>.<name>(..., <actual>, ...)
            ct.semantError(c).println("Expression type " + expr.get_type() + " does not conform to declared static dispatch type " + type_name + ".");
            return;
        }

        // is the method a member of the class of the static type qualifier
        if (!ct.get_class_c(type_name).containsMethod(name, ct)) {
            ct.semantError(c).println("Static dispatch to undefined method " + name + ".");
            return;
        }

        // If the invocation of the method is valid proceed with
        //  1. Validating the number and type of arguments
        //  2. Setting the type of the static dispatch
        
        // Get types of formal arguments
        Formals formals = ct.get_class_c(type_name).getMethod(name, ct).getFormals();
        Vector<AbstractSymbol> tFormal = new Vector<AbstractSymbol>();
        Vector<AbstractSymbol>  paramName = new Vector<AbstractSymbol>();
        for (Enumeration e = formals.getElements(); e.hasMoreElements();) {
            formalc param = ((formalc)e.nextElement());
            tFormal.add(param.getTypeDecl());
            paramName.add(param.getName());
        }

        // wrong number of arguments
        if (tActual.size() != tFormal.size()) {
             ct.semantError(c).println("Method " + name + " called with wrong number of arguments.");
             return;
        }
        
        // non-conforming type of arguments    
        for (int i = 0; i < tActual.size(); i++) {
            if (!ct.supertypes(tActual.get(i)).contains(tFormal.get(i))) {
                ct.semantError(c).println("In call of method " + name
                        + ", type " + tActual.get(i) + " of parameter "
                        +  paramName.get(i) + " does not conform to declared type "
                        + tFormal.get(i) + ".");
                return;
            }
        }

         // All is fine. Set the type information
        method meth = ct.get_class_c(type_name).getMethod(name, ct);
        if (meth.getReturnType().equals(TreeConstants.SELF_TYPE))
            set_type(expr.get_type());
        else
            set_type(meth.getReturnType());
    }
}


/** Defines AST constructor 'dispatch'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class dispatch extends Expression {
    protected Expression expr;
    protected AbstractSymbol name;
    protected Expressions actual;
    /** Creates "dispatch" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for expr
      * @param a2 initial value for name
      * @param a3 initial value for actual
      */
    public dispatch(int lineNumber, Expression a1, AbstractSymbol a2, Expressions a3) {
        super(lineNumber);
        expr = a1;
        name = a2;
        actual = a3;
    }
    public TreeNode copy() {
        return new dispatch(lineNumber, (Expression)expr.copy(), copy_AbstractSymbol(name), (Expressions)actual.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "dispatch\n");
        expr.dump(out, n+2);
        dump_AbstractSymbol(out, n+2, name);
        actual.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_dispatch");
	expr.dump_with_types(out, n + 2);
        dump_AbstractSymbol(out, n + 2, name);
        out.println(Utilities.pad(n + 2) + "(");
        for (Enumeration e = actual.getElements(); e.hasMoreElements();) {
	    ((Expression)e.nextElement()).dump_with_types(out, n + 2);
        }
        out.println(Utilities.pad(n + 2) + ")");
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct) throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        // validate the invoking expression
        expr.validateAndSetType(o, m, c, ct);

        // Set default type of dispatch in case of an error
        set_type(TreeConstants.Object_);

        // Validate each of the actual arguments
        for (Enumeration e = actual.getElements(); e.hasMoreElements();)
            ((Expression)e.nextElement()).validateAndSetType(o, m, c, ct);

        // Type Checking
        
        // Get types of actual arguments
        Vector<AbstractSymbol> tActual = new Vector<AbstractSymbol>();
        for (Enumeration e = actual.getElements(); e.hasMoreElements();)
            tActual.add(Util.getResolvedType(((Expression)e.nextElement()).get_type(), c));
            // getResolvedType for <expr>.<name>(..., self, ...)

        // is the method a member of the class any of the supertypes of the of the invoking object class
        if (!ct.get_class_c(Util.getResolvedType(expr.get_type(), c)).containsMethod(name, ct)) {
        // getResolvedType for self.<name>(...)
            ct.semantError(c).println("Dispatch to undefined method " + name + ".");
            return;
        }

        // If the invocation of the method is valid proceed with
        //  1. Validating the number and type of arguments
        //  2. Setting the type of the static dispatch

        // Get types of formal arguments. getResolvedType for self.<name>(...)
        Formals formals = ct.get_class_c(Util.getResolvedType(expr.get_type(), c)).getMethod(name, ct).getFormals();
        Vector<AbstractSymbol> tFormal = new Vector<AbstractSymbol>();
        Vector<AbstractSymbol>  paramName = new Vector<AbstractSymbol>();
        for (Enumeration e = formals.getElements(); e.hasMoreElements();) {
            formalc param = ((formalc)e.nextElement());
            tFormal.add(param.getTypeDecl());
            paramName.add(param.getName());
        }
   		// Wrong number of arguments
        if (tActual.size() != tFormal.size()) {
             ct.semantError(c).println("Method " + name + " called with wrong number of arguments.");
             return;
        }
        // Non conforming type of arguments
        for (int i = 0; i < tActual.size(); i++) {
            if (!ct.supertypes(tActual.get(i)).contains(tFormal.get(i))) {
                ct.semantError(c).println("In call of method " + name
                        + ", type " + tActual.get(i) + " of parameter "
                        +  paramName.get(i) + " does not conform to declared type "
                        + tFormal.get(i) + ".");
            return;
            }
        }

        // All is fine. Set the type information
        // getResolvedType for self.<name>(...)
        method meth = ct.get_class_c(Util.getResolvedType(expr.get_type(), c)).getMethod(name, ct);
        if (meth.getReturnType().equals(TreeConstants.SELF_TYPE))
            set_type(expr.get_type());
        else 
            set_type(meth.getReturnType());
   } // void validateAndSetType(...)
} // class dispatch extends Expression


/** Defines AST constructor 'cond'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class cond extends Expression {
    protected Expression pred;
    protected Expression then_exp;
    protected Expression else_exp;
    /** Creates "cond" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for pred
      * @param a2 initial value for then_exp
      * @param a3 initial value for else_exp
      */
    public cond(int lineNumber, Expression a1, Expression a2, Expression a3) {
        super(lineNumber);
        pred = a1;
        then_exp = a2;
        else_exp = a3;
    }
    public TreeNode copy() {
        return new cond(lineNumber, (Expression)pred.copy(), (Expression)then_exp.copy(), (Expression)else_exp.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "cond\n");
        pred.dump(out, n+2);
        then_exp.dump(out, n+2);
        else_exp.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_cond");
	pred.dump_with_types(out, n + 2);
	then_exp.dump_with_types(out, n + 2);
	else_exp.dump_with_types(out, n + 2);
	dump_type(out, n);
    }


    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
    // validate the predicate, 'then' expression and the 'else' expression
	pred.validateAndSetType(o, m, c, ct);
	then_exp.validateAndSetType(o, m, c, ct);
	else_exp.validateAndSetType(o, m, c, ct);

    // Check type of predicate
    if (!pred.get_type().equals(TreeConstants.Bool))
        ct.semantError(c).println("Predicate of 'if' does not have type Bool.");

    // Set type of the 'cond' expression. 
    // getResolvedType for cases where the the 'then' or 'else' expression evalutes to SELF_TYPE
    set_type(ct.lub(Util.getResolvedType(then_exp.get_type(), c), Util.getResolvedType(else_exp.get_type(), c)));
    }
}


/** Defines AST constructor 'loop'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class loop extends Expression {
    protected Expression pred;
    protected Expression body;
    /** Creates "loop" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for pred
      * @param a2 initial value for body
      */
    public loop(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        pred = a1;
        body = a2;
    }
    public TreeNode copy() {
        return new loop(lineNumber, (Expression)pred.copy(), (Expression)body.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "loop\n");
        pred.dump(out, n+2);
        body.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_loop");
	pred.dump_with_types(out, n + 2);
	body.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
    // Validate the predicate expression and the body expression
	pred.validateAndSetType(o, m, c, ct);
	body.validateAndSetType(o, m, c, ct);

    // Check the predicate expression
    if (!pred.get_type().equals(TreeConstants.Bool))
        ct.semantError(c).println("Predicate of 'while' does not have type Bool.");

    // set the type of the 'while' expression
    set_type(TreeConstants.Object_);
    }
}


/** Defines AST constructor 'typcase'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class typcase extends Expression {
    protected Expression expr;
    protected Cases cases;
    /** Creates "typcase" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for expr
      * @param a2 initial value for cases
      */
    public typcase(int lineNumber, Expression a1, Cases a2) {
        super(lineNumber);
        expr = a1;
        cases = a2;
    }
    public TreeNode copy() {
        return new typcase(lineNumber, (Expression)expr.copy(), (Cases)cases.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "typcase\n");
        expr.dump(out, n+2);
        cases.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_typcase");
	expr.dump_with_types(out, n + 2);
        for (Enumeration e = cases.getElements(); e.hasMoreElements();) {
	    ((Case)e.nextElement()).dump_with_types(out, n + 2);
        }
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        // Validate the expression of the typcase
        expr.validateAndSetType(o, m, c, ct);

        // Validate every branch
        AbstractSymbol lub = TreeConstants.No_type;
        Vector<AbstractSymbol> bTypes = new Vector<AbstractSymbol>();
        for (Enumeration e = cases.getElements(); e.hasMoreElements();) {
            branch b = (branch)e.nextElement();
	        b.validate(o, m, c, ct);
            if (bTypes.contains(b.getTypeDecl())) // Duplicate branch
                ct.semantError(c).println("Duplicate branch " + b.getTypeDecl() + " in case statement.");
            else
                bTypes.add(b.getTypeDecl());

            // type of typecase is the lub of all the types of the expressions of its branches 
            // getResolvedType for 'case x of y : SELF_TYPE => self ; z : Int => 1 ; esac'
            //  Even though the first branch is illegal the semant proceeds further needing a resolved type
            lub = ct.lub(Util.getResolvedType(lub, c), Util.getResolvedType(b.getExpr().get_type(), c));
        }
            set_type(lub);
    }
}


/** Defines AST constructor 'block'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class block extends Expression {
    protected Expressions body;
    /** Creates "block" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for body
      */
    public block(int lineNumber, Expressions a1) {
        super(lineNumber);
        body = a1;
    }
    public TreeNode copy() {
        return new block(lineNumber, (Expressions)body.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "block\n");
        body.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_block");
        for (Enumeration e = body.getElements(); e.hasMoreElements();) {
	    ((Expression)e.nextElement()).dump_with_types(out, n + 2);
        }
    	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        // Validate each expression and set its type
        for (Enumeration e = body.getElements(); e.hasMoreElements();) {
            Expression expr = (Expression)e.nextElement();
    	    expr.validateAndSetType(o, m, c, ct);
            set_type(expr.get_type());
        }
    }
}


/** Defines AST constructor 'let'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class let extends Expression {
    protected AbstractSymbol identifier;
    protected AbstractSymbol type_decl;
    protected Expression init;
    protected Expression body;
    /** Creates "let" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for identifier
      * @param a2 initial value for type_decl
      * @param a3 initial value for init
      * @param a4 initial value for body
      */
    public let(int lineNumber, AbstractSymbol a1, AbstractSymbol a2, Expression a3, Expression a4) {
        super(lineNumber);
        identifier = a1;
        type_decl = a2;
        init = a3;
        body = a4;
    }
    public TreeNode copy() {
        return new let(lineNumber, copy_AbstractSymbol(identifier), copy_AbstractSymbol(type_decl), (Expression)init.copy(), (Expression)body.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "let\n");
        dump_AbstractSymbol(out, n+2, identifier);
        dump_AbstractSymbol(out, n+2, type_decl);
        init.dump(out, n+2);
        body.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_let");
	dump_AbstractSymbol(out, n + 2, identifier);
	dump_AbstractSymbol(out, n + 2, type_decl);
	init.dump_with_types(out, n + 2);
	body.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {

        // set default type of expression in case of error
        set_type(TreeConstants.Object_);

        if (identifier.equals(TreeConstants.self))
            ct.semantError(c).println("'self' cannot be bound in a 'let' expression.");

        // getResolvedType for 'let <identifier> : SELFTYPE in ...'
        if (!ct.isDefined(Util.getResolvedType(type_decl, c)))
            ct.semantError(c).println("Type " + type_decl + " of let not defined.");

        // Validate the initializer expression
        init.validateAndSetType(o, m, c, ct);

        // let-init
        if (!(Util.getResolvedType(init.get_type(), c)).equals(TreeConstants.No_type)) {
            // getResolvedType for let <identifier> : <type_name> <- self in ...'

            // The inferred type of the initialization and the type declaration must be compatible
            if (type_decl.equals(TreeConstants.SELF_TYPE))
               if (init.get_type().equals(TreeConstants.SELF_TYPE))
                       ; // compatible
               else {
                    ct.semantError(c).println("Inferred type " + init.get_type() + " of initialization of " + identifier + " does not conform to identifier's declared type " + type_decl + ".");
                    return;
               }
            else
                if (!ct.supertypes(Util.getResolvedType(init.get_type(), c)).contains(type_decl)) {
                    ct.semantError(c).println("Inferred type " + init.get_type() + " of initialization of " + identifier + " does not conform to identifier's declared type " + type_decl + ".");
                    return;
                }
        }

        o.enterScope(); // Scope of let starts

        o.addId(identifier, new TypeAndInit(type_decl, init));
        body.validateAndSetType(o, m, c, ct);
        set_type(body.get_type());

        o.exitScope(); // Scope of let ends
    }
}

/**
 * A class to represent the type and initializer of a let variable.
 * This is needed as the object symbol table records have a name-value fields.
 * This class helps stick both the type and initializer expression together to
 * put as the value into the object symbol table
 */
class TypeAndInit {
    private AbstractSymbol type;
    private Expression init;

    public TypeAndInit(AbstractSymbol t, Expression e) {
        type = t;
        init = e;
    }

    public AbstractSymbol getType() {
        return type;
    }

    public Expression getInit() {
        return init;
    }
}

/** Defines AST constructor 'plus'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class plus extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "plus" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for e1
      * @param a2 initial value for e2
      */
    public plus(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new plus(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "plus\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_plus");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        e1.validateAndSetType(o, m, c, ct);
        e2.validateAndSetType(o, m, c, ct);

        // type checking
        AbstractSymbol t1 = e1.get_type();
        AbstractSymbol t2 = e2.get_type();
        set_type(TreeConstants.Object_);
        if (t1.equals(TreeConstants.Int) && t2.equals(TreeConstants.Int))
            set_type(TreeConstants.Int);
        else
            ct.semantError(c).println("Non-Int arguments: " + t1 + " + " + t2);
    }
}


/** Defines AST constructor 'sub'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class sub extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "sub" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for e1
      * @param a2 initial value for e2
      */
    public sub(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new sub(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "sub\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_sub");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        e1.validateAndSetType(o, m, c, ct);
        e2.validateAndSetType(o, m, c, ct);

        // type checking
        AbstractSymbol t1 = e1.get_type();
        AbstractSymbol t2 = e2.get_type();
        set_type(TreeConstants.Object_);
        if (t1.equals(TreeConstants.Int) && t2.equals(TreeConstants.Int))
            set_type(TreeConstants.Int);
        else
            ct.semantError(c).println("Non-Int arguments: " + t1 + " - " + t2);
    }
}


/** Defines AST constructor 'mul'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class mul extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "mul" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for e1
      * @param a2 initial value for e2
      */
    public mul(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new mul(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "mul\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_mul");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        e1.validateAndSetType(o, m, c, ct);
        e2.validateAndSetType(o, m, c, ct);

        // type checking
        AbstractSymbol t1 = e1.get_type();
        AbstractSymbol t2 = e2.get_type();
        set_type(TreeConstants.Object_);
        if (t1.equals(TreeConstants.Int) && t2.equals(TreeConstants.Int))
            set_type(TreeConstants.Int);
        else
            ct.semantError(c).println("Non-Int arguments: " + t1 + " * " + t2);
    }
}


/** Defines AST constructor 'divide'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class divide extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "divide" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for e1
      * @param a2 initial value for e2
      */
    public divide(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new divide(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "divide\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_divide");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        e1.validateAndSetType(o, m, c, ct);
        e2.validateAndSetType(o, m, c, ct);
        
        // type checking
        AbstractSymbol t1 = e1.get_type();
        AbstractSymbol t2 = e2.get_type();
        set_type(TreeConstants.Object_);
        if (t1.equals(TreeConstants.Int) && t2.equals(TreeConstants.Int))
            set_type(TreeConstants.Int);
        else
            ct.semantError(c).println("Non-Int arguments: " + t1 + " / " + t2);
    }
}


/** Defines AST constructor 'neg'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class neg extends Expression {
    protected Expression e1;
    /** Creates "neg" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for e1
      */
    public neg(int lineNumber, Expression a1) {
        super(lineNumber);
        e1 = a1;
    }
    public TreeNode copy() {
        return new neg(lineNumber, (Expression)e1.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "neg\n");
        e1.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_neg");
	e1.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        e1.validateAndSetType(o, m, c, ct);
        set_type(TreeConstants.Int);
    }
}


/** Defines AST constructor 'lt'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class lt extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "lt" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for e1
      * @param a2 initial value for e2
      */
    public lt(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new lt(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "lt\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_lt");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        e1.validateAndSetType(o, m, c, ct);
        e2.validateAndSetType(o, m, c, ct);
        set_type(TreeConstants.Bool);
    }
}


/** Defines AST constructor 'eq'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class eq extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "eq" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for e1
      * @param a2 initial value for e2
      */
    public eq(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new eq(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "eq\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_eq");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        e1.validateAndSetType(o, m, c, ct);
        e2.validateAndSetType(o, m, c, ct);

        Vector<AbstractSymbol> bTypes = new Vector<AbstractSymbol>();
        bTypes.add(TreeConstants.Int);
        bTypes.add(TreeConstants.Str);
        bTypes.add(TreeConstants.Bool);
        if (e1.get_type() != e2.get_type() && (bTypes.contains(e1.get_type()) || bTypes.contains(e2.get_type()))) {
            ct.semantError(c).println("Illegal comparison with a basic type.");
            set_type(TreeConstants.Object_);
        }
        else
            set_type(TreeConstants.Bool);
    }
}


/** Defines AST constructor 'leq'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class leq extends Expression {
    protected Expression e1;
    protected Expression e2;
    /** Creates "leq" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for e1
      * @param a2 initial value for e2
      */
    public leq(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }
    public TreeNode copy() {
        return new leq(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "leq\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_leq");
	e1.dump_with_types(out, n + 2);
	e2.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        e1.validateAndSetType(o, m, c, ct);
        e2.validateAndSetType(o, m, c, ct);
        set_type(TreeConstants.Bool);
    }
}


/** Defines AST constructor 'comp'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class comp extends Expression {
    protected Expression e1;
    /** Creates "comp" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for e1
      */
    public comp(int lineNumber, Expression a1) {
        super(lineNumber);
        e1 = a1;
    }
    public TreeNode copy() {
        return new comp(lineNumber, (Expression)e1.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "comp\n");
        e1.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_comp");
	e1.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        e1.validateAndSetType(o, m, c, ct);
        set_type(TreeConstants.Bool);
    }
}


/** Defines AST constructor 'int_const'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class int_const extends Expression {
    protected AbstractSymbol token;
    /** Creates "int_const" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for token
      */
    public int_const(int lineNumber, AbstractSymbol a1) {
        super(lineNumber);
        token = a1;
    }
    public TreeNode copy() {
        return new int_const(lineNumber, copy_AbstractSymbol(token));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "int_const\n");
        dump_AbstractSymbol(out, n+2, token);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_int");
	dump_AbstractSymbol(out, n + 2, token);
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct) {
        set_type(TreeConstants.Int);
    }
}


/** Defines AST constructor 'bool_const'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class bool_const extends Expression {
    protected Boolean val;
    /** Creates "bool_const" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for val
      */
    public bool_const(int lineNumber, Boolean a1) {
        super(lineNumber);
        val = a1;
    }
    public TreeNode copy() {
        return new bool_const(lineNumber, copy_Boolean(val));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "bool_const\n");
        dump_Boolean(out, n+2, val);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_bool");
	dump_Boolean(out, n + 2, val);
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct) {
        set_type(TreeConstants.Bool);
    }
}


/** Defines AST constructor 'string_const'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class string_const extends Expression {
    protected AbstractSymbol token;
    /** Creates "string_const" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for token
      */
    public string_const(int lineNumber, AbstractSymbol a1) {
        super(lineNumber);
        token = a1;
    }
    public TreeNode copy() {
        return new string_const(lineNumber, copy_AbstractSymbol(token));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "string_const\n");
        dump_AbstractSymbol(out, n+2, token);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_string");
	out.print(Utilities.pad(n + 2) + "\"");
	Utilities.printEscapedString(out, token.getString());
	out.println("\"");
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct) {
        set_type(TreeConstants.Str);
    }
}


/** Defines AST constructor 'new_'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class new_ extends Expression {
    protected AbstractSymbol type_name;
    /** Creates "new_" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for type_name
      */
    public new_(int lineNumber, AbstractSymbol a1) {
        super(lineNumber);
        type_name = a1;
    }
    public TreeNode copy() {
        return new new_(lineNumber, copy_AbstractSymbol(type_name));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "new_\n");
        dump_AbstractSymbol(out, n+2, type_name);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_new");
	dump_AbstractSymbol(out, n + 2, type_name);
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct) throws UnresolvableSelfTypeException {
        // check if name is known type
        // getResolvedType for 'new SELF_TYPE'
        if (!ct.isDefined(Util.getResolvedType(type_name, c))) 
            ct.semantError(c).println("'new' used with undefined class " + type_name + ".");

        // type check
            set_type(type_name);
    }
}


/** Defines AST constructor 'isvoid'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class isvoid extends Expression {
    protected Expression e1;
    /** Creates "isvoid" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for e1
      */
    public isvoid(int lineNumber, Expression a1) {
        super(lineNumber);
        e1 = a1;
    }
    public TreeNode copy() {
        return new isvoid(lineNumber, (Expression)e1.copy());
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "isvoid\n");
        e1.dump(out, n+2);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_isvoid");
	e1.dump_with_types(out, n + 2);
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        e1.validateAndSetType(o, m, c, ct);
        set_type(TreeConstants.Bool);
    }
}


/** Defines AST constructor 'no_expr'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class no_expr extends Expression {
    /** Creates "no_expr" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      */
    public no_expr(int lineNumber) {
        super(lineNumber);
    }
    public TreeNode copy() {
        return new no_expr(lineNumber);
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "no_expr\n");
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_no_expr");
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct) {
        set_type(TreeConstants.No_type);
    }
}


/** Defines AST constructor 'object'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class object extends Expression {
    protected AbstractSymbol name;
    /** Creates "object" AST node. 
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a1 initial value for name
      */
    public object(int lineNumber, AbstractSymbol a1) {
        super(lineNumber);
        name = a1;
    }
    public TreeNode copy() {
        return new object(lineNumber, copy_AbstractSymbol(name));
    }
    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "object\n");
        dump_AbstractSymbol(out, n+2, name);
    }

    
    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_object");
	dump_AbstractSymbol(out, n + 2, name);
	dump_type(out, n);
    }

    public void validateAndSetType(SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
       set_type(Util.typeLookup(name, o, m, c, ct));
    }
}

final class Util {
    private Util() {}

    /**
     *  Returns the type of 'name' in the environment defined by o, m, c(ct is considered included in c)
     */
    public static AbstractSymbol typeLookup(AbstractSymbol name, SymbolTable o, method m, class_c c, ClassTable ct)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        if (name.equals(TreeConstants.self))
            return TreeConstants.SELF_TYPE;
        else if ((TypeAndInit)o.lookup(name) != null)
            return ((TypeAndInit)o.lookup(name)).getType();
        else if (m.containsFormal(name))
            return m.getFormal(name).getTypeDecl();
        else if (c.containsAttr(name, ct))
            return c.getAttr(name, ct).getTypeDecl();
        else {
            ct.semantError(c).println("Undeclared identifier " + name + ".");
            return TreeConstants.Object_;
        }
    }

    /**
     * Resolves a type name.
     * A type name is resolved if it is gaureented not to be a context dependent placeholder, the SELF_TYPE.
     */
    public static AbstractSymbol getResolvedType(AbstractSymbol type, class_c container) {
        if (type.equals(TreeConstants.SELF_TYPE))
            return container.getName();
        return type;
    }
}

class PossibleNullDereferenceException extends Exception {
    PossibleNullDereferenceException(String s) {
        super(s);
    }
}

class UnresolvableSelfTypeException extends Exception {
    UnresolvableSelfTypeException() {
            super("Internal Error: Unresolved SELF_TYPE");
    }
}
