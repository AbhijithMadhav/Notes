/*
 * compexch.h
 *
 *  Created on: 15-Jun-2011
 *      Author: kempa
 */

#ifndef COMPEXCH_H_
#define COMPEXCH_H_

namespace my {
template<class T>
void exch(T &a, T &b)
{
	T t = a;
	a = b;
	b = t;
}

template<class T>
bool compexch(T &a, T &b)
{
	if (b < a)
	{
		exch(a, b);
		return true;
	}
	return false;
}
}
#endif /* COMPEXCH_H_ */
