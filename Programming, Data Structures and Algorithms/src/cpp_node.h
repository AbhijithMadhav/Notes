/*
 * node.h
 *
 *  Created on: 04-Jun-2011
 *      Author: kempa
 */

#ifndef NODE_H_
#define NODE_H_
template<class T>
class node
{
	public:
	T item;
	node<T> *r;
	node<T> *l;
	node(T item)
	{
		this->item = item;
		this->r = NULL;
		this->l = NULL;
	}
};

#endif /* NODE_H_ */
