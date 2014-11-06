/*
 * inPreToLevel.h
 *
 *  Created on: 30-May-2011
 *      Author: kempa
 */

#ifndef INPRETOLEVEL_H_
#define INPRETOLEVEL_H_
#include<deque>
#include<string>
#include<list>
#include<algorithm>
#define START_POS 0
using std::string;
using std::deque;
using std::list;

/*
 * Note: The algorithm will work as long as there are unique nodes in the tree.
 *       The algorithm interprets the location of a particular node based on its
 *       location in the both traversal strings.  Here the value of the node is
 *       its UID. This is the basis of recognising a particular node in both the
 *       traversal strings.
 */
vector<string> inPreToLevel(list<string> preOrderTraversal,
		vector<string> inOrderTraversal)
{
	vector<string> levelOrderTraversal;
	deque<vector<string> > q;
	q.push_front(inOrderTraversal);
	while (!q.empty())
	{
		// find the root of the in-order traversal, q.front()
		//  with the help of the pre-order traversal
		vector<string> in = q.front();
		q.pop_front();
		list<string>::iterator i;
		vector<string>::iterator root;
		for (i = preOrderTraversal.begin(); (root = std::find(in.begin(),
				in.end(), *i)) == in.end(); i++)
			;
		preOrderTraversal.erase(i);
		levelOrderTraversal.push_back(*root);

		// Insert left and right trees into q
		vector<string> *l = new vector<string>(in.begin(), root);
		if (!l->empty())
			q.push_back(*l);
		vector<string> *r = new vector<string>(++root, in.end());
		if (!r->empty())
			q.push_back(*r);
	}
	return levelOrderTraversal;
}

#endif /* INPRETOLEVEL_H_ */
