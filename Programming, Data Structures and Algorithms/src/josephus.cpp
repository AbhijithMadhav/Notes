/*
 * josephus.cpp
 *
 *  Created on: 23-Sep-2010
 *      Author: kempa
 */

struct node
  {
	int item; node* next;
    node(int x, node* t)
      { item = x; next = t;}
  };
typedef node *Link;

/**
 * Implements algorithm to solve the Josephus problem
 *
 * Makes use of a circular list as a data structure.
 * The list is circular after the insertion of each node
 *
 * @param m Position to be be skipped
 * @param n Number of positions
 * @return
 */
int josephus(int m, int n)
  {
    Link t = new node(1, 0);
    t->next = t;
    Link x = t;
    for (int i = 2; i <= n; i++)
      x = (x->next = new node(i, t));
    while (x != x->next)
      {
        for (int i = 1; i < m; i++) x = x->next;
        x->next = x->next->next;
      }
    return x->item;
  }
