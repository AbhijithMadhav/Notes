/*
 * visit.h
 *
 *  Created on: 04-Jun-2011
 *      Author: kempa
 */

#ifndef VISIT_H_
#define VISIT_H_

#include<vector>
using std::vector;
#include<sstream>
using std::stringstream;
#include<string>
using std::string;

template<class T>
void visit(node<T> *cur, vector<string> &t)
{
	stringstream ss;
	ss << cur->item;
	t.insert(t.end(), ss.str()); // inserting into the vector in the end is efficient
}
#endif /* VISIT_H_ */
