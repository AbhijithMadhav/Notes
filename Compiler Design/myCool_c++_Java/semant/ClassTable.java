import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.Vector;

/** This class is used to contain the semantic information about the class strucure of the program*/ 
class ClassTable {
    // For error reporting
    private int semantErrors;
    private PrintStream errorStream;

    // Points to the explicitly constructed list of basic class nodes. Note that this is not attached to the AST given by the parser
    private Classes basicClasses;

    // References the user defined classes of the program as given in the AST by the parser
    private Classes userClasses;

    // Data structure to represent the inheritance relationship of the classes of the program
    private InheritanceGraph ig;

    /** Creates data structures representing basic Cool classes (Object,
     * IO, Int, Bool, String).
     * */
    private void installBasicClasses() {
		AbstractSymbol filename 
		    = AbstractTable.stringtable.addString("<basic class>");
		
		// The following demonstrates how to create dummy parse trees to
		// refer to basic Cool classes.  There's no need for method
		// bodies -- these are already built into the runtime system.
	
		// The Object class has no parent class. Its methods are
		//        cool_abort() : Object    aborts the program
		//        type_name() : Str        returns a string representation 
		//                                 of class name
		//        copy() : SELF_TYPE       returns a copy of the object
	
		class_c Object_class = 
		    new class_c(0, 
			       TreeConstants.Object_, 
			       TreeConstants.No_class,
			       new Features(0)
				   .appendElement(new method(0, 
						      TreeConstants.cool_abort, 
						      new Formals(0), 
						      TreeConstants.Object_, 
						      new no_expr(0)))
				   .appendElement(new method(0,
						      TreeConstants.type_name,
						      new Formals(0),
						      TreeConstants.Str,
						      new no_expr(0)))
				   .appendElement(new method(0,
						      TreeConstants.copy,
						      new Formals(0),
						      TreeConstants.SELF_TYPE,
						      new no_expr(0))),
			       filename);
		
		// The IO class inherits from Object. Its methods are
		//        out_string(Str) : SELF_TYPE  writes a string to the output
		//        out_int(Int) : SELF_TYPE      "    an int    "  "     "
		//        in_string() : Str            reads a string from the input
		//        in_int() : Int                "   an int     "  "     "
	
		class_c IO_class = 
		    new class_c(0,
			       TreeConstants.IO,
			       TreeConstants.Object_,
			       new Features(0)
				   .appendElement(new method(0,
						      TreeConstants.out_string,
						      new Formals(0)
							  .appendElement(new formalc(0,
									     TreeConstants.arg,
									     TreeConstants.Str)),
						      TreeConstants.SELF_TYPE,
						      new no_expr(0)))
				   .appendElement(new method(0,
						      TreeConstants.out_int,
						      new Formals(0)
							  .appendElement(new formalc(0,
									     TreeConstants.arg,
									     TreeConstants.Int)),
						      TreeConstants.SELF_TYPE,
						      new no_expr(0)))
				   .appendElement(new method(0,
						      TreeConstants.in_string,
						      new Formals(0),
						      TreeConstants.Str,
						      new no_expr(0)))
				   .appendElement(new method(0,
						      TreeConstants.in_int,
						      new Formals(0),
						      TreeConstants.Int,
						      new no_expr(0))),
			       filename);
	
		// The Int class has no methods and only a single attribute, the
		// "val" for the integer.
	
		class_c Int_class = 
		    new class_c(0,
			       TreeConstants.Int,
			       TreeConstants.Object_,
			       new Features(0)
				   .appendElement(new attr(0,
						    TreeConstants.val,
						    TreeConstants.prim_slot,
						    new no_expr(0))),
			       filename);
	
		// Bool also has only the "val" slot.
		class_c Bool_class = 
		    new class_c(0,
			       TreeConstants.Bool,
			       TreeConstants.Object_,
			       new Features(0)
				   .appendElement(new attr(0,
						    TreeConstants.val,
						    TreeConstants.prim_slot,
						    new no_expr(0))),
			       filename);
	
		// The class Str has a number of slots and operations:
		//       val                              the length of the string
		//       str_field                        the string itself
		//       length() : Int                   returns length of the string
		//       concat(arg: Str) : Str           performs string concatenation
		//       substr(arg: Int, arg2: Int): Str substring selection
	
		class_c Str_class =
		    new class_c(0,
			       TreeConstants.Str,
			       TreeConstants.Object_,
			       new Features(0)
				   .appendElement(new attr(0,
						    TreeConstants.val,
						    TreeConstants.Int,
						    new no_expr(0)))
				   .appendElement(new attr(0,
						    TreeConstants.str_field,
						    TreeConstants.prim_slot,
						    new no_expr(0)))
				   .appendElement(new method(0,
						      TreeConstants.length,
						      new Formals(0),
						      TreeConstants.Int,
						      new no_expr(0)))
				   .appendElement(new method(0,
						      TreeConstants.concat,
						      new Formals(0)
							  .appendElement(new formalc(0,
									     TreeConstants.arg, 
									     TreeConstants.Str)),
						      TreeConstants.Str,
						      new no_expr(0)))
				   .appendElement(new method(0,
						      TreeConstants.substr,
						      new Formals(0)
							  .appendElement(new formalc(0,
									     TreeConstants.arg,
									     TreeConstants.Int))
							  .appendElement(new formalc(0,
									     TreeConstants.arg2,
									     TreeConstants.Int)),
						      TreeConstants.Str,
						      new no_expr(0))),
			       filename);
	
	    basicClasses = new Classes(0);
	    basicClasses.appendElement(Object_class);
	    basicClasses.appendElement(IO_class);
	    basicClasses.appendElement(Int_class);
	    basicClasses.appendElement(Bool_class);
	    basicClasses.appendElement(Str_class);
    }

    /** Prints line number and file name of the given class.
     *
     * Also increments semantic error count.
     *
     * @param c the class
     * @return a print stream to which the rest of the error message is
     * to be printed.
     *
     * */
    public PrintStream semantError(class_c c) {
	    return semantError(c.getFilename(), c);
    }

    /** Prints the file name and the line number of the given tree node.
     *
     * Also increments semantic error count.
     *
     * @param filename the file name
     * @param t the tree node
     * @return a print stream to which the rest of the error message is
     * to be printed.
     *
     * */
    public PrintStream semantError(AbstractSymbol filename, TreeNode t) {
    	errorStream.print(filename + ":" + t.getLineNumber() + ": ");
    	return semantError();
    }

    /** Increments semantic error count and returns the print stream for
     * error messages.
     *
     * @return a print stream to which the error message is
     * to be printed.
     *
     * */
    public PrintStream semantError() {
	    semantErrors++;
    	return errorStream;
    }

    /** Returns true if there are any static semantic errors. */
    public boolean errors() {
	    return semantErrors != 0;
    }


    // Policy on error: Return immediately
    public ClassTable(Classes cls)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        semantErrors = 0;
    	errorStream = System.err;
        installBasicClasses();
    
        // Check for duplicate definitions of classes
        Classes lst = new Classes(cls.lineNumber);
        for (Enumeration<class_c> e = cls.getElements(); e.hasMoreElements();) {
            class_c c = e.nextElement();
            if (c.getName().equals(TreeConstants.SELF_TYPE)) {
                semantError(c).println("Redefinition of basic class " + c.getName() + ".");
                return;
            }
            else if (isDefined(basicClasses, c.getName())) {
                semantError(c).println("Redefinition of basic class " + c.getName() + ".");
                return;
            }
            else if (isDefined(lst, c.getName())) {
                semantError(c).println("Class " + c.getName() + " was previously defined.");
                return;
            }
            else
                lst.addElement(c);
        }

        // If everything is ok, set userClasses.
        userClasses = cls;
        // The below can be done only once it is ensured that there is no redefinition of user defined classes

        // is class Main defined?
        if (!isDefined(userClasses, TreeConstants.Main)) {
            semantError().println("Class Main is not defined.");
            return;
        }

        // inheriting from a valid type.
        for (Enumeration<class_c> e = cls.getElements(); e.hasMoreElements();) {
            class_c c = e.nextElement();
            if (c.getParent().equals(TreeConstants.SELF_TYPE) || c.getParent().equals(TreeConstants.Bool) || c.getParent().equals(TreeConstants.Str)) {
                semantError(c).println("Class " + c.getName() + " cannot inherit class " + c.getParent() + ".");
                return;
            }
            if (!isDefined(c.getParent())) {
                semantError(c).println("Class " + c.getName() + " inherits from an undefined class " + c.getParent() + ".");
                return;
            }
        }

        // if all is well construct a inheritance graph and chek for a cycle
        ig = new InheritanceGraph(userClasses, basicClasses);
        if (ig.hasCycle()) 
            for (AbstractSymbol s : ig.cycle())
                semantError(get_class_c(s)).println("Class " + s + ", or an ancestor of " + s + ", is involved in an inheritance cycle.");
    }

    /**
     * Gets the class_c object with the specified name in the program. 
     * A lookup is done through the basic classes and user defined classes.
     * Note : Always use this in after a check with isDefinedClass() to avoid a possible null derefernce
     *
     */
    public class_c get_class_c(AbstractSymbol type) throws PossibleNullDereferenceException {
        try {
            return get_class_c(userClasses, type);
        } catch(PossibleNullDereferenceException ex) {
            return get_class_c(basicClasses, type);
        }
    }

    /**
     * Gets the class_c object with the specified name in specified class list(the user class list or the basic class list. 
     */
    private class_c get_class_c(Classes classes, AbstractSymbol name) throws PossibleNullDereferenceException {
        for (Enumeration<class_c> e = classes.getElements(); e.hasMoreElements();) {
            class_c c = e.nextElement();
            if (c.getName().equals(name)) 
                    return c;
        }
        throw new PossibleNullDereferenceException("Internal Error : No class called " + name + ". Use a isDefined(name) before handed.");
    }

    /**
     * Determines if the specified type is a valid defined type.
     * A lookup is done in the user and basic class list
     */
    public boolean isDefined(AbstractSymbol type) throws UnresolvableSelfTypeException {
        if (!isDefined(userClasses, type)) // a in class invocation always contains resolved types
            return isDefined(basicClasses, type);
        return true;
    }
    /**
     * Determines if the specfied type is a valid defined type in the specified class list(user class list or basic class list.
     */
    private boolean isDefined(Classes classes, AbstractSymbol type) throws UnresolvableSelfTypeException {
        if (type.equals(TreeConstants.SELF_TYPE))
            throw new UnresolvableSelfTypeException();
        for (Enumeration e = classes.getElements(); e.hasMoreElements(); )
	        if (((class_c)e.nextElement()).getName().equals(type))
                return true;
        return false;
    }

    /**
     * Gets a list of supertypes of the specified symbol in a given context.
     * Note: The specified type is also its supertype
     *
     * @param type The type whose supertypes is sough
     * @return A list of supertypes
     */
    public Vector<AbstractSymbol> supertypes(AbstractSymbol type) throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        return ig.supertypes(type);
	}

    /**
     * Determines the least upper bound of two specified types
     *
     * @param A type
     * @param A type
     * @return The least upper bound or the least common ancestor
     */
    public AbstractSymbol lub(AbstractSymbol t1, AbstractSymbol t2)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
        return ig.lub(t1, t2); 
    }


    /**
     * Data structure to represent the inheritance relationship of the classes of the program.
     * Provides two important facilities
     *  1. Determines if the inheritance relationship is cyclic
     *  2. Determines the supertypes of a given type
     */
	private class InheritanceGraph 	{
        // To represent the inheritance relationship
	    private SymbolDigraph<AbstractSymbol> sg;

        // Helps find cycles
	    private DirectedCycleDFS cycleFinder;
	    

	    private InheritanceGraph(Classes userClasses, Classes basicClasses) {
	        sg = new SymbolDigraph<AbstractSymbol>(userClasses.getLength() + basicClasses.getLength()); 

            // Add the inheritance relationship of basic types with root type 'Object'
	        for (Enumeration<class_c> e = basicClasses.getElements(); e.hasMoreElements();)  {
	            class_c c = e.nextElement();
                try {
                    if (!c.getName().equals(TreeConstants.Object_))
                        sg.addEdge(TreeConstants.Object_, c.getName());
                }
                catch(Exception ex) {
                    // Relationships of basic type with objects do not consist of self loops, parallel edges or invalid edges
                    continue;
	            }
            }

            // Add the inheritance relationship of specified in the program
	        for (Enumeration<class_c> e = userClasses.getElements(); e.hasMoreElements();)  {
	            class_c c = e.nextElement();
                try {
	                sg.addEdge(c.getParent(), c.getName()); 
                 }
                catch(SelfLoopExistsException ex) {
    	            semantError(c).println("Class " + c.getParent() + ", or an ancestor of " + c.getName() + ", is involved in an inheritance cycle.");
	            }
	            catch(InvalidEdgeException ex) {
	                System.out.println("Internal Error : InheritanceGraph : Error constructing inheritance tree - \"" + ex + "\"");
	                ex.printStackTrace();
	                System.exit(2);
	            }
	            catch(ParallelEdgeExistsException ex) {
                    continue;
                    // This cannot occur as checks for redefined classes have been successful
                }
	        }
	        cycleFinder = new DirectedCycleDFS(sg.G());
	    }
	

	    private boolean hasCycle() {
	        return cycleFinder.hasCycle();
	    }
	   

	    private Iterable<AbstractSymbol> cycle()  throws PossibleNullDereferenceException {
	        if (hasCycle()) {
	            Vector<AbstractSymbol> lst = new Vector<AbstractSymbol>();
	            for (Iterator<Integer> i = cycleFinder.cycle().iterator(); i.hasNext();) {
	                int v = i.next();
	                if (i.hasNext())  // don't want to add the last repeated class of the cycle
	                    lst.add(get_class_c(sg.name(v)).name);
	            }
	            return lst;
	        }
            throw new PossibleNullDereferenceException("Internal Error: There is no cycle in the inheritance graph. Use a hasCycle()");
	   }
	 
       /**
        * Returns ancestors in the increasing order of inheritance.
        *
        */
        private Vector<AbstractSymbol> supertypes(AbstractSymbol type) throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
            if (type.equals(TreeConstants.SELF_TYPE))
                throw new UnresolvableSelfTypeException();

            Vector<AbstractSymbol> lst = new Vector<AbstractSymbol>();
            int t = sg.index(type);
            for (int v = 0; v < sg.G().V(); v++) {
                PathsDFS paths = new PathsDFS(sg.G(), v);
                if (paths.hasPathTo(t)) {
                    for (Integer w : paths.pathTo(t))
                            lst.add(get_class_c(sg.name(w)).name);
                    return lst;
                }
            }
            throw new PossibleNullDereferenceException("Internal Error : There must be atleast one supertype of any type - itself");
    	}
  
       /**
        * Determines the least upper bound of two specified types.
        *
        * The inheritance relationship in cool is a tree(due to single inheritance). Thus consider the paths from the root object to the specified types. As supertypes(type) returns the supertypes in the order of the decreasing types, the lub is the type at which the path bisects
        *
        */
        private AbstractSymbol lub(AbstractSymbol t1, AbstractSymbol t2)  throws PossibleNullDereferenceException, UnresolvableSelfTypeException {
           if (t1.equals(TreeConstants.No_type))
               return t2;
           else if (t2.equals(TreeConstants.No_type))
               return t1;

           AbstractSymbol lub = TreeConstants.Object_;
           for(Enumeration e1 = supertypes(t1).elements(), e2 = supertypes(t2).elements(); e1.hasMoreElements() && e2.hasMoreElements();) {
              AbstractSymbol a1 = (AbstractSymbol)e1.nextElement();
              AbstractSymbol a2 = (AbstractSymbol)e2.nextElement();
              if ( a1 != a2) {
                  return lub;
              }
              lub = a1; // or a2
            }
           return lub;
        }
	}// class InheritanceGraph
}// class ClassTable


