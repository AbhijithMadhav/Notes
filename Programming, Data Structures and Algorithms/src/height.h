/*
 * height.h
 *
 *  Created on: 04-Jun-2011
 *      Author: kempa
 */

#ifndef HEIGHT_H_
#define HEIGHT_H_

#include "node.h"

template<typename T>
int height(node<T> *root)
{
	int l = 0, r = 0;

	if (root)
	{
		if (root->l)
			l = height(root->l);
		if (root->r)
			r = height(root->r);

		if (l > r)
			return l + 1;
		else
			return r + 1;
	}
	else
		return 0;
}
#endif /* HEIGHT_H_ */
