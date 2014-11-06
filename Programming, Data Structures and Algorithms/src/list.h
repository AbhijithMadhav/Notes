namespace list
{
	typedef int Item;
	struct node
	{
		Item item;
		node *next;

		node(){}
		node(int x, node *t)
		{
			item = x;
			next = t;
		}
	};
	typedef node *link;
	typedef link Node;

	void construct(int);
	Node newNode(int);
	void deleteNode(Node);
	void insert(Node, Node);
	Node remove(Node);
	Node next(Node);
	Item item(Node);
}
