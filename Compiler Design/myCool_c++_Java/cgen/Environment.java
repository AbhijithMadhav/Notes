/**
 * An implementation of the code generators environment.
 * 
 * An environment is a mapping of variable identifiers to locations. 
 * Intuitively, an environment tells us for a given identifier the address of
 * the memory location where that identifier’s value is stored.
 * @author kempa
 *
 */
public class Environment extends SymbolTable
{
	public Environment()
	{
		super();
	}

}
