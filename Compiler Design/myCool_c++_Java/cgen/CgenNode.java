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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.Enumeration;

class CgenNode extends class_ implements Comparable<CgenNode>
{
	/** The parent of this node in the inheritance tree */
	private CgenNode parent;

	/** The children of this node in the inheritance tree */
	private Vector<CgenNode> children;

	/** Indicates a basic class */
	final static int Basic = 0;

	/** Indicates a class that came from a Cool program */
	final static int NotBasic = 1;

	/** Does this node correspond to a basic class? */
	private int basic_status;
	
	/** The class tag of the class this node represents */
	public int classTag;
	
	/* Used to assign unique class tags */
	static int tag = 0; 
	// must start with '0' as this is used to index the class-name table

	/**
	 * Constructs a new CgenNode to represent class "c".
	 * 
	 * @param c the class
	 * @param basic_status is this class basic or not
	 * @param table the class table
	 * */
	CgenNode(Class_ c, int basic_status, CgenClassTable table)
	{
		super(0, c.getName(), c.getParent(), c.getFeatures(), c.getFilename());
		this.parent = null;
		this.children = new Vector<CgenNode>();
		this.basic_status = basic_status;
		if ((name.getString().equals("<basic class>")
				|| name.getString().equals(TreeConstants.No_class.toString())
				|| name.getString().equals(TreeConstants.SELF_TYPE.toString())
				|| name.getString().equals(TreeConstants.prim_slot.toString())))
			classTag = -1;
		else
		{
			classTag = tag++;
			/**
			 * The names of the classes are added to the string table so that
			 * string constant objects can be generated in the code. These
			 * objects are indexed in the class-name table and used by
			 * Object.type_name() to return string objects representative of
			 * class names of the invoking objects.
			 */
			AbstractTable.stringtable.addString(name.getString());
			
		}
	}

	void addChild(CgenNode child)
	{
		children.addElement(child);
	}

	/**
	 * Gets the children of this class
	 * 
	 * @return the children
	 * */
	Enumeration<CgenNode> getChildren()
	{
		return children.elements();
	}

	/**
	 * Sets the parent of this class.
	 * 
	 * @param parent the parent
	 * */
	void setParentNd(CgenNode parent)
	{
		if (this.parent != null)
		{
			Utilities.fatalError("parent already set in CgenNode.setParent()");
		}
		if (parent == null)
		{
			Utilities.fatalError("null parent in CgenNode.setParent()");
		}
		this.parent = parent;
	}

	/**
	 * Gets the parent of this class
	 * 
	 * @return the parent
	 * */
	CgenNode getParentNd()
	{
		return parent;
	}

	/**
	 * Returns true is this is a basic class.
	 * 
	 * @return true or false
	 * */
	boolean basic()
	{
		return basic_status == Basic;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(CgenNode nd)
	{
		if (this.classTag < nd.classTag)
			return -1;
		else if (this.classTag > nd.classTag)
			return 1;
		else
			return 0;
	}
	
	/**
	 * Gets a list of ancestors of the given node, the oldest listed first
	 * The current node is also its own ancestor
	 * @param nd
	 * @return
	 */
	public Iterator<CgenNode> getAncestors()
	{
		LinkedList<CgenNode> s = new LinkedList<CgenNode>();
		
		//System.out.println("\n" + this.getName().toString() + " : ");
		s.addFirst(this);
		//System.out.print(name.getString() + " ");
		CgenNode p = getParentNd();
		while (!p.name.equals(TreeConstants.No_class))
		{
			//System.out.print(p.name.getString() + " ");
			s.addFirst(p);
			p = p.getParentNd();
		}
		
		return s.iterator();
	}
	
	/**
	 * Gets the attributes(inherited ones included) of the given node in 
	 * parent-attributes-first order
	 * @param nd
	 * @return
	 */
	public List<attr> getAttributes()
	{
		LinkedList<attr> l = new LinkedList<attr>();
		for(Iterator<CgenNode> i = getAncestors(); i.hasNext(); )
		{
			CgenNode p = i.next();
			for(Enumeration e = p.getFeatures().getElements();
					e.hasMoreElements(); )
			{
				try
				{
					l.addFirst((attr)e.nextElement());
				}
				catch(ClassCastException ex)
				{
					
				}
			}
		}
		return l;
	}

	/**
	 * Gives the offset of the starting attribute of nd
	 * @param nd
	 * @return
	 */
	int getStartAttrOffset()
	{
		int sOffset = CgenSupport.DEFAULT_OBJFIELDS;
		
		for(Iterator<CgenNode> i = getAncestors(); i.hasNext(); )
		{
			CgenNode t = i.next();
			if (t.name.equals(name))
				break;
			for (Enumeration e = t.getFeatures().getElements(); 
					e.hasMoreElements(); )
			{
				try
				{
					attr a = (attr) e.nextElement();
					sOffset++;
				}
				catch(ClassCastException ex)
				{
					
				}
			}	
		}
		return sOffset;
	}
	
	/**
	 * Returns subtypes of nd including itself
	 * @param nd
	 * @return
	 */
	Iterator<CgenNode> getSubtypes()
	{
		Queue<CgenNode> q = new LinkedList<CgenNode>();
		Queue<CgenNode> subTypes = new LinkedList<CgenNode>();
		
		q.add(this);
		while(!q.isEmpty())
		{
			CgenNode t = q.remove();
			subTypes.add(t);
			
			for (Enumeration<CgenNode> e = t.getChildren(); 
					e.hasMoreElements(); )
				q.add(e.nextElement());
		}
		return subTypes.iterator();
		
	}
	
	/**
	 * Do any methods in this type and its ancestors upto 'supertype' override the 
	 * method supetype.mName
	 * @param mName
	 * @param p The node in which p resides
	 * @param nd
	 * @return
	 */
	public boolean isOverridden(AbstractSymbol mName, CgenNode supertype)
	{	
		// reverse set of ancestors to obtain a child first order
		LinkedList<CgenNode> l = new LinkedList<CgenNode>();
		for (Iterator<CgenNode> i = getAncestors(); i.hasNext(); )
		{
			l.addFirst(i.next());
		}
		
		for (Iterator<CgenNode> i = l.iterator(); i.hasNext(); )
		{
			CgenNode t = i.next();
			if (t.name.equals(supertype.name))
				return false;

			for (Enumeration e = t.getFeatures().getElements(); 
					e.hasMoreElements(); )
			{
				try
				{
					method m = (method)e.nextElement();
					if (m.name.equals(mName))
						return true;
				}
				catch(ClassCastException ex)
				{
					
				}
			}

		}
		return false;
	}
	
}
